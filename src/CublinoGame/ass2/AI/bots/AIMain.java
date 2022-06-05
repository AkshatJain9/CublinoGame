/*
 * AUTHORSHIP: Akshat Jain & Chris Kim
 * Other Works/Members Cited: N/A
 */
package CublinoGame.ass2.AI.bots;

import CublinoGame.ass2.AI.gameTree.GameTreeBase;
import CublinoGame.ass2.AI.GameTypes;
import CublinoGame.ass2.game.*;
import CublinoGame.ass2.base.*;

import java.util.ArrayList;

public abstract class AIMain {
    protected Game gameState;
    protected Player player;
    protected GameTreeBase gameTree;

    public AIMain(String s, GameTypes g, Player player) {
        if (g == GameTypes.PUR) this.gameState = new PurGame(s);
        else if (g == GameTypes.CONTRA) this.gameState = new ContraGame(s);
        else this.gameState = new EckeGame(s);
        this.player = player;

        gameTree = new GameTreeBase(gameState);
    }


    public AIMain(String s) {
        if (Character.toLowerCase(s.charAt(0)) == 'p') this.gameState = new PurGame(s);
        else if (Character.toLowerCase(s.charAt(0)) == 'c') this.gameState = new ContraGame(s);
        else this.gameState = new EckeGame(s);
        this.player = gameState.getTurn();
        gameTree = new GameTreeBase(gameState);
    }


    public AIMain(Game g) {
        this.gameState = g;
        this.player = g.getTurn();
        this.gameTree = new GameTreeBase(g);
    }


    /**
     * Evaluates the board state and gametree
     * @return A move which is the most 'optimal' in accordance to the AI algorithm
     */
    public abstract ArrayList<Move> getMove();


    /**
     * Whatever move the opponent made, again is reflected in change to gametree (if it exists)
     * Likely to not be made abstract
     */
    public void applyReturnMove(Game m) {
        for (GameTreeBase gtb : gameTree.children) {
            if (m.toString().equals(gtb.current.toString())) {
                this.gameState = gtb.current;
                this.gameTree = gtb;
                return;
            }
        }
        this.gameState = m;
        this.gameTree = new GameTreeBase(m);
    }
}
