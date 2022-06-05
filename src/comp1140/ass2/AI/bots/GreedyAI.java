/*
 * AUTHORSHIP: Chris Kim
 * Other Works/Members Cited: Akshat Jain
 */

package comp1140.ass2.AI.bots;

import comp1140.ass2.AI.gameTree.GameTreeBase;
import comp1140.ass2.AI.GameTypes;
import comp1140.ass2.AI.heuristics.*;
import comp1140.ass2.base.*;
import comp1140.ass2.game.Game;

import java.util.ArrayList;

public class GreedyAI extends AIMain {
    public GreedyAI(String s, GameTypes g, Player p) {
        super(s, g, p);
    }

    public GreedyAI(Game g){
        super(g);
    }

    @Override
    public ArrayList<Move> getMove() {
        gameTree.expandTree();
        if (gameTree.current.getVariantChar() == 'p') {
            PurHeuristicMCTS p = new PurHeuristicMCTS();
            gameTree.applyHeuristicTree(p);
        } else if (gameTree.current.getVariantChar() == 'c') {
            ContraHeuristic c = new ContraHeuristic();
            gameTree.applyHeuristicTree(c);
        } else {
            EckeHeuristic e = new EckeHeuristic();
            gameTree.applyHeuristicTree(e);
        }

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
}
