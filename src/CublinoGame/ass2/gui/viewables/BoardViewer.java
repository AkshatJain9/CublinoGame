/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package CublinoGame.ass2.gui.viewables;

import CublinoGame.ass2.Cublino;
import CublinoGame.ass2.base.BoardState;
import CublinoGame.ass2.gui.tools.resources.TexturePool;
import javafx.scene.Group;

/**
 * generic drawable board class
 */
public abstract class BoardViewer extends Group {
    protected TexturePool pool;
    protected BoardState board;

    public BoardState getBoard() {
        return board;
    }

    public BoardViewer (TexturePool pool, BoardState board) {
        this.pool = pool;
        this.board = board;

        clearBoard();
        update();
    }

    /**
     * update the board according to the internal board state
     */
    public abstract void update();

    /**
     * create the actual board to play on
     */
    protected abstract void makeBoard();

    /**
     * modify the board placement and update the drawable
     * @param placement the placement string to set the board to
     */
    public void makePlacement (String placement) {
        if (placement == null || (!Cublino.isStateWellFormed(placement) && Character.toLowerCase(placement.charAt(0)) != 'e')) // <- TODO: fix properly
            return;

        board = new BoardState(placement);
        clearBoard();
        update();
    }


    /**
     * set the board directly and apply relevant graphical updates
     * @param state the new BoardState
     */
    public void setBoard(BoardState state) {
        board = state;
        clearBoard();
        update();
    }

    /**
     * clears the pieces off the board whilst keeping background
     * use this method and not getChildren.clear()
     */
    protected void clearBoard () {
        getChildren().clear();
        makeBoard();
    }

    protected ClickEvent onObjClick;
    public void setOnObjClick(ClickEvent onObjClick) {
        this.onObjClick = onObjClick;
    }
}
