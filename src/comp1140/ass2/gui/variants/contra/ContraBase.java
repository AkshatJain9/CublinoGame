/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package comp1140.ass2.gui.variants.contra;

import comp1140.ass2.game.ContraGame;
import comp1140.ass2.gui.Board;
import comp1140.ass2.gui.players.PlayerType;
import comp1140.ass2.gui.variants.Model;
import comp1140.ass2.gui.variants.VariantBase;
import comp1140.ass2.gui.variants.VariantController;
import comp1140.ass2.gui.variants.VariantScreen;

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
