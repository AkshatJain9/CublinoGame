/*
 * AUTHORSHIP: Chris Kim
 * Other Works/Members Cited: N/A
 */
package comp1140.ass2.AI.bots;

import comp1140.ass2.AI.GameTypes;
import comp1140.ass2.base.*;

import java.util.ArrayList;

public class RandomAI extends AIMain {

    public RandomAI(String s, GameTypes g, Player p) {
        super(s, g, p);
    }

    /**
     * Evaluates the board state and gametree
     *
     * @return A move which is the most 'optimal' in accordance to the AI algorithm
     */
    @Override
    public ArrayList<Move> getMove() {
        java.util.Random rnd = new java.util.Random();
        var k = (gameState.getLegalMoves());
        var n = rnd.nextInt(gameState.getLegalMoves().size());
        return k.get(n);
    }
}
