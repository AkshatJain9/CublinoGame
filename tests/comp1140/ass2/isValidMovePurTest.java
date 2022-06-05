package comp1140.ass2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(value = 1000, unit = MILLISECONDS)
class isValidMovePurTest {

    @Test
    public void testSingleStepMove() {

        for (int i = 0; i < ExampleGames.FULL_PUR_GAME_WITH_MOVES_STATES.length; i+= 40) {
            for(int j = 0; j < ExampleGames.FULL_GAME_WITH_MOVES_MOVES[i].length; j++) {
                String state = ExampleGames.FULL_PUR_GAME_WITH_MOVES_STATES[i];
                String move = ExampleGames.FULL_GAME_WITH_MOVES_MOVES[i][j];
                if(move.length() == 4) {
                    assertTrue(Cublino.isValidMovePur(state, move), "Move \"" + move + "\" for state \"" + state + "\" is valid");
                }
            }
        }
    }

    @Test
    public void testMultiStepMove() {
        for (int i = 0; i < ExampleGames.FULL_PUR_GAME_WITH_MOVES_STATES.length; i+= 20) {
            for(int j = 0; j < ExampleGames.FULL_GAME_WITH_MOVES_MOVES[i].length; j++) {
                String state = ExampleGames.FULL_PUR_GAME_WITH_MOVES_STATES[i];
                String move = ExampleGames.FULL_GAME_WITH_MOVES_MOVES[i][j];
                if(move.length() > 4) {
                    assertTrue(Cublino.isValidMovePur(state, move), "Move \"" + move + "\" for state \"" + state + "\" is valid");
                }
            }
        }
    }

    //Tip not at start: 2 tip, jump tip
    //No dice at start
    //Contains other invalid step

    @Test
    public void testInvalidMove() {
        String stateA = "Pwb1ma2if2ca3gc3we3Qc4td4Cb5Oc5Xa6Hf6Wb7We7";
        String[] movesA = {"", "c5c6c7", "b5b6c6", "c4c6d6d7", "d4d5", "d4b4", "g6g7", "b5b6d6", "a6b6b4b6", "b5d5b5"};
        String stateB = "psc1af1ma2if2gc3we3Qc4td4Cb5Oc5Xa6Hf6Wb7We7";
        String[] movesB = {"d4", "d4b4b6", "d4b4b3", "c3c2c1", "d4d3f3f1"};

        for(String move : movesA)
            assertFalse(Cublino.isValidMovePur(stateA, move), "Move \"" + move + "\" is invalid for state \"" + stateA + "\"");

        for(String move : movesB)
            assertFalse(Cublino.isValidMovePur(stateB, move), "Move \"" + move + "\" is invalid for state \"" + stateB + "\"");
    }

}