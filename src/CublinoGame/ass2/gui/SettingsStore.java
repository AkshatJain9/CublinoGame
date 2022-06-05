/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package CublinoGame.ass2.gui;

import javafx.application.ConditionalFeature;
import javafx.application.Platform;

public class SettingsStore {
    public boolean showNumbers = true;
    public boolean sounds = true;
    public boolean use2D = Platform.isSupported(ConditionalFeature.SCENE3D);
}
