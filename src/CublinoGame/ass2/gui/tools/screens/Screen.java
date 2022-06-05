/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package CublinoGame.ass2.gui.tools.screens;

import javafx.scene.Scene;

/**
 * Single view containing a screen
 */
public interface Screen {
    /**
     * what to draw on the screen
     * @return a scene containing the group to draw
     */
    Scene getScene();
}
