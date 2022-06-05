/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package comp1140.ass2.gui.variants.ecke;

import comp1140.ass2.game.EckeGame;
import comp1140.ass2.gui.Board;
import comp1140.ass2.gui.players.PlayerType;
import comp1140.ass2.gui.variants.Model;
import comp1140.ass2.gui.variants.VariantBase;
import comp1140.ass2.gui.variants.VariantController;
import comp1140.ass2.gui.variants.VariantScreen;

public class EckeBase extends VariantBase {
    Model model;
    EckeController controller;
    VariantScreen screen;

    public EckeBase(Board host, PlayerType p1, PlayerType p2) {
        super(host);
        model = new Model(new EckeGame(), p1, p2);
        controller = new EckeController(this);
        screen = new VariantScreen(this);

        getController().switchControl();
    }

    @Override
    public String getVariantName() {
        return "Ecke";
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
