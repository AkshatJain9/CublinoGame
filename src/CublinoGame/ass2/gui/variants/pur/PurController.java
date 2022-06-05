/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package CublinoGame.ass2.gui.variants.pur;

import CublinoGame.ass2.base.Move;
import CublinoGame.ass2.gui.players.PlayerType;
import CublinoGame.ass2.gui.variants.VariantBase;
import CublinoGame.ass2.gui.variants.VariantController;

import java.util.ArrayList;

public class PurController extends VariantController {

    public PurController(VariantBase base) {
        super(base);
    }

    @Override
    public void modifyBoardWithInput(Move move) {
        if (move.isValidJumpMovement())
            base.getGame().getBoard().applyJump(move);
        else if (move.isValidTiltMovement() && getMoveCount() == 0)
            base.getModel().getGame().getBoard().applyTilt(move);
        incrementMoveCount();
    }

    @Override
    public ArrayList<ArrayList<Move>> getLegalMoves(int k) {
        var ret = new ArrayList<ArrayList<Move>>();

        for (var spots : base.getGame().getLegalMoves()) {
            // can only make tilt moves if this is the first move
            if (base.getController().getMoveCount() != 0) {
                spots.removeIf(x -> base.getGame().getBoard().tiltDice(x));
            }
            ret.add(spots);
        }

        return ret;
    }

    @Override
    public void onSwitchControl(PlayerType.Ref type) {
        // finish button
        var s = (PurScreen)(base.getScreen());
        if (s == null)
            return;
        var disabled = base.getModel().getCurrentPlayer().getType() != PlayerType.Ref.LOCAL;
        s.getFinishButton().setDisable(disabled);
    }
}
