package comp1140.ass2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(value = 1000, unit = MILLISECONDS)
class isValidStepPurTest {

    @Test
    public void testValidStep() {

        for (int i = 0; i < ExampleGames.FULL_PUR_GAME_WITH_MOVES_STATES.length; i+= 50) {
            for(int j = 0; j < ExampleGames.FULL_GAME_WITH_MOVES_MOVES[i].length; j++) {
                String state = ExampleGames.FULL_PUR_GAME_WITH_MOVES_STATES[i];
                String move = ExampleGames.FULL_GAME_WITH_MOVES_MOVES[i][j];
                for(int k = 0; k <= move.length()-4; k+=2) {
                    String step = move.substring(k, k+4);
                    assertTrue(Cublino.isValidStepPur(state, step), "Step \"" + step + "\" is valid for state \"" + state + "\"");
                }
            }
        }

    }

    @Test
    public void testBackwardStep() {

        String stateA = "Pwb1bc1sf1if2ca3ub3gc3Cb5Mb6Hf6Oa7Fb7Sc7We7";
        String[] stepsA = {"b5b4", "b6b4", "f7f5", "e7e6"};
        String stateB = "pwb1bc1sf1if2ca3ub3gc3Cb5Mb6Oa7Fb7Sc7Ad7We7";
        String[] stepsB = {"a3a4", "f1f3", "f2f3", "c2c4"};

        for(String step : stepsA)
            assertFalse(Cublino.isValidStepPur(stateA, step), "Step \"" + step + "\" is invalid for state \"" + stateA + "\"");

        for(String step : stepsB)
            assertFalse(Cublino.isValidStepPur(stateB, step), "Step \"" + step + "\" is invalid for state \"" + stateB + "\"");

    }

    @Test
    public void testInvalidDistance() {

        String stateA = "Pwb1bc1sf1if2ca3ub3gc3Cb5Mb6Hf6Oa7Fb7Sc7We7";
        String[] stepsA = {"c6d7", "b5e5", "d5c6", "d5f7", "a4a7"};
        String stateB = "pwb1bc1sf1if2ca3ub3gc3Cb5Mb6Oa7Fb7Sc7Ad7We7";
        String[] stepsB = {"b3a1", "c3f3", "f2e1", "f2g1", "f2a2"};

        for(String step : stepsA)
            assertFalse(Cublino.isValidStepPur(stateA, step), "Step \"" + step + "\" is invalid for state \"" + stateA + "\"");

        for(String step : stepsB)
            assertFalse(Cublino.isValidStepPur(stateB, step), "Step \"" + step + "\" is invalid for state \"" + stateB + "\"");

    }

    @Test
    public void testJumpOverDice() {
        String stateA = "Pwb1bc1sf1if2ca3ub3gc3Ad5Mb6Hf6Oa7Fb7Sc7We7";
        String[] stepsA = {"f6d6", "d5d7"};
        String stateB = "pwb1bc1sf1if2ca3ub3gc3Cb5Mb6Oa7Fb7Sc7Ad7We7";
        String[] stepsB = {"a3a1", "c3c5", "f2d2"};

        for(String step : stepsA)
            assertFalse(Cublino.isValidStepPur(stateA, step), "Step \"" + step + "\" is invalid for state \"" + stateA + "\"");

        for(String step : stepsB)
            assertFalse(Cublino.isValidStepPur(stateB, step), "Step \"" + step + "\" is invalid for state \"" + stateB + "\"");
    }

    @Test
    public void testOccupiedEndPoint() {
        String stateA = "Pwb1bc1sf1if2ca3ub3gc3Cb5Mb6Hf6Oa7Fb7Sc7We7";
        String[] stepsA = {"a7c7", "c7a7", "b5b6", "b7a7", "b7c7"};
        String stateB = "pwb1bc1sf1if2ca3ub3gc3Cb5Mb6Oa7Fb7Sc7Ad7We7";
        String[] stepsB = {"b3b1", "b1c1", "f2f1", "a3c3", "c3a3"};

        for(String step : stepsA)
            assertFalse(Cublino.isValidStepPur(stateA, step), "Step \"" + step + "\" is invalid for state \"" + stateA + "\"");

        for(String step : stepsB)
            assertFalse(Cublino.isValidStepPur(stateB, step), "Step \"" + step + "\" is invalid for state \"" + stateB + "\"");
    }

}