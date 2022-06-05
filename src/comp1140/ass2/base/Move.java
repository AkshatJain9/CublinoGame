/*
 * AUTHORSHIP: Akshat Jain
 * Other Works/Members Cited: N/A
 */

package comp1140.ass2.base;

import comp1140.ass2.helpers.Position;

import java.util.Objects;

public class Move {
    private final Position start;
    private final Position end;
    private Player dieOwner;

    /**
     * Creates move in accordance to location string and player
     * @param s The location string of the move
     * @param p The player who's move it is
     */
    public Move (String s, Player p) {
        if (s == null || s.length() != 4) throw new RuntimeException("string was malformed");
        start = new Position(s.substring(0,2));
        end = new Position(s.substring(2,4));
        dieOwner = p;
    }

    /**
     * Creates move in accordance to location string, player should be loaded manually
     * @param s The location string of the move
     */
    public Move (String s) {
        if (s == null || s.length() != 4) throw new RuntimeException("string was malformed");
        start = new Position(s.substring(0,2));
        end = new Position(s.substring(2,4));
        dieOwner = null;
    }

    /**
     * Constructors to interpret the game state string
     * @param start the starting position of the dice before the move
     * @param end the final position of the dice after the move
     * @param owner whose dice it is
     */
    public Move (Position start, Position end, Player owner) {
        this.start = start;
        this.end = end;
        this.dieOwner = owner;
    }

    /**
     * Creates move in accordance to only integer coordinate locations
     * @param xstart Starting x-coordinate
     * @param ystart Starting y-coordinate
     * @param xend End x-coordinate
     * @param yend End y-coordinate
     * @param p Player whose turn it is
     */
    public Move (int xstart, int ystart, int xend, int yend, Player p) {
        this.start = new Position(xstart,ystart);
        this.end = new Position(xend,yend);
        this.dieOwner = p;
    }

    // getters
    public Position getStart() {
        return start;
    }

    public Position getEnd() {
        return end;
    }

    public Player getPlayer() {
        return dieOwner;
    }

    public void setPlayer(Player p) {
        this.dieOwner = p;
    }

    /**
     * Checks if the tilt movement is valid.
     * Only checks if the x and y coordinates are correct.
     * Doesn't account for if there is a conflict of dice position.
     * @return if it is a valid tilt movement
     */
    public boolean isValidTiltMovement () {
        if (dieOwner == null) throw new RuntimeException("dice owner was null");
        if (dieOwner == Player.PLAYER1) {
            return (start.getX() == end.getX() && start.getY() == end.getY() - 1) ||
                    (start.getY() == end.getY() && Math.abs(start.getX() - end.getX()) == 1);
        }
        return (start.getX() == end.getX() && start.getY() == end.getY() + 1) ||
                (start.getY() == end.getY() && Math.abs(start.getX() - end.getX()) == 1);
    }

    /**
     * Checks if the jump movement is valid.
     * Only checks if the x and y coordinates are correct.
     * Doesn't account for if there is a conflict of dice position.
     * Doesn't check if there is a dice under a jump, this is done in the board class.
     * @return if it is a valid jump movement
     */
    public boolean isValidJumpMovement () {
        if (dieOwner == null) throw new RuntimeException("dice owner was null");
        if (dieOwner == Player.PLAYER1) {
            return (start.getX() == end.getX() && start.getY() == end.getY() - 2) ||
                    (start.getY() == end.getY() && Math.abs(start.getX() - end.getX()) == 2);
        }
        return (start.getX() == end.getX() && start.getY() == end.getY() + 2) ||
                (start.getY() == end.getY() && Math.abs(start.getX() - end.getX()) == 2);
    }

    /**
     * Checks if the tilt movement is valid.
     * Only checks if the x and y coordinates are correct.
     * Doesn't account for if there is a conflict of dice position.
     * @return if it is a valid diagonal tilt movement
     */
    public boolean isValidDiagonalTilt () {
        if (dieOwner == null) throw new RuntimeException("dice owner was null");
        if (dieOwner == Player.PLAYER1) {
            return ((start.getX() == end.getX() + 1 && start.getY() == end.getY() - 1) ||
                    (start.getX() == end.getX() - 1 && start.getY() == end.getY() - 1));
        }
        return ((start.getX() == end.getX() + 1 && start.getY() == end.getY() + 1) ||
                (start.getX() == end.getX() - 1 && start.getY() == end.getY() + 1));

    }

    /**
     * Checks if the diagonal jump movement is valid.Only checks if the x and y coordinates are correct.
     * Doesn't account for if there is a conflict of dice position.
     * Doesn't check if there is a dice under a jump, this is done in the board class.
     * @return if it is a valid diagonal jump movement
     */
    public boolean isValidDiagonalJump () {
        if (dieOwner == null) throw new RuntimeException("dice owner was null");
        if (dieOwner == Player.PLAYER1) {
            return ((start.getX() == end.getX() + 2 && start.getY() == end.getY() - 2) ||
                    (start.getX() == end.getX() - 2 && start.getY() == end.getY() - 2));
        }
        return ((start.getX() == end.getX() + 2 && start.getY() == end.getY() + 2) ||
                (start.getX() == end.getX() - 2 && start.getY() == end.getY() + 2));
    }

    /**
     * retrieves the position under the jump (Also works for diagonal jump)
     * @return the position of the dice under jump
     */
    public Position getPositionUnderJump () {
        if (isValidTiltMovement() || isValidDiagonalTilt()) return start;
        return new Position((start.getX() + end.getX())/2, (start.getY()+ end.getY())/2);
    }

    /**
     * Reads from move's start and end position to calculate direction of dice movement
     * @return Direction of movement as defined in enum class
     */
    public Direction getDirection() {
        if (end.getX() > start.getX()) return Direction.EAST;
        if (end.getX() < start.getX()) return Direction.WEST;
        if (end.getY() > start.getY()) return Direction.NORTH;
        return Direction.SOUTH;
    }

    /**
     * Returns diagonal direction (as int for now)
     * @return 1 for NE, 2 for SE, 3 for SW, 4 for NW
     */
    public int getDiagonalDirection() {
        if (end.getX() > start.getX() && end.getY() > start.getY()) return 1;
        if (end.getX() > start.getX() && end.getY() < start.getY()) return 2;
        if (end.getX() < start.getX() && end.getY() < start.getY()) return 3;
        if (end.getX() < start.getX() && end.getY() > start.getY()) return 4;
        return 0;
    }

    @Override
    public String toString() {
        return start.toString() + end.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return Objects.equals(start, move.start) && Objects.equals(end, move.end) && dieOwner == move.dieOwner;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, dieOwner);
    }
}
