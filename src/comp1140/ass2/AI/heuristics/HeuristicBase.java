/*
 * AUTHORSHIP: Chris Kim & Akshat Jain
 * Other Works/Members Cited: N/A
 */
package comp1140.ass2.AI.heuristics;


import comp1140.ass2.game.Game;

public interface HeuristicBase {
    /**
     * Reads from current gamestate to evaluate relative advantages
     * @return Evaluation in terms of a double
     */
    double evaluate(Game g);
}
