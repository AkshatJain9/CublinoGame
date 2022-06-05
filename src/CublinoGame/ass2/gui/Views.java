/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package CublinoGame.ass2.gui;

/**
 * preset camera angles
 */
public enum Views {
    FACING_WHITE    ("Facing Black"),
    FACING_BLACK    ("Facing White"),
    BIRDS_EYE       ("Birds Eye"),
    SIDE_ON         ("Side On"),
    CORNER          ("Corner")
    ;

    private final String name;

    private Views(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}