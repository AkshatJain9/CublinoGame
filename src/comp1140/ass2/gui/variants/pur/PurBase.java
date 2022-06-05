/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package comp1140.ass2.gui.variants.pur;

import comp1140.ass2.game.PurGame;
import comp1140.ass2.gui.Board;
import comp1140.ass2.gui.players.PlayerType;
import comp1140.ass2.gui.variants.*;

public class PurBase extends VariantBase {

    private final Model model;
    private final PurController controller;
    private final PurScreen screen;

    public PurBase(Board host, PlayerType p1, PlayerType p2) {
        super(host);

        model = new Model(new PurGame(), p1, p2);
        controller = new PurController(this);
        screen = new PurScreen(this);

        getController().switchControl();
    }

    @Override
    public String getVariantName() {
        return "Pur";
    }

    @Override
    public Model getModel() { return model; }

    @Override
    public VariantController getController() {
        return controller;
    }

    @Override
    public VariantScreen getScreen() {
        return screen;
    }
}
