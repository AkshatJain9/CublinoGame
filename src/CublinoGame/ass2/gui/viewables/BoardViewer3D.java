/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package CublinoGame.ass2.gui.viewables;

import CublinoGame.ass2.base.Dice;
import CublinoGame.ass2.gui.Viewer;
import CublinoGame.ass2.base.BoardState;
import CublinoGame.ass2.gui.tools.GuiBase;
import CublinoGame.ass2.gui.tools.resources.TexturePool;
import CublinoGame.ass2.helpers.Position;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;

/**
 * Drawable representation of a board
 * This group also contains the die
 */
public class BoardViewer3D extends BoardViewer {
    public BoardViewer3D(TexturePool pool, BoardState board) {
        this(pool, board, true);
    }

    boolean showNums;

    public BoardViewer3D(TexturePool pool, BoardState board, boolean showNums) {
        super(pool, board);
        this.showNums = showNums;
    }

    /**
     * update the board according to the internal board state
     */
    public void update() {
        clearBoard();
        // assuming the board is 7x7, find all dice and draw them
        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 7; x++) {
                // get the dice
                Dice d = board.getAtPosition(new Position(x, y));
                if (d == null)
                    continue; // no dice here

                // make the dice mesh
                DiceMeshViewer dmv = new DiceMeshViewer(d, pool);
                dmv.setTranslateX(x * Viewer.TILESIZE);
                dmv.setTranslateY(0);
                dmv.setTranslateZ(y * Viewer.TILESIZE);
                var finalPos = new Position(x, y);
                dmv.setOnDiceClicked(position -> onObjClick.onClick(finalPos));

                getChildren().add (dmv);
            }
        }
    }

    /**
     * draws the board background
     */
    @Override
    protected void makeBoard () {
        for (int y = 0; y < 7; y++) {
            if (showNums) {
                // draw y label
                Text ly = new Text(Integer.toString(y + 1));
                ly.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
                ly.setRotationAxis(Rotate.X_AXIS);
                ly.setRotate(-90);
                ly.setTranslateX(-GuiBase.TILESIZE);
                ly.setTranslateY((float) Viewer.TILESIZE / 3);
                ly.setTranslateZ(y * GuiBase.TILESIZE);
                getChildren().add(ly);

                // draw reverse
                Text ly2 = new Text(Integer.toString(y + 1));
                ly2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
                ly2.setRotationAxis(Rotate.X_AXIS);
                ly2.setRotate(90);
                ly2.setScaleX(-ly2.getScaleX());
                ly2.setTranslateX(GuiBase.TILESIZE * 7);
                ly2.setTranslateY((float) Viewer.TILESIZE / 3);
                ly2.setTranslateZ(y * GuiBase.TILESIZE);
                getChildren().add(ly2);
            }

            for (int x = 0; x < 7; x++) {
                if (y == 0) {
                    if (showNums) {
                        // draw x label
                        Text lx = new Text(String.valueOf((char) (x + (int) 'a')));
                        lx.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
                        lx.setRotationAxis(Rotate.X_AXIS);
                        lx.setRotate(-90);
                        lx.setTranslateX(x * GuiBase.TILESIZE);
                        lx.setTranslateY((float) Viewer.TILESIZE / 3);
                        lx.setTranslateZ(-GuiBase.TILESIZE);
                        getChildren().add(lx);

                        // draw reverse
                        Text lx2 = new Text(String.valueOf((char) ((x) + (int) 'a')));
                        lx2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
                        lx2.setRotationAxis(Rotate.X_AXIS);
                        lx2.setRotate(90);
                        lx2.setTranslateX(x * GuiBase.TILESIZE);
                        lx2.setTranslateY((float) Viewer.TILESIZE / 3);
                        lx2.setTranslateZ(GuiBase.TILESIZE * 7);
                        lx2.setScaleX(-lx2.getScaleX());
                        getChildren().add(lx2);
                    }
                }

                // draw tile
                Plane t;
                if (y % 2 == 0)
                    if (x % 2 == 0)
                        t = new Plane(pool.get("tile1"));
                    else
                        t = new Plane(pool.get("tile2"));
                else
                    if (x % 2 == 0)
                        t = new Plane(pool.get("tile2"));
                    else
                        t = new Plane(pool.get("tile1"));

                t.setRotationAxis(Rotate.X_AXIS);
                t.setRotate(-90);
                t.setTranslateX(x * Viewer.TILESIZE);
                t.setTranslateY((float)(Viewer.TILESIZE / 3));
                t.setTranslateZ(y * Viewer.TILESIZE);
                t.setScaleX((float)Viewer.TILESIZE / 2);
                t.setScaleY((float)Viewer.TILESIZE / 2);
                t.setScaleZ((float)Viewer.TILESIZE / 2);
                getChildren().add (t);
            }
        }
    }
}
