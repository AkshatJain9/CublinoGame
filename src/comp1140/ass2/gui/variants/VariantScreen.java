/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package comp1140.ass2.gui.variants;

import comp1140.ass2.base.Dice;
import comp1140.ass2.gui.Views;
import comp1140.ass2.gui.menus.GameOverOverlay;
import comp1140.ass2.gui.menus.PauseScreenOverlay;
import comp1140.ass2.gui.tools.GuiBase;
import comp1140.ass2.gui.tools.screens.Screen3D;
import comp1140.ass2.gui.viewables.Plane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Rotate;

/**
 * generic gamescreen which reads a game state
 * view
 */
public class VariantScreen extends Screen3D {
    protected FlowPane UI;

    // getters and setters
    private final Text turnText;
    public Text getTurnText() {
        return turnText;
    }

    private final GameGroup gameGroup;
    public GameGroup getGameGroup() {
        return gameGroup;
    }

    private ComboBox views;

    VariantBase base;

    protected Text variantText;

    public VariantScreen(VariantBase base) {
        super();

        this.base = base;

        // initialise UI
        // buttons
        UI = new FlowPane();
        UI.setLayoutX(100);
        UI.setLayoutY(GuiBase.APP_HEIGHT - 100);

        if (GuiBase.is3DSupported()) {
            // table
            Plane p = new Plane(base.getHost().getTexturePool().get("koyubi"));
            p.setRotationAxis(Rotate.X_AXIS);
            p.setRotate(-90);
            p.setScaleX(-5000);
            p.setScaleY(-5000);
            p.setScaleZ(5000);
            p.setTranslateY(500);
            root3d.getChildren().add(0, p);

            // views dropdown
            ObservableList options = FXCollections.observableArrayList();

            for (Views v : Views.values()){
                options.add(v);
            }

            // views drop down
            views = new ComboBox(options);
            views.setPromptText(options.get(0).toString());
            views.setOnAction(actionEvent -> updateView((Views) views.getValue()));
            UI.getChildren().add(views);


            // instruction
            var inst = new Text("Right click + drag -> rotate\nMiddle click + drag -> pan\nScroll -> zoom");
            inst.setTextAlignment(TextAlignment.RIGHT);
            inst.setX(GuiBase.APP_WIDTH - 180);
            inst.setY(30);
            inst.setFill (Color.WHITE);
            root2d.getChildren().add (inst);
        }

        // add UI


        gameGroup = new GameGroup(base);
        root3d.getChildren().add(gameGroup);

        var r = new Rectangle(0,0,GuiBase.APP_WIDTH, 80);
        r.setFill(Color.BLACK);
        r.setOpacity(0.2);
        root2d.getChildren().add (r);

        // text
        variantText = new Text("now playing: " + base.getVariantName());
        variantText.setX(30);
        variantText.setY(30);
        variantText.setFill (Color.WHITE);
        root2d.getChildren().add (variantText);

        // playing text
        turnText = new Text(base.getModel().getCurrentPlayer().getName() + " is playing...");
        turnText.setX(30);
        turnText.setY(60);
        turnText.setFill (Color.WHITE);
        root2d.getChildren().add (turnText);


        root2d.getChildren().add(UI);

        // pause menu
        var pauseMenu = new PauseScreenOverlay(base);

        root2d.setOnKeyPressed(keyEvent -> {
            KeyCode key = keyEvent.getCode();
            if (key == KeyCode.ESCAPE)
                pauseMenu.setVisible(!pauseMenu.isVisible());
        });
        pauseMenu.setVisible(false);
        root2d.getChildren().add (pauseMenu);
    }

    // update with camera presets
    public void updateView(Views view) {
        if (!GuiBase.is3DSupported())
            return;

        switch (view) {
            case BIRDS_EYE -> {
                cameraRotateX.setAngle(-90);
                cameraRotateY.setAngle(0);
                cameraTranslate.setX(-100);
                cameraTranslate.setY(-200);
                cameraTranslate.setZ(100);
            }
            case CORNER -> {
                cameraTranslate.setX(-100);
                cameraTranslate.setY(0);
                cameraTranslate.setZ(-64);
                cameraRotateX.setAngle(-55);
                cameraRotateY.setAngle(45);
            }
            case SIDE_ON -> {
                cameraTranslate.setX(125);
                cameraTranslate.setY(0);
                cameraTranslate.setZ(-180);
                cameraRotateX.setAngle(-45);
                cameraRotateY.setAngle(-90);
            }
            case FACING_BLACK -> {
                cameraTranslate.setX(0);
                cameraTranslate.setY(0);
                cameraTranslate.setZ(-100);
                cameraRotateX.setAngle(-45);
                cameraRotateY.setAngle(180);
            }
            case FACING_WHITE -> {
                cameraTranslate.setX(0);
                cameraTranslate.setY(0);
                cameraTranslate.setZ(0);
                cameraRotateX.setAngle(-45);
                cameraRotateY.setAngle(0);
            }
        }
    }

    public void update(Dice selected) {
        gameGroup.update(selected);
    }

    public void enableGameOver() {
        root2d.getChildren().add (new GameOverOverlay(base));
    }
}
