package comp1140.customTests;

import comp1140.ass2.base.Dice;
import comp1140.ass2.base.Direction;
import comp1140.ass2.base.Player;
import comp1140.ass2.helpers.Position;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DiceTest {
    void testArrays (int[] exp, int[] actual, String msg) {
        assertArrayEquals(exp, actual, "\nExpected: " + Arrays.toString(exp) + "\nbut got: " + Arrays.toString(actual)+"\n" + msg);
    }

    /**
     * test the movement of a dice forward in back both horizontally and vertically
     */
    @Test
    public void testFlipsInverse () {
        Dice d = new Dice(Position.Zero(), Player.PLAYER2, new int[] {4,1,3}, new int[] {2,1,5});
        d.tiltDice(Direction.NORTH);
        testArrays(new int[] { 4,2,3 }, d.getxCycle(), "for x on north");
        testArrays(new int[] { 6,2,1 }, d.getyCycle(), "for y on north");
        d.tiltDice(Direction.SOUTH);
        testArrays(new int[] { 4,1,3 }, d.getxCycle(), "for x on north");
        testArrays(new int[] { 2,1,5 }, d.getyCycle(), "for y on north");

        d = new Dice(Position.Zero(), Player.PLAYER2, new int[] {4,1,3}, new int[] {2,1,5});
        d.tiltDice(Direction.EAST);
        testArrays(new int[] { 6,4,1 }, d.getxCycle(), "for x on north");
        testArrays(new int[] { 2,4,5 }, d.getyCycle(), "for y on north");
        d.tiltDice(Direction.WEST);
        testArrays(new int[] { 4,1,3 }, d.getxCycle(), "for x on north");
        testArrays(new int[] { 2,1,5 }, d.getyCycle(), "for y on north");
    }

    /**
     * tests if rolling the dice twice in a given direction gives the correct upper side
     */
    @Test
    public void testHiddenSide() {
        Dice d = new Dice(Position.Zero(), Player.PLAYER2, new int[] {4,1,3}, new int[] {2,1,5});
        d.tiltDice(Direction.NORTH);
        d.tiltDice(Direction.NORTH);
        assertEquals(6, d.getTop(), "retrieved after tilting north twice");

        d = new Dice(Position.Zero(), Player.PLAYER2, new int[] {4,1,3}, new int[] {2,1,5});
        d.tiltDice(Direction.EAST);
        d.tiltDice(Direction.EAST);
        assertEquals(6, d.getTop(),"retrieved after tilting east twice");

        d = new Dice(Position.Zero(), Player.PLAYER2, new int[] {4,1,3}, new int[] {2,1,5});
        d.tiltDice(Direction.SOUTH);
        d.tiltDice(Direction.SOUTH);
        assertEquals(6, d.getTop(), "retrieved after tilting south twice");

        d = new Dice(Position.Zero(), Player.PLAYER2, new int[] {4,1,3}, new int[] {2,1,5});
        d.tiltDice(Direction.WEST);
        d.tiltDice(Direction.WEST);
        assertEquals(6, d.getTop(), "retrieved after tilting west twice");
    }

    /**
     * test a composition of flips for a die
     */
    @Test
    public void testFlipsBlackBox () {
        Dice d = new Dice(Position.Zero(), Player.PLAYER2, new int[] {4,1,3}, new int[] {2,1,5});
        d.tiltDice(Direction.NORTH);
        testArrays(new int[] { 4,2,3 }, d.getxCycle(), "for x on north");
        testArrays(new int[] { 6,2,1 }, d.getyCycle(), "for y on north");
        d.tiltDice(Direction.NORTH);
        testArrays(new int[] { 4,6,3 }, d.getxCycle(), "for x on N + N");
        testArrays(new int[] { 5,6,2 }, d.getyCycle(), "for y on N + N");
        d.tiltDice(Direction.NORTH);
        testArrays(new int[] { 4,5,3 }, d.getxCycle(), "for x on N + N + N");
        testArrays(new int[] { 1,5,6 }, d.getyCycle(), "for y on N + N + N");
        d.tiltDice(Direction.EAST);
        testArrays(new int[] { 2,4,5 }, d.getxCycle(), "for x on N + N + N + E");
        testArrays(new int[] { 1,4,6 }, d.getyCycle(), "for y on N + N + N + E");
        d.tiltDice(Direction.NORTH);
        testArrays(new int[] { 2,1,5 }, d.getxCycle(), "for x on N + N + N + E + N");
        testArrays(new int[] { 3,1,4 }, d.getyCycle(), "for y on N + N + N + E + N");
        d.tiltDice(Direction.EAST);
        testArrays(new int[] { 6,2,1 }, d.getxCycle(), "for x on N + N + N + E + N + E");
        testArrays(new int[] { 3,2,4 }, d.getyCycle(), "for y on N + N + N + E + N + E");

        d = new Dice(Position.Zero(), Player.PLAYER2, new int[] {4,1,3}, new int[] {2,1,5});
        d.tiltDice(Direction.WEST);
        testArrays(new int[] { 1,3,6 }, d.getxCycle(), "for x on W");
        testArrays(new int[] { 2,3,5 }, d.getyCycle(), "for y on W");
        d.tiltDice(Direction.EAST);
        testArrays(new int[] { 4,1,3 }, d.getxCycle(), "for y on W + E");
        testArrays(new int[] { 2,1,5 }, d.getyCycle(), "for x on W + E");
        d.tiltDice(Direction.SOUTH);
        testArrays(new int[] { 4,5,3 }, d.getxCycle(), "for x on W + E + S");
        testArrays(new int[] { 1,5,6 }, d.getyCycle(), "for y on W + E + S");
    }

    /**
     * Test positions close to 0 and close to 7
     */
    @Test
    public void testEdgePositions () {
        // inputs
        String[] inputs = new String[] {
                "aa1",
                "aa7",
                "ag1",
                "ag7",
        };

        // positions
        Position[] expectedPos = new Position[] {
                new Position(0,0),
                new Position(0,6),
                new Position(6,0),
                new Position(6,6),
        };

        for (int i = 0; i < inputs.length; i++) {
            Dice d = new Dice(inputs[i]);
            assertEquals(expectedPos[i], d.getPosition(), "different positions while testing " + inputs[i]);
        }
    }

    /**
     * test the string based constructor
     */
    @Test
    public void testStringConstructorBlackBox () {
        // inputs
        String[] inputs = new String[] {
                "cf4",
                "aa6",
                "jc2",
                "Fe6",
                "Ja6",
                "nc3",
                "Rd2",
                "Eb2",
                "Na1",
                "mc1",
                "cb2",
                "Be5",
                "Nd6",
                "Aa3",
                "jb1",
                "Fd3",
                "ac2",
                "Na2",
                "If4",
                "fd4",
        };

        // positions
        Position[] expectedPos = new Position[] {
                new Position (5, 3),
                new Position (0, 5),
                new Position (2, 1),
                new Position (4, 5),
                new Position (0, 5),
                new Position (2, 2),
                new Position (3, 1),
                new Position (1, 1),
                new Position (0, 0),
                new Position (2, 0),
                new Position (1, 1),
                new Position (4, 4),
                new Position (3, 5),
                new Position (0, 2),
                new Position (1, 0),
                new Position (3, 2),
                new Position (2, 1),
                new Position (0, 1),
                new Position (5, 3),
                new Position (3, 3),
        };

        // players
        Player[] expectedPlayer = new Player[] {
                Player.PLAYER2,
                Player.PLAYER2,
                Player.PLAYER2,
                Player.PLAYER1,
                Player.PLAYER1,
                Player.PLAYER2,
                Player.PLAYER1,
                Player.PLAYER1,
                Player.PLAYER1,
                Player.PLAYER2,
                Player.PLAYER2,
                Player.PLAYER1,
                Player.PLAYER1,
                Player.PLAYER1,
                Player.PLAYER2,
                Player.PLAYER1,
                Player.PLAYER2,
                Player.PLAYER1,
                Player.PLAYER1,
                Player.PLAYER2,
        };

        // top
        int[] expectedTop = new int[] { 1, 1, 3, 2, 3, 4, 5, 2, 4, 4, 1, 1, 4, 1, 3, 2, 1, 4, 3, 2 } ;

        // front
        int[] expectedFront = new int[] { 4, 2, 2, 3, 2, 2, 3, 1, 2, 1, 4, 3, 2, 2, 2, 3, 2, 2, 1, 3 };

        for (int i = 0; i < inputs.length; i++) {
            Dice d = new Dice(inputs[i]);
            assertEquals(expectedPos[i], d.getPosition(), "different positions while testing " + inputs[i]);
            assertEquals(expectedPlayer[i], d.getTurn(), "different players while testing " + inputs[i]);
            assertEquals(expectedTop[i], d.getTop(), "different top faces while testing " + inputs[i]);
            // find the front face
            d.tiltDice(Direction.SOUTH);
            assertEquals(expectedFront[i], d.getTop(), "different front faces while testing " + inputs[i]);
        }
    }

    /**
     * test edge letters like A and Z for rotation
     */
    @Test
    public void testToStringOnEdgesRotation () {
        String[] strings = new String[] {
                "aa1",
                "za1",
        };
        for (String s : strings)
            assertEquals(s, new Dice(s).toString());
    }

    /**
     * test edge letters like A and Z for positioning
     */
    @Test
    public void testToStringOnEdgesPosition () {
        String[] strings = new String[] {
                "ea1",
                "ea7",
                "eg1",
                "eg7",
        };
        for (String s : strings)
            assertEquals(s, new Dice(s).toString());
    }

    /**
     * test the toString method
     */
    @Test
    public void testToString() {
        // strings
        String[] strings = new String[] {
                "Fd6",
                "Ac2",
                "Nf1",
                "bd2",
                "Mb5",
                "Fe6",
                "Bb2",
                "Ec1",
                "Bd3",
                "fd6",
                "Qb6",
                "Af1",
                "Nb2",
                "Bc6",
                "jf5",
                "nf6",
                "je3",
                "qb2",
                "nc1",
                "Ee4",
                "me4",
                "Fa6",
                "Nf1",
                "qf1",
                "md4",
                "Eb1",
                "mf1",
                "Jd6",
                "Qf5",
                "rf2",
                "Rd3",
                "Be4",
                "Qb3",
                "Ma5",
                "Bd2",
                "Qb6",
                "ad1",
                "qa3",
                "Qc3",
                "na5",
        };
        for (String s : strings)
            assertEquals(s, new Dice(s).toString());
    }
}
