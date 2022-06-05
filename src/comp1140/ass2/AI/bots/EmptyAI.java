package comp1140.ass2.AI.bots;

import comp1140.ass2.AI.GameTypes;
import comp1140.ass2.base.*;
import comp1140.ass2.gui.variants.Model;

import java.util.ArrayList;

/**
 * dummy AI class, not to be used for any computation
 */
public class EmptyAI extends AIMain {
    public EmptyAI() {
        super(Model.INITIAL_STATE, GameTypes.PUR, Player.PLAYER2);
    }

    /**
     * Evaluates the board state and gametree
     *
     * @return A move which is the most 'optimal' in accordance to the AI algorithm
     */
    @Override
    public ArrayList<Move> getMove() {
        return null;
    }
}
