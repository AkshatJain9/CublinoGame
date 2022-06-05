/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package CublinoGame.ass2.gui.variants.replay;

import CublinoGame.ass2.gui.variants.VariantBase;
import CublinoGame.ass2.gui.variants.VariantScreen;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;

public class ReplayScreen extends VariantScreen {
    public ReplayScreen(VariantBase base) {
        super(base);

        ReplayController controller = (ReplayController) base.getController();

        Button forward = new Button(">>>");
        forward.setOnAction(actionEvent -> controller.moveReplayForward());
        UI.getChildren().add(0, forward);

        Slider playhead = new Slider();
        playhead.setMax(base.getModel().replay.size() - 1);
        playhead.valueProperty().addListener(observable -> controller.setReplayPlayhead((int) playhead.getValue()));
        UI.getChildren().add (0, playhead);

        Button backward = new Button("<<<");
        backward.setOnAction(actionEvent -> controller.moveReplayBackward());
        UI.getChildren().add(0, backward);

        var var = switch (base.getGame().getVariantChar()) {
            case 'p' -> "Pur";
            case 'c' -> "Contra";
            case 'e' -> "Ecke";
            default -> "Unknown";
        };

        variantText.setText(var + " replay");
        getTurnText().setText ("Watching " + base.getModel().getPlayer1().getName() + " vs " + base.getModel().getPlayer2().getName());
    }
}
