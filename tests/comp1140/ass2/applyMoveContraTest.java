package comp1140.ass2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static comp1140.ass2.Cublino.applyMoveContra;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(value = 1000, unit = MILLISECONDS)
class applyMoveContraTest {

    @Test
    public void testApplyMove() {
        for (int i = 0; i < ExampleGames.FULL_CONTRA_GAME.length - 1; i++) {
            String startingState = ExampleGames.FULL_CONTRA_GAME[i][0];
            String move = ExampleGames.FULL_CONTRA_GAME[i][1];
            String endingState = ExampleGames.FULL_CONTRA_GAME[i+1][0];
            if (startingState.length() == endingState.length())
                assertEquals(endingState, applyMoveContra(startingState, move), "State \"" + startingState + "\" with move \"" + move + "\"");
        }
    }

    @Test
    public void testCompareAdjacent() {
        for (int i = 0; i < ExampleGames.FULL_CONTRA_GAME.length - 1; i++) {
            String startingState = ExampleGames.FULL_CONTRA_GAME[i][0];
            String move = ExampleGames.FULL_CONTRA_GAME[i][1];
            String endingState = ExampleGames.FULL_CONTRA_GAME[i+1][0];
            if (startingState.length() != endingState.length())
                assertEquals(endingState, applyMoveContra(startingState, move), "State \"" + startingState + "\" with move \"" + move + "\"");
        }
    }

}