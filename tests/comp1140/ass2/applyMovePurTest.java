package comp1140.ass2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.jupiter.api.Assertions.*;

import static comp1140.ass2.Cublino.*;

@Timeout(value = 1000, unit = MILLISECONDS)
class applyMovePurTest {

    @Test
    public void testSingleStep() {
        for (int i = 0; i < ExampleGames.FULL_PUR_GAME.length - 1; i++) {
            String startingState = ExampleGames.FULL_PUR_GAME[i][0];
            String move = ExampleGames.FULL_PUR_GAME[i][1];
            String endingState = ExampleGames.FULL_PUR_GAME[i+1][0];
            if (move.length() == 4)
                assertEquals(endingState, applyMovePur(startingState, move), "State \"" + startingState + "\" with move \"" + move + "\"");
        }
    }

    @Test
    public void testMultiStepMove() {
        for (int i = 0; i < ExampleGames.FULL_PUR_GAME.length - 1; i++) {
            String startingState = ExampleGames.FULL_PUR_GAME[i][0];
            String move = ExampleGames.FULL_PUR_GAME[i][1];
            String endingState = ExampleGames.FULL_PUR_GAME[i+1][0];
            if (move.length() > 4)
                assertEquals(endingState, applyMovePur(startingState, move), "State \"" + startingState + "\" with move \"" + move + "\"");
        }
    }

}