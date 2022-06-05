/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package CublinoGame.ass2.gui.players;

/**
 * A real human player
 */
public class LocalPlayer implements PlayerType {
    private String name;

    public LocalPlayer(String name) {
        this.name = name;
    }

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
        return Ref.LOCAL;
    }
}

