/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package CublinoGame.ass2.gui.players;

/**
 * Any player interacting through a network
 */
public class RemotePlayer implements PlayerType {
    /**
     * IPv4 address of the player
     */
    private String ip;

    /**
     * whether the player stated the match
     */
    private boolean isHost;

    private String name;

    public RemotePlayer(String name, String ip, boolean isHost) {
        this.ip = ip;
        this.isHost = isHost;
        this.name = name;
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
}
