/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package CublinoGame.ass2.gui.variants.contra;

import CublinoGame.ass2.game.ContraGame;
import CublinoGame.ass2.gui.Board;
import CublinoGame.ass2.gui.players.PlayerType;
import CublinoGame.ass2.gui.variants.Model;
import CublinoGame.ass2.gui.variants.VariantBase;
import CublinoGame.ass2.gui.variants.VariantController;
import CublinoGame.ass2.gui.variants.VariantScreen;

public class ContraBase extends VariantBase {

    Model model;
    ContraController controller;
    VariantScreen screen;

    public ContraBase(Board host, PlayerType p1, PlayerType p2) {
        super(host);

        model = new Model(new ContraGame(), p1, p2);
        controller = new ContraController(this);
        screen = new VariantScreen(this);

        getController().switchControl();
    }

    @Override
    public String getVariantName() {
        return "Contra";
    }

    @Override
    public Model getModel() {
        return model;
    }

    @Override
    public VariantController getController() {
        return controller;
    }

    @Override
    public VariantScreen getScreen() {
        return screen;
    }
}
