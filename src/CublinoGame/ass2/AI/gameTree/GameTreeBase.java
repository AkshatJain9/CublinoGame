/*
 * AUTHORSHIP: Akshat Jain & Chris Kim
 * Other Works/Members Cited: N/A
 */
package CublinoGame.ass2.AI.gameTree;


import CublinoGame.ass2.AI.heuristics.HeuristicBase;
import CublinoGame.ass2.game.*;
import CublinoGame.ass2.base.Move;

import java.util.ArrayList;

public class GameTreeBase {
    public final Game current;
    public double evaluation;
    public ArrayList<GameTreeBase> children;
    public ArrayList<Move> fnmove;

    public GameTreeBase (Game g) {
        this.current = g;
        fnmove = null;
        children = new ArrayList<>();
    }

    public GameTreeBase (Game g, ArrayList<Move> m) {
        this.current = g;
        this.fnmove = m;
        children = new ArrayList<>();
    }

    /**
     * Reads current stored gamestate
     * @return Possible gamestates which could arise from current gamestate
     */
    public ArrayList<GameTreeBase> getChildren () {
        return children;
    }

    /**
     * Returns move
     * @return Move
     */
    public ArrayList<Move> getFnmove() {
        return fnmove;
    }

    /**
     * Alters gameTree so it is expanded one layer deeper
     */
    public void expandTree() {
        // if there is no children in the tree
        if (children.isEmpty()) {
            // For each legal move from a possible GameState, add it to the arraylist of children.
            for (ArrayList<Move> move : current.getLegalMoves()) {
                Game temp = current.clone();
                ArrayList<Move> xmove = new ArrayList<>();
                for (Move m : move) {
                    Move j = new Move(m.toString(), current.getTurn());
                    xmove.add(j);
                }
                temp.play(move);
                GameTreeBase childtemp = new GameTreeBase(temp,xmove);
                children.add(childtemp);
            }

        }
        else {
            // Check for case when there is a tree with multiple children. Apply the function to the all the children.
            for (GameTreeBase child : children) {
                child.expandTree();
            }
        }
    }

    /**
     * Expands gametree by desired depth
     * @param depth How deep the gametree needs to be evaluated
     */
    public void expandTreeTimes (int depth) {
        if (depth < 0) throw new IllegalArgumentException();
        while (depth > 0) {
            expandTree();
            depth--;
        }
    }

    /**
     * For use in MCTS, randomly adds a child node for exploration
     */
    public void randomExpand() {
        for (ArrayList<Move> move : current.getLegalMoves()) {
            Game temp = current.clone();
            ArrayList<Move> xmove = new ArrayList<>();
            for (Move m : move) {
                Move j = new Move(m.toString(), current.getTurn());
                xmove.add(j);
            }
            temp.play(move);
            GameTreeBase childtemp = new GameTreeBase(temp,xmove);
            if (hasChild(childtemp)) {
                continue;
            }
            children.add(childtemp);
        }
    }

    /**
     * Checks if a child node has already been explored
     * @param explore Child node to be checked
     * @return If it has been explored or not
     */
    public boolean hasChild(GameTreeBase explore) {
        for (GameTreeBase explored : children) {
            if (explored.current.toString().equals(explore.current.toString())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return current.toString() + " which was received by the move " + fnmove + " and has evaluation " + evaluation;
    }

    /**
     * Applies a heuristic to a tree
     * @param h Heuristic to be applied
     */
    public void applyHeuristicTree(HeuristicBase h) {
        this.evaluation = h.evaluate(this.current);
        for (GameTreeBase child : children) {
            child.applyHeuristicTree(h);

        }
    }



}
