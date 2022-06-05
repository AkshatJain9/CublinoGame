package comp1140.ass2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.jupiter.api.Assertions.*;

import static comp1140.ass2.Cublino.*;

@Timeout(value = 1000, unit = MILLISECONDS)
class isStateWellFormedTest {

    private void test(String in, boolean expected) {
        boolean out = isStateWellFormed(in);
        assertEquals(expected, out, "Expected isStateWellFormed called on \"" + in +
                "\" to be " + expected +
                " but got " + out + ".");
    }

    @Test
    public void testMalformedVariant() {
        String[] cases = {
                "" // Empty string
                , "aa1ob1kc1kd1se1wf1dg1"
                , "Oe2db3Qc4ae4oc6"
                , "5rd1Gd7"
                , "_rd1Aa2Gd7tg7"
                , "xGa1Fb1Ec1Dd1Ce1Bf1Ag1Na2Mb2Kc2Kd2Je2If2Hg2Ua3Tb3Sc3Rd3Qe3Of3Og3va4wb4xc4Xe4Wf4Vg4oa5ob5qc5rd5se5tf5ug5ha6ib6jc6kd6ke6mf6ng6aa7bb7cc7dd7ee7ff7gg7"
        };

        for (String testCase : cases)
            test(testCase, false);
        for (char c = 0; c < 265; c++) {
            if (c != 'p' && c != 'P' && c != 'c' && c != 'C') {
                test("" + c, false);
                test( c + "Caa1ob1kc1kd1se1wf1dg1", false);
            }
        }

    }

    @Test
    public void testMalformedDice() {
        String[] cases = {
                "Caa1ob1kc1kd1se1wf1dg"
                , "POe2db3Qc4ae4oc6xxx"
                , "Crd1Aa2Gd7tgs"
                , "Caa1ob1kc1kd1se1wf1dg"
                , "POe2db3Qc4ae4oc6xxxwa1"
                , "Crd1GD7"
                , "Crd1Aa2Gd7xxxtg7"
        };

        for (String testCase : cases)
            test(testCase, false);
    }

    @Test
    public void testWellFormed() {
        String[] cases = {
                  "P" // Empty P
                , "p" // Empty p
                , "C" // Empty C
                , "c" // Empty c
                , "Caa1ob1kc1kd1se1wf1dg1"
                , "POe2db3Qc4ae4oc6"
                , "Crd1Gd7"
                , "Crd1Aa2Gd7tg7"
                , "CGa1Fb1Ec1Dd1Ce1Bf1Ag1Na2Mb2Kc2Kd2Je2If2Hg2Ua3Tb3Sc3Rd3Qe3Of3Og3va4wb4xc4Xe4Wf4Vg4oa5ob5qc5rd5se5tf5ug5ha6ib6jc6kd6ke6mf6ng6aa7bb7cc7dd7ee7ff7gg7"
                , "Pva4wb4xc4Xe4Wf4Vg4oa5ob5qc5rd5se5tf5ug5ha6ib6jc6kd6ke6mf6ng6aa7bb7cc7dd7ee7ff7gg7Ga1Fb1Ec1Dd1Ce1Bf1Ag1Na2Mb2Kc2Kd2Je2If2Hg2Ua3Tb3Sc3Rd3Qe3Of3Og3"
                , "PAa1ba1"
        };

        for (String testCase : cases)
            test(testCase, true);
    }

    @Test
    public void testValidState() {
        for (String[] state : ExampleGames.FULL_PUR_GAME) {
            test(state[0], true);
        }
        for (String[] state : ExampleGames.FULL_CONTRA_GAME) {
            test(state[0],true);
        }
    }

}