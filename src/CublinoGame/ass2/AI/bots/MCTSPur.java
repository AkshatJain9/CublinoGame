/*
 * AUTHORSHIP: Chris Kim & Akshat Jain
 * Other Works/Members Cited: N/A
 */

package CublinoGame.ass2.AI.bots;

import CublinoGame.ass2.AI.GameTypes;
import CublinoGame.ass2.AI.gameTree.GameTreeBase;
import CublinoGame.ass2.AI.heuristics.PurHeuristicMCTS;
import CublinoGame.ass2.base.*;
import CublinoGame.ass2.game.Game;

import java.util.ArrayList;
import java.util.Random;

public class MCTSPur extends AIMain {
    public MCTSPur(String s, GameTypes g, Player p) {
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
        Random rand = new Random();
        gameTree.expandTree();
        long startTime = System.currentTimeMillis();
        while ((System.currentTimeMillis()-startTime) < 10000) {
            for (GameTreeBase g : gameTree.children) {
                Game t = g.current.clone();
                int turn = 50;
                while (turn > 0) {
                    if (t.getLegalMoves().size() == 0) {
                        t.switchTurn();
                        turn--;
                        continue;
                    }
                    if (turn % 3 == 0) {
                        GreedyAI tempAI = new GreedyAI(t);
                        ArrayList<Move> playing = tempAI.getMove();
                        t.play(playing);
                    } else {
                        ArrayList<Move> playing = t.getLegalMoves().get(rand.nextInt(t.getLegalMoves().size()));
                        t.play(playing);
                    }
                    turn--;
                }
                PurHeuristicMCTS p = new PurHeuristicMCTS();
                double eval = p.evaluate(t);
                if (eval > 0) g.evaluation += 1;
                else if (eval < 0) g.evaluation -= 1;
            }
        }
    }
}
