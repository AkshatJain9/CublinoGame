/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package CublinoGame.ass2.gui.variants.pur;

import CublinoGame.ass2.gui.variants.VariantBase;
import CublinoGame.ass2.gui.variants.VariantScreen;
import javafx.scene.control.Button;

public class PurScreen extends VariantScreen {
    Button finish;
    public Button getFinishButton() {
        return finish;
    }

    public PurScreen(VariantBase base) {
        super(base);

        finish = new Button("End Turn");
        finish.setOnAction(actionEvent -> base.getController().endTurn());
        UI.getChildren().add(0, finish);
    }
}
