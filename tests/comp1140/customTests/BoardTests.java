package comp1140.customTests;

import comp1140.ass2.base.BoardState;
import comp1140.ass2.base.Dice;
import comp1140.ass2.base.Player;
import comp1140.ass2.game.ContraGame;
import comp1140.ass2.gui.Board;
import comp1140.ass2.helpers.Position;
import comp1140.ass2.game.PurGame;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTests {

    private void stateATest(Position in, Dice expected) {
        PurGame state = new PurGame("pfb1ac1Ce1Oa2pd2ia4Lc4Td4Je4Og4sd5be5Aa6if6");
        Dice out = state.getBoard().getAtPosition(in);
        assertEquals(expected, out);
    }
    // testing if the dice are in the right places and it matches accordingly with the string encoding.
    @Test
    public void testBoardConstructor() {
        Position pos1 = new Position(5,5);
        Dice pos1Exp = new Dice("if6");
        Position pos2 = new Position(0,5);
        Dice pos2Exp = new Dice("Aa6");
        Position pos3 = new Position(4,4);
        Dice pos3Exp = new Dice("be5");
        Position pos4 = new Position(3,4);
        Dice pos4Exp = new Dice("sd5");
        Position pos5 = new Position(6,3);
        Dice pos5Exp = new Dice("Og4");
        Position pos6 = new Position(4,3);
        Dice pos6Exp = new Dice("Je4");
        Position pos7 = new Position(3,3);
        Dice pos7Exp = new Dice("Td4");
        Position pos8 = new Position(2,3);
        Dice pos8Exp = new Dice("Lc4");
        Position pos9 = new Position(0,3);
        Dice pos9Exp = new Dice("ia4");
        Position pos10 = new Position(3,1);
        Dice pos10Exp = new Dice("pd2");
        Position pos11 = new Position(0,1);
        Dice pos11Exp = new Dice("Oa2");
        Position pos12 = new Position(4,0);
        Dice pos12Exp = new Dice("Ce1");
        Position pos13 = new Position(2,0);
        Dice pos13Exp = new Dice("ac1");
        Position pos14 = new Position(1,0);
        Dice pos14Exp = new Dice("fb1");

        stateATest(pos1,pos1Exp);
        stateATest(pos2,pos2Exp);
        stateATest(pos3,pos3Exp);
        stateATest(pos4,pos4Exp);
        stateATest(pos5,pos5Exp);
        stateATest(pos6,pos6Exp);
        stateATest(pos7,pos7Exp);
        stateATest(pos8,pos8Exp);
        stateATest(pos9,pos9Exp);
        stateATest(pos10,pos10Exp);
        stateATest(pos11,pos11Exp);
        stateATest(pos12,pos12Exp);
        stateATest(pos13,pos13Exp);
        stateATest(pos14,pos14Exp);
    }
    PurGame pgA = new PurGame("Pca1be1af1ag1Oa2pd2te2fd3Pc4Ed4Gg5Ue6Je7Ef7");
    PurGame pgB = new PurGame("Psc1ma2if2ca3gc3we3Qc4td4Qa5Cb5Oc5Hf6Wb7We7");
    ContraGame cgA = new ContraGame("cGb1Sg1La2Ac2Te2Jg3Ec4gc5cg5qb6bc7bd7ve7vf7");

    private void testPurA(Position in, Position[] expected) {
        ArrayList<Position> out = pgA.getBoard().getOpponentDicePosContra(in);
        assertArrayEquals(expected, out.toArray());
    }

    private void testPurB(Position in, Position[] expected) {
        ArrayList<Position> out = pgB.getBoard().getOpponentDicePosContra(in);
        assertArrayEquals(expected, out.toArray());
    }

    private void testContra(Position in, Position[] expected) {
        ArrayList<Position> out = cgA.getBoard().getOpponentDicePosContra(in);
        assertArrayEquals(expected, out.toArray());
    }

    @Test
    public void testGetAdjacent() {
        Position posA = new Position(3,2);
        Position[] pgAposAExpected = {new Position(3,3)};
        Position posB = new Position(3,3);
        Position[] pgAposBExpected = {new Position(3,2)};
        Position posC = new Position(2,3);
        Position[] cgAposCExpected = {new Position(2,4)};
        Position posD = new Position(2,4);
        Position[] cgAposDExpected = {new Position(2,3)};
        Position posE = new Position(2,3);
        Position[] pgBposEExpected = {new Position(3,3), new Position(2,2)};
        Position posF = new Position(5,5);
        Position[] pgBposFExpected = {};
        Position posG = new Position(2,2);
        Position[] pgBposGExpected = {new Position(2,3)};
        Position posH = new Position(3,3);
        Position[] pgBposHExpected = {new Position(2,3)};
        Position posI = new Position(2,4);
        Position[] pgBposIExpected = {};
        Position posJ = new Position(1,4);
        Position[] pgBposJExpected = {};
        Position posK = new Position(1,6);
        Position[] pgBposKExpected = {};
        Position posL = new Position(0,4);
        Position[] pgBposLExpected = {};
        Position posM = new Position(4,6);
        Position[] pgBposMExpected = {};


        // checks if the die are added to the array
        testPurA(posA,pgAposAExpected);
        testPurA(posB,pgAposBExpected);
        testPurB(posE,pgBposEExpected);
        testPurB(posF,pgBposFExpected);
        testPurB(posG,pgBposGExpected);
        testPurB(posH,pgBposHExpected);
        testPurB(posI,pgBposIExpected);
        testPurB(posJ,pgBposJExpected);
        testPurB(posK,pgBposKExpected);
        testPurB(posL,pgBposLExpected);
        testPurB(posM,pgBposMExpected);
        testContra(posC,cgAposCExpected);
        testContra(posD,cgAposDExpected);
    }

    @Test
    public void testMoveDice() {
        Dice[][] placements = new Dice[7][7];
        Dice d = new Dice(new Position(0,0), Player.PLAYER1, new int[] {4,1,3}, new int[] {2,1,5});
        placements[0][0] = d;
        BoardState board = new BoardState(placements);
        board.moveDie(new Position(0), new Position(1));
        assertNull(board.getAtPosition(new Position (0,0)));
        assertEquals(d, board.getAtPosition(new Position (1,1)));
    }
}
