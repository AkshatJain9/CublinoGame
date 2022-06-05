package comp1140.ass2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Timeout(value = 1000, unit = MILLISECONDS)
class generateMovePurTest {

    private String errorPrefix(String inputState, String move) {
        return "Cublino.generateMovePur(\"" + inputState + "\")"
                + System.lineSeparator()
                + "returned \"" + move + "\";"
                + System.lineSeparator();
    }

    @Test
    public void testGeneratePurMove() {
        for (int i = 0; i < states.length; i++) {
            String move = Cublino.generateMovePur(states[i]);
            Set<String> legalMoves = new HashSet<>(Arrays.asList(moves[i]));
            assertTrue(legalMoves.contains(move), errorPrefix(states[i], move) + "expected a move from \n" + Arrays.toString(moves[i]));
        }
    }

    public static final String[] states = {
            "PWa1Wb1Wc1Wd1We1Wf1Wg1va7vb7vc7vd7ve7vf7vg7"
            , "PWb1Wc1Wg1La2Tb2Ld2Wd3ja4ia6ie6vc7vd7vf7vg7"
            , "PWc1Se1La2Pc2Ld2Lg2ga3Gc3ia6ed6ie6vd7vf7vg7"
            , "Pga1Se1Tb2Ld2Lg2Gc3Pa4Jb4vf5eb6ic6ed6ef6vd7"
            , "Pga1Tb2Ld2cg3Pa4Jb4Mg4Cb5vd5vf5qb6ic6ed6Ga7"
            , "Pwb1Tb2cg3Aa4Mb4jc4Mg4Cb5vf5qb6ic6ed6Ga7Gd7"
            , "Psc1ca3sf3Mb4jc4td4Qa5Cb5Oc5vf5Wg5qb6Ga7Gd7"
            , "Psc1ma2if2ca3gc3we3Qc4td4Qa5Cb5Oc5Hf6Wb7We7"
            , "Pba1wb1sf1if2ca3ub3gc3Qc4Cb5Hf6Oa7Fb7Sc7We7"
            , "Pbc1sf1sg1qe2ca3gc3ud3Sa5Qc6Oa7Fb7Sc7We7Af7"
            , "Pbc1we1sg1oc2od2if2ud3Cb5Ea6Oa7Fb7Sc7Gd7Ne7"
            , "Pba1gb1wf1db2qc2od2ud3Cb5Ea6Oa7Sc7Fd7Gf7Ng7"
            , "Pba1tb1wc1sg1da2mb2ud3Cb5Mb6Oa7Wb7Cc7Fd7Ng7"
            , "Pba1wc1td1wf1mb2od2ne3Sa5Id6Oa7Sc7Fd7Ce7Ng7"
            , "Pba1wc1ve1wf1pg1mb2jc3Ka6Oa7Fb7Sc7Vd7Ce7Ng7"
            , "Pgb1rd1ve1wf1pg1mb2af3Ka6Oa7Fb7Sc7Sd7Uf7Rg7"
            , "Pva1gb1rd1wf1pg1mb2gg2Ka6Oa7Wb7Fd7Ce7Uf7Rg7"
            , "Pva1gb1rd1wf1pg1mb2cf2Ka6Oa7Wb7Vc7Ce7Uf7Rg7"
            , "Pva1gb1bc1pe1sg1ea2gg2Oc6Oa7Wb7Vc7Sd7Uf7Rg7"
            , "Pva1gb1td1rf1sg1ea2gg2Ka6Oa7Wb7Vc7Sd7Je7Rg7"
            , "Pva1gb1cd1rf1pg1ea2gg2Ka6Oa7Wb7Vc7Ud7Bf7Cg7"
            , "Pgb1vc1cd1rf1pg1ea2gg2Ka6Oa7Wb7Vc7Ud7Ce7Bf7"
    };

    public static final String[][] moves = {
            new String[]{"a1a2", "b1b2", "c1c2", "d1d2", "e1e2", "f1f2", "g1g2"}
            , new String[]{"a2a3a5a7", "a2a3a5", "a2a3", "a2c2e2", "a2c2", "b1b3", "b1a1a3a5a7", "b1a1a3a5", "b1a1a3", "b1a1", "b1d1", "b2b3", "b2c2e2", "b2c2", "c1c2e2", "c1c2", "c1a1a3a5a7", "c1a1a3a5", "c1a1a3", "c1a1", "c1d1", "d2d4", "d2c2", "d2e2", "d3d4", "d3c3", "d3e3", "g1g2", "g1f1"}
            , new String[]{"a2a4", "a2b2", "c1b1", "c1d1d3b3", "c1d1d3", "c1d1f1", "c1d1", "c2c4", "c2b2", "c2e2", "c3c4", "c3b3", "c3d3", "d2d3b3", "d2d3", "d2b2", "d2e2", "e1e2", "e1d1d3b3", "e1d1d3", "e1d1b1", "e1d1", "e1f1", "g2g3", "g2f2"}
            , new String[]{"a4a5", "a4c4", "b2b3b5b7", "b2b3b5", "b2b3d3", "b2b3", "b2a2", "b2c2c4", "b2c2e2", "b2c2", "b4b5b7", "b4b5", "b4c4", "c3c4", "c3b3b5b7", "c3b3b5", "c3b3", "c3d3", "d2d3b3b5b7", "d2d3b3b5", "d2d3b3", "d2d3", "d2c2c4", "d2c2a2", "d2c2", "d2e2", "e1e2c2c4", "e1e2c2a2", "e1e2c2", "e1e2", "e1d1d3b3b5b7", "e1d1d3b3b5", "e1d1d3b3", "e1d1d3", "e1d1", "e1f1", "g2g3", "g2f2"}
            , new String[]{"a4a5c5c7", "a4a5c5e5g5", "a4a5c5e5", "a4a5c5", "a4a5", "a4c4", "a7b7", "b2b3", "b2a2", "b2c2e2", "b2c2", "b4c4", "b5b7", "b5a5", "b5c5c7", "b5c5e5g5", "b5c5e5", "b5c5", "d2d3", "d2c2a2", "d2c2", "d2e2", "g4g5e5c5c7", "g4g5e5c5a5", "g4g5e5c5", "g4g5e5", "g4g5", "g4f4f6", "g4f4"}
            , new String[]{"a4a5c5c7e7", "a4a5c5c7", "a4a5c5", "a4a5", "a7b7", "b2b3", "b2a2", "b2c2", "b4d4", "b5b7", "b5a5", "b5c5c7e7", "b5c5c7", "b5c5", "d7c7", "d7e7", "g4g5e5", "g4g5", "g4f4f6", "g4f4"}
            , new String[]{"a5a6c6", "a5a6", "a7b7", "b4a4a6c6", "b4a4a6", "b4a4", "b5b7", "b5d5", "c5c6a6", "c5c6", "c5d5", "d7c7", "d7e7", "g5g6", "g5e5"}
            , new String[]{"a5a6", "b5b6", "b5d5", "b7a7", "b7c7", "c4c6", "c4b4b6", "c4b4", "c4e4", "c5c6", "c5d5", "e7d7", "e7f7", "f6f7d7", "f6f7", "f6e6", "f6g6"}
            , new String[]{"b5b6", "b5a5", "b5c5", "b7d7f7", "b7d7", "c4c5a5", "c4c5", "c4b4b6", "c4b4", "c4d4", "c7d7f7", "c7d7", "e7d7", "e7f7", "f6f7d7", "f6f7", "f6e6", "f6g6"}
            , new String[]{"a5a6", "a5b5", "b7d7", "c6b6", "c6d6", "c7d7", "e7d7", "e7g7", "f7d7", "f7g7"}
            , new String[]{"a6b6", "b5b6", "b5a5", "b5c5", "d7f7", "e7f7"}
            , new String[]{"a6b6", "a7b7", "b5b6", "b5a5", "b5c5", "c7b7", "c7e7", "d7b7", "d7e7", "f7e7", "g7e7"}
            , new String[]{"b5a5", "b5c5", "b6a6", "b6c6", "c7e7", "d7e7", "g7f7"}
            , new String[]{"a5a6", "a5b5", "a7b7", "c7b7", "d6c6", "d6e6", "d7b7", "d7f7", "e7f7", "g7f7"}
            , new String[]{"a6b6", "d7f7", "e7f7", "g7f7"}
            , new String[]{"a6b6", "c7e7", "d7e7", "f7e7", "g7e7"}
            , new String[]{"a6b6", "a7c7", "b7c7", "d7c7", "e7c7"}
            , new String[]{"a6b6", "b7d7", "c7d7", "e7d7", "f7d7"}
            , new String[]{"c6b6", "c6d6", "c7e7", "d7e7", "f7e7", "g7e7"}
            , new String[]{"a6b6", "d7f7", "e7f7", "g7f7"}
            , new String[]{"a6b6", "c7e7", "d7e7", "f7e7", "g7e7"}
            , new String[]{"a6b6", "e7g7", "f7g7"}
    };

}