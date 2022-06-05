/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package CublinoGame.ass2.gui.variants;

import CublinoGame.ass2.AI.bots.AIMain;
import CublinoGame.ass2.base.Dice;
import CublinoGame.ass2.game.Game;
import CublinoGame.ass2.gui.players.PlayerType;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Client-side information
 */
public class Model {
    public static final String INITIAL_STATE = "PWa1Wb1Wc1Wd1We1Wf1Wg1va7vb7vc7vd7ve7vf7vg7";

    //dice selected by the current player
    private Dice selectedDice;

    PlayerType player1;
    PlayerType player2;

    AIMain AI;

    Game game;

    public ArrayList<String> replay;

    public Model(Game game, PlayerType p1, PlayerType p2) {
        if (p1.getName().equals (p2.getName())) {
            p1.setName(p1.getName() + "1");
            p2.setName(p2.getName() + "2");
        }

        replay = new ArrayList<>();

        player1 = p1;
        player2 = p2;
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public boolean writeReplay (String path) {
        // serialise data
        StringBuilder data = new StringBuilder();
        data.append (getGame().getVariantChar()).append ("\n");
        data.append (getPlayer1().getName()).append("\n");
        data.append (getPlayer2().getName()).append("\n");
        for (String state : replay) {
            data.append (state).append("\n");
        }

        // write it to file
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(data.toString());
            System.out.println("wrote to " + path);
            writer.close();
            return true;
        } catch (IOException e) {
            System.out.println("something wrong happened whilst writing replay");
            e.printStackTrace();
            return false;
        }
    }

    public Dice getSelectedDice() {
        return selectedDice;
    }
    public void setSelectedDice(Dice value) {
        selectedDice = value;
    }

    public AIMain getAI() {
        return AI;
    }

    public PlayerType getPlayer1() {
        return player1;
    }

    public PlayerType getPlayer2() {
        return player2;
    }

    /**
     * get player data for current player
     * @return playerType instance
     */
    public PlayerType getCurrentPlayer() {
        return switch (getGame().getTurn()) {
            case PLAYER1 -> getPlayer1();
            case PLAYER2 -> getPlayer2();
        };
    }
}
