/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package CublinoGame.ass2.gui.tools.resources;

import javafx.scene.media.AudioClip;

public class AudioPool extends ResourcePool<AudioClip> {
    @Override
    public void load(String key, String path) {
        pool.put (key, new AudioClip(path));
    }
}
