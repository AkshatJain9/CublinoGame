/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package CublinoGame.ass2.gui.viewables;

import CublinoGame.ass2.base.Dice;
import CublinoGame.ass2.base.Direction;
import CublinoGame.ass2.base.Player;
import CublinoGame.ass2.gui.Viewer;
import CublinoGame.ass2.gui.tools.resources.TexturePool;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.transform.Rotate;

/**
 * drawable representation of a regular dice
 */
public class DiceMeshViewer extends Group implements DiceViewer{

    // contains all 6 sides of the cube
    Plane[] planes;

    // the dice to represent
    Dice dice;

    // texture pool
    TexturePool pool;

    // used in access player specific textures
    int player;

    public Direction lastDirection;

    public DiceMeshViewer(Dice d, TexturePool pool) {
        player = d.getTurn() == Player.PLAYER1 ? 1 : 2;
        dice = d;
        this.pool = pool;

        planes = new Plane[6];
        float w = (float)(Viewer.TILESIZE-40)/2;


        // store intrinsic properties of each side
        // the (n+1)th element in each array is referring to the side on the right sided dice
        // with n dots on it

        Point3D[] axes = new Point3D[] {
                Rotate.X_AXIS, Rotate.Z_AXIS, Rotate.Y_AXIS, Rotate.Y_AXIS, Rotate.Y_AXIS, Rotate.X_AXIS
        };
        float[] rotations = new float[] {-1, 0, -1, 1, 2, 1};

        Point3D[] translateAxes = new Point3D[] {
                Rotate.Y_AXIS, Rotate.Z_AXIS, Rotate.X_AXIS, Rotate.X_AXIS, Rotate.Z_AXIS, Rotate.Y_AXIS
        };
        float[] offset = new float[] {-1, -1, 1, -1, 1, 1};

        // creating each dice
        for (int i = 0; i < 6; i++) {
            var diceNo = i + 1;

            Plane p = new Plane (pool.get ("dice" + player + diceNo));
            p.setRotationAxis(axes[i]);
            p.setRotate(90 * rotations[i]);
            var off = w * offset[i];

            if (Rotate.X_AXIS.equals(translateAxes[i])) {
                p.setTranslateX(getTranslateX() + off);
            } else if (Rotate.Y_AXIS.equals(translateAxes[i])) {
                p.setTranslateY(getTranslateY() + off);
            } else if (Rotate.Z_AXIS.equals(translateAxes[i])) {
                p.setTranslateZ(getTranslateZ() + off);
            }

            p.setOnMouseClicked(mouseEvent -> onDiceClicked.onClick(dice.getPosition()));

            p.setScaleX(w);
            p.setScaleY(w);
            p.setScaleZ(w);

            planes[i] = p;
        }

        getChildren().addAll (planes);

        updateFaces();
    }

    private ClickEvent onDiceClicked;

    @Override
    public void setOnDiceClicked(ClickEvent onDiceClicked) {
        this.onDiceClicked = onDiceClicked;
    }

    /**
     * retextures each side of the dice according to the cycles
     * giving the illusion of the dice flipping
     */
    @Override
    public void updateFaces () {
        int[] faces = new int[]{
                dice.getyCycle()[1],
                dice.getyCycle()[0],
                dice.getxCycle()[2],
                dice.getxCycle()[0],
                dice.getyCycle()[2],
                7 - dice.getxCycle()[1]
        };

        for (int i = 0; i < planes.length; i++) {
            Plane p = planes[i];
            p.updateTexture(pool.get ("dice" + player + faces[i]));
        }
    }
}
