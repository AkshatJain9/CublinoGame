/*
 * AUTHORSHIP: Chris Kim & Akshat Jain
 * Other Works/Members Cited: N/A
 */
package CublinoGame.ass2.AI.heuristics;

import CublinoGame.ass2.game.Game;

public class EckeHeuristic implements HeuristicBase{
    /**
     * Reads from current gamestate to evaluate relative advantages
     *
     * @param g Gamestate to be evaluated
     * @return Evaluation in terms of a double
     */
    @Override
    public double evaluate(Game g) {
        int yPositionHeuristic = 0;
        int topNumHeuristic = 0;
        int finishHeuristic = 0;

        for (int row = 0; row <= 6; row++) {
            for (int col = 0; col <= 6; col++) {
                if (g.getBoard().getAtIndex(col,row) != null) {
                    switch (g.getBoard().getAtIndex(col,row).getTurn()) {
                        case PLAYER1 -> {
                            yPositionHeuristic += g.getBoard().getAtIndex(col,row).getPosition().getY();
                            topNumHeuristic += g.getBoard().getAtIndex(col,row).getTop();
                            if (row == 6 && (col == 0 || col == 6)) finishHeuristic += 100;
                        }
                        case PLAYER2 -> {
                            yPositionHeuristic -= (6 - g.getBoard().getAtIndex(col,row).getPosition().getY());
                            topNumHeuristic -= g.getBoard().getAtIndex(col,row).getTop();
                            if (row == 0 && (col == 0 || col == 6)) finishHeuristic -= 100;
                        }
                    }
                }
            }
        }
        return topNumHeuristic + 10*yPositionHeuristic + finishHeuristic;
    }
}
