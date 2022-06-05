package CublinoGame.customTests;

import CublinoGame.ass2.helpers.Matrix;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Timeout(value = 30, unit= TimeUnit.MILLISECONDS)
public class MatrixTests {
    void testArrays (double[] expected, double[] actual) {
        assertArrayEquals(expected, actual,
                "\nExpected: " + Arrays.toString(expected) +
                         "\nbut got:  " + Arrays.toString(actual) + "\n");
    }

    @Test
    void testGetColumn() {
        Matrix m = new Matrix(new double[][] {new double[] {1,2,3}, new double[] {1,2,3}});
        testArrays(new double[] {2,2}, m.getColumn(1));
    }

    @Test
    void testGetRow() {
        Matrix m = new Matrix(new double[][] {new double[] {1,2,3}, new double[] {1,2,3}});
        testArrays(new double[] {1,2,3}, m.getRow(1));
    }

    @Test
    void testDuplicateMatrix() {
        Matrix m = new Matrix(new double[][] {new double[] {1,2,3}, new double[] {1,2,3}});
        Matrix n = new Matrix(m);
        assertEquals(m, n);
    }

    @Test
    void testAddMatrix () {
        Matrix m = new Matrix(new double[][] {new double[] {1,2,3}, new double[] {1,2,3}});
        Matrix n = new Matrix(new double[][] {new double[] {1,2,3}, new double[] {1,2,3}});
        assertEquals (new Matrix(new double[][] {new double[] {2,4,6}, new double[] {2,4,6}}), Matrix.add(m, n));
    }

    @Test
    void testSubtractMatrixTest () {
        Matrix m = new Matrix(new double[][] {new double[] {2,4,6}, new double[] {2,4,6}});
        Matrix n = (new Matrix(new double[][] {new double[] {1,2,3}, new double[] {1,2,3}}));
        assertEquals (new Matrix(new double[][] {new double[] {1,2,3}, new double[] {1,2,3}}), Matrix.subtract(m, n));
    }

    @Test
    void testMultiplyConstant () {
        Matrix m = new Matrix(new double[][] {new double[] {1,2,3}, new double[] {1,2,3}});
        assertEquals (new Matrix(new double[][] {new double[] {2,4,6}, new double[] {2,4,6}}), Matrix.multiplyConstant(2, m));
    }

    @Test
    void testDotProduct () {
        Matrix m = new Matrix(new double[][] {new double[] {1,2}, new double[] {3,4}});
        Matrix n = (new Matrix(new double[][] {new double[] {4}, new double[] {5}}));
        assertEquals (new Matrix(new double[][] {new double[] {14}, new double[] {32}}), Matrix.dotProduct(m, n));
    }

    @Test
    void testSmall() {
        Matrix m = new Matrix(new double[][] {
                new double[] {3, 0, 2},
                new double[] {2, 0,-2},
                new double[] {0, 1, 1},
        });
        Matrix expected = new Matrix(new double[][] {
                new double[] {2, -2},
                new double[] {0,  1},
        });
        assertEquals(expected, Matrix.getSmaller(m, 0, 1));
    }

    @Test
    void testMinors() {
        Matrix m = new Matrix(new double[][] {
                new double[] {3, 0, 2},
                new double[] {2, 0,-2},
                new double[] {0, 1, 1},
        });

        Matrix minors = new Matrix(new double[][] {
                new double[] { 2,  2,  2},
                new double[] {-2,  3,  3},
                new double[] { 0, -10, 0},
        });

        assertEquals(minors, Matrix.getMinors(m));
    }

    @Test
    void testCofactor() {
        Matrix m = new Matrix(new double[][] {
                new double[] { 2,  2,  2},
                new double[] {-2,  3,  3},
                new double[] { 0, -10, 0},
        });

        Matrix expected = new Matrix(new double[][] {
                new double[] { 2,  -2,  2},
                new double[] { 2,   3, -3},
                new double[] { 0,  10,  0},
        });

        assertEquals(expected, Matrix.getCofactors(m));
    }

    @Test
    void testTranspose() {
        Matrix expected = new Matrix(new double[][] {
                new double[] { 2,   2,  0 },
                new double[] {-2,   3,  10},
                new double[] { 2,  -3,  0 },
        });

        Matrix m = new Matrix(new double[][] {
                new double[] { 2,  -2,  2},
                new double[] { 2,   3, -3},
                new double[] { 0,  10,  0},
        });

        assertEquals(expected, Matrix.getTranspose(m));
    }

    @Test
    void testDeterminant() {
        Matrix m = new Matrix(new double[][] {
                new double[] { 2,   2,  2 },
                new double[] {-2,   3,  10},
                new double[] { 0,  -3,  0 },
        });

        assertEquals(72, Matrix.getDeterminant(m));
    }

    @Test
    void testInverse(){
        Matrix m = new Matrix(new double[][] {
                new double[] {3, 0, 2},
                new double[] {2, 0,-2},
                new double[] {0, 1, 1},
        });
        Matrix expected = new Matrix(new double[][] {
                new double[] { 0.2,  0.2, 0},
                new double[] {-0.2,  0.3, 1},
                new double[] { 0.2, -0.3, 0},
        });

        assertEquals(expected, Matrix.getInverse(m));
    }
}