/*
 * AUTHORSHIP: Chris Kim
 * Other Works/Members Cited: Justin Tieu
 */

package CublinoGame.ass2.gui.menus;

import CublinoGame.ass2.gui.tools.GuiBase;
import CublinoGame.ass2.gui.variants.VariantBase;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static CublinoGame.ass2.gui.tools.GuiBase.APP_HEIGHT;
import static CublinoGame.ass2.gui.tools.GuiBase.APP_WIDTH;

public class PauseScreenOverlay extends Group {

    public PauseScreenOverlay(VariantBase vb) {
        Group pause = new Group();

        // transition
        var bg = new Rectangle(GuiBase.APP_WIDTH, GuiBase.APP_HEIGHT, Color.BLACK);
        bg.setOpacity(0.8);

        FadeTransition fade = new FadeTransition();
        fade.setFromValue(0);
        fade.setToValue(0.6);
        fade.setNode(bg);
        fade.play();
        getChildren().add(bg);

        // rectangle in the middle
        Group menuPane = new Group();
        Rectangle pane = new Rectangle(APP_WIDTH/2-300,APP_HEIGHT/2-250,600,500);
        Color menuCol = Color.web("#e7e7e7",0.8);
        pane.setFill(menuCol);
        menuPane.getChildren().add(pane);
        pane.setArcHeight(30);
        pane.setArcWidth(30);
        pause.getChildren().add(pane);

        // exit round

        Label paused = new Label ("Game Paused");
        paused.setMinSize(300,125);
        paused.setMaxSize(300,125);
        paused.setAlignment(Pos.CENTER);
        paused.setStyle("-fx-font-size: 2.5em;");
        paused.setTextFill(Color.WHITE);
        getChildren().add(paused);

        Button resume = new Button ("Resume");
        resume.setMinSize(250,50);
        resume.setMaxSize(250,50);
        resume.setLayoutX(GuiBase.APP_WIDTH/2-100);
        resume.setLayoutY(GuiBase.APP_HEIGHT/2+100);
        resume.setOnAction(e -> this.setVisible(false));
        getChildren().add(resume);

        Button exitround = new Button ("Exit");
        exitround.setMinSize(250,50);
        exitround.setMaxSize(250,50);
        exitround.setLayoutX(GuiBase.APP_WIDTH/2-250);
        exitround.setLayoutY(GuiBase.APP_HEIGHT/2+160);
        exitround.setOnAction(e -> goHome(vb));
        getChildren().add(exitround);

        //exit button
        Button exit = new Button ("Exit to Desktop");
        exit.setMinSize(250,50);
        exit.setMaxSize(250,50);
        exit.setLayoutX(GuiBase.APP_WIDTH/2+50);
        exit.setLayoutY(GuiBase.APP_HEIGHT/2+160);
        exit.setOnAction(e -> Platform.exit());
        getChildren().add(exit);

        getStylesheets().add(getClass().getResource("title.css").toExternalForm());

    }
    void goHome(VariantBase vb) {
        vb.getController().terminate();
        vb.getHost().setScreen(new HomeScreen(vb.getHost()));
    }
}
