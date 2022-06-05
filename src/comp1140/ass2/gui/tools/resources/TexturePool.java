/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package comp1140.ass2.gui.tools.resources;

import javafx.scene.image.Image;

public class TexturePool extends ResourcePool <Image> {
    @Override
    public void load(String key, String path) {
        pool.put (key, new Image (path));
    }
}
