/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package CublinoGame.ass2.gui.variants.contra;

import CublinoGame.ass2.base.Move;
import CublinoGame.ass2.game.ContraGame;
import CublinoGame.ass2.gui.variants.VariantBase;
import CublinoGame.ass2.gui.variants.VariantController;

public class ContraController extends VariantController {
    public ContraController(VariantBase base) {
        super(base);
    }

    /**
     * modifies the board with the move input
     *
     * @param move
     */
    @Override
    protected void modifyBoardWithInput(Move move) {
        if (move.isValidTiltMovement())
            base.getModel().getGame().getBoard().applyTilt(move);

        incrementMoveCount();
    }

    @Override
    protected void handleComplete() {
        // end the turn immediately
        super.handleComplete();
        endTurn();
    }

    @Override
    protected void onMovePlayed(Move move) {
        super.onMovePlayed(move);
        ContraGame contraGame = (ContraGame)base.getGame();
        contraGame.battle(move.getEnd());
    }
}
