/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */
package comp1140.ass2.AI;

import comp1140.ass2.AI.bots.*;
import comp1140.ass2.base.Player;
import comp1140.ass2.gui.variants.Model;

public class AiHelper {
    public static AIMain getAI (AiType ai, GameTypes game, Player p) {
        switch (ai) {
            case GREEDY -> { return new GreedyAI(Model.INITIAL_STATE, game, p); }
            case RANDOM -> { return new RandomAI(Model.INITIAL_STATE, game, p); }
            case MINIMAX -> { return new MiniMax(Model.INITIAL_STATE, game, p); }
            case MCTS -> {
                if (game == GameTypes.ECKE)
                    return new MCTSEcke(Model.INITIAL_STATE, game, p);
                else if (game == GameTypes.CONTRA)
                    return new MCTSContra(Model.INITIAL_STATE, game, p);
                else if (game == GameTypes.PUR)
                    return new MCTSPur(Model.INITIAL_STATE, game, p);
            }
        }

        throw new IllegalArgumentException();
    }
}
