/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package CublinoGame.ass2.gui.variants;

import CublinoGame.ass2.game.Game;
import CublinoGame.ass2.gui.Board;

/**
 * Home class for a single variant.
 * Contains all variant specific classes
 */
public abstract class VariantBase {
    private final Board host;

    public VariantBase (Board host){
        this.host = host;
    }

    /**
     * get the Board instance
     * @return application host
     */
    public Board getHost() {
        return host;
    }

    /**
     * The name of the variant eg. Pur, Ecke
     * @return variant name
     */
    public abstract String getVariantName();

    /**
     * get Model instance
     * @return variant model
     */
    public abstract Model getModel();

    /**
     * get game state from model
     * @return game state
     */
    public Game getGame() {
        return getModel().getGame();
    }

    /**
     * Get the controller instance
     * @return controller
     */
    public abstract VariantController getController();

    /**
     * Get the view class
     * @return screen
     */
    public abstract VariantScreen getScreen();
}
