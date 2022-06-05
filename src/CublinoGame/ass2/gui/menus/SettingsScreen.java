/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: Chris
 */

package CublinoGame.ass2.gui.menus;

import CublinoGame.ass2.gui.Board;
import CublinoGame.ass2.gui.tools.screens.Screen;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static CublinoGame.ass2.gui.tools.GuiBase.APP_HEIGHT;
import static CublinoGame.ass2.gui.tools.GuiBase.APP_WIDTH;

public class SettingsScreen implements Screen {
    Board host;
    public SettingsScreen(Board host) {
        this.host = host;
    }

    @Override
    public Scene getScene() {
        Group g = new Group();

        Rectangle pane = new Rectangle(0, 0,APP_WIDTH,APP_HEIGHT);
        Color menuCol = Color.web("#e7e7e7",0.8);
        pane.setFill(menuCol);
        g.getChildren().add(pane);

        Label settings = new Label("Settings");
        settings.setAlignment(Pos.CENTER);
        settings.setLayoutX(APP_WIDTH/2-150);
        settings.setLayoutY(0);
        settings.setStyle("-fx-font-size: 4em;");
        settings.setMinSize(300,150);
        settings.setMaxSize(300,150);
        g.getChildren().add(settings);

        var x = APP_WIDTH/2-300;
        var y = APP_HEIGHT/2-250;

        FlowPane fp = new FlowPane();
        fp.setLayoutX(x);
        fp.setLayoutY(y);
        fp.setPadding(new Insets(50));
        g.getChildren().add (fp);

        Label numlabel = new Label("Enable coordinate numbers ");
        fp.getChildren().add (numlabel);
        var nums = new CheckBox();
        nums.setOnAction(actionEvent -> host.settingsStore.showNumbers = nums.isSelected());
        nums.setSelected(host.settingsStore.showNumbers);
        fp.getChildren().add (nums);


        Label soundlabel = new Label("  |  Enable sound ");
        fp.getChildren().add (soundlabel);
        var sounds = new CheckBox();
        sounds.setOnAction(actionEvent -> host.settingsStore.sounds = sounds.isSelected());
        sounds.setSelected(host.settingsStore.sounds);
        fp.getChildren().add (sounds);

        // back button
        Button back = new Button ("Back");
        back.setLayoutX(10);
        back.setLayoutY(10);
        g.getChildren().add(back);
        back.setOnAction(actionEvent -> host.setScreen(new HomeScreen(host)));
        back.getStyleClass().add("back");
        back.getStylesheets().add(getClass().getResource("title.css").toExternalForm());

        return new Scene(g);

    }
}
