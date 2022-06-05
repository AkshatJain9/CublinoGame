/*
 * AUTHORSHIP: Chris Kim
 * Other Works/Members Cited:
 */

package comp1140.ass2.gui.menus;

import comp1140.ass2.gui.tools.GuiBase;
import comp1140.ass2.gui.variants.VariantBase;
import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.nio.file.Paths;
import java.time.LocalDateTime;

public class GameOverOverlay extends Group {
    public GameOverOverlay(VariantBase vb) {
        var bg = new Rectangle(GuiBase.APP_WIDTH, GuiBase.APP_HEIGHT, Color.WHITE);
        bg.setOpacity(0.5);

        FadeTransition fade = new FadeTransition();
        fade.setFromValue(0);
        fade.setToValue(0.6);
        fade.setNode(bg);
        fade.play();
        getChildren().add(bg);

        String extra = switch (vb.getGame().hasWon()) {
            case WIN -> vb.getModel().getPlayer1().getName() + " wins";
            case LOSE -> vb.getModel().getPlayer2().getName() + " wins";
            default -> "Draw";
        };

        // Game Over Text
        Label over = new Label("Game Over!");
        over.setAlignment(Pos.CENTER);
        over.setStyle("-fx-font-size: 4em; -fx-font-weight: bold;");
        over.setLayoutX(GuiBase.APP_WIDTH/2-175);
        over.setLayoutY(GuiBase.APP_HEIGHT/2-350);
        over.setMinSize(350,75);
        over.setMaxSize(300,75);
        getChildren().add(over);

        Label winner = new Label(extra);
        winner.setAlignment(Pos.CENTER);
        //winner.setMinSize(300,75);
        //winner.setMaxSize(300,75);
        winner.setLayoutX(GuiBase.APP_WIDTH/2-150);
        winner.setLayoutY(GuiBase.APP_HEIGHT/2-275);
        winner.setStyle("-fx-font-size: 3em; -fx-font-weight: bold;");
        getChildren().add(winner);

        // variant
        String vari = "";
        switch (vb.getGame().getVariantChar()) {
            case 'p' -> vari = "Variant " + "Pur";
            case 'c' -> vari = "Variant " + "Contra";
            case 'e' -> vari = "Variant " + "Ecke";
        }
        Label variant = new Label(vari);
        variant.setAlignment(Pos.CENTER);
        variant.setStyle("-fx-font-size: 2em; -fx-font-weight: bold;");
        variant.setMinSize(250,50);
        variant.setMaxSize(250,50);
        variant.setLayoutX(GuiBase.APP_WIDTH/2-125);
        variant.setLayoutY(GuiBase.APP_HEIGHT/2-200);
        getChildren().add(variant);

        // buttons
        // replay and exit button
        Button replayExit = new Button("Save Replay and Exit");
        Button exit = new Button ("Exit");
        String menu = "-fx-font-size: 1.5em; -fx-background-color: #524848; -fx-text-fill: white;";

        replayExit.setMinSize(250,50);
        replayExit.setMaxSize(250,50);
        replayExit.setLayoutX(GuiBase.APP_WIDTH/2-250);
        replayExit.setLayoutY(GuiBase.APP_HEIGHT/2+220);
        replayExit.setStyle(menu);
        replayExit.setOnAction(e -> {
            String file = Paths.get("replays",vb.getModel().getGame().getVariantChar() + "_" + LocalDateTime.now().getMonthValue() + "-" + LocalDateTime.now().getDayOfMonth() + "-" + LocalDateTime.now().getHour() + "-" + LocalDateTime.now().getMinute() + ".cblr").toString();
            var outcome = vb.getModel().writeReplay(file);

            if (outcome) {
                Alert msg = new Alert(Alert.AlertType.INFORMATION, "Wrote to file " + file);
                msg.showAndWait();
                goHome(vb);
            } else {
                Alert msg = new Alert(Alert.AlertType.ERROR, "could not write to file");
                msg.showAndWait();
                goHome(vb);
            }
        });
        getChildren().add(replayExit);

        //exit button
        exit.setMinSize(150,50);
        exit.setMaxSize(150,50);
        exit.setLayoutX(GuiBase.APP_WIDTH/2+50);
        exit.setLayoutY(GuiBase.APP_HEIGHT/2+220);
        exit.setStyle(menu);
        exit.setOnAction(e -> goHome(vb));
        getChildren().add(exit);

    }

    void goHome(VariantBase vb) {
        vb.getController().terminate();
        vb.getHost().setScreen(new HomeScreen(vb.getHost()));
    }
}
