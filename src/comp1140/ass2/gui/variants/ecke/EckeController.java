/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package comp1140.ass2.gui.variants.ecke;

import comp1140.ass2.base.Move;
import comp1140.ass2.game.ContraGame;
import comp1140.ass2.game.EckeGame;
import comp1140.ass2.gui.variants.VariantBase;
import comp1140.ass2.gui.variants.VariantController;

import java.util.ArrayList;

public class EckeController extends VariantController {
    public EckeController(VariantBase base) {
        super(base);
    }

    /**
     * modifies the board with the move input
     *
     * @param move
     */
    @Override
    protected void modifyBoardWithInput(Move move) {
        if (move.isValidJumpMovement())
            base.getGame().getBoard().applyJump(move);
        else if (move.isValidTiltMovement())
            base.getModel().getGame().getBoard().applyTilt(move);
        else if (move.isValidDiagonalJump())
            base.getModel().getGame().getBoard().applyJump(move);
        else if (move.isValidDiagonalTilt())
            base.getModel().getGame().getBoard().applyDiagonalTilt(move);

        incrementMoveCount();
    }

    @Override
    protected void onMovePlayed(Move move) {
        super.onMovePlayed(move);
        EckeGame eckeGame = (EckeGame) base.getGame();
        eckeGame.eckeBattle(move.getEnd());
    }

    @Override
    protected void handleComplete() {
        super.handleComplete();
        endTurn();
    }
}
