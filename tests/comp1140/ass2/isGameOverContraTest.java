package comp1140.ass2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(value = 1000, unit = MILLISECONDS)
class isGameOverContraTest {

    private void test(String in, int expected, String msg) {
        int out = Cublino.isGameOverContra(in);
        assertEquals(expected, out, "State \"" + in + "\" is " + msg);
    }

    @Test
    public void testUnfinishedGame() {
        String[] cases = {
                "cWa1Wc1Wd1We1Wf1Wg1Lb2va7vb7vc7vd7ve7vf7vg7"
                , "CWa1Wc1Wd1We1Wf1Wg1Lb2ie6va7vb7vc7vd7vf7vg7"
                , "cWc1Wd1We1Wf1Wg1La2Lb2ie6va7vb7vc7vd7vf7vg7"
                , "CWc1Wd1We1Wf1Wg1La2Lb2ib6ie6va7vc7vd7vf7vg7"
                , "cWc1Wd1We1Wf1La2Lb2Lg2ib6ie6va7vc7vd7vf7vg7"
                , "CWc1Wd1We1Wf1La2Lb2Lg2ib6ie6va7rb7vd7vf7vg7"
                , "cWc1We1Wf1La2Lb2Ld2Lg2ib6ie6va7rb7vd7vf7vg7"
                , "CWc1We1Wf1La2Lb2Ld2Lg2ec6ie6va7rb7vd7vf7vg7"
                , "cWc1We1Wf1La2Lb2Ld2Hf2ec6ie6va7rb7vd7vf7vg7"
                , "CWc1We1Wf1La2Lb2Ld2Hf2ec6ef6va7rb7vd7vf7vg7"
                , "cWc1We1Wf1Lb2Ld2Hf2Ba3ec6ef6va7rb7vd7vf7vg7"
                , "CWc1We1Wf1Lb2Ld2Hf2Ba3ia6ec6ef6rb7vd7vf7vg7"
                , "cSd1We1Wf1Lb2Ld2Hf2Ba3ia6ec6ef6rb7vd7vf7vg7"
                , "CSd1We1Wf1Lb2Ld2Hf2Ba3ia6ec6ef6rb7vd7re7vg7"
                , "cSd1We1Wf1Lb2Hc2Hf2Ba3ia6ec6ef6rb7vd7re7vg7"
                , "CSd1We1Wf1Lb2Hc2Hf2Ba3ia6ec6ef6ba7vd7re7vg7"
                , "cSd1We1Wf1Ha2Hc2Hf2Ba3ia6ec6ef6ba7vd7re7vg7"
                , "CSd1We1Wf1Ha2Hc2Hf2Ba3ia6ec6mg6ba7vd7re7vg7"
                , "cWe1Wf1Ha2Hc2Kd2Hf2Ba3ia6ec6mg6ba7vd7re7vg7"
                , "CWe1Wf1Ha2Hc2Kd2Hf2Ba3ca5ec6mg6ba7vd7re7vg7"
                , "cWe1Wf1Ha2Hc2Kd2Hf2Rb3ca5ec6mg6ba7vd7re7vg7"
                , "CWe1Wf1Ha2Hc2Kd2Hf2Rb3ca5bg5ec6ba7vd7re7vg7"
                , "cWe1Wf1Ha2Hc2Kd2Pe2Rb3ca5bg5ec6ba7vd7re7vg7"
                , "CWe1Wf1Ha2Hc2Kd2Pe2Rb3ca5ff5ec6ba7vd7re7vg7"
                , "cWe1Wf1Ha2Pb2Kd2Pe2Rb3ca5ff5ec6ba7vd7re7vg7"
                , "CWe1Wf1Ha2Pb2Kd2Pe2Rb3ca5ff5ec6ba7vd7vf7vg7"
                , "cWe1Wf1Ha2Pb2Kd2Pe2Ob4ca5ff5ec6ba7vd7vf7vg7"
                , "CWe1Wf1Ha2Pb2Kd2Pe2Ob4ff5ec6ba7vd7vf7vg7"
                , "cWe1Sg1Ha2Pb2Kd2Pe2Ob4ff5ec6ba7vd7vf7vg7"
                , "CWe1Sg1Ha2Pb2Kd2Pe2Ob4kf4ec6ba7vd7vf7vg7"
        };

        for (String testCase : cases)
            test(testCase, 0, "unfinished");
    }

    @Test
    public void testPlayerOneWin() {
        String[] cases = {
                "cGa1Gc1We1Pe2Lg2He4pg4wg5kb6Ba7vc7vf7"
                , "cWg1La2Le2Lf2Fa3ec4Re4da5sb5hd5ic6Me7"
                , "cFf3Fd4fd5id6ig6Gb7re7"
                , "cSb1Wc1Oe2Ke3oc4gf5eb6ee6re7Bg7"
                , "cGf1Td2Rf3Dg3pd4le6Bc7"
                , "cTc2Gd3De3Og3pa4ob4Xd5dg5Df7"
                , "cmc3kc4ea5Af7"
                , "cGc1jd2tc4pf4pg4kd5ef6Cb7"
                , "cbd2ub3Md7"
                , "ckd2Xf4Lb7"
                , "cud2Pg5le6Bb7"
                , "cka2ke3Og3db5Sg5ba7Cg7"
                , "cbf3Dg3Xc5Fb7be7"
                , "ccc2If3df6Ed7"
                , "cra3id4tf4ve7Hg7"
                , "cmb2He2la4Eg4ce5Hg5ib6ic6Bg7"
                , "cWd1vb3id4tc5ad5cf5Fg7"
                , "crf3ac4Eb5pe5Bc7"
                , "cWb1Sd1La2Kg2Ce4sd5Vg5la6ec6Df7"
                , "cUf2xa3md4bc7Bg7"
                , "cof2we4ja6Vb7"
        };

        for (String testCase : cases)
            test(testCase, 1, "won by player 1");
    }

    @Test
    public void testPlayerTwoWin() {
        String[] cases = {
                "CWb1tf1Lb2Ba3we3ge4Ua5ra7"
                , "Cee1Ta4pg4re5md6fb7"
                , "Cca1Ge3ae5"
                , "Cbf1Aa2Bd3Hd5af5Ea6"
                , "Ccg1Pb2Ne3Ua4vb4Ha6"
                , "Cwd1Bg3Df4Vb5Sf5ia6ud6"
                , "Caa1qb2Le2Tf4"
                , "Cca1Kc2Wg5fc7"
                , "CGb1cd1La2Le2Lf2Bb3Bg3qb6qe6va7vb7bc7vg7"
                , "Cpg1Ha3lc3Ld6"
                , "CGc1bf1Xc4La6ig6rc7bg7"
                , "Caf1ha4Eb4Pc4Cb5"
                , "Cue1xb3ae5Wg5kb6"
                , "Cbd1Lg2Ob4uf4We6"
                , "Cod1Pc3Qe4Sb5Fc6"
                , "Caa1kb2Dd4Mf6"
                , "CWa1af1Pd2Dc3xe3wa5Vc5Xe6va7rc7"
                , "Ccg1Lc2Lf2Xd3pa4Dc5Ve5ja6kb6"
                , "Csc1ea4Cd4Pe6"
                , "Ccg1Ed2pa4Od4ab6vb7fc7"
                , "Cda1Eg4qb5Se5Ff5ia6"
        };

        for (String testCase : cases)
            test(testCase, 2, "won by player 2");
    }

}