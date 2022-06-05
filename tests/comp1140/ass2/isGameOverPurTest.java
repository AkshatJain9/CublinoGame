package comp1140.ass2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(value = 1000, unit = MILLISECONDS)
class isGameOverPurTest {

    private void test(String in, int expected, String msg) {
        int out = Cublino.isGameOverPur(in);
        assertEquals(expected, out, "State \"" + in + "\" is " + msg);
    }

    @Test
    public void testUnfinishedGame() {
        String[] cases = {
                "pWa1Wb1Wc1Wd1We1Wf1Lg2va7vb7vc7vd7ve7vf7vg7"
                , "PWa1Wb1Wc1Wd1We1Wf1Lg2ig6va7vb7vc7vd7ve7vf7"
                , "pWa1Wb1Wc1Wd1We1Lf2Lg2ig6va7vb7vc7vd7ve7vf7"
                , "PWa1Wb1Wc1Wd1We1Lf2Lg2ia6ig6vb7vc7vd7ve7vf7"
                , "pWa1Wb1Wc1Wd1We1Le2Lf2ia6ig6vb7vc7vd7ve7vf7"
                , "PWa1Wb1Wc1Wd1We1Le2Lf2ia6ib6ig6vc7vd7ve7vf7"
                , "pWa1Wb1Wc1Wd1We1Ld2Le2ia6ib6ig6vc7vd7ve7vf7"
                , "PWa1Wb1Wc1Wd1We1Ld2Le2ia6ib6ie6ig6vc7vd7vf7"
                , "pWb1Wc1Wd1We1La2Ld2Le2ia6ib6ie6ig6vc7vd7vf7"
                , "PWb1Wc1Wd1We1La2Ld2Le2ia6ib6ie6ig6vc7fe7vf7"
                , "pWb1Wd1We1La2Ld2Le2Wa3ia6ib6ie6ig6vc7fe7vf7"
                , "PWb1Wd1We1La2Ld2Le2Wa3ia6ib6ie6ig6vc7vd7vf7"
                , "pWb1Gc1We1La2Ld2Le2Wa3ia6ib6ie6ig6vc7vd7vf7"
                , "PWb1Gc1We1La2Ld2Le2Wa3ia6ib6ie6if6ig6vc7vf7"
                , "pGc1Wd1We1La2Ld2Le2Wa3ia6ib6ie6if6ig6vc7vf7"
                , "PGc1Wd1We1La2Ld2Le2Wa3ia6ib6id6ie6ig6vc7vf7"
                , "pGc1We1La2Ld2Le2Wa3Wd3ia6ib6id6ie6ig6vc7vf7"
                , "PGc1We1La2Ld2Le2Wa3Wd3re5ia6ib6id6ie6ig6vc7"
                , "pGc1We1La2Le2Lf2Wa3Wd3re5ia6ib6id6ie6ig6vc7"
                , "PGc1We1La2Le2Lf2Wa3Wd3re5ia6ib6id6ef6ig6vc7"
                , "pGc1Sf1La2Le2Lf2Wa3Wd3re5ia6ib6id6ef6ig6vc7"
                , "PGc1Sf1La2Le2Lf2Wa3Wd3re5ia6ib6ee6ef6ig6vc7"
                , "pGc1We1La2Le2Lf2Wa3Wd3re5ia6ib6ee6ef6ig6vc7"
                , "PGc1We1La2Le2Lf2Wa3Wd3ee4re5ia6ib6ef6ig6vc7"
                , "pGc1We1La2Le2Lf2Wa3ee4Lf4re5ia6ib6ef6ig6vc7"
                , "PGc1We1La2Le2Lf2Wa3ee4Lf4re5ia6ib6ie6ig6vc7"
                , "pGc1We1La2Lf2Wa3Be3ee4Lf4re5ia6ib6ie6ig6vc7"
                , "PGc1We1La2Lf2Wa3Be3ee4Lf4re5ia6ib6qd6ig6vc7"
                , "pWe1La2Jc2Lf2Wa3Be3ee4Lf4re5ia6ib6qd6ig6vc7"
                , "PWe1La2Jc2Lf2Wa3Be3ee4Lf4re5ia6ib6qd6qf6vc7"
        };

        for (String testCase : cases)
            test(testCase, 0, "unfinished");

    }

    @Test
    public void testPlayerOneWin() {
        String[] cases = {
                "Pca1bb1dc1ad1ee1kf1vg1Ue6Ib7Rc7Cd7Be7Wf7Ng7"
                , "pga1gb1ic1be1lf1vg1qc2Xa7Gb7Vc7Cd7Be7Wf7Bg7"
                , "poa1cb1fc1gd1we1vg1dd2Ua7Bb7Tc7Dd7Ke7Gf7Sg7"
                , "pwa1gb1bd1se1wf1tg1kf2Aa7Vb7Kc7Rd7Ue7Df7Qg7"
                , "pca1cb1dc1we1lf1sg1eb2Ra7Kb7Vc7Ed7Ce7Ff7Kg7"
                , "pca1ib1wd1we1qf1bg1qg2Sa7Hb7Hc7Dd7Be7Vf7Vg7"
                , "pgb1rc1ud1le1sf1og1ec2Na7Xb7Gc7Ud7Fe7Uf7Gg7"
                , "pta1wb1wc1ge1xf1ga2qg2Ca7Ub7Wc7Nd7Je7Vf7Dg7"
                , "paa1fb1gd1ve1of1gg1ob2Fa7Fb7Cc7Id7We7Wf7Xg7"
                , "poa1gb1bc1md1gg1qg2cf3Aa7Nb7Cc7Fd7Ge7Rf7Vg7"
                , "pba1db1rc1se1wf1ae2ef2Ka7Nb7Fc7Fd7De7Xf7Wg7"
                , "pca1ic1sd1de1bf1cg1ig2Ia7Lb7Vc7Hd7Se7Rf7Eg7"
                , "pnc1ad1se1cg1qg2if4eg5Ra7Fb7Ac7Gd7Ce7Uf7Dg7"
                , "pva1fb1rc1dd1if1fg1sd2Oa7Ub7Vc7Wd7Je7Wf7Sg7"
                , "pma1rb1cc1dd1gg1tc2mg2Sa7Cb7Sc7Dd7Be7Rf7Og7"
                , "psa1gb1fc1we1cf1cg1hf2Ba7Kb7Qc7Gd7De7Vf7Vg7"
                , "Pua1pb1kc1jd1ce1qf1vg1Qf6Sa7Sb7Rd7Se7Sf7Rg7"
                , "pva1fb1jc1ed1nf1cg1ee2Wa7Wb7Cc7Vd7Se7Rf7Bg7"
                , "pga1xb1gc1dd1sf1bg1ib2Ea7Gb7Kc7Md7Pe7Wf7Ag7"
                , "psa1tb1cc1fd1pf1rg1hf2Ra7Ub7Nc7Cd7Ve7Nf7Jg7"
                , "pxa1rb1nc1wd1jf1bg1xe2Aa7Xb7Oc7Wd7Qe7Af7Sg7"
        };

        for (String testCase : cases)
            test(testCase, 1, "won by player 1");
    }

    @Test
    public void testPlayerTwoWin() {
        String[] cases = {
                "pna1jb1lc1re1rf1ng1fa2Ga7Vb7Fc7Ad7Oe7Gf7Bg7"
                , "Pfa1cb1vc1ad1we1sf1ug1Pa6Hc6Wa7Fb7Fe7Ff7Rg7"
                , "pba1db1mc1hd1xf1sg1pe2Fa7Fb7Dc7Ad7Oe7Vf7Hg7"
                , "Pia1fb1jc1pd1re1gf1rg1Df6Ja7Gb7Bc7Xe7Mf7Gg7"
                , "Pka1rb1pc1vd1ue1af1bg1Qb6Vc6Nf6Ja7Jb7Ce7Dg7"
                , "Pba1ub1fc1md1te1kf1sg1Bd6Ca7Kb7Dd7Ae7Rf7Fg7"
                , "Psa1rb1uc1kd1ee1gf1eg1Da6Ib6Ua7Vc7Xd7Be7Mg7"
                , "Paa1xb1vc1vd1se1sf1jg1Ed6Qe6Ba7Nb7Ad7Mf7Sg7"
                , "poa1rb1rc1bd1ve1dg1wb2Ga7Fb7Gc7Gd7Be7Uf7Mg7"
                , "Pca1qb1sc1gd1ce1uf1gg1Lg6Fa7Wb7Sc7Gd7Df7Cg7"
                , "pga1fb1cc1we1xf1gg1va2Ea7Ab7Ec7Kd7Se7Df7Fg7"
                , "Pna1kb1kc1rd1ve1cf1sg1Td6Ie6Oa7Hb7Dc7Bd7Ce7"
                , "pka1tc1od1oe1sf1fg1tg2Ma7Db7Hc7Vd7Je7Hf7Cg7"
                , "Pwa1eb1lc1nd1be1if1cg1Tg5Ic6Fa7Db7Gd7Wf7Ug7"
                , "Paa1vb1vc1rd1qe1qf1ng1Ia5Td6Me6Oa7Fc7Hd7Wg7"
                , "Pwa1db1bc1ud1ue1cf1dg1Mg6Aa7Ab7Vc7Fe7Gf7Gg7"
                , "Pba1fb1wc1wd1fe1vf1jg1Td6Ca7Rb7Gd7Le7Of7Sg7"
                , "pgb1sc1kd1xf1hd2kg2vc3Aa7Cb7Oc7Gd7Ge7Mf7Bg7"
                , "Pva1ob1bc1dd1ee1bf1rg1Td6Db7Bc7Hd7Ae7Df7Ug7"
                , "Pba1vb1ec1rd1se1wf1bg1Le6Aa7Mc7Kd7Be7Df7Vg7"
                , "poa1db1rc1wd1wf1bg1rg2Ga7Db7Gc7Sd7Re7Af7Kg7"
        };

        for (String testCase : cases)
            test(testCase, 2, "won by player 2");
    }

    @Test
    public void testDraw() {
        String[] cases = {
                "Pia1eb1cc1fd1ce1hf1kg1Rf6Ba7Pb7Uc7Ce7Af7Dg7"
                , "pga1cb1dc1gd1if1vg1jb2Da7Vb7Dc7Fd7He7Df7Eg7"
                , "Pca1xb1ac1hd1ke1vf1vg1Df6Ma7Dc7Gd7We7Xf7Wg7"
                , "pnc1ud1ge1wf1xg1ed2xe2Ea7Sb7Jc7Kd7Ke7Vf7Gg7"
                , "pga1gb1pc1fd1ue1bg1jb2Aa7Hb7Jc7Dd7Be7Kf7Vg7"
        };

        for (String testCase : cases)
            test(testCase, 3, "a draw");
    }

}