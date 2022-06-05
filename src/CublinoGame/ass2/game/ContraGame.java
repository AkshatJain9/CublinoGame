/*
 * AUTHORSHIP: Akshat Jain & Chris Kim & Justin Tieu
 * Other Works/Members Cited: N/A
 */
package CublinoGame.ass2.game;

import CublinoGame.ass2.base.BoardState;
import CublinoGame.ass2.base.Move;
import CublinoGame.ass2.base.Outcome;
import CublinoGame.ass2.base.Player;
import CublinoGame.ass2.helpers.Position;

import java.util.ArrayList;
import java.util.Collections;

public class ContraGame extends Game {
    public ContraGame() {super();}
    public ContraGame(BoardState b, Player t) {
        super(b, t);
    }
    public ContraGame (String str) {
        super(str);
    }

    /**
     * tests for the variant's win condition
     *
     * @return true iff the dice placements are such that a win/draw condition is met
     */
    @Override
    public int[] score() {
        int[] status = {0};
        if (getLegalMoves().size() == 0) {
            switchTurn();
            if (getLegalMoves().size() == 0) {
                status[0] = 3;
                return status;
            }
            switchTurn();
        }
        for (int row = 0; row <= 6; row += 6) {
            for (int col = 0; col <= 6; col++) {
                if (board.getAtIndex(col,row) != null) {
                    if (row == 0 && board.getAtIndex(col,row).getTurn() == Player.PLAYER2) {
                        status[0] = 2;
                        return status;
                    }
                    if (row == 6 && board.getAtIndex(col,row).getTurn() == Player.PLAYER1) {
                        status[0] = 1;
                        return status;
                    }
                }
            }
        }
        return status;
    }

    /**
     * tests for the variant's win condition
     *
     * @return the outcome for player 1
     */
    @Override
    public Outcome hasWon() {
        return switch (score()[0]) {
            case 1  -> Outcome.WIN;
            case 2  -> Outcome.LOSE;
            default -> Outcome.ONGOING;
        };
    }

    /**
     * Whether the piece placements are valid for *both* games
     *
     * @return Whether this current game state is valid
     */
    @Override
    public boolean isValid() {
        int P1Dice = 0;
        int P2Dice = 0;
        boolean P1finish = false;
        boolean P2finish = false;
        for (int row = 0; row <= 6; row++) {
            for (int col = 0; col <= 6; col++) {
                if (board.getAtIndex(col,row) != null) {
                    switch (board.getAtIndex(col,row).getTurn()) {
                        case PLAYER1 -> P1Dice++;
                        case PLAYER2 -> P2Dice++;
                    }
                }
            }
            if (row == 0 && P2Dice > 0) P2finish = true;
            if (row == 5 && P1Dice <= 6) P1finish = true;
        }
        return P2Dice != 0 && P1Dice != 0 && P1Dice <= 7 && P2Dice <= 7 && (!P1finish || !P2finish);
    }

    @Override
    public char getVariantChar() {
        return 'c';
    }

    /**
     * Generates a copy of the Game object seperate to original
     *
     * @return Copy of gamestate
     */
    @Override
    public Game clone() {
        return new ContraGame(toString());
    }

    /**
     * Returns arrayList of legal moves
     * Input reads from the current gameState
     */
    public ArrayList<ArrayList<Move>> getLegalMoves() {
        ArrayList<ArrayList<Move>> contraMoves = new ArrayList<>();
        for (int row = 0; row <= 6; row++) {
            for (int col = 0; col <= 6; col++) {
                if (board.getAtIndex(col,row) != null) {
                    if (board.getAtIndex(col,row).getTurn().equals(this.turn)) {
                        Position current = new Position(col,row);
                        ArrayList<Position> tilts = current.getTiltPositions();
                        for (Position end : tilts) {
                            Move m = new Move(current,end,this.turn);
                            ArrayList<Move> innerMoves = new ArrayList<>(Collections.singletonList(m));
                            contraMoves.add(innerMoves);
                        }
                    }
                }
            }
        }
        contraMoves.removeIf(m -> !board.tiltDice(m.get(0)));
        return contraMoves;
    }

    /**
     * play a list of moves to the game state,
     * switches the turn on use
     * @param m the move to play
     */
    public void play(ArrayList<Move> m) {
        board.applyTilt(m.get(0));
        battle(m.get(0).getEnd());
        switchTurn();
    }

    /**
     * When a move has been played, call this function to initiate a battle in accordance to Contra rules
     * @param end The end position of the move that has just been applied, where the battle will occur
     */
    public void battle (Position end) {
        ArrayList<Position> losingDice = new ArrayList<>();
        ArrayList<Position> opponentDice = board.getOpponentDicePosContra(end);
        int opponentScore = 0;
        for (Position loc : opponentDice) {
            opponentScore += board.getAtPosition(loc).getTop();
        }
        for (Position loc : opponentDice) {
            ArrayList<Position> homeDice = board.getOpponentDicePosContra(loc);
            int homeScore = 0;
            for (Position ourDice : homeDice) {
                homeScore += board.getAtPosition(ourDice).getTop();
            }
            if (homeScore > opponentScore) losingDice.add(loc);
            if (homeScore < opponentScore && !losingDice.contains(end)) losingDice.add(end);
        }
        for (Position removal : losingDice) board.removeDie(removal);
    }
}
