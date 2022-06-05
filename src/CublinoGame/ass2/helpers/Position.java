package CublinoGame.ass2.helpers;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Represents a single point in 2D space with Integer coordinates
 */
public class Position {
    private int x;
    private int y;

    public Position (Position p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    public Position () {
        x = 0;
        y = 0;
    }

    public Position (String die) {
        if (die == null || die.length() != 2 || die.charAt(0) < 'a' || die.charAt(0) > 'g' ||
                !(Character.isDigit(die.charAt(1))) ||
                Integer.parseInt(die.substring(1,2)) < 0 || Integer.parseInt(die.substring(1,2)) > 7) {
            throw new java.lang.UnsupportedOperationException();
        }
        this.x = (int) die.charAt(0) - (int) 'a';
        this.y = Integer.parseInt(die.substring(1,2)) - 1;
    }

    public Position (int n) {
        assert (n <= 6 && n >= 0);
        this.x = n;
        this.y = n;
    }

    public Position (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX (int value) { x = value; }

    public int getY() {
        return y;
    }

    public void setY (int value) { y = value; }

    /**
     * Returns Manhattan Distance to Another Position
     * @param p The other position
     * @return Manhattan Distance
     */
    public int getMHDist(Position p) {
        return Math.abs(this.getX() - p.getX()) + Math.abs(this.getY() - p.getY());
    }

    /**
     * Get Direct Pythagorean Distance between positions
     * @param p The other position in question
     * @return Direct distance as double
     */
    public double getDirectDist(Position p) {
        return Math.sqrt(Math.abs(this.getX() - p.getX())^2 + Math.abs(this.getY() - p.getY())^2);
    }

    /**
     * Returns valid tilt locations regardless of the player
     * @return Valid tilt movement locations
     */
    public ArrayList<Position> getTiltPositions() {
        ArrayList<Position> tiltLocs = new ArrayList<>();
        if (this.x - 1 >= 0) {
            tiltLocs.add(new Position(x-1,y));
        }
        if (this.x + 1 <= 6) {
            tiltLocs.add(new Position(x+1,y));
        }
        if (this.y - 1 >= 0) {
            tiltLocs.add(new Position(x,y-1));
        }
        if (this.y + 1 <= 6) {
            tiltLocs.add(new Position(x,y+1));
        }
        return tiltLocs;
    }

    /**
     * Returns valid jump locations regardless of the player
     * @return Valid jump movement locations
     */
    public ArrayList<Position> getJumpPositions() {
        ArrayList<Position> jumpLocs = new ArrayList<>();
        if (this.x - 2 >= 0) {
            jumpLocs.add(new Position(x-2,y));
        }
        if (this.x + 2 <= 6) {
            jumpLocs.add(new Position(x+2,y));
        }
        if (this.y - 2 >= 0) {
            jumpLocs.add(new Position(x,y-2));
        }
        if (this.y + 2 <= 6) {
            jumpLocs.add(new Position(x,y+2));
        }
        return jumpLocs;
    }

    /**
     *  Generates the valid tilt positions in a diagonal direction
     * @return Valid Diagonal Tilt Positions
     */
    public ArrayList<Position> getDiagonalTiltPositions() {
        ArrayList<Position> diagtiltLocs = new ArrayList<>();
        if (this.x - 1 >= 0 && this.y - 1 >= 0) {
            diagtiltLocs.add(new Position(x-1,y-1));
        }
        if (this.x + 1 <= 6 && this.y - 1 >= 0) {
            diagtiltLocs.add(new Position(x+1,y-1));
        }
        if (this.x - 1 >= 0 && this.y + 1 <= 6) {
            diagtiltLocs.add(new Position(x-1,y+1));
        }
        if (this.x + 1 <= 6 && this.y + 1 <= 6) {
            diagtiltLocs.add(new Position(x+1,y+1));
        }
        return diagtiltLocs;
    }

    /**
     *  Generates the valid jump positions in a diagonal direction
     * @return Valid Diagonal Jump Positions
     */
    public ArrayList<Position> getDiagonalJumpPositions() {
        ArrayList<Position> diagJumpLocs = new ArrayList<>();
        if (this.x - 2 >= 0 && this.y - 2 >= 0) {
            diagJumpLocs.add(new Position(x-2,y-2));
        }
        if (this.x + 2 <= 6 && this.y - 2 >= 0) {
            diagJumpLocs.add(new Position(x+2,y-2));
        }
        if (this.x - 2 >= 0 && this.y + 2 <= 6) {
            diagJumpLocs.add(new Position(x-2,y+2));
        }
        if (this.x + 2 <= 6 && this.y + 2 <= 6) {
            diagJumpLocs.add(new Position(x+2,y+2));
        }
        return diagJumpLocs;
    }

    /**
     * Returns all surrounding positions from a single location
     * @return Surrounding positions
     */
    public ArrayList<Position> getallSurroundingPositions() {
        ArrayList<Position> allLocs = new ArrayList<>();
        allLocs.addAll(getTiltPositions());
        allLocs.addAll(getDiagonalTiltPositions());
        return allLocs;
    }

    @Override
    public String toString() {
        char x = (char) (this.x + (int)'a');
        int y = this.y+1;
        return Character.toString(x) + y;
    }

    public static Position Zero () {
        return new Position (0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
