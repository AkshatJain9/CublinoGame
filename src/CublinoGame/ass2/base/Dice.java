/*
 * AUTHORSHIP: Justin Tieu, Akshat Jain
 * Other Works/Members Cited: N/A
 */

package CublinoGame.ass2.base;

import CublinoGame.ass2.helpers.*;
import java.util.*;

/**
* Handles code relating specifically to an *individual* dice
 */
public class Dice {
    private Position position;
    private final Player owner;

    private int[] xCycle;
    private int[] yCycle;

    // Constructors for setting the Dice Class

    public Dice (Position pos, Player owner, int[] xCycle, int[] yCycle) {
        this.position = pos;
        this.owner = owner;
        this.xCycle = xCycle;
        this.yCycle = yCycle;
    }

    /**
     * construct a dice using the string encoding
     * @param string the string encoding
     */
    public Dice (String string) {
        if (!isDiceValid(string)) throw new java.lang.UnsupportedOperationException();
        char[] s = string.toCharArray();

        // determine owner
        owner = Character.isUpperCase(s[0]) ? Player.PLAYER1 : Player.PLAYER2;

        // determine position
        position = new Position((int) s[1] - 97, (int) s[2] - 49);

        // determine orientation
        // find top side
        int top = ((int) Character.toLowerCase(s[0]) - 97)/4 + 1;

        // find front side
        int counter = ((int) Character.toLowerCase(s[0]) - 97) % 4;
        ArrayList<Integer> diceStuff = new ArrayList<>();
        for(int i = 1; i <= 6; i++) {
            if (i != top && i != 7 - top) {
                diceStuff.add(i);
            }
        }
        int front = diceStuff.get(counter);

        yCycle = new int[] { 7 - front, top, front };

        // one of the sides on the ambiguous sides of the dice
        int possibleSide = -1;

        // find sides that haven't been added to the dice yet
        for (int i = 1; i <= 6; i++) {
            if (i != 7 - front && i != top && i != front && i != 7 - top) {
                possibleSide = i;
                break;
            }
        }

        // guess one possibility for xCycle
        xCycle = new int[]{possibleSide, top, 7 - possibleSide};

        // Check if 1 is on the x-cycle, bring it to the top, otherwise do it to the y-cycle
        if (xCycle[0] == 1) tiltDice(Direction.EAST);
        else if (xCycle[2] == 1) tiltDice(Direction.WEST);
        else {
            while (yCycle[1] != 1) {
                tiltDice(Direction.NORTH);
            }
        }
        // Bring 2 to the front
        while (yCycle[2] != 2) {
            rotateDieZAxis(xCycle,yCycle);
        }
        // If the left side is 3 then by definition its a RH die otherwise not
        yCycle = new int[] { 7 - front, top, front };
        xCycle = xCycle[0] == 3 ? new int[]{possibleSide, top, 7 - possibleSide} :
                                  new int[]{7 - possibleSide, top, possibleSide};
    }

    /**
     * Rotates a dice anti-clockwise when looking from above, only used in finding orientation
     * @param xCycle x-cycle of dice
     * @param yCycle y-cycle of dice
     */
    public static void rotateDieZAxis(int[] xCycle, int[] yCycle) {
        int[] tempCycle;
        tempCycle = yCycle.clone();
        System.arraycopy(xCycle, 0, yCycle, 0, 3);
        for (int i = 0; i < 3; i++) {
            xCycle[i] = tempCycle[2-i];
        }
    }

    /**
     * checks if the given string is capable in
     * representing a dice
     * @param dice the string to check
     * @return whether the string is valid
     */
    public static boolean isDiceValid (String dice) {
        if (dice.length() != 3) return false;
        if (Character.toLowerCase(dice.charAt(0)) < 'a' && Character.toLowerCase(dice.charAt(0)) > 'x' ) return false;
        if (!(dice.charAt(1) >= 'a' && dice.charAt(1) <= 'g')) return false;
        return dice.charAt(2) >= '1' && dice.charAt(2) <= '7';
    }

    /**
     * gets dice position where square 1 is at 0
     * @return current dice position
     */
    public Position getPosition() {
        return this.position;
    }

    /**
     * Updates the position of a dice when a move is played
     */
    public void setPosition(Position p) {
        this.position = p;
    }

    /**
     * gets the owner of the dice
     * @return which player owns the dice
     */
    public Player getTurn() {
        return this.owner;
    }


    /**
     * Tilts the suspended dice in a certain direction.
     * only affects the dice
     * @param d the direction to tilt the dice in
     */
    public void tiltDice(Direction d) {
        var dir = d.getDirection();
        var k = dir == 1 ? 0 : 2;
        if (d.getAxis() == Axis.Y) {
            // shift yCycle
            yCycle = Helpers.shift(yCycle, dir);
            // replace front or end side with hidden side
            yCycle[k] = 7 - yCycle [2 - k];
            // ensure center number is common on both cycles
            xCycle[1] = yCycle[1];
        } else {
            xCycle = Helpers.shift(xCycle, dir);
            xCycle[k] = 7 - xCycle [2 - k];
            yCycle[1] = xCycle[1];
        }
    }

    /**
     * gets the uppermost number
     * @return the uppermost number
     */
    public int getTop () {
        return xCycle[1];
    }

    /**
     * gets the number facing north
     * @return the northern facing number
     */
    public int getFront () { return yCycle[2]; }

    public int[] getxCycle () {
        return xCycle;
    }

    public int[] getyCycle () {
        return yCycle;
    }

    /**
     * copy the current dice
     * @return a new copy of the current dice
     */
    public Dice getCopy () {
        return new Dice(position, owner, xCycle, yCycle);
    }

    // sort of just added this in with intellij's autofill

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dice dice = (Dice) o;
        return Objects.equals(position, dice.position) && owner == dice.owner &&
                Arrays.equals(xCycle, dice.xCycle) && Arrays.equals(yCycle, dice.yCycle);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(position, owner);
        result = 31 * result + Arrays.hashCode(xCycle);
        result = 31 * result + Arrays.hashCode(yCycle);
        return result;
    }

    @Override
    public String toString() {
        int a = (getTop() - 1)*4;
        int b = 0;

        for (int i = 1; i <= 6; i++) {
            if (i == getTop() || i == 7 - getTop()) continue;
            if (i == getFront()) break;
            b++;
        }

        char rot = (char)(97 + a + b);
        char rotation = owner == Player.PLAYER1 ? Character.toUpperCase(rot) : rot;
        return rotation + getPosition().toString();
    }
}