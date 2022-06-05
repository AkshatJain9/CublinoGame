/*
 * AUTHORSHIP: Akshat Jain
 * Other Works/Members Cited: N/A
 */
package CublinoGame.ass2.AI.bots;

import CublinoGame.ass2.AI.GameTypes;
import CublinoGame.ass2.AI.gameTree.GameTreeBase;
import CublinoGame.ass2.base.*;
import CublinoGame.ass2.game.Game;


import java.util.ArrayList;
import java.util.Random;

public class MCTSGeneral extends AIMain {
    public MCTSGeneral(String s, GameTypes g, Player p) {
        super(s, g, p);
    }

    @Override
    public ArrayList<Move> getMove() {
        MonteCarlo();
        if (player == Player.PLAYER1) {
            double besteval = -999999;
            ArrayList<Move> out = null;
            for (GameTreeBase g : gameTree.children) {
                if (g.evaluation > besteval) {
                    out = g.getFnmove();
                    besteval = g.evaluation;
                }
            }
            return out;
        }

        double besteval = 999999;
        ArrayList<Move> out = null;
        for (GameTreeBase g : gameTree.children) {
            if (g.evaluation < besteval) {
                out = g.getFnmove();
                besteval = g.evaluation;
            }
        }
        return out;
    }



    public void MonteCarlo() {
        gameTree.expandTree();
        Random rand = new Random();
        long startTime = System.currentTimeMillis();
        while ((System.currentTimeMillis()-startTime) < 10000) {
            for (GameTreeBase g : gameTree.children) {
                Game t = g.current.clone();
                while (t.score()[0] == 0) {
                    if (t.getLegalMoves().size() == 0) {
                        t.switchTurn();
                        continue;
                    }
                    ArrayList<Move> playing = t.getLegalMoves().get(rand.nextInt(t.getLegalMoves().size()));
                    t.play(playing);
                }
                if (t.score()[0] == 1) {
                    g.evaluation += 1;
                }
                else if (t.score()[0] == 2) {
                    g.evaluation -= 1;
                }
            }
        }
    }
}
