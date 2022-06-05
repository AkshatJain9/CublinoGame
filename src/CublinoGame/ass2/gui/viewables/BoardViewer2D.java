/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package CublinoGame.ass2.gui.viewables;

import CublinoGame.ass2.base.BoardState;
import CublinoGame.ass2.base.Dice;
import CublinoGame.ass2.gui.tools.GuiBase;
import CublinoGame.ass2.gui.tools.resources.TexturePool;
import CublinoGame.ass2.helpers.Position;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoardViewer2D extends BoardViewer {

    public BoardViewer2D(TexturePool pool, BoardState board) {
        super(pool, board);
    }

    /**
     * update the board according to the internal board state
     */
    @Override
    public void update() {
        clearBoard();
        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 7; x++) {
                // get the dice
                Dice d = board.getAtPosition(new Position(x, 6 - y));
                if (d == null)
                    continue; // no dice here

                DiceImageViewer div = new DiceImageViewer(d, pool);
                div.setX (x * GuiBase.TILESIZE + 5);
                div.setY (y * GuiBase.TILESIZE + 5);
                div.setFitWidth(GuiBase.TILESIZE - 10);
                div.setFitHeight(GuiBase.TILESIZE - 10);
                var finalPos = new Position(x, 6 - y);
                div.setOnDiceClicked(position -> onObjClick.onClick(finalPos));
                div.updateFaces();
                getChildren().add (div);
            }
        }
    }

    @Override
    protected void makeBoard() {
        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 7; x ++) {
                var rect = new Rectangle();
                rect.setX(x * GuiBase.TILESIZE);
                rect.setY(y * GuiBase.TILESIZE);
                rect.setWidth(GuiBase.TILESIZE);
                rect.setHeight(GuiBase.TILESIZE);

                Color c;
                if (y % 2 == 0)
                    if (x % 2 == 0)
                        c = Color.GRAY;
                    else
                        c = Color.WHITE;
                else
                if (x % 2 == 0)
                    c = Color.WHITE;
                else
                    c = Color.GRAY;

                rect.setFill(c);
                getChildren().add (rect);
            }
        }
    }
}