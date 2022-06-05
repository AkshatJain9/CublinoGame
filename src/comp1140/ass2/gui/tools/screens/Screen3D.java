/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package comp1140.ass2.gui.tools.screens;

import comp1140.ass2.gui.tools.GuiBase;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Paint;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

/**
 * Generic viewer for both Board and viewer, contains a movable camera
 */
public class Screen3D implements Screen {

    protected final Group root = new Group();
    protected final Group root3d = new Group();
    protected final Group root2d = new Group();
    protected PerspectiveCamera camera;

    // position before rotation transformations
    protected Translate cameraTranslate;

    // position after rotation transformations
    protected Translate cameraPostTranslate;

    protected Rotate cameraRotateX;
    protected Rotate cameraRotateY;

    protected final double cameraPivotX = 400;
    protected final double cameraPivotY = 300;


    @Override
    public Scene getScene() {
        if (GuiBase.is3DSupported()) {
            // setup camera
            camera = new PerspectiveCamera(false);

            camera.getTransforms().add(cameraRotateY = new Rotate(0, Rotate.Y_AXIS));
            camera.getTransforms().add(cameraTranslate = new Translate(0, 0, 0));
            camera.getTransforms().add(cameraRotateX = new Rotate(-45, Rotate.X_AXIS));
            camera.getTransforms().add(cameraPostTranslate = new Translate(-100, -350, -500));

            cameraRotateY.setPivotX(cameraPivotX);
            cameraRotateY.setPivotZ(cameraPivotY);
            cameraRotateX.setPivotX(cameraPivotX);
            cameraRotateX.setPivotZ(cameraPivotY);

            // create returnable scene
            var world = new SubScene(root3d, GuiBase.APP_WIDTH, GuiBase.APP_HEIGHT, true, SceneAntialiasing.BALANCED);

            // add everything to root
            world.setCamera(camera);
            root.getChildren().add(world);
        } else {
            root.getChildren().add (root3d);
        }

        root.minWidth(GuiBase.APP_WIDTH);
        root.minHeight(GuiBase.APP_HEIGHT);
        root.getChildren().add(root2d);
        Scene s = new Scene(root, GuiBase.APP_WIDTH, GuiBase.APP_HEIGHT);

        // camera input
        s.setOnMouseDragged(this::dragMouse);
        s.setOnMousePressed(this::pressMouse);
        s.setOnScroll(this::scrollMouse);

        s.fillProperty().set(Paint.valueOf("#009688"));

        return s;
    }

    private void scrollMouse(ScrollEvent scrollEvent) {
        cameraPostTranslate.setZ(cameraPostTranslate.getZ() + scrollEvent.getDeltaY() * 10);
    }

    // controls

    // pitch
    double mx = 0;
    double ax = 0;

    // yaw
    double my = 0;
    double ay = 0;

    // position
    double tx = 0;
    double tz = 0;

    private void pressMouse(MouseEvent mouseEvent) {
        if (!GuiBase.is3DSupported())
            return;

        mx = mouseEvent.getSceneX();
        ax = cameraRotateY.getAngle();

        my = mouseEvent.getSceneY();
        ay = cameraRotateX.getAngle();

        tx = cameraTranslate.getX();
        tz = cameraTranslate.getZ();
    }


    private void dragMouse(MouseEvent mouseEvent) {
        if (!GuiBase.is3DSupported())
            return;

        var dx = mx - mouseEvent.getSceneX();
        var dy = my - mouseEvent.getSceneY();

        if (mouseEvent.isSecondaryButtonDown()) {
            cameraRotateY.setAngle(ax - dx);
            cameraRotateX.setAngle(ay + dy);
        }

        if (mouseEvent.isMiddleButtonDown()) {
            cameraTranslate.setX(tx + dx * 4);
            cameraTranslate.setZ(tz - dy * 4);
        }
    }
}
