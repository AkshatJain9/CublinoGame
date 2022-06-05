package CublinoGame.ass2.base;

import CublinoGame.ass2.helpers.Axis;

/**
 * The absolute direction on the board, upwards if north
 */
public enum Direction {
    NORTH (1, Axis.Y),
    SOUTH (-1, Axis.Y),
    EAST (1, Axis.X),
    WEST (-1, Axis.X);

    int i;
    Axis axis;

    Direction(int i, Axis axis) {
        this.i = i;
        this.axis = axis;
    }

    public int getDirection () {
        return i;
    }

    public Axis getAxis () {
        return axis;
    }
}
