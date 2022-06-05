package comp1140.ass2;

public class ExampleGames {

    public static final String INITIAL_STATE = "PWa1Wb1Wc1Wd1We1Wf1Wg1va7vb7vc7vd7ve7vf7vg7";

    public static final String[][] FULL_PUR_GAME = {
            new String[]{"PWa1Wb1Wc1Wd1We1Wf1Wg1va7vb7vc7vd7ve7vf7vg7", "d1d2"}
            , new String[]{"pWa1Wb1Wc1We1Wf1Wg1Ld2va7vb7vc7vd7ve7vf7vg7", "f7f6"}
            , new String[]{"PWa1Wb1Wc1We1Wf1Wg1Ld2if6va7vb7vc7vd7ve7vg7", "e1e2c2"}
            , new String[]{"pWa1Wb1Wc1Wf1Wg1Lc2Ld2if6va7vb7vc7vd7ve7vg7", "d7d6"}
            , new String[]{"PWa1Wb1Wc1Wf1Wg1Lc2Ld2id6if6va7vb7vc7ve7vg7", "c2c3"}
            , new String[]{"pWa1Wb1Wc1Wf1Wg1Ld2Bc3id6if6va7vb7vc7ve7vg7", "b7d7f7f5"}
            , new String[]{"PWa1Wb1Wc1Wf1Wg1Ld2Bc3vf5id6if6va7vc7ve7vg7", "c1c2e2"}
            , new String[]{"pWa1Wb1Wf1Wg1Ld2Le2Bc3vf5id6if6va7vc7ve7vg7", "c7d7f7"}
            , new String[]{"PWa1Wb1Wf1Wg1Ld2Le2Bc3vf5id6if6va7ve7ff7vg7", "a1c1"}
            , new String[]{"pWb1Wc1Wf1Wg1Ld2Le2Bc3vf5id6if6va7ve7ff7vg7", "f5f4"}
            , new String[]{"PWb1Wc1Wf1Wg1Ld2Le2Bc3if4id6if6va7ve7ff7vg7", "d2d3"}
            , new String[]{"pWb1Wc1Wf1Wg1Le2Bc3Bd3if4id6if6va7ve7ff7vg7", "f7f5f3"}
            , new String[]{"PWb1Wc1Wf1Wg1Le2Bc3Bd3ff3if4id6if6va7ve7vg7", "f1e1"}
            , new String[]{"pWb1Wc1Ge1Wg1Le2Bc3Bd3ff3if4id6if6va7ve7vg7", "d6d5"}
            , new String[]{"PWb1Wc1Ge1Wg1Le2Bc3Bd3ff3if4cd5if6va7ve7vg7", "c1c2c4"}
            , new String[]{"pWb1Ge1Wg1Le2Bc3Bd3ff3Lc4if4cd5if6va7ve7vg7", "f4e4"}
            , new String[]{"PWb1Ge1Wg1Le2Bc3Bd3ff3Lc4qe4cd5if6va7ve7vg7", "d3e3g3"}
            , new String[]{"pWb1Ge1Wg1Le2Bc3ff3Rg3Lc4qe4cd5if6va7ve7vg7", "d5d4"}
            , new String[]{"PWb1Ge1Wg1Le2Bc3ff3Rg3Lc4pd4qe4if6va7ve7vg7", "c3b3"}
            , new String[]{"pWb1Ge1Wg1Le2Fb3ff3Rg3Lc4pd4qe4if6va7ve7vg7", "d4f4"}
            , new String[]{"PWb1Ge1Wg1Le2Fb3ff3Rg3Lc4qe4pf4if6va7ve7vg7", "b1c1"}
            , new String[]{"pSc1Ge1Wg1Le2Fb3ff3Rg3Lc4qe4pf4if6va7ve7vg7", "f4g4"}
            , new String[]{"PSc1Ge1Wg1Le2Fb3ff3Rg3Lc4qe4hg4if6va7ve7vg7", "b3a3"}
            , new String[]{"pSc1Ge1Wg1Le2Va3ff3Rg3Lc4qe4hg4if6va7ve7vg7", "g4f4d4"}
            , new String[]{"PSc1Ge1Wg1Le2Va3ff3Rg3Lc4pd4qe4if6va7ve7vg7", "e1e3"}
            , new String[]{"pSc1Wg1Le2Va3Ge3ff3Rg3Lc4pd4qe4if6va7ve7vg7", "d4f4f2d2"}
            , new String[]{"PSc1Wg1pd2Le2Va3Ge3ff3Rg3Lc4qe4if6va7ve7vg7", "c1c2"}
            , new String[]{"pWg1Kc2pd2Le2Va3Ge3ff3Rg3Lc4qe4if6va7ve7vg7", "e7e6g6"}
            , new String[]{"PWg1Kc2pd2Le2Va3Ge3ff3Rg3Lc4qe4if6ig6va7vg7", "a3a4"}
            , new String[]{"pWg1Kc2pd2Le2Ge3ff3Rg3Pa4Lc4qe4if6ig6va7vg7", "g7f7f5"}
            , new String[]{"PWg1Kc2pd2Le2Ge3ff3Rg3Pa4Lc4qe4rf5if6ig6va7", "a4a5"}
            , new String[]{"pWg1Kc2pd2Le2Ge3ff3Rg3Lc4qe4Ca5rf5if6ig6va7", "g6e6"}
            , new String[]{"PWg1Kc2pd2Le2Ge3ff3Rg3Lc4qe4Ca5rf5ie6if6va7", "g1f1"}
            , new String[]{"pGf1Kc2pd2Le2Ge3ff3Rg3Lc4qe4Ca5rf5ie6if6va7", "e6e5"}
            , new String[]{"PGf1Kc2pd2Le2Ge3ff3Rg3Lc4qe4Ca5ce5rf5if6va7", "e2f2f4d4"}
            , new String[]{"pGf1Kc2pd2Ge3ff3Rg3Lc4Td4qe4Ca5ce5rf5if6va7", "a7a6a4"}
            , new String[]{"PGf1Kc2pd2Ge3ff3Rg3ia4Lc4Td4qe4Ca5ce5rf5if6", "f1e1"}
            , new String[]{"pCe1Kc2pd2Ge3ff3Rg3ia4Lc4Td4qe4Ca5ce5rf5if6", "e5g5"}
            , new String[]{"PCe1Kc2pd2Ge3ff3Rg3ia4Lc4Td4qe4Ca5rf5cg5if6", "a5b5"}
            , new String[]{"pCe1Kc2pd2Ge3ff3Rg3ia4Lc4Td4qe4Gb5rf5cg5if6", "f3d3"}
            , new String[]{"PCe1Kc2pd2fd3Ge3Rg3ia4Lc4Td4qe4Gb5rf5cg5if6", "c2b2"}
            , new String[]{"pCe1Xb2pd2fd3Ge3Rg3ia4Lc4Td4qe4Gb5rf5cg5if6", "f5e5"}
            , new String[]{"PCe1Xb2pd2fd3Ge3Rg3ia4Lc4Td4qe4Gb5be5cg5if6", "b5b6"}
            , new String[]{"pCe1Xb2pd2fd3Ge3Rg3ia4Lc4Td4qe4be5cg5Jb6if6", "g5f5d5"}
            , new String[]{"PCe1Xb2pd2fd3Ge3Rg3ia4Lc4Td4qe4sd5be5Jb6if6", "b2a2"}
            , new String[]{"pCe1Oa2pd2fd3Ge3Rg3ia4Lc4Td4qe4sd5be5Jb6if6", "e4e2c2"}
            , new String[]{"PCe1Oa2qc2pd2fd3Ge3Rg3ia4Lc4Td4sd5be5Jb6if6", "e3e4"}
            , new String[]{"pCe1Oa2qc2pd2fd3Rg3ia4Lc4Td4Je4sd5be5Jb6if6", "c2c1"}
            , new String[]{"Pac1Ce1Oa2pd2fd3Rg3ia4Lc4Td4Je4sd5be5Jb6if6", "g3g4"}
            , new String[]{"pac1Ce1Oa2pd2fd3ia4Lc4Td4Je4Og4sd5be5Jb6if6", "d3d1b1"}
            , new String[]{"Pfb1ac1Ce1Oa2pd2ia4Lc4Td4Je4Og4sd5be5Jb6if6", "b6a6"}
            , new String[]{"pfb1ac1Ce1Oa2pd2ia4Lc4Td4Je4Og4sd5be5Aa6if6", "e5e3"}
            , new String[]{"Pfb1ac1Ce1Oa2pd2be3ia4Lc4Td4Je4Og4sd5Aa6if6", "e1e2c2"}
            , new String[]{"pfb1ac1Oa2Ic2pd2be3ia4Lc4Td4Je4Og4sd5Aa6if6", "d5d3d1"}
            , new String[]{"Pfb1ac1sd1Oa2Ic2pd2be3ia4Lc4Td4Je4Og4Aa6if6", "e4e5"}
            , new String[]{"pfb1ac1sd1Oa2Ic2pd2be3ia4Lc4Td4Og4Re5Aa6if6", "c1e1"}
            , new String[]{"Pfb1sd1ae1Oa2Ic2pd2be3ia4Lc4Td4Og4Re5Aa6if6", "c4e4e6"}
            , new String[]{"pfb1sd1ae1Oa2Ic2pd2be3ia4Td4Og4Re5Aa6Le6if6", "f6f5d5"}
            , new String[]{"Pfb1sd1ae1Oa2Ic2pd2be3ia4Td4Og4cd5Re5Aa6Le6", "c2e2"}
            , new String[]{"pfb1sd1ae1Oa2pd2Ie2be3ia4Td4Og4cd5Re5Aa6Le6", "b1a1"}
            , new String[]{"Pva1sd1ae1Oa2pd2Ie2be3ia4Td4Og4cd5Re5Aa6Le6", "e6d6"}
            , new String[]{"pva1sd1ae1Oa2pd2Ie2be3ia4Td4Og4cd5Re5Aa6Hd6", "a4b4"}
            , new String[]{"Pva1sd1ae1Oa2pd2Ie2be3eb4Td4Og4cd5Re5Aa6Hd6", "d6d7"}
            , new String[]{"pva1sd1ae1Oa2pd2Ie2be3eb4Td4Og4cd5Re5Aa6Ad7", "d5d3f3"}
            , new String[]{"Pva1sd1ae1Oa2pd2Ie2be3cf3eb4Td4Og4Re5Aa6Ad7", "a6b6"}
            , new String[]{"pva1sd1ae1Oa2pd2Ie2be3cf3eb4Td4Og4Re5Jb6Ad7", "b4c4"}
            , new String[]{"Pva1sd1ae1Oa2pd2Ie2be3cf3mc4Td4Og4Re5Jb6Ad7", "g4g5"}
            , new String[]{"pva1sd1ae1Oa2pd2Ie2be3cf3mc4Td4Re5Gg5Jb6Ad7", "d1c1"}
            , new String[]{"Pva1wc1ae1Oa2pd2Ie2be3cf3mc4Td4Re5Gg5Jb6Ad7", "d4e4"}
            , new String[]{"pva1wc1ae1Oa2pd2Ie2be3cf3mc4Pe4Re5Gg5Jb6Ad7", "a1b1d1"}
            , new String[]{"Pwc1fd1ae1Oa2pd2Ie2be3cf3mc4Pe4Re5Gg5Jb6Ad7", "d7e7"}
            , new String[]{"pwc1fd1ae1Oa2pd2Ie2be3cf3mc4Pe4Re5Gg5Jb6Je7", "c4d4f4f2"}
            , new String[]{"Pwc1fd1ae1Oa2pd2Ie2qf2be3cf3Pe4Re5Gg5Jb6Je7", "e5e6"}
            , new String[]{"pwc1fd1ae1Oa2pd2Ie2qf2be3cf3Pe4Gg5Jb6Oe6Je7", "f2f1"}
            , new String[]{"Pwc1fd1ae1af1Oa2pd2Ie2be3cf3Pe4Gg5Jb6Oe6Je7", "e2f2f4d4"}
            , new String[]{"pwc1fd1ae1af1Oa2pd2be3cf3Ed4Pe4Gg5Jb6Oe6Je7", "e3d3"}
            , new String[]{"Pwc1fd1ae1af1Oa2pd2fd3cf3Ed4Pe4Gg5Jb6Oe6Je7", "e4f4"}
            , new String[]{"pwc1fd1ae1af1Oa2pd2fd3cf3Ed4Hf4Gg5Jb6Oe6Je7", "e1g1"}
            , new String[]{"Pwc1fd1af1ag1Oa2pd2fd3cf3Ed4Hf4Gg5Jb6Oe6Je7", "e6d6"}
            , new String[]{"pwc1fd1af1ag1Oa2pd2fd3cf3Ed4Hf4Gg5Jb6Dd6Je7", "f3f2"}
            , new String[]{"Pwc1fd1af1ag1Oa2pd2pf2fd3Ed4Hf4Gg5Jb6Dd6Je7", "g5f5"}
            , new String[]{"pwc1fd1af1ag1Oa2pd2pf2fd3Ed4Hf4Cf5Jb6Dd6Je7", "d1e1"}
            , new String[]{"Pwc1be1af1ag1Oa2pd2pf2fd3Ed4Hf4Cf5Jb6Dd6Je7", "f4e4c4"}
            , new String[]{"pwc1be1af1ag1Oa2pd2pf2fd3Pc4Ed4Cf5Jb6Dd6Je7", "c1b1"}
            , new String[]{"Pgb1be1af1ag1Oa2pd2pf2fd3Pc4Ed4Cf5Jb6Dd6Je7", "b6c6e6"}
            , new String[]{"pgb1be1af1ag1Oa2pd2pf2fd3Pc4Ed4Cf5Dd6Ue6Je7", "f2e2c2"}
            , new String[]{"Pgb1be1af1ag1Oa2tc2pd2fd3Pc4Ed4Cf5Dd6Ue6Je7", "f5g5"}
            , new String[]{"pgb1be1af1ag1Oa2tc2pd2fd3Pc4Ed4Gg5Dd6Ue6Je7", "b1a1"}
            , new String[]{"Pca1be1af1ag1Oa2tc2pd2fd3Pc4Ed4Gg5Dd6Ue6Je7", "d6d7f7"}
            , new String[]{"pca1be1af1ag1Oa2tc2pd2fd3Pc4Ed4Gg5Ue6Je7Ef7", "c2e2"}
            , new String[]{"Pca1be1af1ag1Oa2pd2te2fd3Pc4Ed4Gg5Ue6Je7Ef7", "e6f6"}
            , new String[]{"pca1be1af1ag1Oa2pd2te2fd3Pc4Ed4Gg5Nf6Je7Ef7", "d2f2"}
            , new String[]{"Pca1be1af1ag1Oa2te2pf2fd3Pc4Ed4Gg5Nf6Je7Ef7", "e7g7"}
            , new String[]{"pca1be1af1ag1Oa2te2pf2fd3Pc4Ed4Gg5Nf6Ef7Jg7", "f1d1"}
            , new String[]{"Pca1ad1be1ag1Oa2te2pf2fd3Pc4Ed4Gg5Nf6Ef7Jg7", "f6g6"}
            , new String[]{"pca1ad1be1ag1Oa2te2pf2fd3Pc4Ed4Gg5Ag6Ef7Jg7", "d3e3"}
            , new String[]{"Pca1ad1be1ag1Oa2te2pf2be3Pc4Ed4Gg5Ag6Ef7Jg7", "g7e7"}
            , new String[]{"pca1ad1be1ag1Oa2te2pf2be3Pc4Ed4Gg5Ag6Je7Ef7", "d1f1"}
            , new String[]{"Pca1be1af1ag1Oa2te2pf2be3Pc4Ed4Gg5Ag6Je7Ef7", "c4e4"}
            , new String[]{"pca1be1af1ag1Oa2te2pf2be3Ed4Pe4Gg5Ag6Je7Ef7", "e3f3"}
            , new String[]{"Pca1be1af1ag1Oa2te2pf2rf3Ed4Pe4Gg5Ag6Je7Ef7", "d4f4"}
            , new String[]{"pca1be1af1ag1Oa2te2pf2rf3Pe4Ef4Gg5Ag6Je7Ef7", "e2d2"}
            , new String[]{"Pca1be1af1ag1Oa2ld2pf2rf3Pe4Ef4Gg5Ag6Je7Ef7", "a2a3"}
            , new String[]{"pca1be1af1ag1ld2pf2Ga3rf3Pe4Ef4Gg5Ag6Je7Ef7", "f2e2"}
            , new String[]{"Pca1be1af1ag1ld2te2Ga3rf3Pe4Ef4Gg5Ag6Je7Ef7", "f4f5"}
            , new String[]{"pca1be1af1ag1ld2te2Ga3rf3Pe4Uf5Gg5Ag6Je7Ef7", "e2f2"}
            , new String[]{"Pca1be1af1ag1ld2pf2Ga3rf3Pe4Uf5Gg5Ag6Je7Ef7", "g5e5"}
            , new String[]{"pca1be1af1ag1ld2pf2Ga3rf3Pe4Ge5Uf5Ag6Je7Ef7", "d2e2"}
            , new String[]{"Pca1be1af1ag1te2pf2Ga3rf3Pe4Ge5Uf5Ag6Je7Ef7", "f5f6"}
            , new String[]{"pca1be1af1ag1te2pf2Ga3rf3Pe4Ge5Tf6Ag6Je7Ef7", "f3g3"}
            , new String[]{"Pca1be1af1ag1te2pf2Ga3vg3Pe4Ge5Tf6Ag6Je7Ef7", "e4e6"}
            , new String[]{"pca1be1af1ag1te2pf2Ga3vg3Ge5Pe6Tf6Ag6Je7Ef7", "e2d2"}
            , new String[]{"Pca1be1af1ag1ld2pf2Ga3vg3Ge5Pe6Tf6Ag6Je7Ef7", "e5f5"}
            , new String[]{"pca1be1af1ag1ld2pf2Ga3vg3Wf5Pe6Tf6Ag6Je7Ef7", "f2g2"}
            , new String[]{"Pca1be1af1ag1ld2hg2Ga3vg3Wf5Pe6Tf6Ag6Je7Ef7", "g6g7"}
            , new String[]{"pca1be1af1ag1ld2hg2Ga3vg3Wf5Pe6Tf6Je7Ef7Qg7", "d2d1"}
            , new String[]{"Pca1wd1be1af1ag1hg2Ga3vg3Wf5Pe6Tf6Je7Ef7Qg7", "f7d7"}
            , new String[]{"pca1wd1be1af1ag1hg2Ga3vg3Wf5Pe6Tf6Ed7Je7Qg7", "d1c1"}
            , new String[]{"Pca1gc1be1af1ag1hg2Ga3vg3Wf5Pe6Tf6Ed7Je7Qg7", "f5e5"}
            , new String[]{"pca1gc1be1af1ag1hg2Ga3vg3Ge5Pe6Tf6Ed7Je7Qg7", "e1d1"}
            , new String[]{"Pca1gc1fd1af1ag1hg2Ga3vg3Ge5Pe6Tf6Ed7Je7Qg7", "e5d5"}
            , new String[]{"pca1gc1fd1af1ag1hg2Ga3vg3Cd5Pe6Tf6Ed7Je7Qg7", "g1e1"}
            , new String[]{"Pca1gc1fd1ae1af1hg2Ga3vg3Cd5Pe6Tf6Ed7Je7Qg7", "d7f7"}
            , new String[]{"pca1gc1fd1ae1af1hg2Ga3vg3Cd5Pe6Tf6Je7Ef7Qg7", "g3g1"}
            , new String[]{"Pca1gc1fd1ae1af1vg1hg2Ga3Cd5Pe6Tf6Je7Ef7Qg7", "e6g6"}
            , new String[]{"pca1gc1fd1ae1af1vg1hg2Ga3Cd5Tf6Pg6Je7Ef7Qg7", "c1b1"}
            , new String[]{"Pca1cb1fd1ae1af1vg1hg2Ga3Cd5Tf6Pg6Je7Ef7Qg7", "d5c5"}
            , new String[]{"pca1cb1fd1ae1af1vg1hg2Ga3Sc5Tf6Pg6Je7Ef7Qg7", "b1c1"}
            , new String[]{"Pca1gc1fd1ae1af1vg1hg2Ga3Sc5Tf6Pg6Je7Ef7Qg7", "f6e6"}
            , new String[]{"pca1gc1fd1ae1af1vg1hg2Ga3Sc5Le6Pg6Je7Ef7Qg7", "a1b1"}
            , new String[]{"Pgb1gc1fd1ae1af1vg1hg2Ga3Sc5Le6Pg6Je7Ef7Qg7", "g6f6d6"}
            , new String[]{"pgb1gc1fd1ae1af1vg1hg2Ga3Sc5Td6Le6Je7Ef7Qg7", "b1a1"}
            , new String[]{"Pca1gc1fd1ae1af1vg1hg2Ga3Sc5Td6Le6Je7Ef7Qg7", "d6d7"}
            , new String[]{"pca1gc1fd1ae1af1vg1hg2Ga3Sc5Le6Dd7Je7Ef7Qg7", "g2f2"}
            , new String[]{"Pca1gc1fd1ae1af1vg1pf2Ga3Sc5Le6Dd7Je7Ef7Qg7", "c5c6"}
            , new String[]{"pca1gc1fd1ae1af1vg1pf2Ga3Kc6Le6Dd7Je7Ef7Qg7", "f2g2"}
            , new String[]{"Pca1gc1fd1ae1af1vg1hg2Ga3Kc6Le6Dd7Je7Ef7Qg7", "a3b3"}
            , new String[]{"pca1gc1fd1ae1af1vg1hg2Wb3Kc6Le6Dd7Je7Ef7Qg7", "a1b1"}
            , new String[]{"Pgb1gc1fd1ae1af1vg1hg2Wb3Kc6Le6Dd7Je7Ef7Qg7", "e7c7"}
            , new String[]{"pgb1gc1fd1ae1af1vg1hg2Wb3Kc6Le6Jc7Dd7Ef7Qg7", "g2f2"}
            , new String[]{"Pgb1gc1fd1ae1af1vg1pf2Wb3Kc6Le6Jc7Dd7Ef7Qg7", "c7e7"}
            , new String[]{"pgb1gc1fd1ae1af1vg1pf2Wb3Kc6Le6Dd7Je7Ef7Qg7", "b1a1"}
            , new String[]{"Pca1gc1fd1ae1af1vg1pf2Wb3Kc6Le6Dd7Je7Ef7Qg7", "b3b4"}
            , new String[]{"pca1gc1fd1ae1af1vg1pf2Lb4Kc6Le6Dd7Je7Ef7Qg7", "f2e2"}
            , new String[]{"Pca1gc1fd1ae1af1vg1te2Lb4Kc6Le6Dd7Je7Ef7Qg7", "e7c7"}
            , new String[]{"pca1gc1fd1ae1af1vg1te2Lb4Kc6Le6Jc7Dd7Ef7Qg7", "e2f2"}
            , new String[]{"Pca1gc1fd1ae1af1vg1pf2Lb4Kc6Le6Jc7Dd7Ef7Qg7", "c6d6f6"}
            , new String[]{"pca1gc1fd1ae1af1vg1pf2Lb4Le6Df6Jc7Dd7Ef7Qg7", "f2g2"}
            , new String[]{"Pca1gc1fd1ae1af1vg1hg2Lb4Le6Df6Jc7Dd7Ef7Qg7", "f6g6"}
            , new String[]{"pca1gc1fd1ae1af1vg1hg2Lb4Le6Og6Jc7Dd7Ef7Qg7", "c1b1"}
            , new String[]{"Pca1cb1fd1ae1af1vg1hg2Lb4Le6Og6Jc7Dd7Ef7Qg7", "e6f6"}
            , new String[]{"pca1cb1fd1ae1af1vg1hg2Lb4Tf6Og6Jc7Dd7Ef7Qg7", "g2f2"}
            , new String[]{"Pca1cb1fd1ae1af1vg1pf2Lb4Tf6Og6Jc7Dd7Ef7Qg7", "f7e7"}
            , new String[]{"pca1cb1fd1ae1af1vg1pf2Lb4Tf6Og6Jc7Dd7Ie7Qg7", "d1c1"}
            , new String[]{"Pca1cb1vc1ae1af1vg1pf2Lb4Tf6Og6Jc7Dd7Ie7Qg7", "g6e6"}
            , new String[]{"pca1cb1vc1ae1af1vg1pf2Lb4Oe6Tf6Jc7Dd7Ie7Qg7", "f1d1"}
            , new String[]{"Pca1cb1vc1ad1ae1vg1pf2Lb4Oe6Tf6Jc7Dd7Ie7Qg7", "b4c4"}
            , new String[]{"pca1cb1vc1ad1ae1vg1pf2Tc4Oe6Tf6Jc7Dd7Ie7Qg7", "f2g2"}
            , new String[]{"Pca1cb1vc1ad1ae1vg1hg2Tc4Oe6Tf6Jc7Dd7Ie7Qg7", "g7f7"}
            , new String[]{"pca1cb1vc1ad1ae1vg1hg2Tc4Oe6Tf6Jc7Dd7Ie7Mf7", "g1f1"}
            , new String[]{"Pca1cb1vc1ad1ae1rf1hg2Tc4Oe6Tf6Jc7Dd7Ie7Mf7", "d7b7"}
            , new String[]{"pca1cb1vc1ad1ae1rf1hg2Tc4Oe6Tf6Db7Jc7Ie7Mf7", "g2g1"}
            , new String[]{"Pca1cb1vc1ad1ae1rf1xg1Tc4Oe6Tf6Db7Jc7Ie7Mf7", null}
    };

    public static final String[][] FULL_CONTRA_GAME = {
            new String[]{"CWa1Wb1Wc1Wd1We1Wf1Wg1va7vb7vc7vd7ve7vf7vg7", "g1g2"}
            , new String[]{"cWa1Wb1Wc1Wd1We1Wf1Lg2va7vb7vc7vd7ve7vf7vg7", "c7c6"}
            , new String[]{"CWa1Wb1Wc1Wd1We1Wf1Lg2ic6va7vb7vd7ve7vf7vg7", "f1g1"}
            , new String[]{"cWa1Wb1Wc1Wd1We1Sg1Lg2ic6va7vb7vd7ve7vf7vg7", "c6b6"}
            , new String[]{"CWa1Wb1Wc1Wd1We1Sg1Lg2qb6va7vb7vd7ve7vf7vg7", "d1d2"}
            , new String[]{"cWa1Wb1Wc1We1Sg1Ld2Lg2qb6va7vb7vd7ve7vf7vg7", "d7c7"}
            , new String[]{"CWa1Wb1Wc1We1Sg1Ld2Lg2qb6va7vb7rc7ve7vf7vg7", "d2e2"}
            , new String[]{"cWa1Wb1Wc1We1Sg1Te2Lg2qb6va7vb7rc7ve7vf7vg7", "c7d7"}
            , new String[]{"CWa1Wb1Wc1We1Sg1Te2Lg2qb6va7vb7vd7ve7vf7vg7", "g2f2"}
            , new String[]{"cWa1Wb1Wc1We1Sg1Te2Hf2qb6va7vb7vd7ve7vf7vg7", "d7c7"}
            , new String[]{"CWa1Wb1Wc1We1Sg1Te2Hf2qb6va7vb7rc7ve7vf7vg7", "b1b2"}
            , new String[]{"cWa1Wc1We1Sg1Lb2Te2Hf2qb6va7vb7rc7ve7vf7vg7", "b6c6"}
            , new String[]{"CWa1Wc1We1Sg1Lb2Te2Hf2ic6va7vb7rc7ve7vf7vg7", "b2a2"}
            , new String[]{"cWa1Wc1We1Sg1Ha2Te2Hf2ic6va7vb7rc7ve7vf7vg7", "c6b6"}
            , new String[]{"CWa1Wc1We1Sg1Ha2Te2Hf2qb6va7vb7rc7ve7vf7vg7", "a2b2"}
            , new String[]{"cWa1Wc1We1Sg1Lb2Te2Hf2qb6va7vb7rc7ve7vf7vg7", "c7c6"}
            , new String[]{"CWa1Wc1We1Sg1Lb2Te2Hf2qb6jc6va7vb7ve7vf7vg7", "b2c2"}
            , new String[]{"cWa1Wc1We1Sg1Tc2Te2Hf2qb6jc6va7vb7ve7vf7vg7", "c6c5"}
            , new String[]{"CWa1Wc1We1Sg1Tc2Te2Hf2gc5qb6va7vb7ve7vf7vg7", "c2c3"}
            , new String[]{"cWa1Wc1We1Sg1Te2Hf2Dc3gc5qb6va7vb7ve7vf7vg7", "b7c7"}
            , new String[]{"CWa1Wc1We1Sg1Te2Hf2Dc3gc5qb6va7fc7ve7vf7vg7", "e1d1"}
            , new String[]{"cWa1Wc1Gd1Sg1Te2Hf2Dc3gc5qb6va7fc7ve7vf7vg7", "c7b7"}
            , new String[]{"CWa1Wc1Gd1Sg1Te2Hf2Dc3gc5qb6va7vb7ve7vf7vg7", "d1d2"}
            , new String[]{"cWa1Wc1Sg1Jd2Te2Hf2Dc3gc5qb6va7vb7ve7vf7vg7", "g7g6"}
            , new String[]{"CWa1Wc1Sg1Jd2Te2Hf2Dc3gc5qb6ig6va7vb7ve7vf7", "c1b1"}
            , new String[]{"cWa1Gb1Sg1Jd2Te2Hf2Dc3gc5qb6ig6va7vb7ve7vf7", "b7c7"}
            , new String[]{"CWa1Gb1Sg1Jd2Te2Hf2Dc3gc5qb6ig6va7fc7ve7vf7", "f2f3"}
            , new String[]{"cWa1Gb1Sg1Jd2Te2Dc3Af3gc5qb6ig6va7fc7ve7vf7", "c7d7"}
            , new String[]{"CWa1Gb1Sg1Jd2Te2Dc3Af3gc5qb6ig6va7bd7ve7vf7", "d2c2"}
            , new String[]{"cWa1Gb1Sg1Ac2Te2Dc3Af3gc5qb6ig6va7bd7ve7vf7", "a7b7"}
            , new String[]{"CWa1Gb1Sg1Ac2Te2Dc3Af3gc5qb6ig6fb7bd7ve7vf7", "a1a2"}
            , new String[]{"cGb1Sg1La2Ac2Te2Dc3Af3gc5qb6ig6fb7bd7ve7vf7", "b7c7"}
            , new String[]{"CGb1Sg1La2Ac2Te2Dc3Af3gc5qb6ig6bc7bd7ve7vf7", "f3g3"}
            , new String[]{"cGb1Sg1La2Ac2Te2Dc3Jg3gc5qb6ig6bc7bd7ve7vf7", "g6g5"}
            , new String[]{"CGb1Sg1La2Ac2Te2Dc3Jg3gc5cg5qb6bc7bd7ve7vf7", "c3c4"}
            , new String[]{"cGb1Sg1La2Ac2Te2Jg3Ec4gc5cg5qb6bc7bd7ve7vf7", "g5g4"}
            , new String[]{"CGb1Sg1La2Ac2Te2Ec4pg4gc5qb6bc7bd7ve7vf7", "c4b4"}
            , new String[]{"cGb1Sg1La2Ac2Te2Ib4pg4gc5qb6bc7bd7ve7vf7", "c5d5"}
            , new String[]{"CGb1Sg1La2Ac2Te2Ib4pg4wd5qb6bc7bd7ve7vf7", "b4c4"}
            , new String[]{"cGb1Sg1La2Ac2Te2Ec4pg4wd5qb6bc7bd7ve7vf7", "d5e5"}
            , new String[]{"CGb1Sg1La2Ac2Te2Ec4pg4se5qb6bc7bd7ve7vf7", "c4d4"}
            , new String[]{"cGb1Sg1La2Ac2Te2Md4pg4se5qb6bc7bd7ve7vf7", "f7g7"}
            , new String[]{"CGb1Sg1La2Ac2Te2Md4pg4se5qb6bc7bd7ve7fg7", "d4c4"}
            , new String[]{"cGb1Sg1La2Ac2Te2Ec4pg4se5qb6bc7bd7ve7fg7", "g7f7"}
            , new String[]{"CGb1Sg1La2Ac2Te2Ec4pg4se5qb6bc7bd7ve7vf7", "g1f1"}
            , new String[]{"cGb1Wf1La2Ac2Te2Ec4pg4se5qb6bc7bd7ve7vf7", "e7e6"}
            , new String[]{"CGb1Wf1La2Ac2Te2Ec4pg4se5qb6ie6bc7bd7vf7", "b1a1"}
            , new String[]{"cCa1Wf1La2Ac2Te2Ec4pg4se5qb6ie6bc7bd7vf7", "c7b7"}
            , new String[]{"CCa1Wf1La2Ac2Te2Ec4pg4se5qb6ie6fb7bd7vf7", "f1f2"}
            , new String[]{"cCa1La2Ac2Te2Lf2Ec4pg4se5qb6ie6fb7bd7vf7", "b7a7"}
            , new String[]{"CCa1La2Ac2Te2Lf2Ec4pg4se5qb6ie6va7bd7vf7", "c4c5"}
            , new String[]{"cCa1La2Ac2Te2Lf2pg4Uc5se5qb6ie6va7bd7vf7", "e5e4"}
            , new String[]{"CCa1La2Ac2Te2Lf2ne4pg4Uc5qb6ie6va7bd7vf7", "c2d2"}
            , new String[]{"cCa1La2Jd2Te2Lf2ne4pg4Uc5qb6ie6va7bd7vf7", "b6c6"}
            , new String[]{"CCa1La2Jd2Te2Lf2ne4pg4Uc5ie6va7bd7vf7", "a1b1"}
            , new String[]{"cGb1La2Jd2Te2Lf2ne4pg4Uc5ie6va7bd7vf7", "e4e3"}
            , new String[]{"CGb1La2Jd2Te2Lf2pg4Uc5ie6va7bd7vf7", "c5d5"}
            , new String[]{"cGb1La2Jd2Te2Lf2pg4Nd5ie6va7bd7vf7", "g4f4"}
            , new String[]{"CGb1La2Jd2Te2Lf2tf4Nd5ie6va7bd7vf7", "d5d6"}
            , new String[]{"cGb1La2Jd2Te2Lf2tf4Sd6va7vf7", "f7f6"}
            , new String[]{"CGb1La2Jd2Te2Lf2tf4Sd6if6va7", "d6d7"}
            , new String[]{"cGb1La2Jd2Te2Lf2tf4if6va7Kd7", null}
    };

    public static final String[] FULL_PUR_GAME_WITH_MOVES_STATES = {
            "PWa1Wb1Wc1Wd1We1Wf1Wg1va7vb7vc7vd7ve7vf7vg7"
            , "pWb1Wc1Wd1We1Wf1Wg1La2va7vb7vc7vd7ve7vf7vg7"
            , "PWb1Wc1Wd1We1Wf1Wg1La2ia6vb7vc7vd7ve7vf7vg7"
            , "pWb1Wc1We1Wf1Wg1La2Ld2ia6vb7vc7vd7ve7vf7vg7"
            , "PWb1Wc1We1Wf1Wg1La2Ld2ia6ra7vc7vd7ve7vf7vg7"
            , "pWb1Wc1We1Wf1Wg1Tb2Ld2ia6ra7vc7vd7ve7vf7vg7"
            , "PWb1Wc1We1Wf1Wg1Tb2Ld2ra5ia6vc7vd7ve7vf7vg7"
            , "pWb1Wc1We1Wg1Tb2Ld2Wd3ra5ia6vc7vd7ve7vf7vg7"
            , "PWb1Wc1We1Wg1Tb2Ld2Wd3ja4ia6vc7vd7ve7vf7vg7"
            , "pWb1Wc1Wg1La2Tb2Ld2Wd3ja4ia6vc7vd7ve7vf7vg7"
            , "PWb1Wc1Wg1La2Tb2Ld2Wd3ja4ia6ie6vc7vd7vf7vg7"
            , "pWb1Wc1Wg1La2Tb2Ld2Gc3ja4ia6ie6vc7vd7vf7vg7"
            , "PWb1Wc1Wg1La2Tb2Ld2ga3Gc3ia6ie6vc7vd7vf7vg7"
            , "pWb1Wc1Wg1La2Pc2Ld2ga3Gc3ia6ie6vc7vd7vf7vg7"
            , "PWb1Wc1Wg1La2Pc2Ld2ga3Gc3ia6ic6ie6vd7vf7vg7"
            , "pWb1Wc1La2Pc2Ld2Lg2ga3Gc3ia6ic6ie6vd7vf7vg7"
            , "PWb1Wc1La2Pc2Ld2Lg2ga3Gc3ia6ed6ie6vd7vf7vg7"
            , "pWc1Wd1La2Pc2Ld2Lg2ga3Gc3ia6ed6ie6vd7vf7vg7"
            , "PWc1Wd1La2Pc2Ld2Lg2ga3Gc3ia6ed6ie6fe7vf7vg7"
            , "pWc1Se1La2Pc2Ld2Lg2ga3Gc3ia6ed6ie6fe7vf7vg7"
            , "PWc1Se1La2Pc2Ld2Lg2ga3Gc3ia6ed6ie6vd7vf7vg7"
            , "pWc1Se1Tb2Pc2Ld2Lg2ga3Gc3ia6ed6ie6vd7vf7vg7"
            , "PWc1Se1Tb2Pc2Ld2Lg2ga3Gc3ia6ed6ef6vd7vf7vg7"
            , "pSe1Tb2Pc2Ld2Lg2ga3Gb3Gc3ia6ed6ef6vd7vf7vg7"
            , "PSe1Tb2Pc2Ld2Lg2ga3Gb3Gc3ia6ic6ed6ef6vd7vf7"
            , "pSe1Pa2Tb2Ld2Lg2ga3Gb3Gc3ia6ic6ed6ef6vd7vf7"
            , "Pga1Se1Pa2Tb2Ld2Lg2Gb3Gc3ia6ic6ed6ef6vd7vf7"
            , "pga1Se1Pa2Tb2Ld2Lg2Gc3Jb4ia6ic6ed6ef6vd7vf7"
            , "Pga1Se1Pa2Tb2Ld2Lg2Gc3Jb4vf5ia6ic6ed6ef6vd7"
            , "pga1Se1Tb2Ld2Lg2Gc3Pa4Jb4vf5ia6ic6ed6ef6vd7"
            , "Pga1Se1Tb2Ld2Lg2Gc3Pa4Jb4vf5eb6ic6ed6ef6vd7"
            , "pga1Tb2Ld2Lg2Gc3Pa4Jb4Wb5vf5eb6ic6ed6ef6vd7"
            , "Pga1Tb2Ld2Lg2Gc3Pa4Jb4Wb5vf5ia6ic6ed6ef6vd7"
            , "pga1Tb2Ld2Lg2Gc3Pa4Jb4vf5ia6ic6ed6ef6Ga7vd7"
            , "Pga1Tb2Ld2Lg2Gc3Pa4Jb4vf5ia6qb6ed6ef6Ga7vd7"
            , "pga1Tb2Ld2Lg2Pa4Jb4Cb5vf5ia6qb6ed6ef6Ga7vd7"
            , "Pga1Tb2Ld2Lg2Pa4Jb4Cb5vf5ia6qb6ic6ed6Ga7vd7"
            , "pga1Tb2Ld2Bg3Pa4Jb4Cb5vf5ia6qb6ic6ed6Ga7vd7"
            , "Pga1Tb2Ld2Bg3Pa4Jb4Cb5vd5vf5ia6qb6ic6ed6Ga7"
            , "pga1Tb2Ld2Pa4Jb4Mg4Cb5vd5vf5ia6qb6ic6ed6Ga7"
            , "Pga1Tb2Ld2cg3Pa4Jb4Mg4Cb5vd5vf5qb6ic6ed6Ga7"
            , "pga1Tb2Ld2cg3Jb4Mg4Cb5vd5vf5qb6ic6ed6Ga7Cc7"
            , "Pga1Tb2Ld2cg3Jb4Mg4Cb5vd5fg5qb6ic6ed6Ga7Cc7"
            , "pga1Tb2Ld2cg3Aa4Mg4Cb5vd5fg5qb6ic6ed6Ga7Cc7"
            , "Pga1Tb2Ld2cg3Aa4Mg4Cb5rc5fg5qb6ic6ed6Ga7Cc7"
            , "pga1Tb2Bd3cg3Aa4Mg4Cb5rc5fg5qb6ic6ed6Ga7Cc7"
            , "Pwb1Tb2Bd3cg3Aa4Mg4Cb5rc5fg5qb6ic6ed6Ga7Cc7"
            , "pwb1Tb2Bd3cg3Aa4Mg4Cb5rc5fg5qb6ic6ed6Ga7Gd7"
            , "Pwb1Tb2Bd3cg3Aa4jc4Mg4Cb5fg5qb6ic6ed6Ga7Gd7"
            , "pwb1Tb2cg3Aa4Mb4jc4Mg4Cb5fg5qb6ic6ed6Ga7Gd7"
            , "Pwb1Tb2cg3Aa4Mb4jc4Mg4Cb5vf5qb6ic6ed6Ga7Gd7"
            , "pwb1Tb2cg3Aa4Mb4jc4Cb5We5vf5qb6ic6ed6Ga7Gd7"
            , "Pwb1Tb2ca3cg3Aa4Mb4jc4Cb5We5vf5qb6ed6Ga7Gd7"
            , "pwb1ca3Db3cg3Aa4Mb4jc4Cb5We5vf5qb6ed6Ga7Gd7"
            , "Psc1ca3Db3cg3Aa4Mb4jc4Cb5We5vf5qb6ed6Ga7Gd7"
            , "psc1ca3Db3cg3Aa4Mb4jc4Cb5vf5Wg5qb6ed6Ga7Gd7"
            , "Psc1ca3Db3sf3Aa4Mb4jc4Cb5vf5Wg5qb6ed6Ga7Gd7"
            , "psc1ca3Db3sf3Mb4jc4Qa5Cb5vf5Wg5qb6ed6Ga7Gd7"
            , "Psc1ca3Db3sf3Mb4jc4Qa5Cb5dd5vf5Wg5qb6Ga7Gd7"
            , "psc1ca3sf3Mb4jc4Qa5Cb5Oc5dd5vf5Wg5qb6Ga7Gd7"
            , "Psc1ca3sf3Mb4jc4td4Qa5Cb5Oc5vf5Wg5qb6Ga7Gd7"
            , "psc1ca3sf3Mb4jc4td4Qa5Cb5Oc5vf5qb6Lg6Ga7Gd7"
            , "Psc1ca3gc3sf3Mb4td4Qa5Cb5Oc5vf5qb6Lg6Ga7Gd7"
            , "psc1ca3gc3sf3Qc4td4Qa5Cb5Oc5vf5qb6Lg6Ga7Gd7"
            , "Psc1if2ca3gc3sf3Qc4td4Qa5Cb5Oc5qb6Lg6Ga7Gd7"
            , "psc1if2ca3gc3sf3Qc4td4Qa5Cb5Oc5qb6Lg6Ga7We7"
            , "Psc1if2ca3gc3sf3ma4Qc4td4Qa5Cb5Oc5Lg6Ga7We7"
            , "psc1if2ca3gc3sf3ma4Qc4td4Qa5Cb5Oc5Hf6Ga7We7"
            , "Psc1ma2if2ca3gc3sf3Qc4td4Qa5Cb5Oc5Hf6Ga7We7"
            , "psc1ma2if2ca3gc3sf3Qc4td4Qa5Cb5Oc5Hf6Wb7We7"
            , "Psc1ma2if2ca3gc3we3Qc4td4Qa5Cb5Oc5Hf6Wb7We7"
            , "psc1ma2if2ca3gc3we3Qc4td4Cb5Oc5Xa6Hf6Wb7We7"
            , "Pwb1ma2if2ca3gc3we3Qc4td4Cb5Oc5Xa6Hf6Wb7We7"
            , "pwb1ma2if2ca3gc3we3Qc4td4Cb5Oc5Xa6Hf6Sc7We7"
            , "Pwb1sf1ma2if2ca3gc3Qc4td4Cb5Oc5Xa6Hf6Sc7We7"
            , "pwb1sf1ma2if2ca3gc3Qc4td4Cb5Xa6Hf6Oa7Sc7We7"
            , "Pwb1sf1ma2if2ca3gc3tb4Qc4Cb5Xa6Hf6Oa7Sc7We7"
            , "pwb1sf1ma2if2ca3gc3tb4Qc4Cb5Kb6Hf6Oa7Sc7We7"
            , "Pwb1sf1ma2if2ca3ub3gc3Qc4Cb5Kb6Hf6Oa7Sc7We7"
            , "pwb1sf1ma2if2ca3ub3gc3Qc4Cb5Hf6Oa7Fb7Sc7We7"
            , "Pba1wb1sf1if2ca3ub3gc3Qc4Cb5Hf6Oa7Fb7Sc7We7"
            , "pba1wb1sf1if2ca3ub3gc3Cb5Mb6Hf6Oa7Fb7Sc7We7"
            , "Pwb1bc1sf1if2ca3ub3gc3Cb5Mb6Hf6Oa7Fb7Sc7We7"
            , "pwb1bc1sf1if2ca3ub3gc3Cb5Mb6Oa7Fb7Sc7Ad7We7"
            , "Pbc1wd1sf1if2ca3ub3gc3Cb5Mb6Oa7Fb7Sc7Ad7We7"
            , "pbc1wd1sf1if2ca3ub3gc3Sa5Mb6Oa7Fb7Sc7Ad7We7"
            , "Pbc1wd1sf1if2ca3gc3ud3Sa5Mb6Oa7Fb7Sc7Ad7We7"
            , "pbc1wd1sf1if2ca3gc3ud3Sa5Qc6Oa7Fb7Sc7Ad7We7"
            , "Pbc1sf1sg1if2ca3gc3ud3Sa5Qc6Oa7Fb7Sc7Ad7We7"
            , "pbc1sf1sg1if2ca3gc3ud3Sa5Qc6Oa7Fb7Sc7We7Af7"
            , "Pbc1sf1sg1qe2ca3gc3ud3Sa5Qc6Oa7Fb7Sc7We7Af7"
            , "pbc1sf1sg1qe2ca3gc3ud3Sa5Qc6Oa7Fb7Sc7Gd7Af7"
            , "Pbc1sf1sg1qe2gb3gc3ud3Sa5Qc6Oa7Fb7Sc7Gd7Af7"
            , "pbc1sf1sg1qe2gb3gc3ud3Cb5Qc6Oa7Fb7Sc7Gd7Af7"
            , "Pbc1sf1sg1oc2qe2gb3ud3Cb5Qc6Oa7Fb7Sc7Gd7Af7"
            , "pbc1sf1sg1oc2qe2gb3ud3Cb5Mb6Oa7Fb7Sc7Gd7Af7"
            , "Pbc1sf1sg1oc2if2gb3ud3Cb5Mb6Oa7Fb7Sc7Gd7Af7"
            , "pbc1sf1sg1oc2if2gb3ud3Cb5Ea6Oa7Fb7Sc7Gd7Af7"
            , "Pbc1we1sg1oc2if2gb3ud3Cb5Ea6Oa7Fb7Sc7Gd7Af7"
            , "pbc1we1sg1oc2if2gb3ud3Cb5Ea6Oa7Fb7Sc7Gd7Ne7"
            , "Pbc1we1sg1oc2od2if2ud3Cb5Ea6Oa7Fb7Sc7Gd7Ne7"
            , "pbc1we1sg1oc2od2if2ud3Cb5Ea6Oa7Fb7Sc7Ne7Gf7"
            , "Pgb1bc1sg1oc2od2if2ud3Cb5Ea6Oa7Fb7Sc7Ne7Gf7"
            , "pgb1bc1sg1oc2od2if2ud3Cb5Ea6Oa7Fb7Cd7Ne7Gf7"
            , "Pgb1bc1sg1db2od2if2ud3Cb5Ea6Oa7Fb7Cd7Ne7Gf7"
            , "pgb1bc1sg1db2od2if2ud3Cb5Ea6Oa7Fb7Sc7Ne7Gf7"
            , "Pgb1bc1sg1db2qc2od2ud3Cb5Ea6Oa7Fb7Sc7Ne7Gf7"
            , "pgb1bc1sg1db2qc2od2ud3Cb5Ea6Oa7Fb7Sc7Gf7Ng7"
            , "Pba1gb1sg1db2qc2od2ud3Cb5Ea6Oa7Fb7Sc7Gf7Ng7"
            , "pba1gb1sg1db2qc2od2ud3Cb5Ea6Oa7Sc7Fd7Gf7Ng7"
            , "Pba1gb1wf1db2qc2od2ud3Cb5Ea6Oa7Sc7Fd7Gf7Ng7"
            , "pba1gb1wf1db2qc2od2ud3Cb5Ea6Oa7Sc7Fd7Ne7Gf7"
            , "Pba1wc1wf1db2qc2od2ud3Cb5Ea6Oa7Sc7Fd7Ne7Gf7"
            , "pba1wc1wf1db2qc2od2ud3Cb5Ea6Oa7Wb7Fd7Ne7Gf7"
            , "Pba1tb1wc1wf1qc2od2ud3Cb5Ea6Oa7Wb7Fd7Ne7Gf7"
            , "pba1tb1wc1wf1qc2od2ud3Cb5Mb6Oa7Wb7Fd7Ne7Gf7"
            , "Pba1tb1wc1wf1mb2od2ud3Cb5Mb6Oa7Wb7Fd7Ne7Gf7"
            , "pba1tb1wc1wf1mb2od2ud3Cb5Mb6Oa7Wb7Fd7Gf7Ng7"
            , "Pba1tb1wc1wf1da2mb2ud3Cb5Mb6Oa7Wb7Fd7Gf7Ng7"
            , "pba1tb1wc1wf1da2mb2ud3Cb5Mb6Oa7Wb7Cc7Fd7Ng7"
            , "Pba1tb1wc1sg1da2mb2ud3Cb5Mb6Oa7Wb7Cc7Fd7Ng7"
            , "pba1tb1wc1sg1da2mb2ud3Sa5Mb6Oa7Wb7Cc7Fd7Ng7"
            , "Pba1wc1td1sg1da2mb2ud3Sa5Mb6Oa7Wb7Cc7Fd7Ng7"
            , "pba1wc1td1sg1da2mb2ud3Sa5Mb6Oa7Wb7Fd7Ce7Ng7"
            , "Pba1wc1td1sg1da2mb2ne3Sa5Mb6Oa7Wb7Fd7Ce7Ng7"
            , "pba1wc1td1sg1da2mb2ne3Sa5Mb6Oa7Sc7Fd7Ce7Ng7"
            , "Pba1wc1td1sg1mb2dc2ne3Sa5Mb6Oa7Sc7Fd7Ce7Ng7"
            , "pba1wc1td1sg1mb2dc2ne3Sa5Qc6Oa7Sc7Fd7Ce7Ng7"
            , "Pba1wc1td1wf1mb2dc2ne3Sa5Qc6Oa7Sc7Fd7Ce7Ng7"
            , "pba1wc1td1wf1mb2dc2ne3Sa5Id6Oa7Sc7Fd7Ce7Ng7"
            , "Pba1wc1td1wf1mb2od2ne3Sa5Id6Oa7Sc7Fd7Ce7Ng7"
            , "pba1wc1td1wf1mb2od2ne3Sa5Id6Oa7Sc7Fd7Ce7Uf7"
            , "Pba1wc1wf1pg1mb2od2ne3Sa5Id6Oa7Sc7Fd7Ce7Uf7"
            , "pba1wc1wf1pg1mb2od2ne3Sa5Id6Oa7Fb7Sc7Ce7Uf7"
            , "Pba1wc1wf1pg1mb2od2ud3Sa5Id6Oa7Fb7Sc7Ce7Uf7"
            , "pba1wc1wf1pg1mb2od2ud3Sa5Oa7Fb7Sc7Vd7Ce7Uf7"
            , "Pba1wc1rd1wf1pg1mb2ud3Sa5Oa7Fb7Sc7Vd7Ce7Uf7"
            , "pba1wc1rd1wf1pg1mb2ud3Ka6Oa7Fb7Sc7Vd7Ce7Uf7"
            , "Pba1wc1ve1wf1pg1mb2ud3Ka6Oa7Fb7Sc7Vd7Ce7Uf7"
            , "pba1wc1ve1wf1pg1mb2ud3Ka6Oa7Fb7Sc7Vd7Ce7Ng7"
            , "Pba1wc1ve1wf1pg1mb2jc3Ka6Oa7Fb7Sc7Vd7Ce7Ng7"
            , "pba1wc1ve1wf1pg1mb2jc3Ka6Oa7Fb7Sc7Ce7Vf7Ng7"
            , "Pwc1rd1ve1wf1pg1mb2jc3Ka6Oa7Fb7Sc7Ce7Vf7Ng7"
            , "pwc1rd1ve1wf1pg1mb2jc3Ka6Oa7Fb7Sc7Sd7Vf7Ng7"
            , "Pwc1rd1ve1wf1pg1mb2ud3Ka6Oa7Fb7Sc7Sd7Vf7Ng7"
            , "pwc1rd1ve1wf1pg1mb2ud3Ka6Oa7Fb7Sc7Sd7Re7Ng7"
            , "Pwc1rd1ve1wf1pg1mb2ne3Ka6Oa7Fb7Sc7Sd7Re7Ng7"
            , "pwc1rd1ve1wf1pg1mb2ne3Ka6Oa7Fb7Sc7Sd7Re7Uf7"
            , "Pwc1rd1ve1wf1pg1mb2af3Ka6Oa7Fb7Sc7Sd7Re7Uf7"
            , "pwc1rd1ve1wf1pg1mb2af3Ka6Oa7Fb7Sc7Sd7Uf7Rg7"
            , "Pgb1rd1ve1wf1pg1mb2af3Ka6Oa7Fb7Sc7Sd7Uf7Rg7"
            , "pgb1rd1ve1wf1pg1mb2af3Ka6Oa7Fb7Sd7Se7Uf7Rg7"
            , "Pgb1rd1ve1wf1pg1mb2jg3Ka6Oa7Fb7Sd7Se7Uf7Rg7"
            , "pgb1rd1ve1wf1pg1mb2jg3Ka6Oa7Fb7Sc7Sd7Uf7Rg7"
            , "Pca1rd1ve1wf1pg1mb2jg3Ka6Oa7Fb7Sc7Sd7Uf7Rg7"
            , "pca1rd1ve1wf1pg1mb2jg3Ka6Oa7Fb7Sc7Ce7Uf7Rg7"
            , "Pca1rd1ve1wf1pg1mb2gg2Ka6Oa7Fb7Sc7Ce7Uf7Rg7"
            , "pca1rd1ve1wf1pg1mb2gg2Ka6Oa7Sc7Fd7Ce7Uf7Rg7"
            , "Pgb1rd1ve1wf1pg1mb2gg2Ka6Oa7Sc7Fd7Ce7Uf7Rg7"
            , "pgb1rd1ve1wf1pg1mb2gg2Ka6Oa7Wb7Fd7Ce7Uf7Rg7"
            , "Pva1gb1rd1wf1pg1mb2gg2Ka6Oa7Wb7Fd7Ce7Uf7Rg7"
            , "pva1gb1rd1wf1pg1mb2gg2Ka6Oa7Wb7Vc7Ce7Uf7Rg7"
            , "Pgb1rd1ve1wf1pg1mb2gg2Ka6Oa7Wb7Vc7Ce7Uf7Rg7"
            , "pgb1rd1ve1wf1pg1mb2gg2Ka6Oa7Wb7Vc7Sd7Uf7Rg7"
            , "Pva1gb1rd1wf1pg1mb2gg2Ka6Oa7Wb7Vc7Sd7Uf7Rg7"
            , "pva1gb1rd1wf1pg1mb2gg2Ka6Oa7Wb7Vc7Ce7Uf7Rg7"
            , "Pgb1vc1rd1wf1pg1mb2gg2Ka6Oa7Wb7Vc7Ce7Uf7Rg7"
            , "pgb1vc1rd1wf1pg1mb2gg2Ka6Oa7Vc7Wd7Ce7Uf7Rg7"
            , "Pgb1vc1rd1wf1pg1mb2cf2Ka6Oa7Vc7Wd7Ce7Uf7Rg7"
            , "pgb1vc1rd1wf1pg1mb2cf2Ka6Oa7Wb7Vc7Ce7Uf7Rg7"
            , "Pva1gb1rd1wf1pg1mb2cf2Ka6Oa7Wb7Vc7Ce7Uf7Rg7"
            , "pva1gb1rd1wf1pg1mb2cf2Ka6Oa7Wb7Vc7Sd7Uf7Rg7"
            , "Pva1gb1bc1wf1pg1mb2cf2Ka6Oa7Wb7Vc7Sd7Uf7Rg7"
            , "pva1gb1bc1wf1pg1mb2cf2Db6Oa7Wb7Vc7Sd7Uf7Rg7"
            , "Pva1gb1bc1pe1wf1mb2cf2Db6Oa7Wb7Vc7Sd7Uf7Rg7"
            , "pva1gb1bc1pe1wf1mb2cf2Db6Oa7Wb7Vc7Sd7Je7Rg7"
            , "Pva1gb1bc1pe1sg1mb2cf2Db6Oa7Wb7Vc7Sd7Je7Rg7"
            , "pva1gb1bc1pe1sg1mb2cf2Oc6Oa7Wb7Vc7Sd7Je7Rg7"
            , "Pva1gb1bc1pe1sg1mb2gg2Oc6Oa7Wb7Vc7Sd7Je7Rg7"
            , "pva1gb1bc1pe1sg1mb2gg2Oc6Oa7Wb7Vc7Sd7Uf7Rg7"
            , "Pva1gb1bc1pe1sg1ea2gg2Oc6Oa7Wb7Vc7Sd7Uf7Rg7"
            , "pva1gb1bc1pe1sg1ea2gg2Oc6Oa7Wb7Vc7Sd7Je7Rg7"
            , "Pva1gb1rd1pe1sg1ea2gg2Oc6Oa7Wb7Vc7Sd7Je7Rg7"
            , "pva1gb1rd1pe1sg1ea2gg2Oc6Oa7Wb7Vc7Sd7Je7Bf7"
            , "Pva1gb1pe1rf1sg1ea2gg2Oc6Oa7Wb7Vc7Sd7Je7Bf7"
            , "pva1gb1pe1rf1sg1ea2gg2Db6Oa7Wb7Vc7Sd7Je7Bf7"
            , "Pva1gb1pe1rf1sg1ea2cf2Db6Oa7Wb7Vc7Sd7Je7Bf7"
            , "pva1gb1pe1rf1sg1ea2cf2Ka6Oa7Wb7Vc7Sd7Je7Bf7"
            , "Pva1gb1pe1rf1sg1ea2gg2Ka6Oa7Wb7Vc7Sd7Je7Bf7"
            , "pva1gb1pe1rf1sg1ea2gg2Ka6Oa7Wb7Vc7Sd7Je7Rg7"
            , "Pva1gb1td1rf1sg1ea2gg2Ka6Oa7Wb7Vc7Sd7Je7Rg7"
            , "pva1gb1td1rf1sg1ea2gg2Ka6Oa7Wb7Vc7Sd7Uf7Rg7"
            , "Pva1gb1sc1td1rf1ea2gg2Ka6Oa7Wb7Vc7Sd7Uf7Rg7"
            , "pva1gb1sc1td1rf1ea2gg2Ka6Oa7Wb7Vc7Ce7Uf7Rg7"
            , "Pva1gb1sc1rf1pg1ea2gg2Ka6Oa7Wb7Vc7Ce7Uf7Rg7"
            , "pva1gb1sc1rf1pg1ea2gg2Ka6Oa7Wb7Vc7Ud7Ce7Rg7"
            , "Pva1gb1sc1rf1pg1ea2cf2Ka6Oa7Wb7Vc7Ud7Ce7Rg7"
            , "pva1gb1sc1rf1pg1ea2cf2Ka6Oa7Wb7Vc7Ud7Ce7Bf7"
            , "Pva1gb1sc1rf1pg1ea2gg2Ka6Oa7Wb7Vc7Ud7Ce7Bf7"
            , "pva1gb1sc1rf1pg1ea2gg2Ka6Oa7Wb7Vc7Ud7Bf7Cg7"
            , "Pva1gb1cd1rf1pg1ea2gg2Ka6Oa7Wb7Vc7Ud7Bf7Cg7"
            , "pva1gb1cd1rf1pg1ea2gg2Ka6Oa7Wb7Vc7Ud7Ce7Bf7"
            , "Pva1gb1cd1pe1rf1ea2gg2Ka6Oa7Wb7Vc7Ud7Ce7Bf7"
            , "pva1gb1cd1pe1rf1ea2gg2Ka6Oa7Wb7Vc7Ud7Bf7Cg7"
            , "Pva1gb1cd1pe1rf1mb2gg2Ka6Oa7Wb7Vc7Ud7Bf7Cg7"
            , "pva1gb1cd1pe1rf1mb2gg2Ka6Oa7Wb7Vc7Ud7Ce7Bf7"
            , "Pgb1vc1cd1pe1rf1mb2gg2Ka6Oa7Wb7Vc7Ud7Ce7Bf7"
            , "pgb1vc1cd1pe1rf1mb2gg2Db6Oa7Wb7Vc7Ud7Ce7Bf7"
            , "Pgb1vc1cd1rf1pg1mb2gg2Db6Oa7Wb7Vc7Ud7Ce7Bf7"
            , "pgb1vc1cd1rf1pg1mb2gg2Ka6Oa7Wb7Vc7Ud7Ce7Bf7"
            , "Pgb1vc1cd1rf1pg1ea2gg2Ka6Oa7Wb7Vc7Ud7Ce7Bf7"
            , "pgb1vc1cd1rf1pg1ea2gg2Ka6Oa7Wb7Vc7Ud7Ce7Rg7"
            , "Pgb1vc1cd1pe1rf1ea2gg2Ka6Oa7Wb7Vc7Ud7Ce7Rg7"
            , "pgb1vc1cd1pe1rf1ea2gg2Ka6Oa7Wb7Vc7Ud7Ce7Bf7"
            , "Pda1gb1vc1cd1pe1rf1gg2Ka6Oa7Wb7Vc7Ud7Ce7Bf7"
            , "pda1gb1vc1cd1pe1rf1gg2Ka6Oa7Wb7Vc7Ud7Ce7Rg7"
    };

    public static final String[][] FULL_GAME_WITH_MOVES_MOVES = {
            new String[]{"a1a2", "b1b2", "c1c2", "d1d2", "e1e2", "f1f2", "g1g2"}
            , new String[]{"a7a6", "b7b6", "c7c6", "d7d6", "e7e6", "f7f6", "g7g6"}
            , new String[]{"a2a3", "a2b2", "b1b2", "b1a1a3", "b1a1", "c1c2", "c1a1a3", "c1a1", "d1d2", "e1e2", "f1f2", "g1g2"}
            , new String[]{"a6a5", "a6b6", "b7b6", "b7a7a5", "b7a7", "c7c6", "c7a7a5", "c7a7", "d7d6", "e7e6", "f7f6", "g7g6"}
            , new String[]{"a2a3", "a2b2", "b1b2", "b1a1a3", "b1a1", "b1d1d3", "b1d1", "c1c2e2", "c1c2", "c1a1a3", "c1a1", "c1d1d3", "c1d1", "d2d3", "d2c2", "d2e2", "e1e2c2", "e1e2", "e1d1d3", "e1d1", "f1f2", "f1d1d3", "f1d1", "g1g2"}
            , new String[]{"a6a5", "a6b6", "a7a5", "a7b7", "c7c6", "c7b7", "d7d6", "d7b7", "e7e6", "f7f6", "g7g6"}
            , new String[]{"b1b3", "b1a1", "b1d1d3", "b1d1", "b2b3", "b2a2", "b2c2e2", "b2c2", "c1c2a2", "c1c2e2", "c1c2", "c1a1", "c1d1d3", "c1d1", "d2d3", "d2c2a2", "d2c2", "d2e2", "e1e2c2a2", "e1e2c2", "e1e2", "e1d1d3", "e1d1", "f1f2", "f1d1d3", "f1d1", "g1g2"}
            , new String[]{"a5a4", "a5b5", "a6a4", "a6b6", "c7c6", "c7b7", "d7d6", "d7b7", "e7e6", "f7f6", "g7g6"}
            , new String[]{"b1b3", "b1a1", "b1d1f1", "b1d1", "b2b3", "b2a2", "b2c2e2", "b2c2", "c1c2a2", "c1c2e2", "c1c2", "c1a1", "c1d1f1", "c1d1", "d2d4", "d2c2a2", "d2c2", "d2e2", "d3d4", "d3c3", "d3e3", "e1e2c2a2", "e1e2c2", "e1e2", "e1d1", "e1f1", "g1g2", "g1f1d1", "g1f1"}
            , new String[]{"a4a3a1", "a4a3", "a4b4", "a6a5a3a1", "a6a5a3", "a6a5", "a6b6", "c7c6", "c7b7", "d7d6", "d7b7", "e7e6", "f7f6", "g7g6"}
            , new String[]{"a2a3a5a7", "a2a3a5", "a2a3", "a2c2e2", "a2c2", "b1b3", "b1a1a3a5a7", "b1a1a3a5", "b1a1a3", "b1a1", "b1d1", "b2b3", "b2c2e2", "b2c2", "c1c2e2", "c1c2", "c1a1a3a5a7", "c1a1a3a5", "c1a1a3", "c1a1", "c1d1", "d2d4", "d2c2", "d2e2", "d3d4", "d3c3", "d3e3", "g1g2", "g1f1"}
            , new String[]{"a4a3a1", "a4a3", "a4b4", "a6a5a3a1", "a6a5a3", "a6a5", "a6b6", "c7c6", "c7b7", "c7e7e5", "c7e7", "d7d6f6", "d7d6", "d7b7", "d7e7e5", "d7e7", "e6e5", "e6d6", "e6f6", "f7f6d6", "f7f6", "f7e7e5", "f7e7", "g7g6", "g7e7e5", "g7e7"}
            , new String[]{"a2a4", "a2c2c4", "a2c2e2", "a2c2", "b1b3d3", "b1b3", "b1a1", "b1d1d3b3", "b1d1d3", "b1d1", "b2b3d3", "b2b3", "b2c2c4", "b2c2e2", "b2c2", "c1c2c4", "c1c2e2", "c1c2", "c1a1", "c1d1d3b3", "c1d1d3", "c1d1", "c3c4", "c3b3", "c3d3", "d2d3b3", "d2d3", "d2c2c4", "d2c2", "d2e2", "g1g2", "g1f1"}
            , new String[]{"a3a1", "a3b3d3d1", "a3b3d3", "a3b3", "a6a5", "a6b6", "c7c6", "c7b7", "c7e7e5", "c7e7", "d7d6f6", "d7d6", "d7b7", "d7e7e5", "d7e7", "e6e5", "e6d6", "e6f6", "f7f6d6", "f7f6", "f7e7e5", "f7e7", "g7g6", "g7e7e5", "g7e7"}
            , new String[]{"a2a4", "a2b2", "b1b2", "b1a1", "b1d1d3b3", "b1d1d3", "b1d1", "c1a1", "c1d1d3b3", "c1d1d3", "c1d1", "c2c4", "c2b2", "c2e2", "c3c4", "c3b3", "c3d3", "d2d3b3", "d2d3", "d2b2", "d2e2", "g1g2", "g1f1"}
            , new String[]{"a3a1", "a3b3d3d1", "a3b3d3", "a3b3", "a6a5", "a6b6d6f6", "a6b6d6", "a6b6", "c6c5", "c6b6", "c6d6f6", "c6d6", "d7d6b6", "d7d6f6", "d7d6", "d7c7c5", "d7c7", "d7e7e5", "d7e7", "e6e5", "e6d6b6", "e6d6", "e6f6", "f7f6d6b6", "f7f6d6", "f7f6", "f7e7e5", "f7e7c7c5", "f7e7c7", "f7e7", "g7g6", "g7e7e5", "g7e7c7c5", "g7e7c7", "g7e7"}
            , new String[]{"a2a4", "a2b2", "b1b2", "b1a1", "b1d1d3b3", "b1d1d3", "b1d1", "c1a1", "c1d1d3b3", "c1d1d3", "c1d1", "c2c4", "c2b2", "c2e2", "c3c4", "c3b3", "c3d3", "d2d3b3", "d2d3", "d2b2", "d2e2", "g2g3", "g2f2"}
            , new String[]{"a3a1", "a3b3d3", "a3b3", "a6a5", "a6b6", "d6d5", "d6c6", "d6f6", "d7d5", "d7c7", "d7e7e5", "d7e7", "e6e5", "e6c6", "e6f6", "f7f6", "f7e7e5", "f7e7c7", "f7e7", "g7g6", "g7e7e5", "g7e7c7", "g7e7"}
            , new String[]{"a2a4", "a2b2", "c1b1", "c1e1", "c2c4", "c2b2", "c2e2", "c3c4", "c3b3", "c3d3", "d1d3b3", "d1d3", "d1b1", "d1e1", "d2d3b3", "d2d3", "d2b2", "d2e2", "g2g3", "g2f2"}
            , new String[]{"a3a1", "a3b3d3d1b1", "a3b3d3d1f1", "a3b3d3d1", "a3b3d3", "a3b3", "a6a5", "a6b6", "d6d5", "d6c6", "d6f6", "e6e5", "e6c6", "e6f6", "e7e5", "e7d7d5", "e7d7", "f7f6", "f7d7d5", "f7d7", "g7g6"}
            , new String[]{"a2a4", "a2b2", "c1b1", "c1d1d3b3", "c1d1d3", "c1d1f1", "c1d1", "c2c4", "c2b2", "c2e2", "c3c4", "c3b3", "c3d3", "d2d3b3", "d2d3", "d2b2", "d2e2", "e1e2", "e1d1d3b3", "e1d1d3", "e1d1b1", "e1d1", "e1f1", "g2g3", "g2f2"}
            , new String[]{"a3a2", "a3b3b1d1f1", "a3b3b1d1", "a3b3b1", "a3b3d3d1b1", "a3b3d3d1f1", "a3b3d3d1", "a3b3d3", "a3b3", "a6a5", "a6b6", "d6d5", "d6c6", "d6f6", "d7d5", "d7c7", "d7e7e5", "d7e7", "e6e5", "e6c6", "e6f6", "f7f6", "f7e7e5", "f7e7c7", "f7e7", "g7g6", "g7e7e5", "g7e7c7", "g7e7"}
            , new String[]{"b2b3d3", "b2b3", "b2a2a4", "b2a2", "c1b1b3d3", "c1b1b3", "c1b1", "c1d1d3b3", "c1d1d3", "c1d1f1", "c1d1", "c2c4", "c2a2a4", "c2a2", "c2e2", "c3c4", "c3b3", "c3d3", "d2d3b3", "d2d3", "d2e2", "e1e2", "e1d1d3b3", "e1d1d3", "e1d1b1b3d3", "e1d1b1b3", "e1d1b1", "e1d1", "e1f1", "g2g3", "g2f2"}
            , new String[]{"a3a2", "a6a5", "a6b6", "d6d5", "d6c6", "d6e6g6", "d6e6", "d7d5", "d7c7", "d7e7", "f6f5", "f6e6c6", "f6e6", "f6g6", "f7f5", "f7e7c7", "f7e7", "g7g6e6c6", "g7g6e6", "g7g6", "g7e7c7", "g7e7"}
            , new String[]{"b2b4", "b2a2a4", "b2a2", "b3b4", "b3d3", "c2c4", "c2a2a4", "c2a2", "c2e2", "c3c4", "c3d3", "d2d3", "d2e2", "e1e2", "e1d1d3", "e1d1", "e1f1", "g2g3", "g2f2"}
            , new String[]{"a3a1", "a6a5", "a6b6", "c6c5", "c6b6", "c6e6g6", "c6e6", "d6d5", "d6b6", "d6e6g6", "d6e6", "d7d5", "d7c7c5", "d7c7", "d7e7g7", "d7e7", "f6f5", "f6e6", "f6g6", "f7f5", "f7e7c7c5", "f7e7c7", "f7e7", "f7g7"}
            , new String[]{"a2a3", "a2c2c4", "a2c2e2", "a2c2", "b2b4", "b2c2c4", "b2c2e2", "b2c2", "b3b4", "b3a3", "b3d3", "c3c4", "c3a3", "c3d3", "d2d3", "d2c2c4", "d2c2", "d2e2", "e1e2c2c4", "e1e2c2", "e1e2", "e1d1d3", "e1d1", "e1f1", "g2g3", "g2f2"}
            , new String[]{"a1b1", "a6a5", "a6b6", "c6c5", "c6b6", "c6e6g6", "c6e6", "d6d5", "d6b6", "d6e6g6", "d6e6", "d7d5", "d7c7c5", "d7c7", "d7e7g7", "d7e7", "f6f5", "f6e6", "f6g6", "f7f5", "f7e7c7c5", "f7e7c7", "f7e7", "f7g7"}
            , new String[]{"a2a3", "a2c2c4a4", "a2c2c4", "a2c2e2", "a2c2", "b2b3b5", "b2b3d3", "b2b3", "b2c2c4a4", "b2c2c4", "b2c2e2", "b2c2", "b4b5", "b4a4", "b4c4", "c3c4a4", "c3c4", "c3b3b5", "c3b3", "c3d3", "d2d3b3b5", "d2d3b3", "d2d3", "d2c2c4a4", "d2c2c4", "d2c2", "d2e2", "e1e2c2c4a4", "e1e2c2c4", "e1e2c2", "e1e2", "e1d1d3b3b5", "e1d1d3b3", "e1d1d3", "e1d1", "e1f1", "g2g3", "g2f2"}
            , new String[]{"a1b1", "a6a5a3", "a6a5", "a6b6", "c6c5", "c6b6", "c6e6g6", "c6e6", "d6d5", "d6b6", "d6e6g6", "d6e6", "d7d5", "d7c7c5", "d7c7", "d7e7", "f5f4", "f5e5", "f5g5", "f6f4", "f6e6", "f6g6"}
            , new String[]{"a4a5", "a4c4", "b2b3b5b7", "b2b3b5", "b2b3d3", "b2b3", "b2a2", "b2c2c4", "b2c2e2", "b2c2", "b4b5b7", "b4b5", "b4c4", "c3c4", "c3b3b5b7", "c3b3b5", "c3b3", "c3d3", "d2d3b3b5b7", "d2d3b3b5", "d2d3b3", "d2d3", "d2c2c4", "d2c2a2", "d2c2", "d2e2", "e1e2c2c4", "e1e2c2a2", "e1e2c2", "e1e2", "e1d1d3b3b5b7", "e1d1d3b3b5", "e1d1d3b3", "e1d1d3", "e1d1", "e1f1", "g2g3", "g2f2"}
            , new String[]{"a1b1", "b6a6", "c6c5a5a3", "c6c5a5", "c6c5", "c6a6", "c6e6g6", "c6e6", "d6d5", "d6e6g6", "d6e6", "d7d5", "d7c7c5a5a3", "d7c7c5a5", "d7c7c5", "d7c7", "d7e7", "f5f4", "f5e5", "f5g5", "f6f4", "f6e6", "f6g6"}
            , new String[]{"a4a5a7", "a4a5c5c7e7", "a4a5c5c7", "a4a5c5", "a4a5", "a4c4", "b2b3d3", "b2b3", "b2a2", "b2c2c4", "b2c2e2", "b2c2", "b4b6", "b4c4", "b5b6", "b5a5a7", "b5a5", "b5c5c7e7", "b5c5c7", "b5c5", "c3c4", "c3b3", "c3d3", "d2d3b3", "d2d3", "d2c2c4", "d2c2a2", "d2c2", "d2e2", "g2g3", "g2f2"}
            , new String[]{"a1b1", "a6a5a3", "a6a5", "a6b6", "c6c5", "c6b6", "c6e6g6", "c6e6", "d6d5", "d6b6", "d6e6g6", "d6e6", "d7d5", "d7c7c5", "d7c7", "d7e7", "f5f4", "f5e5", "f5g5", "f6f4", "f6e6", "f6g6"}
            , new String[]{"a4a5", "a4c4", "a7b7", "b2b3b5b7", "b2b3b5", "b2b3d3", "b2b3", "b2a2", "b2c2c4", "b2c2e2", "b2c2", "b4b5b7", "b4b5", "b4c4", "c3c4", "c3b3b5b7", "c3b3b5", "c3b3", "c3d3", "d2d3b3b5b7", "d2d3b3b5", "d2d3b3", "d2d3", "d2c2c4", "d2c2a2", "d2c2", "d2e2", "g2g3", "g2f2"}
            , new String[]{"a1b1", "a6a5a3", "a6a5c5", "a6a5", "a6c6e6g6", "a6c6e6", "a6c6", "b6c6e6g6", "b6c6e6", "b6c6", "d6d5", "d6c6", "d6e6g6", "d6e6", "d7d5", "d7c7", "d7e7", "f5f4", "f5e5", "f5g5", "f6f4", "f6e6c6", "f6e6", "f6g6"}
            , new String[]{"a4a5c5c7e7", "a4a5c5c7", "a4a5c5", "a4a5", "a4c4", "a7b7", "b2b3", "b2a2", "b2c2e2", "b2c2", "b4c4", "b5b7", "b5a5", "b5c5c7e7", "b5c5c7", "b5c5", "d2d3", "d2c2a2", "d2c2", "d2e2", "g2g3", "g2f2"}
            , new String[]{"a1b1", "a6a5a3", "a6a5c5", "a6a5", "c6c5a5a3", "c6c5a5", "c6c5", "c6e6", "d6d5", "d6e6", "d7d5", "d7c7c5a5a3", "d7c7c5a5", "d7c7c5", "d7c7", "d7e7", "f5f4", "f5e5", "f5g5"}
            , new String[]{"a4a5c5c7", "a4a5c5e5g5", "a4a5c5e5", "a4a5c5", "a4a5", "a4c4", "a7b7", "b2b3", "b2a2", "b2c2e2", "b2c2", "b4c4", "b5b7", "b5a5", "b5c5c7", "b5c5e5g5", "b5c5e5", "b5c5", "d2d3", "d2c2a2", "d2c2", "d2e2", "g3g4", "g3f3"}
            , new String[]{"a1b1", "a6a5a3", "a6a5c5e5g5g3", "a6a5c5e5g5", "a6a5c5e5", "a6a5c5", "a6a5", "c6c5a5a3", "c6c5a5", "c6c5e5g5g3", "c6c5e5g5", "c6c5e5", "c6c5", "c6e6", "d5d4", "d5c5a5a3", "d5c5a5", "d5c5", "d5e5g5g3", "d5e5g5", "d5e5", "d6d4", "d6e6", "f5f4", "f5e5c5a5a3", "f5e5c5a5", "f5e5c5", "f5e5", "f5g5g3", "f5g5"}
            , new String[]{"a4a5c5c7", "a4a5c5e5g5", "a4a5c5e5", "a4a5c5", "a4a5", "a4c4", "a7b7", "b2b3", "b2a2", "b2c2e2", "b2c2", "b4c4", "b5b7", "b5a5", "b5c5c7", "b5c5e5g5", "b5c5e5", "b5c5", "d2d3", "d2c2a2", "d2c2", "d2e2", "g4g5e5c5c7", "g4g5e5c5a5", "g4g5e5c5", "g4g5e5", "g4g5", "g4f4f6", "g4f4"}
            , new String[]{"a1b1", "b6a6", "c6c5a5", "c6c5e5g5", "c6c5e5", "c6c5", "c6a6", "c6e6", "d5d4", "d5c5a5", "d5c5", "d5e5g5", "d5e5", "d6d4", "d6e6", "f5f4", "f5e5c5a5", "f5e5c5", "f5e5", "f5g5", "g3g2", "g3f3"}
            , new String[]{"a7b7d7", "a7b7", "b2b3", "b2a2", "b2c2e2", "b2c2", "b4a4", "b4c4", "b5b7d7", "b5b7", "b5a5", "b5c5e5", "b5c5", "c7b7", "c7d7", "d2d3", "d2c2a2", "d2c2", "d2e2", "g4g6", "g4f4"}
            , new String[]{"a1b1", "b6b4", "b6a6", "c6c5a5a3", "c6c5a5", "c6c5e5", "c6c5", "c6a6", "c6e6", "d5d4", "d5c5a5a3", "d5c5a5", "d5c5", "d5e5", "d6d4", "d6e6", "g3g2", "g3f3", "g5f5"}
            , new String[]{"a4a5", "a4b4", "a7b7d7", "a7b7", "b2b3", "b2a2", "b2c2e2", "b2c2", "b5b7d7", "b5b7", "b5a5", "b5d5d7b7", "b5d5d7", "b5d5", "c7b7", "c7d7", "d2d3", "d2c2a2", "d2c2", "d2e2", "g4g6", "g4f4"}
            , new String[]{"a1b1", "b6b4", "b6a6", "c5c4", "c5a5a3", "c5a5", "c5d5", "c6c4", "c6a6", "c6e6", "d6d5", "d6e6", "g3g2", "g3f3", "g5f5"}
            , new String[]{"a4a5", "a4b4", "a7b7d7", "a7b7", "b2b3", "b2a2", "b2c2", "b5b7d7", "b5b7", "b5a5", "b5d5d7b7", "b5d5d7", "b5d5", "c7b7", "c7d7", "d3d4", "d3c3", "d3e3", "g4g6", "g4f4"}
            , new String[]{"b1a1", "b1c1", "b6b4", "b6a6", "c5c4", "c5a5a3", "c5a5", "c5d5", "c6c4", "c6a6", "c6e6", "d6d5", "d6e6", "g3g2", "g3f3", "g5f5"}
            , new String[]{"a4a5c5c7e7", "a4a5c5c7", "a4a5c5", "a4a5", "a4b4d4", "a4b4", "a7b7", "b2b3", "b2a2", "b2c2", "b5b7", "b5a5", "b5c5c7e7", "b5c5c7", "b5c5", "d3d4b4", "d3d4", "d3c3c5c7e7", "d3c3c5c7", "d3c3c5a5", "d3c3c5", "d3c3", "d3e3", "d7c7", "d7e7", "g4g6", "g4f4"}
            , new String[]{"b1a1", "b1c1", "b6a6", "c4c3", "c4d4", "c6c5c3", "c6c5a5a3", "c6c5a5", "c6c5", "c6a6", "c6e6", "d6d5", "d6e6", "g3g2", "g3f3", "g5f5"}
            , new String[]{"a4a5c5c7e7", "a4a5c5c7", "a4a5c5", "a4a5", "a7b7", "b2b3", "b2a2", "b2c2", "b4d4", "b5b7", "b5a5", "b5c5c7e7", "b5c5c7", "b5c5", "d7c7", "d7e7", "g4g5e5", "g4g5", "g4f4f6", "g4f4"}
            , new String[]{"b1a1", "b1c1", "b6a6", "c4c3", "c4d4", "c6c5c3", "c6c5a5a3", "c6c5a5", "c6c5", "c6a6", "c6e6e4", "c6e6", "d6d5", "d6e6e4", "d6e6", "f5f4", "f5d5", "f5g5", "g3g2", "g3f3"}
            , new String[]{"a4a5c5", "a4a5", "a7b7", "b2b3", "b2a2", "b2c2", "b4d4", "b5b7", "b5a5", "b5c5", "d7c7", "d7e7", "e5e6c6a6", "e5e6c6", "e5e6", "e5d5", "e5g5"}
            , new String[]{"a3a2", "a3c3", "b1a1", "b1c1", "b6a6", "b6c6e6e4", "b6c6e6", "b6c6", "c4c3", "c4d4", "d6d5", "d6c6a6", "d6c6", "d6e6e4", "d6e6", "f5f4", "f5d5", "f5g5", "g3g2", "g3f3"}
            , new String[]{"a4a5c5", "a4a5", "a7b7", "b3c3c5a5", "b3c3c5", "b3c3", "b4d4", "b5b7", "b5a5", "b5c5", "d7c7", "d7e7", "e5e6c6a6", "e5e6c6", "e5e6", "e5d5", "e5g5"}
            , new String[]{"a3a2", "a3c3", "b6a6", "b6c6e6", "b6c6", "c1b1", "c1d1", "c4c3", "c4d4", "d6d5", "d6c6a6", "d6c6", "d6e6", "f5f4", "f5e5", "g3g2", "g3f3"}
            , new String[]{"a4a5c5", "a4a5", "a7b7", "b3c3c5a5", "b3c3c5", "b3c3", "b4d4", "b5b7", "b5a5", "b5c5", "d7c7", "d7e7", "g5g6", "g5e5"}
            , new String[]{"a3a2", "a3c3", "b6a6a4a2", "b6a6a4", "b6a6", "b6c6e6", "b6c6", "c1b1", "c1d1", "c4c3", "c4a4a2", "c4a4", "c4d4", "d6d5", "d6c6a6a4a2", "d6c6a6a4", "d6c6a6", "d6c6", "d6e6", "f3f2", "f3e3", "f3g3", "f5f4f2", "f5f4", "f5e5"}
            , new String[]{"a5a6c6", "a5a6", "a5c5e5", "a5c5", "a7b7", "b3c3c5e5", "b3c3c5", "b3c3", "b4a4a6c6", "b4a4a6", "b4a4", "b4d4d6", "b4d4", "b5b7", "b5c5e5", "b5c5", "d7c7", "d7e7", "g5g6", "g5e5c5", "g5e5"}
            , new String[]{"a3a2", "a3b3", "b6a6a4a2", "b6a6a4", "b6a6", "b6c6", "c1b1", "c1d1", "c4c3", "c4a4a2", "c4a4", "c4d4", "d5d4", "d5e5", "f3f2", "f3e3", "f3g3", "f5f4f2", "f5f4", "f5e5"}
            , new String[]{"a5a6c6", "a5a6", "a7b7", "b4a4a6c6", "b4a4a6", "b4a4", "b5b7", "b5d5", "c5c6a6", "c5c6", "c5d5", "d7c7", "d7e7", "g5g6", "g5e5"}
            , new String[]{"a3a2", "a3b3", "b6a6a4a2", "b6a6a4", "b6a6", "b6c6", "c1b1", "c1d1", "c4c3", "c4a4a2", "c4a4", "c4e4", "d4d3", "d4e4", "f3f2", "f3e3", "f3g3", "f5f4f2", "f5f4", "f5e5", "f5g5"}
            , new String[]{"a5a6c6", "a5a6", "a7b7", "b4a4a6c6", "b4a4a6", "b4a4", "b4c4c6a6", "b4c4c6", "b4c4e4", "b4c4", "b5b7", "b5d5", "c5c6a6", "c5c6", "c5d5", "d7c7", "d7e7", "g6g7", "g6f6"}
            , new String[]{"a3a2", "a3b3d3", "a3b3", "b6b4", "b6a6a4a2", "b6a6a4", "b6a6", "b6c6", "c1b1", "c1d1", "c3c2", "c3b3", "c3d3", "d4d3b3", "d4d3", "d4b4", "d4e4", "f3f2", "f3e3", "f3g3", "f5f4f2", "f5f4", "f5e5", "f5g5"}
            , new String[]{"a5a6c6", "a5a6", "a7b7", "b5b7", "b5d5", "c4c6a6", "c4c6", "c4b4", "c4e4", "c5c6a6", "c5c6", "c5d5", "d7c7", "d7e7", "g6g7", "g6f6"}
            , new String[]{"a3a2", "a3b3d3", "a3b3", "b6b4", "b6a6a4a2", "b6a6a4", "b6a6", "b6c6", "c1b1", "c1d1", "c3c2", "c3b3", "c3d3", "d4d3b3", "d4d3", "d4b4", "d4e4", "f2f1", "f2e2", "f2g2", "f3f1", "f3e3", "f3g3"}
            , new String[]{"a5a6", "a7b7", "b5b6", "b5d5", "c4c6", "c4b4b6", "c4b4", "c4e4", "c5c6", "c5d5", "e7d7", "e7f7", "g6g7", "g6f6"}
            , new String[]{"a3a2", "a3b3d3", "a3b3", "a4a2", "a4b4", "c1b1", "c1d1", "c3c2", "c3b3", "c3d3", "d4d3b3", "d4d3", "d4b4", "d4e4", "f2f1", "f2e2", "f2g2", "f3f1", "f3e3", "f3g3"}
            , new String[]{"a5a6", "a7b7", "b5b6", "b5d5", "c4c6", "c4b4b6", "c4b4", "c4e4", "c5c6", "c5d5", "e7d7", "e7f7", "f6f7d7", "f6f7", "f6e6", "f6g6"}
            , new String[]{"a2a1", "a2b2", "a3a1", "a3b3d3", "a3b3", "c1b1", "c1d1", "c3c2", "c3b3", "c3d3", "d4d3b3", "d4d3", "d4b4", "d4e4", "f2f1", "f2e2", "f2g2", "f3f1", "f3e3", "f3g3"}
            , new String[]{"a5a6", "b5b6", "b5d5", "b7a7", "b7c7", "c4c6", "c4b4b6", "c4b4", "c4e4", "c5c6", "c5d5", "e7d7", "e7f7", "f6f7d7", "f6f7", "f6e6", "f6g6"}
            , new String[]{"a2a1", "a2b2", "a3a1", "a3b3d3f3f1", "a3b3d3f3", "a3b3d3", "a3b3", "c1b1", "c1d1", "c3c2", "c3b3", "c3d3f3f1", "c3d3f3", "c3d3", "d4d3b3", "d4d3f3f1", "d4d3f3", "d4d3", "d4b4", "d4e4e2g2", "d4e4e2", "d4e4", "e3e2g2", "e3e2", "e3d3b3", "e3d3", "e3f3f1", "e3f3", "f2f1", "f2e2", "f2g2"}
            , new String[]{"a6a7c7", "a6a7", "a6b6", "b5b6", "b5a5a7c7", "b5a5a7", "b5a5", "b5d5", "b7a7", "b7c7", "c4c6", "c4b4b6", "c4b4", "c4e4", "c5c6", "c5a5a7c7", "c5a5a7", "c5a5", "c5d5", "e7d7", "e7f7", "f6f7d7", "f6f7", "f6e6", "f6g6"}
            , new String[]{"a2a1c1", "a2a1", "a2b2", "a3a1c1", "a3a1", "a3b3d3f3f1", "a3b3d3f3", "a3b3d3", "a3b3", "b1a1", "b1c1", "c3c2", "c3b3", "c3d3f3f1", "c3d3f3", "c3d3", "d4d3b3", "d4d3f3f1", "d4d3f3", "d4d3", "d4b4", "d4e4e2g2", "d4e4e2", "d4e4", "e3e2g2", "e3e2", "e3d3b3", "e3d3", "e3f3f1", "e3f3", "f2f1", "f2e2", "f2g2"}
            , new String[]{"a6a7", "a6b6", "b5b6", "b5a5a7", "b5a5", "b5d5", "c4c6", "c4b4b6", "c4b4", "c4e4", "c5c6", "c5a5a7", "c5a5", "c5d5", "c7b7", "c7d7f7", "c7d7", "e7d7b7", "e7d7", "e7f7", "f6f7d7b7", "f6f7d7", "f6f7", "f6e6", "f6g6"}
            , new String[]{"a2a1c1", "a2a1", "a2b2", "a3a1c1", "a3a1", "a3b3d3", "a3b3", "b1a1", "b1c1", "c3c2", "c3b3", "c3d3", "d4d3b3", "d4d3", "d4b4", "d4e4", "f1e1", "f1g1", "f2e2", "f2g2"}
            , new String[]{"a6b6", "a7b7d7f7", "a7b7d7", "a7b7", "b5b6", "b5a5", "b5c5", "c4c5a5", "c4c5", "c4a4", "c4d4", "c7b7", "c7d7f7", "c7d7", "e7d7b7", "e7d7", "e7f7", "f6f7d7b7", "f6f7d7", "f6f7", "f6e6", "f6g6"}
            , new String[]{"a2a1c1", "a2a1", "a2b2", "a3a1c1", "a3a1", "a3b3d3", "a3b3", "b1a1", "b1c1", "b4b3d3", "b4b3", "b4a4", "b4d4", "c3c2", "c3b3", "c3d3", "f1e1", "f1g1", "f2e2", "f2g2"}
            , new String[]{"a7b7d7f7", "a7b7d7", "a7b7", "b5b7d7f7", "b5b7d7", "b5b7", "b5a5", "b5c5", "b6b7d7f7", "b6b7d7", "b6b7", "b6a6", "b6c6", "c4c5a5", "c4c5", "c4b4", "c4d4", "c7b7", "c7d7f7", "c7d7", "e7d7b7", "e7d7", "e7f7", "f6f7d7b7", "f6f7d7", "f6f7", "f6e6", "f6g6"}
            , new String[]{"a2a1c1", "a2a1", "a2b2", "a3a1c1", "a3a1", "b1a1", "b1c1", "b3b2", "b3d3", "c3c2", "c3d3", "f1e1", "f1g1", "f2e2", "f2g2"}
            , new String[]{"b5b6", "b5a5", "b5c5", "b7d7f7", "b7d7", "c4c5a5", "c4c5", "c4b4b6", "c4b4", "c4d4", "c7d7f7", "c7d7", "e7d7", "e7f7", "f6f7d7", "f6f7", "f6e6", "f6g6"}
            , new String[]{"a1c1", "a3a2", "b1c1", "b3b2", "b3d3", "c3c2", "c3d3", "f1e1", "f1g1", "f2e2", "f2g2"}
            , new String[]{"b5a5", "b5c5", "b6a6", "b6c6", "b7d7f7", "b7d7", "c7d7f7", "c7d7", "e7d7", "e7f7", "f6f7d7", "f6f7", "f6e6", "f6g6"}
            , new String[]{"a3a2", "b1a1", "b1d1", "b3b2", "b3d3", "c1a1", "c1d1", "c3c2", "c3d3", "f1e1", "f1g1", "f2e2", "f2g2"}
            , new String[]{"b5a5", "b5c5", "b6a6", "b6c6", "d7f7", "e7f7"}
            , new String[]{"a3a2", "b3b2", "b3d3", "c1b1", "c1e1g1", "c1e1", "c3c2", "c3d3", "d1b1", "d1e1g1", "d1e1", "f1e1", "f1g1", "f2e2", "f2g2"}
            , new String[]{"a5a6c6", "a5a6", "a5b5", "b6a6", "b6c6", "d7f7", "e7f7"}
            , new String[]{"a3a2", "a3b3", "c1b1", "c1e1g1", "c1e1", "c3c2", "c3b3", "c3e3", "d1b1", "d1e1g1", "d1e1", "d3d2", "d3b3", "d3e3", "f1e1", "f1g1", "f2e2", "f2g2"}
            , new String[]{"a5a6", "a5b5", "c6b6", "c6d6", "d7f7", "e7f7"}
            , new String[]{"a3a2", "a3b3", "c1b1", "c1d1", "c3c2", "c3b3", "c3e3", "d3d2", "d3b3", "d3e3", "f1e1", "f2e2", "f2g2", "g1e1"}
            , new String[]{"a5a6", "a5b5", "b7d7", "c6b6", "c6d6", "c7d7", "e7d7", "e7g7", "f7d7", "f7g7"}
            , new String[]{"a3a2", "a3b3", "c1b1", "c1d1", "c3c2", "c3b3", "c3e3e1", "c3e3", "d3d2f2", "d3d2", "d3b3", "d3e3e1", "d3e3", "e2e1", "e2d2", "e2f2", "f1e1", "g1e1"}
            , new String[]{"a5a6", "a5b5", "c6b6", "c6d6", "c7e7g7", "c7e7", "d7e7g7", "d7e7", "f7e7", "f7g7"}
            , new String[]{"b3b2", "b3a3", "c1b1", "c1d1", "c3c2", "c3a3", "c3e3e1", "c3e3", "d3d2f2", "d3d2", "d3e3e1", "d3e3", "e2e1", "e2d2", "e2f2", "f1e1", "g1e1"}
            , new String[]{"b5b6d6", "b5b6", "b5a5", "b5c5", "c6b6", "c6d6", "c7e7g7", "c7e7", "d7e7g7", "d7e7", "f7e7", "f7g7"}
            , new String[]{"b3b2d2f2", "b3b2d2", "b3b2", "b3a3", "b3c3e3e1", "b3c3e3", "b3c3", "c1b1", "c1d1", "c2b2", "c2d2f2", "c2d2", "d3d2b2", "d3d2f2", "d3d2", "d3c3a3", "d3c3", "d3e3e1", "d3e3", "e2e1", "e2d2b2", "e2d2", "e2f2", "f1e1", "g1e1"}
            , new String[]{"b5a5", "b5c5", "b6a6", "b6c6", "c7e7g7", "c7e7", "d7e7g7", "d7e7", "f7e7", "f7g7"}
            , new String[]{"b3b2d2", "b3b2", "b3a3", "b3c3e3", "b3c3", "c1b1", "c1d1", "c2b2", "c2d2", "d3d2b2", "d3d2", "d3c3a3", "d3c3", "d3e3", "f1e1", "f2e2", "f2g2", "g1e1"}
            , new String[]{"a6b6", "b5b6", "b5a5", "b5c5", "c7e7g7", "c7e7", "d7e7g7", "d7e7", "f7e7", "f7g7"}
            , new String[]{"b3b2d2", "b3b2", "b3a3", "b3c3e3", "b3c3", "c1b1", "c1d1f1", "c1d1", "c2b2", "c2d2", "d3d2b2", "d3d2", "d3c3a3", "d3c3", "d3e3", "e1d1b1", "e1d1", "e1f1", "f2f1d1b1", "f2f1d1", "f2f1", "f2e2", "f2g2", "g1f1d1b1", "g1f1d1", "g1f1"}
            , new String[]{"a6b6", "b5b6", "b5a5", "b5c5", "d7f7", "e7f7"}
            , new String[]{"c1b1", "c1d1f1", "c1d1", "c2b2", "c2e2g2", "c2e2", "d2d1b1", "d2d1f1", "d2d1", "d2b2", "d2e2g2", "d2e2", "d3d1b1", "d3d1f1", "d3d1", "d3c3", "d3e3", "e1d1b1", "e1d1", "e1f1", "f2f1d1b1", "f2f1d1", "f2f1", "f2e2", "f2g2", "g1f1d1b1", "g1f1d1", "g1f1"}
            , new String[]{"a6b6", "b5b6", "b5a5", "b5c5", "b7d7", "c7d7", "e7d7", "e7g7", "f7d7", "f7g7"}
            , new String[]{"b1a1", "b1d1", "c1a1", "c1d1", "c2b2", "c2e2g2", "c2e2", "d2d1", "d2b2", "d2e2g2", "d2e2", "d3d1", "d3c3", "d3e3", "f2f1", "f2e2", "f2g2", "g1f1"}
            , new String[]{"a6b6", "a7c7", "b5b6", "b5a5", "b5c5", "b7c7", "d7c7", "e7c7", "e7g7", "f7g7"}
            , new String[]{"b1a1", "b1d1", "b2a2", "b2c2e2g2", "b2c2e2", "b2c2", "c1a1", "c1d1", "d2d1", "d2c2a2", "d2c2", "d2e2g2", "d2e2", "d3d1", "d3c3", "d3e3", "f2f1", "f2e2c2a2", "f2e2c2", "f2e2", "f2g2", "g1f1"}
            , new String[]{"a6b6", "b5b6", "b5a5", "b5c5", "b7d7", "c7d7", "e7d7", "e7g7", "f7d7", "f7g7"}
            , new String[]{"b1a1", "b1d1", "b2a2", "c1a1", "c1d1", "c2a2", "c2e2", "d2d1", "d2e2", "d3d1", "d3c3", "d3e3", "g1f1"}
            , new String[]{"a6b6", "b5b6", "b5a5", "b5c5", "b7d7", "c7d7", "f7e7", "g7e7"}
            , new String[]{"a1c1", "b1c1", "b2a2", "c2c1", "c2a2", "c2e2", "d2d1", "d2e2", "d3d1", "d3c3c1", "d3c3", "d3e3", "g1f1"}
            , new String[]{"a6b6", "a7b7", "b5b6", "b5a5", "b5c5", "c7b7", "c7e7", "d7b7", "d7e7", "f7e7", "g7e7"}
            , new String[]{"a1c1", "b1c1", "b2a2", "c2c1", "c2a2", "c2e2", "d2d1", "d2e2", "d3d1", "d3c3c1", "d3c3", "d3e3", "f1e1", "f1g1"}
            , new String[]{"a6b6", "a7b7", "b5b6", "b5a5", "b5c5", "c7b7", "d7b7", "e7g7", "f7g7"}
            , new String[]{"a1b1d1", "a1b1", "b2b1d1", "b2b1", "b2a2", "c1b1", "c1d1", "c2a2", "c2e2", "d2d1b1", "d2d1", "d2e2", "d3d1b1", "d3d1", "d3c3", "d3e3", "f1e1", "f1g1"}
            , new String[]{"a6b6", "a7c7", "b5b6", "b5a5", "b5c5", "b7c7", "d7c7", "e7c7", "e7g7", "f7g7"}
            , new String[]{"b1d1", "c1d1", "c2b2", "c2e2", "d2d1", "d2b2", "d2e2", "d3d1", "d3c3", "d3e3", "f1e1", "f1g1"}
            , new String[]{"a7c7", "b5a5", "b5c5", "b6a6", "b6c6", "b7c7", "d7c7", "e7c7", "e7g7", "f7g7"}
            , new String[]{"b1d1", "b2a2", "b2c2e2", "b2c2", "c1d1", "d2d1", "d2c2a2", "d2c2", "d2e2", "d3d1", "d3c3", "d3e3", "f1e1", "f1g1"}
            , new String[]{"a7c7e7", "a7c7", "b5a5", "b5c5", "b6a6", "b6c6", "b7c7e7", "b7c7", "d7c7", "d7e7", "f7e7c7", "f7e7", "g7e7c7", "g7e7"}
            , new String[]{"a2c2", "b1d1", "b2c2", "c1d1", "d3d2", "d3c3", "d3e3", "f1e1", "f1g1"}
            , new String[]{"b5a5", "b5c5", "b6a6", "b6c6", "c7e7", "d7e7", "g7f7"}
            , new String[]{"a2c2", "b1d1", "b2c2", "c1d1", "d3d2", "d3c3", "d3e3", "g1f1"}
            , new String[]{"a5a6c6", "a5a6", "a5b5", "b6a6", "b6c6", "c7e7", "d7e7", "g7f7"}
            , new String[]{"a1b1", "a2c2", "b2b1", "b2c2", "c1b1", "c1e1", "d1b1", "d1e1", "d3d2", "d3c3", "d3e3", "g1f1"}
            , new String[]{"a5a6c6", "a5a6", "a5b5", "a7c7", "b6a6", "b6c6", "b7c7", "d7c7", "d7f7", "e7c7", "e7f7", "g7f7"}
            , new String[]{"a1b1", "a2c2", "b2b1", "b2c2", "c1b1", "c1e1", "d1b1", "d1e1", "e3e2", "e3d3", "e3f3", "g1f1"}
            , new String[]{"a5a6c6", "a5a6", "a5b5b7", "a5b5", "a7b7", "b6b7", "b6a6", "b6c6", "c7b7", "d7b7", "d7f7", "e7f7", "g7f7"}
            , new String[]{"a1b1", "b2b1", "b2a2", "b2d2", "c1b1", "c1e1", "c2a2", "c2d2", "d1b1", "d1e1", "e3e2", "e3d3", "e3f3", "g1f1"}
            , new String[]{"a5a6", "a5b5", "a7b7", "c6b6", "c6d6", "c7b7", "d7b7", "d7f7", "e7f7", "g7f7"}
            , new String[]{"a1b1", "b2b1", "b2a2", "b2d2", "c1b1", "c1e1g1", "c1e1", "c2a2", "c2d2", "d1b1", "d1e1g1", "d1e1", "e3e2", "e3d3", "e3f3", "f1e1", "f1g1"}
            , new String[]{"a5a6", "a5b5", "a7b7", "c7b7", "d6c6", "d6e6", "d7b7", "d7f7", "e7f7", "g7f7"}
            , new String[]{"a1b1", "b2b1", "b2a2", "b2c2e2", "b2c2", "c1b1", "c1e1g1", "c1e1", "d1b1", "d1e1g1", "d1e1", "d2c2a2", "d2c2", "d2e2", "e3e2c2a2", "e3e2c2", "e3e2", "e3d3", "e3f3", "f1e1", "f1g1"}
            , new String[]{"a5a6", "a5b5", "a7b7", "c7b7", "d6c6", "d6e6", "d7b7", "e7g7", "f7g7"}
            , new String[]{"a1b1d1", "a1b1", "b2b1d1", "b2b1", "b2a2", "b2c2e2", "b2c2", "c1b1", "c1d1", "d2d1b1", "d2d1", "d2c2a2", "d2c2", "d2e2", "e3e2c2a2", "e3e2c2", "e3e2", "e3d3d1b1", "e3d3d1", "e3d3", "e3f3", "f1e1", "g1e1"}
            , new String[]{"a5a6", "a5b5", "b7d7", "c7d7", "d6d7", "d6c6", "d6e6", "e7d7", "e7g7", "f7d7", "f7g7"}
            , new String[]{"a1b1d1", "a1b1", "b2b1d1", "b2b1", "b2a2", "b2c2e2", "b2c2", "c1b1", "c1d1", "d2d1b1", "d2d1", "d2c2a2", "d2c2", "d2e2", "d3d1b1", "d3d1", "d3c3", "d3e3", "f1e1", "g1e1"}
            , new String[]{"a5a6", "a5b5", "e7g7", "f7g7"}
            , new String[]{"a1b1", "b2b1", "b2a2", "b2c2", "c1b1", "c1e1", "d1b1", "d1e1", "d3d2", "d3c3", "d3e3", "f1e1", "g1e1"}
            , new String[]{"a6b6", "e7g7", "f7g7"}
            , new String[]{"a1b1d1", "a1b1", "b2b1d1", "b2b1", "b2a2", "b2c2", "c1b1", "c1d1", "d3d2", "d3c3", "d3e3", "e1d1b1", "e1d1", "f1d1b1", "f1d1"}
            , new String[]{"a6b6", "d7f7", "e7f7", "g7f7"}
            , new String[]{"a1b1d1", "a1b1", "b2b1d1", "b2b1", "b2a2", "b2c2", "c1b1", "c1d1", "c3c2a2", "c3c2", "c3b3b1d1", "c3b3b1", "c3b3", "c3d3", "e1d1b1", "e1d1", "f1d1b1", "f1d1"}
            , new String[]{"a6b6", "b7d7", "c7d7", "e7d7", "f7d7"}
            , new String[]{"b2b1", "b2a2", "b2c2", "c1b1", "c3c2a2", "c3c2", "c3b3b1", "c3b3", "c3d3", "d1b1"}
            , new String[]{"a6b6", "c7e7", "d7e7", "f7e7", "g7e7"}
            , new String[]{"b2b1", "b2a2", "b2c2", "c1b1", "d1b1", "d3d2", "d3c3", "d3e3"}
            , new String[]{"a6b6", "d7f7", "e7f7", "g7f7"}
            , new String[]{"b2b1", "b2a2", "b2c2", "c1b1", "d1b1", "e3e2", "e3d3", "e3f3"}
            , new String[]{"a6b6", "e7g7", "f7g7"}
            , new String[]{"b2b1", "b2a2", "b2c2", "c1b1", "d1b1", "f3f2", "f3e3", "f3g3"}
            , new String[]{"a6b6", "c7e7", "d7e7", "f7e7", "g7e7"}
            , new String[]{"b1a1", "b1c1", "b2a2", "b2c2", "d1c1a1", "d1c1", "e1c1a1", "e1c1", "f3f2", "f3e3", "f3g3"}
            , new String[]{"a6b6", "a7c7", "b7c7", "d7c7", "e7c7"}
            , new String[]{"b1a1", "b1c1", "b2a2", "b2c2", "d1c1a1", "d1c1", "e1c1a1", "e1c1", "g3g2", "g3f3"}
            , new String[]{"a6b6", "c7e7", "d7e7", "f7e7", "g7e7"}
            , new String[]{"a1b1", "b2b1", "b2a2", "b2c2", "d1c1", "e1c1", "g3g2", "g3f3"}
            , new String[]{"a6b6", "b7d7", "c7d7", "e7d7", "f7d7"}
            , new String[]{"a1b1", "b2b1", "b2a2", "b2c2", "d1c1", "e1c1", "g2f2"}
            , new String[]{"a6b6", "a7b7", "c7b7", "d7b7"}
            , new String[]{"b1a1", "b1c1", "b2a2", "b2c2", "d1c1a1", "d1c1", "e1c1a1", "e1c1", "g2f2"}
            , new String[]{"a6b6", "a7c7", "b7c7", "d7c7", "e7c7"}
            , new String[]{"a1c1e1", "a1c1", "b1c1e1", "b1c1", "b2a2", "b2c2", "d1c1", "d1e1", "f1e1c1", "f1e1", "g1e1c1", "g1e1", "g2f2"}
            , new String[]{"a6b6", "b7d7", "c7d7", "e7d7", "f7d7"}
            , new String[]{"b1a1", "b1c1", "b2a2", "b2c2", "d1c1a1", "d1c1", "e1c1a1", "e1c1", "g2f2"}
            , new String[]{"a6b6", "c7e7", "d7e7", "f7e7", "g7e7"}
            , new String[]{"a1c1e1", "a1c1", "b1c1e1", "b1c1", "b2a2", "b2c2", "d1c1", "d1e1", "f1e1c1", "f1e1", "g1e1c1", "g1e1", "g2f2"}
            , new String[]{"a6b6", "b7d7", "c7d7", "e7d7", "f7d7"}
            , new String[]{"b1a1", "b2a2", "b2c2", "c1a1", "c1e1", "d1e1", "f1e1", "g1e1", "g2f2"}
            , new String[]{"a6b6", "a7b7", "c7b7", "d7b7"}
            , new String[]{"b1a1", "b2a2", "b2c2", "c1a1", "c1e1", "d1e1", "f1e1", "f2e2", "f2g2", "g1e1"}
            , new String[]{"a6b6", "b7d7", "c7d7", "e7d7", "f7d7"}
            , new String[]{"a1c1e1", "a1c1", "b1c1e1", "b1c1", "b2a2", "b2c2", "d1c1", "d1e1", "f1e1c1", "f1e1", "f2e2", "f2g2", "g1e1c1", "g1e1"}
            , new String[]{"a6b6", "c7e7", "d7e7", "f7e7", "g7e7"}
            , new String[]{"b1d1", "b2a2", "b2c2", "c1d1", "f1e1", "f2e2", "f2g2", "g1e1"}
            , new String[]{"b6a6", "b6c6", "c7e7", "d7e7", "f7e7", "g7e7"}
            , new String[]{"b1d1", "b2a2", "b2c2", "c1d1", "e1d1", "e1g1", "f1d1", "f1g1", "f2e2", "f2g2"}
            , new String[]{"b6a6", "b6c6", "d7f7", "e7f7", "g7f7"}
            , new String[]{"b1d1f1", "b1d1", "b2a2", "b2c2", "c1d1f1", "c1d1", "e1d1", "e1f1", "f2f1d1", "f2f1", "f2e2", "f2g2", "g1f1d1", "g1f1"}
            , new String[]{"c6b6", "c6d6", "d7f7", "e7f7", "g7f7"}
            , new String[]{"b1d1f1", "b1d1", "b2a2", "b2c2", "c1d1f1", "c1d1", "e1d1", "e1f1", "g1f1d1", "g1f1", "g2f2"}
            , new String[]{"c6b6", "c6d6", "c7e7", "d7e7", "f7e7", "g7e7"}
            , new String[]{"a2b2", "b1d1f1", "b1d1", "c1d1f1", "c1d1", "e1d1", "e1f1", "g1f1d1", "g1f1", "g2f2"}
            , new String[]{"c6b6", "c6d6", "d7f7", "e7f7", "g7f7"}
            , new String[]{"a1c1", "a2b2", "b1c1", "d1c1", "d1f1", "e1c1", "e1f1", "g1f1", "g2f2"}
            , new String[]{"c6b6", "c6d6", "e7g7", "f7g7"}
            , new String[]{"a1c1", "a2b2", "b1c1", "e1d1", "f1d1", "g2f2"}
            , new String[]{"b6a6", "b6c6", "e7g7", "f7g7"}
            , new String[]{"a1c1", "a2b2", "b1c1", "e1d1", "f1d1", "f2e2", "f2g2"}
            , new String[]{"a6b6", "e7g7", "f7g7"}
            , new String[]{"a1c1", "a2b2", "b1c1", "e1d1", "f1d1", "g2f2"}
            , new String[]{"a6b6", "d7f7", "e7f7", "g7f7"}
            , new String[]{"a1c1e1", "a1c1", "a2b2", "b1c1e1", "b1c1", "d1c1", "d1e1", "f1e1c1", "f1e1", "g1e1c1", "g1e1", "g2f2"}
            , new String[]{"a6b6", "c7e7", "d7e7", "f7e7", "g7e7"}
            , new String[]{"a2b2", "c1e1g1", "c1e1", "d1e1g1", "d1e1", "f1e1", "f1g1", "g2g1e1", "g2g1", "g2f2"}
            , new String[]{"a6b6", "b7d7", "c7d7", "e7d7", "f7d7"}
            , new String[]{"a2b2", "b1d1", "c1d1", "f1e1", "g1e1", "g2f2"}
            , new String[]{"a6b6", "d7f7", "e7f7", "g7f7"}
            , new String[]{"a2b2", "b1d1", "c1d1", "f1e1", "f2e2", "f2g2", "g1e1"}
            , new String[]{"a6b6", "e7g7", "f7g7"}
            , new String[]{"a2b2", "b1d1", "c1d1", "f1e1", "g1e1", "g2f2"}
            , new String[]{"a6b6", "c7e7", "d7e7", "f7e7", "g7e7"}
            , new String[]{"a1c1e1", "a1c1", "a2b2", "b1c1e1", "b1c1", "d1c1", "d1e1", "f1e1c1", "f1e1", "g1e1c1", "g1e1", "g2f2"}
            , new String[]{"a6b6", "e7g7", "f7g7"}
            , new String[]{"a1c1", "a2b2", "b1c1", "d1c1", "e1c1", "e1g1", "f1g1", "g2g1", "g2f2"}
            , new String[]{"a6b6", "c7e7", "d7e7", "f7e7", "g7e7"}
            , new String[]{"a1c1", "b1c1", "b2a2", "b2c2", "d1c1", "e1c1", "e1g1", "f1g1", "g2g1", "g2f2"}
            , new String[]{"a6b6", "e7g7", "f7g7"}
            , new String[]{"b1a1", "b2a2", "b2c2", "c1a1", "e1g1", "f1g1", "g2g1", "g2f2"}
            , new String[]{"b6a6", "b6c6", "e7g7", "f7g7"}
            , new String[]{"b1a1", "b2a2", "b2c2", "c1a1", "c1e1", "d1e1", "f1e1", "g1e1", "g2f2"}
            , new String[]{"a6b6", "e7g7", "f7g7"}
            , new String[]{"a2a1", "a2b2", "b1a1", "c1a1", "c1e1", "d1e1", "f1e1", "g1e1", "g2f2"}
            , new String[]{"a6b6", "d7f7", "e7f7", "g7f7"}
            , new String[]{"a2a1", "a2b2", "b1a1", "c1a1", "e1g1", "f1g1", "g2g1", "g2f2"}
            , new String[]{"a6b6", "e7g7", "f7g7"}
            , new String[]{"e1g1", "f1g1", "g2g1", "g2f2"}
    };


}
