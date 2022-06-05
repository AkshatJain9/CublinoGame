/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package CublinoGame.ass2.gui.players;

import CublinoGame.ass2.AI.bots.AIMain;

/**
 * Player wrapper for the AIs
 */
public class AIPlayer implements PlayerType {
    private final AIMain ai;
    private int time;

    String name;

    public AIPlayer(AIMain ai) {
        this.ai = ai;
        name = ai.getClass().getSimpleName();
    }

    /**
     * get the AI instructions for the bot
     * @return the AIMain instance
     */
    public AIMain getAI() {
        return ai;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * set the name of the player
     *
     * @param value player name
     */
    @Override
    public void setName(String value) {
        name = value;
    }

    @Override
    public Ref getType() {
        return Ref.AI;
    }

    public void setTime(int value) {
        time = value;
    }

    public int getTime() {
        return time;
    }
}
