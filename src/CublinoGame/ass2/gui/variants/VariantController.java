/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package CublinoGame.ass2.gui.variants;

import CublinoGame.ass2.base.Dice;
import CublinoGame.ass2.base.Move;
import CublinoGame.ass2.base.Outcome;
import CublinoGame.ass2.gui.players.AIPlayer;
import CublinoGame.ass2.gui.players.PlayerType;
import CublinoGame.ass2.helpers.Position;
import javafx.concurrent.Task;

import java.util.ArrayList;


/**
 * generic controller, handles user interactions and translates them into
 * game modifying actions
 */
public abstract class VariantController {
    protected VariantBase base;

    private int moves;

    public VariantController(VariantBase base) {
        this.base = base;
    }

    public int getMoveCount() {
        return moves;
    }

    protected void incrementMoveCount() {
        moves++;
    }

    protected void resetMoveCount() {
        moves = 0;
    }

    protected void setSelectedDice(Dice value) {
        base.getModel().setSelectedDice(value);
    }

    private boolean interactive;

    protected Dice getSelectedDice() {
        return base.getModel().getSelectedDice();
    }

    public enum ObjectType {
        DICE,
        TILE
    }

    /**
     * Whenever the user clicks their mouse
     * @param pos board position between 0 and 7
     */
    public void handlePlayerInput(Position pos, ObjectType type) {
        System.out.println("Mouse event handled by " + type + " at " + pos + " and interactive is " + interactive);
        if (!interactive)
            return;

        if (base.getModel().getSelectedDice() == null) {
            // nothing selected
            setSelectedDice(base.getGame().getBoard().getAtPosition(pos));
        } else {
            // something selected
            // should only be able to select tiles at this stage
            if (type == ObjectType.TILE) {
                // tile
                var selected = base.getModel().getSelectedDice();
                Move move = new Move(selected.getPosition(), pos, base.getGame().getTurn());
                modifyBoardWithInput(move);
                onMovePlayed(move);
                handleComplete();
            } else {
                // dice
                var dice = base.getGame().getBoard().getAtPosition(pos);
                if (dice == null || getMoveCount() == 0)
                    setSelectedDice(dice);
            }
        }
        base.getScreen().update(getSelectedDice());
    }

    /**
     * Called after human move is handled
     */
    protected void handleComplete(){ }

    /**
     * modifies the board with the move input
     * @param move
     */
    protected abstract void modifyBoardWithInput(Move move);

    /**
     * Gets the legal moves with respect to other game related factors
     * @param moveCount
     * @return
     */
    public ArrayList<ArrayList<Move>> getLegalMoves (int moveCount)
    {
        return base.getGame().getLegalMoves();
    }

    /**
     * begins the AI task
     */
    private void startComputingAI() {
        // open a new thread
        Task <ArrayList<Move>> task = new Task<>() {
            @Override
            protected ArrayList<Move> call() throws Exception {
                System.out.println("started AI thread...");
                var aiPlayer = (AIPlayer)base.getModel().getCurrentPlayer();
                aiPlayer.getAI().applyReturnMove(base.getGame());
                return aiPlayer.getAI().getMove();
            }
        };

        task.setOnSucceeded(workerStateEvent -> aiComplete(task.getValue()));

        Thread t = new Thread (task);
        t.setDaemon(true);
        t.start();
    }

    /**
     * called when anyone plays a move
     * @param move the move played
     */
    protected void onMovePlayed (Move move) {
        if (base.getHost().settingsStore.sounds)
            base.getHost().getAudioPool().get("tilt").play();

        // update replay
        base.getModel().replay.add(base.getModel().getGame().toString());
    }


    /**
     * called after the AI thread has succeeded
     * @param move
     */
    private void aiComplete(ArrayList<Move> move) {
        System.out.println("thread completed successfully, got " + move);

        if (move == null) {
            endTurn();
            return;
        }

        base.getGame().play(move);
        base.getGame().switchTurn(); // <- potential issue

        for (Move m : move)
            onMovePlayed(m);

        incrementMoveCount();

        endTurn();
    }

    /**
     * ends the turn of the current player, exits
     * if no moves have been played
     */
    public void endTurn() {
        if (getMoveCount() == 0)
            return;

        onTurnEnd();

        base.getGame().switchTurn();
        base.getScreen().update(getSelectedDice());
        resetMoveCount();
        setSelectedDice(null);

        // player text
        base.getScreen().getTurnText().setText(base.getModel().getCurrentPlayer().getName() + " is playing...");
        switchControl();
    }

    boolean noMovesBefore = false;
    boolean terminated = false;

    /**
     * used to interrupt switchControl and stop all game activity
     */
    public void terminate() {
        terminated = true;
    }

    private final static int MAXIMUM_GAME_LENGTH = 200;

    /**
     * maintain the game loop, switches control to the next player
     */
    public void switchControl() {
        if (terminated)
            return;

        interactive = false;

        // check for a win condition
        var o = base.getGame().hasWon();
        if (o != Outcome.ONGOING) {
            interactive = false;
            base.getScreen().enableGameOver();
            return;
        }

        // check for needlessly long games
        if (base.getModel().replay.size() >= MAXIMUM_GAME_LENGTH) {
            base.getScreen().enableGameOver();
            return;
        }

        // switch control
        var type = base.getModel().getCurrentPlayer().getType();
        onSwitchControl(type);

        // switch turn when no moves available
        if (getLegalMoves(getMoveCount()).size() == 0) {
            if (noMovesBefore)
                base.getScreen().enableGameOver();
            else {
                noMovesBefore = true;
                switchControl();
            }
        } else
            noMovesBefore = false;

        switch (type) {
            case LOCAL  -> interactive = true;
            case REMOTE -> throw new UnsupportedOperationException();
            case AI     -> startComputingAI();
        }
    }

    /**
     * Called during switchcontrol
     * @param type
     */
    protected void onSwitchControl(PlayerType.Ref type) { }

    /**
     * called before the turn ends
     */
    protected void onTurnEnd() { }
}
