package comp1140.ass2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(value = 1000, unit = MILLISECONDS)
class generateMoveContraTest {

    private String errorPrefix(String inputState, String move) {
        return "Cublino.generateMoveContra(\"" + inputState + "\")"
                + System.lineSeparator()
                + "returned \"" + move + "\";"
                + System.lineSeparator();
    }

    @Test
    public void testGenerateContraMove() {
        for (int i = 0; i < states.length; i++) {
            String move = Cublino.generateMoveContra(states[i]);
            Set<String> legalMoves = new HashSet<>(Arrays.asList(moves[i]));
            assertTrue(legalMoves.contains(move), errorPrefix(states[i], move) + "expected a move from \n" + Arrays.toString(moves[i]));
        }
    }

    public static String[] states = {
            "CWa1Wb1Wc1Wd1We1Wf1Wg1va7vb7vc7vd7ve7vf7vg7"
            , "cWa1Wd1We1Wf1Wg1Lc2Bb3id6va7vb7vc7rd7vf7vg7"
            , "CWa1Gc1We1Wf1Wg1Hb2Bb3ia6ib6id6if6vc7rd7vg7"
            , "cWa1Wd1We1Wf1Wg1Td2Bb3ia6ib6qc6if6rb7rd7vg7"
            , "CWa1Wd1We1Wf1Wg1Td2Na4cb5ia6mb6if6rb7rd7rf7"
            , "cWa1Wd1We1Wf1Lg2Dd3Sa5mb6jd6if6vc7rf7"
            , "CWa1We1Wf1Ld2Lg2Kc3Sa5gd5qe6vc7rf7"
            , "cWa1We1Wf1Hc2Dd3Bg3Sa5gd5ed6qe6rf7"
            , "CWa1We1Hc2Lf2Bg3Ed4Sa5we5me6if6rf7"
            , "cWe1La2Hc2Lf2Ve3Ed4Sa5sf5me6if6be7"
            , "CWe1La2Ld2Lf2Ff3Ed4Sa5we5me6if6be7"
            , "cWe1Ld2Lf2Ba3Ff3Me4gd5Ka6me6if6fd7"
            , "CWe1Ld2Lf2Ba3Ff3Me4gd5Ka6eg6be7"
            , "cSf1Ld2Tg2Ba3Me4Nf4gd5dg5Ka6rf7"
    };

    public static String[][] moves = {
            new String[]{"a1a2", "b1b2", "c1c2", "d1d2", "e1e2", "f1f2", "g1g2"}
            , new String[]{"a7a6", "b7b6", "c7c6", "d6d5", "d6c6", "d6e6", "d7e7", "f7f6", "f7e7", "g7g6"}
            , new String[]{"a1a2", "a1b1", "b2a2", "b2c2", "b3b4", "b3a3", "b3c3", "c1c2", "c1b1", "c1d1", "e1e2", "e1d1", "f1f2", "g1g2"}
            , new String[]{"a6a5", "b6b5", "b7a7", "b7c7", "c6c5", "c6d6", "d7d6", "d7c7", "d7e7", "f6f5", "f6e6", "f6g6", "g7g6", "g7f7"}
            , new String[]{"a1a2", "a1b1", "a4a5", "a4b4", "d1c1", "d2d3", "d2c2", "d2e2", "e1e2", "f1f2", "g1g2"}
            , new String[]{"b6b5", "b6a6", "b6c6", "c7c6", "c7b7", "c7d7", "d6d5", "d6c6", "d6e6", "f6f5", "f6e6", "f6g6", "f7e7", "f7g7"}
            , new String[]{"a1a2", "a1b1", "a5a6", "a5b5", "c3c4", "c3b3", "c3d3", "d2d3", "d2c2", "d2e2", "e1e2", "e1d1", "f1f2", "f1g1", "g2g3", "g2f2"}
            , new String[]{"d5d4", "d5c5", "d5e5", "d6c6", "e6e5", "e6f6", "f7f6", "f7e7", "f7g7"}
            , new String[]{"a1a2", "a1b1", "a5a6", "a5b5", "c2c3", "c2b2", "c2d2", "d4d5", "d4c4", "d4e4", "e1e2", "e1d1", "e1f1", "f2f3", "f2e2", "f2g2", "g3g4", "g3f3"}
            , new String[]{"e6e5", "e6d6", "e7d7", "e7f7", "f5f4", "f5e5", "f5g5", "f6g6"}
            , new String[]{"a2a3", "a2b2", "a5a6", "a5b5", "d2d3", "d2c2", "d2e2", "d4d5", "d4c4", "d4e4", "e1e2", "e1d1", "e1f1", "f2e2", "f2g2", "f3f4", "f3e3", "f3g3"}
            , new String[]{"d5d4", "d5c5", "d5e5", "d7d6", "d7c7", "d7e7", "e6e5", "e6d6", "f6f5", "f6g6"}
            , new String[]{"a3a4", "a3b3", "a6a7", "a6b6", "d2d3", "d2c2", "d2e2", "e1e2", "e1d1", "e1f1", "e4e5", "e4d4", "e4f4", "f2e2", "f2g2", "f3f4", "f3e3", "f3g3"}
            , new String[]{"d5d4", "d5c5", "d5e5", "f7f6", "f7e7", "f7g7", "g5g4", "g5f5"}
    };

}