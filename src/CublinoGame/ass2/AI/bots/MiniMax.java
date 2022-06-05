/*
 * AUTHORSHIP: Akshat Jain
 * Other Works/Members Cited: Chris Kim
 */

package CublinoGame.ass2.AI.bots;

import CublinoGame.ass2.AI.GameTypes;
import CublinoGame.ass2.AI.gameTree.GameTreeBase;
import CublinoGame.ass2.AI.heuristics.*;
import CublinoGame.ass2.base.*;

import java.util.ArrayList;

public class MiniMax extends AIMain {
    public MiniMax(String s, GameTypes g, Player p) {
        super(s, g, p);
    }

    @Override
    public ArrayList<Move> getMove() {
        gameTree.expandTreeTimes(3);
        alphaBeta(gameTree, -9999, 9999, true);
        return gameTree.getFnmove();
    }

    public double alphaBeta(GameTreeBase g, double alpha, double beta, boolean parent) {
        if (g.children.size() == 0) {
            if (g.current.getVariantChar() == 'p') {
                PurHeuristic p = new PurHeuristic();
                g.evaluation = p.evaluate(g.current);
                return p.evaluate(g.current);
            } else if (g.current.getVariantChar() == 'c') {
                ContraHeuristic c = new ContraHeuristic();
                g.evaluation = c.evaluate(g.current);
                return c.evaluate(g.current);
            } else if (g.current.getVariantChar() == 'e') {
                EckeHeuristic e = new EckeHeuristic();
                g.evaluation = e.evaluate(g.current);
                return e.evaluate(g.current);
            }
        }
        double value;
        if (g.current.getTurn() == Player.PLAYER1) {
            value = -9999;
            for (GameTreeBase childs : g.children) {
                value = Math.max(value, alphaBeta(childs, alpha, beta, false));
                if (value >= beta) {
                    break;
                }
                alpha = Math.max(alpha, value);
                if (parent) {
                    g.fnmove = childs.getFnmove();
                }
            }
        }
        else {
            value = 9999;
            for (GameTreeBase childs : g.children) {
                value = Math.min(value, alphaBeta(childs, alpha, beta, false));
                if (value <= alpha) {
                    break;
                }
                beta = Math.min(beta, value);
                if (parent) {
                    g.fnmove = childs.getFnmove();
                }
            }
        }
        return value;
    }
}
