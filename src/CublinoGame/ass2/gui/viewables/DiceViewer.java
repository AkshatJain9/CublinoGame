/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package CublinoGame.ass2.gui.viewables;

/**
 * generic drawable dice
 */
public interface DiceViewer {
    /**
     * updates the faces according to the internal dice
     */
    void updateFaces();

    /**
     * click event for dice
     * @param onDiceClicked
     */
    void setOnDiceClicked(ClickEvent onDiceClicked);
}
