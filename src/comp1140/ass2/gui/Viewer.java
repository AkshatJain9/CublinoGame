package comp1140.ass2.gui;

import comp1140.ass2.base.BoardState;
import comp1140.ass2.gui.tools.GuiBase;
import comp1140.ass2.gui.tools.resources.TexturePool;
import comp1140.ass2.gui.tools.screens.Screen3D;
import comp1140.ass2.gui.viewables.BoardViewer;
import comp1140.ass2.gui.viewables.BoardViewer2D;
import comp1140.ass2.gui.viewables.BoardViewer3D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * A very simple viewer for piece placements in the Cublino game.
 * <p>
 * NOTE: This class is separate from your main game class.  This
 * class does not play a game, it just illustrates various piece
 * placements.
 */
public class Viewer extends GuiBase {
    private final ViewerScreen viewer;

    public Viewer() {
        super();
        setScreen(viewer = new ViewerScreen(getTexturePool()));
    }

    /**
     * Draw a placement in the window, removing any previously drawn one
     *
     * @param placement A valid placement string
     */
    void makePlacement(String placement) {
        viewer.makePlacement(placement);
    }

    private static class ViewerScreen extends Screen3D {
        private TextField textField;
        private final Group controls = new Group();

        //private final BoardViewer3D boardGroup;
        private final BoardViewer boardGroup;

        public ViewerScreen(TexturePool texturePool) {
            // assign texturePool to board
            boardGroup = GuiBase.is3DSupported() ? new BoardViewer3D(texturePool, new BoardState()) : new BoardViewer2D(texturePool, new BoardState());
            boardGroup.setOnObjClick(pos -> { });

            // setup gui
            makeControls();

            // setup default placements
            makePlacement("PWa1Wb1Wc1Wd1We1Wf1Wg1va7vb7vc7vd7ve7vf7vg7");


            // TODO: fix regression in lighting
            // setup extra lights
            //AmbientLight al = new AmbientLight();
            //al.setRotationAxis(Rotate.X_AXIS);
            //al.setRotate(-45);
            //al.setTranslateY(-300);
            //boardGroup.getChildren().add(al);

            // add both layers to root
            root3d.getChildren().add(boardGroup);

            // add everything to ui subscene
            root2d.getChildren().add(controls);
        }

        /**
         * applies a board string to the viewer board
         */
        public void makePlacement(String placement) {
            boardGroup.makePlacement(placement);
        }

        /**
         * Create a basic text field for input and a refresh button.
         */
        private void makeControls() {
            Label label1 = new Label("Placement:");
            textField = new TextField();
            textField.setPrefWidth(300);
            Button refresh = new Button("Refresh");
            refresh.setOnAction(actionEvent -> {
                makePlacement(textField.getText());
                //  textField.clear(); // <- this is actually quite annoying imo ...
            });
            HBox hb = new HBox();
            hb.getChildren().addAll(label1, textField, refresh);
            hb.setSpacing(10);
            hb.setLayoutX(230);
            hb.setLayoutY(GuiBase.APP_HEIGHT - 50);
            controls.getChildren().add(hb);
        }
    }
}

