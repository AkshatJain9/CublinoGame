/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package CublinoGame.ass2.gui.viewables;

import CublinoGame.ass2.base.Dice;
import CublinoGame.ass2.base.Player;
import CublinoGame.ass2.gui.tools.resources.TexturePool;
import javafx.scene.image.ImageView;

public class DiceImageViewer extends ImageView implements DiceViewer {
    Dice internalDice;
    int player;
    TexturePool pool;

    public DiceImageViewer(Dice d, TexturePool pool) {
        player = d.getTurn() == Player.PLAYER1 ? 1 : 2;
        this.pool = pool;
        internalDice = d;

        setOnMouseClicked(mouseEvent -> onDiceClicked.onClick(internalDice.getPosition()));
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
        setImage (pool.get ("dice" + player + internalDice.getTop()));
    }
}
