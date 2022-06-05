/*
 * AUTHORSHIP: Chris Kim, Akshat Jain
 * Other Works/Members Cited: N/A
 */

package CublinoGame.ass2.base;

import CublinoGame.ass2.Cublino;
import CublinoGame.ass2.helpers.Position;

import java.util.ArrayList;

public class BoardState implements Cloneable {
    // this 2D array uses the convention of y before x ie placements [y][x] to preserve matrix indexing format
    public Dice[][] placements;

    /**
     * Construct a board with dice in their initial positions.
     */
    public BoardState() {
        placements = new Dice[7][7];
    }

    /**
     * Construct a board using a placement string
     * @param placement the entire placement string representing the game state
     */
    public BoardState(String placement) {
        if (!Cublino.isStateWellFormed (placement) && !((placement.toLowerCase()).charAt(0) == 'e')) {
            throw new java.lang.UnsupportedOperationException();
        }
        placements = new Dice[7][7];
        for (int i = 1; i < placement.length(); i += 3) {
            Dice d = new Dice(placement.substring(i,i+3));
            if (placements[d.getPosition().getY()][d.getPosition().getX()] != null) {
                throw new java.lang.UnsupportedOperationException();
            }
            placements[d.getPosition().getY()][d.getPosition().getX()] = d;
        }
    }

    /**
     * Creates new board given only placements
     * @param placements The Dice placements
     */
    public BoardState(Dice[][] placements) {
        this.placements = placements;
    }

    /**
     * Returns placements
     */
    public Dice[][] getPlacements() {
        return placements;
    }

    /**
     * gets the dice at the given position
     * @param p the position to search
     * @return a dice (if available), will return null otherwise
     */
    public Dice getAtPosition (Position p) {
        return placements[p.getY()][p.getX()];
    }

    public Dice getAtIndex (int x, int y) {
        return placements[y][x];
    }

    /**
     * Insert a given dice at the given position
     * @param p the position to insert to
     * @param d the dice to insert
     */
    public void insertDie (Position p, Dice d) {
        placements[p.getY()][p.getX()] = d;
    }

    /**
     * Removes dice at a specified location
     * @param p The position at which the dice is to be removed
     */
    public void removeDie (Position p) {
        placements[p.getY()][p.getX()] = null;
    }

    /**
     * forcefully move a dice from one position to another
     * do not use this for general game use
     * @param start Start posiitons
     * @param end end position
     */
    public void moveDie (Position start, Position end) {
        var dice = getAtPosition(start);
        if (dice == null)
            return;
        dice.setPosition(end);
        removeDie (start);
        insertDie(end, dice);
    }

    /**
     * Return if a tilt move is valid or not
     * @param m the move being played
     * @return whether the roll operation would be successful
     */
    public boolean tiltDice (Move m) {
        var a = !isOccupied(m.getEnd());
        var b = m.isValidTiltMovement();
        return a && b;
    }

    /**
     * rolls the dice on the board in a specified direction
     * @param m the move being played
     */
    public void applyTilt (Move m) {
        insertDie(m.getEnd(), getAtPosition(m.getStart()));
        removeDie(m.getStart());
        getAtPosition(m.getEnd()).tiltDice(m.getDirection());
        getAtPosition(m.getEnd()).setPosition(m.getEnd());
    }

    /**
     * Return if diagonal tilt is valid
     * @param m Move to be checked
     * @return If it is valid or not
     */
    public boolean diagonalTilt (Move m) {
        return !isOccupied(m.getEnd()) && m.isValidDiagonalTilt();
    }

    /**
     * Applies a diagonal tilt to board state
     * @param m Move to be applied
     */
    public void applyDiagonalTilt (Move m) {
        insertDie(m.getEnd(), getAtPosition(m.getStart()));
        removeDie(m.getStart());
        switch (m.getDiagonalDirection()) {
            case 1 -> {
                getAtPosition(m.getEnd()).tiltDice(Direction.NORTH);
                getAtPosition(m.getEnd()).tiltDice(Direction.EAST);
                getAtPosition(m.getEnd()).tiltDice(Direction.NORTH);
            }
            case 2 -> {
                getAtPosition(m.getEnd()).tiltDice(Direction.SOUTH);
                getAtPosition(m.getEnd()).tiltDice(Direction.EAST);
                getAtPosition(m.getEnd()).tiltDice(Direction.SOUTH);
            }
            case 3 -> {
                getAtPosition(m.getEnd()).tiltDice(Direction.SOUTH);
                getAtPosition(m.getEnd()).tiltDice(Direction.WEST);
                getAtPosition(m.getEnd()).tiltDice(Direction.SOUTH);
            }
            case 4 -> {
                getAtPosition(m.getEnd()).tiltDice(Direction.NORTH);
                getAtPosition(m.getEnd()).tiltDice(Direction.WEST);
                getAtPosition(m.getEnd()).tiltDice(Direction.NORTH);
            }
        }
        getAtPosition(m.getEnd()).setPosition(m.getEnd());
    }

    /**
     * jumps the dice on the board in a specified direction
     * @param m the move being played
     * @return whether it was possible to jump the dice in the given direction
     */

    public boolean jumpDice (Move m) {
        var a = !isOccupied(m.getEnd());
        var b = m.isValidJumpMovement();
        var c = isOccupied(m.getPositionUnderJump());
        return a && b  && c;
    }

    /**
     * Checks if jump is valid
     * @param m Move to be checked
     * @return Validity
     */
    public boolean diagonalJump (Move m) {
        return !isOccupied(m.getEnd()) && m.isValidDiagonalJump() && isOccupied(m.getPositionUnderJump());
    }

    /**
     * Jumps the dice on the board in a specified direction
     * @param m the move being played
     */
    public void applyJump (Move m) {
        insertDie(m.getEnd(), getAtPosition(m.getStart()));
        removeDie(m.getStart());
        getAtPosition(m.getEnd()).setPosition(m.getEnd());
    }

    /**
     * Whether a specified position is occupied
     * @param p the position to check
     * @return whether that position has another dice
     */
    public boolean isOccupied (Position p) {
        var k = placements[p.getY()][p.getX()];
        return placements[p.getY()][p.getX()] != null;
    }


    /**
     * Gets a list of dice which are adjacent to the dice at p and it belongs to the other player (by tilt)
     * @param p Position
     * @return adjacent positions of die that belong to the other player
     */
    public ArrayList<Position> getOpponentDicePosContra (Position p) {
        ArrayList<Position> adjpos = new ArrayList<>();
        ArrayList<Position> surroundingPositions = p.getTiltPositions();
        for (Position loc : surroundingPositions) {
            if (getAtPosition(loc) != null && getAtPosition(p) != null) {
                if (isOccupied(loc) && getAtPosition(loc).getTurn() != getAtPosition(p).getTurn()) {
                    adjpos.add(loc);
                }
            }
        }
        return adjpos;
    }


    /**
     * Gets a list of dice which are adjacent to the dice at p and it belongs to the other player
     * @param p Position
     * @return adjacent positions of die that belong to the other player
     */
    public ArrayList<Position> getOpponentDicePosEcke (Position p) {
        ArrayList<Position> adjpos = new ArrayList<>();
        ArrayList<Position> surroundingPositions = p.getallSurroundingPositions();
        for (Position loc : surroundingPositions) {
            if (getAtPosition(loc) != null && getAtPosition(p) != null) {
                if (isOccupied(loc) && getAtPosition(loc).getTurn() != getAtPosition(p).getTurn()) {
                    adjpos.add(loc);
                }
            }
        }
        return adjpos;
    }


    /**
     * Gets an array list of all dice on the board
     * @return the arraylist containing all dice on the board at that given state.
     */
    public ArrayList<Dice> getBoardPieces () {
        ArrayList<Dice> pieces = new ArrayList<>();

        // searches the board
        for (int row = 0; row<=6 ; row++) {
            for (int column = 0; column<=6; column++) {
                // checks if the position is occupied and adds the die to the list if it is present
                if (isOccupied(new Position(row,column))) {
                    pieces.add(getAtPosition(new Position(row,column)));
                }
            }
        }
        return pieces;
    }

    /**
     * prints a string version of the board
     * keep in mind that the board sides are reversed
     * @return String form of board
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var col : placements) {
            for (var dice : col) {
                if (dice == null) {
                    sb.append("..  ");
                } else {
                    sb.append(dice.getTop()).append(dice.getTurn() == Player.PLAYER1 ? "1" : "2").append("  ");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    @Override
    public BoardState clone() {
        try {
            BoardState clone = (BoardState) super.clone();
            //System.arraycopy(placements, 0, )
            clone = new BoardState();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
