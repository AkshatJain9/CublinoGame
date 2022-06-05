package comp1140.ass2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static comp1140.ass2.Cublino.isStateValid;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(value = 1000, unit = MILLISECONDS)
class isStateValidTest {

    private void test(String in, boolean expected) {
        boolean out = isStateValid(in);
        assertEquals(expected, out, "Expected isStateValid called on \"" + in +
                "\" to be " + expected +
                " but got " + out + ".");
    }

    @Test
    public void testValidPur() {
        for (String[] state : ExampleGames.FULL_PUR_GAME) {
            test(state[0], true);
        }

    }

    @Test
    public void testValidContra() {
        for (String[] state : ExampleGames.FULL_CONTRA_GAME) {
            test(state[0], true);
        }
    }

    @Test
    public void testNotWellFormed() {
        String[] cases = {
                "" // Empty string
                , "Caa1ob1kc1kd1se1wf1dg"
                , "POe2db3Qc4ae4oc6xxx"
                , "Crd1Aa2Gd7tgs"
                , "Caa1ob1kc1kd1se1wf1dg"
                , "POe2db3Qc4ae4oc6xxxwa1"
                , "Crd1GD7"
                , "Crd1Aa2Gd7xxxtg7"
                , "aa1ob1kc1kd1se1wf1dg1"
                , "_rd1Aa2Gd7tg7"
                , "xGa1Fb1Ec1Dd1Ce1Bf1Ag1Na2Mb2Kc2Kd2Je2If2Hg2Ua3Tb3Sc3Rd3Qe3Of3Og3va4wb4xc4Xe4Wf4Vg4oa5ob5qc5rd5se5tf5ug5ha6ib6jc6kd6ke6mf6ng6aa7bb7cc7dd7ee7ff7gg7"
        };

        for (String testCase : cases)
            test(testCase, false);
    }

    @Test
    public void testOverlappingDice() {
        String[] cases = {
                "PWa1Wa1Wc1Wd1We1Wf1Wg1va7vb7vc7vd7ve7vf7vg7"
                , "PWb1Ge1Wg1Le2Bc3ff3Rg3Lc4pd4qe4if6va7ve7vb1"
                , "pfa4ac1Ce1Oa2pd2ia4Lc4Td4Je4Og4sd5be5Aa6if6"
                , "pwe7fd1ae1af1Oa2pd2fd3cf3Ed4Hf4Gg5Jb6Oe6Je7"
                , "Pca1cb1vc1ad1ad1vg1hg2Tc4Oe6Tf6Jc7Dd7Ie7Qg7"
                , "cWg7Gc1We1Wg1La2Lc2Lf2ib6ic6if6va7vd7ve7vg7"
                , "CWb1Gc1Le2Lf2Lg2Bc3hb1gg5ib6ic6vd7ve7rf7"
                , "cHa2Jc2Le2Lg2xb3la2Mf4og4sa5vd7ve7"
                , "Cqb2Ud2Be3hb4Ee4og4cb5id2ie6"
                , "Cqb2Ud2hb4se5qe5"
        };

        for (String testCase : cases)
            test(testCase, false);
    }

    @Test
    public void testUnreachableState() {
        String[] cases = {
                "Pta1tb1tc1td1te1tf1tg1Ra7Rb7Rc7Rd7Re7Rf7Rg7"
                , "CWa1Wb1cd1Wf1Wg1va7vb7Gd7vf7vg7"
                , "P"
                , "p"
                , "PWa1Wb1Wc1We1Wf1Wg1va7vb7vd7ve7vf7vg7"
        };

        for (String testCase : cases)
            test(testCase, false);
    }

}