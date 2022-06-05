/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package CublinoGame.ass2.gui.variants.replay;

import CublinoGame.ass2.base.Move;
import CublinoGame.ass2.gui.variants.VariantBase;
import CublinoGame.ass2.gui.variants.VariantController;

public class ReplayController extends VariantController {
    public int playback;

    public int getPlayback() {
        return playback;
    }

    public ReplayController(VariantBase base) {
        super(base);
    }

    /**
     * modifies the board with the move input
     *
     * @param move
     */
    @Override
    protected void modifyBoardWithInput(Move move) { }

    public void moveReplayForward() {
        if (playback + 1 >= base.getModel().replay.size())
            return;
        playback++;
        updatePlayback();
    }

    public void setReplayPlayhead(int p) {
        playback = p;
        updatePlayback();
    }

    public void moveReplayBackward() {
        if (playback == 0)
            return;
        playback--;
        updatePlayback();
    }

    private void updatePlayback() {
        base.getScreen().getGameGroup().getBoardGroup().makePlacement(base.getModel().replay.get(playback));
    }
}
