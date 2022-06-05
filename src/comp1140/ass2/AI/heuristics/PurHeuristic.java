/*
 * AUTHORSHIP: Chris Kim & Akshat Jain
 * Other Works/Members Cited: N/A
 */
package comp1140.ass2.AI.heuristics;

import comp1140.ass2.game.Game;
import comp1140.ass2.helpers.Position;


import static comp1140.ass2.base.Player.PLAYER1;
import static comp1140.ass2.base.Player.PLAYER2;


public class PurHeuristic implements HeuristicBase {


    @Override
    public double evaluate(Game g) {
        int yPositionHeuristic = 0;
        int topNumHeuristic = 0;
        int jumpHeuristic = 0;

        for (int row = 0; row <= 6; row++) {
            for (int col = 0; col <= 6; col++) {
                if (g.getBoard().getAtIndex(col,row) != null) {
                    switch (g.getBoard().getAtIndex(col,row).getTurn()) {
                        case PLAYER1 -> {
                            yPositionHeuristic += g.getBoard().getAtIndex(col,row).getPosition().getY();
                            topNumHeuristic += g.getBoard().getAtIndex(col,row).getTop();
                            for (Position p : new Position(row,col).getTiltPositions()) {
                                if (g.getBoard().getAtPosition(p) != null) {
                                    if (g.getBoard().getAtPosition(p).getTurn() == PLAYER2) {
                                        if (g.getTurn() == PLAYER1) {
                                            jumpHeuristic++;
                                        } else {
                                            jumpHeuristic--;
                                        }
                                    }
                                }
                            }
                        }
                        case PLAYER2 -> {
                            yPositionHeuristic -= (6 - g.getBoard().getAtIndex(col,row).getPosition().getY());
                            topNumHeuristic -= g.getBoard().getAtIndex(col,row).getTop();
                            for (Position p : new Position(row,col).getTiltPositions()) {
                                if (g.getBoard().getAtPosition(p) != null) {
                                    if (g.getBoard().getAtPosition(p).getTurn() == PLAYER1) {
                                        if (g.getTurn() == PLAYER2) {
                                            jumpHeuristic--;
                                        } else {
                                            jumpHeuristic++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return topNumHeuristic + 10*yPositionHeuristic + jumpHeuristic;
    }
}
