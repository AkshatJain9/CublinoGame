package comp1140.ass2.helpers;

import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;

import java.util.ArrayList;
import java.util.List;

/**
 * nxm matrix
 */
public class Matrix {

    private double[][] matrix;

    public static Matrix identity(int size) {
        Matrix id = new Matrix(size, size);
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                id.setAt(y, x, (x == y ? 1 : 0));
            }
        }
        return id;
    }

    /**
     * Construct square matrix of size l
     * @param l side length
     */
    public Matrix (int l) {
        this (l, l);
    }

    /**
     * generate an empty matrix
     * @param h height of matrix
     * @param w width of matrix
     */
    public Matrix(int h, int w) {
        this.matrix = new double[h][w];
    }

    /**
     * generate a matrix with an array of arrays. where each
     * array element is a separate row
     * @param matrix
     */
    public Matrix (double[][]matrix) {
        // TODO: check for invalid matrices
        this.matrix = matrix;
    }

    public double[][] getArray() {
        return this.matrix;
    }

    /**
     * duplicate a matrix
     * @param m the matrix to copy
     */
    public Matrix (Matrix m) {
        matrix = new double[m.getHeight()][m.getWidth()];

        for (int y = 0; y < m.getHeight(); y++)
            for (int x = 0; x < m.getWidth(); x++)
                setAt(y, x, m.getAt(y, x));
    }

    public Matrix (List<Transform> transformList) {
        this(4);
        matrix = identity(4).matrix;
        for (Transform t : transformList) {
            if (t instanceof Rotate) {
                addRotation((Rotate) t);
            } else if (t instanceof Translate) {
                addTranslation((Translate) t);
            }
        }
    }

    public void addTranslation (Translate t) {
        Matrix m = new Matrix(new double[][] {
                new double[] { 1,0,0, t.getX() },
                new double[] { 0,1,0, t.getY() },
                new double[] { 0,0,1, t.getZ() },
                new double[] { 0,0,0, 1 },
        });
        matrix = Matrix.dotProduct(m, this).matrix;
    }

    /**
     * rotates anticlockwise
     * @param r
     */
    public void addRotation (Rotate r) {
        var axis = r.getAxis();
        var angle = r.getAngle();
        Matrix m;
        if (Rotate.X_AXIS.equals(axis)) {
            m = new Matrix(
                    new double[][]{
                            new double[]{1, 0, 0, 0},
                            new double[]{0, Math.cos(angle), Math.sin(angle), 0},
                            new double[]{0, -Math.sin(angle), Math.cos(angle), 0},
                            new double[]{0, 0, 0, 1},
                    });
        } else if (Rotate.Y_AXIS.equals(axis)) {
            m = new Matrix(
                    new double[][]{
                            new double[]{Math.cos(angle), 0, -Math.sin(angle), 0},
                            new double[]{0, 1, 0, 0},
                            new double[]{Math.sin(angle), 0, Math.cos(angle), 0},
                            new double[]{0, 0, 0, 1},
                    });
        } else if (Rotate.Z_AXIS.equals(axis)) {
            m = new Matrix(
                    new double[][]{
                            new double[]{Math.cos(angle), -Math.sin(angle), 0, 0},
                            new double[]{Math.sin(angle), Math.cos(angle), 0, 0},
                            new double[]{0, 0, 0, 1}
                    });
        } else {
            throw new UnsupportedOperationException("make sure the rotation affects only one axis");
        }
        // NOTE: getArray just copies the array over, could be unintended side effects
        matrix = Matrix.dotProduct(m, this).getArray();
    }

    /**
     * get the number of rows
     * @return height of matrix
     */
    public int getHeight() {
        return matrix.length;
    }

    /**
     * get the number of columns
     * @return width of matrix
     */
    public int getWidth() {
        return matrix[0].length;
    }

    /**
     * get elements on a given row
     * @param y the row to return
     * @return
     */
    public double[] getRow(int y) {
        return matrix[y];
    }

    /**
     * get elements on a given column
     * @param x the column to return
     * @return
     */
    public double[] getColumn (int x) {
        double[] out = new double[getHeight()];
        for (int i = 0; i < out.length; i++)
            out[i] = getAt (i, x);
        return out;
    }

    /**
     * get an item at the given coordinates
     * @param y
     * @param x
     * @return
     */
    public double getAt (int y, int x) {
        if (insideMatrix(y, x))
            throw new IndexOutOfBoundsException("tried accessing outside of matrix");

        return matrix [y][x];
    }

    /**
     * set the given coordinate to some value
     * @param y
     * @param x
     * @param value
     */
    public void setAt (int y, int x, double value) {
        if (insideMatrix(y, x))
            throw new IndexOutOfBoundsException("tried accessing outside of matrix");

        matrix[y][x] = value;
    }


    /**
     * whether a coordinate is inside a matrix
     * @param y
     * @param x
     * @return true if x and y is in the matrix
     */
    boolean insideMatrix(int y, int x) {
        return y > getHeight() || y < 0 || x > getWidth() || x < 0;
    }

    public static Translate applyTransformation (Translate t, Matrix m) {
        if (m.getWidth() != 4 || m.getHeight() != 4)
            throw new UnsupportedOperationException("Only 4x4 matrices can be homogenous transformation matrices");

        return HMatrixToTranslate(dotProduct(m, translateToHMatrix(t)));
    }

    public static Translate HMatrixToTranslate (Matrix m) {
        if (m.getHeight() != 4 || m.getWidth() != 1)
            throw new UnsupportedOperationException("cannot get 3D translation from non 4x1 matrix");

        Translate ret = new Translate();
        ret.setX(m.getAt(0, 0));
        ret.setY(m.getAt(1, 0));
        ret.setZ(m.getAt(2, 0));
        return ret;
    }

    public static Matrix translateToHMatrix(Translate t) {
        return new Matrix (new double[][] {
                new double[] {t.getX()},
                new double[] {t.getY()},
                new double[] {t.getZ()},
        });
    }

    /**
     * adds a matrix to this matrix
     * @param left
     * @param right
     * @return the sum, l + r
     */
    public static Matrix add (Matrix left, Matrix right)
    {
        if (left.getWidth() != right.getWidth() || left.getHeight() != right.getHeight())
            throw new ArithmeticException("invalid matrix dimensions");

        Matrix ret = new Matrix(left.getHeight(), left.getWidth());

        for (int y = 0; y < left.getHeight(); y++) {
            double[] row = left.getRow(y);
            for (int x = 0; x < row.length; x++) {
                ret.setAt (y,x, left.getAt(y,x) + right.getAt(y, x));
            }
        }

        return ret;
    }

    /**
     * subtracts this matrix by another matrix
     * @param left
     * @param right
     * @return the difference, l - r
     */
    public static Matrix subtract (Matrix left, Matrix right)
    {
        var k = Matrix.multiplyConstant(-1, right);
        return Matrix.add(left, k);
    }

    /**
     * @param k
     */

    /**
     * scalar multiplication, multiply all elements
     * by a single number
     * @param k the scalar
     * @param m the matrix
     * @return the product, k * m
     */
    public static Matrix multiplyConstant (double k, Matrix m)
    {
        Matrix ret = new Matrix(m);
        for (int y = 0; y < m.getHeight(); y++) {
            for (int x = 0; x < m.getWidth(); x++) {
                ret.setAt(y, x, m.getAt(y, x) * k);
            }
        }
        return ret;
    }

    /**
     * compute the dot product
     * @param left
     * @param right
     * @return the product, l . r
     */
    public static Matrix dotProduct (Matrix left, Matrix right)
    {
        // check if sizes add up
        if (left.getWidth() != right.getHeight())
            throw new ArithmeticException("tried taking dot product of two incompatible matrices");

        int w = right.getWidth();
        int h = left.getHeight();
        Matrix ret = new Matrix(h, w);

        for (int a = 0; a < h; a++) {
            for (int b = 0; b < w; b++) {
                ret.setAt (a, b, multiplyRowByCol(left, right, a,b));
            }
        }

        return ret;
    }

    /**
     * multiplies a single row by a single column
     * @param m1 first matrix
     * @param m2 second matrix
     * @param dy position of row
     * @param dx position of column
     * @return the sum of the products
     */
    private static double multiplyRowByCol(Matrix m1, Matrix m2, int dy, int dx) {
        double out = 0;

        for (int i = 0; i < m1.getWidth(); i++)
            out += m1.getRow(dy)[i] * m2.getColumn(dx)[i];

        return out;
    }

    /**
     * Get the inverse matrix
     * @param m
     * @return
     */
    public static Matrix getInverse(Matrix m) {
        if (m.getHeight() != m.getWidth())
            throw new ArithmeticException("cannot find inverse of non square matrix");

        return multiplyConstant(1/getDeterminant(m), getTranspose(getCofactors(getMinors(m))));
    }

    /**
     * Finds the matrix of minors
     * @param m
     * @return
     */
    public static Matrix getMinors(Matrix m) {
        Matrix ret = new Matrix(m.getHeight(), m.getWidth());
        for (int y = 0; y < m.getHeight();y ++) {
            for (int x = 0; x < m.getWidth(); x++) {
                Matrix s = getSmaller(m, y, x);
                ret.setAt(y, x, Matrix.getDeterminant(s));
            }
        }

        return ret;
    }

    /**
     * Helper function, gets the submatrix that excludes the given row and column
     * @param y row to exclude
     * @param x column to exclude
     * @return the resulting submatrix
     */
    public static Matrix getSmaller(Matrix m, int y, int x) {
        Matrix ret = new Matrix (m.getHeight() - 1, m.getWidth() - 1);
        int dy = 0;
        for (int _y = 0; _y < m.getHeight(); _y ++) {
            int dx = 0;
            if (y == _y) {
                dy++;
                continue;
            }
            for (int _x = 0; _x < m.getWidth(); _x++) {
                if (x == _x) {
                    dx++;
                    continue;
                }

                ret.setAt (_y - dy, _x - dx, m.getAt(_y, _x));
            }
        }

        return ret;
    }

    /**
     * Finds the matrix of cofactors
     * @param m the matrix
     * @return the matrix of cofactors
     */
    public static Matrix getCofactors(Matrix m) {
        Matrix ret = new Matrix(m.getHeight(), m.getWidth());
        for (int y = 0; y < m.getHeight(); y++) {
            for (int x = 0; x < m.getWidth(); x++) {
                int ysign = y % 2 == 0 ? 1 : -1;
                int sign = x % 2 == 0 ? ysign : ysign * -1;
                ret.setAt(y, x, m.getAt(y, x) * sign);
            }
        }
        return ret;
    }

    /**
     * flip all elements about the leading diagonal
     * @param m the matrix
     * @return the transposed matrix
     */
    public static Matrix getTranspose(Matrix m) {
        Matrix ret = new Matrix(m.getHeight(), m.getWidth());
        for (int i = 0; i < m.getHeight(); i++) {
            for (int j = 0; j < m.getWidth(); j++) {
                ret.setAt(i, j, m.getAt(j, i));
            }
        }

        return ret;
    }

    /**
     * Get the determinant of a matrix using a laplace expansion
     * @param m the matrix
     * @return the determinant
     */
    public static double getDeterminant (Matrix m) {
        // base case
        if (m.getWidth() == 2 && m.getHeight() == 2){
            return m.getAt (0,0) * m.getAt(1,1) - m.getAt(0,1) * m.getAt (1,0);
        }

        double det = 0;
        for (int x = 0; x < m.getWidth(); x++) {
            double sign = (x % 2 == 0 ? 1 : -1);
            var small = getSmaller(m, 0, x);
            var sdet =  getDeterminant(small);
            det += m.getAt(0, x) * sdet * sign;
        }

        return det;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (double[] row : matrix) {
            out.append ("[ ");
            for (double x : row) out.append(x).append(" ");
            out.append("]");
        }
        return out.toString();
    }

    // maximum range of error for equivalence
    private static final double EPSILON = 1;

    @Override
    public boolean equals (Object obj) {
        if (!(obj instanceof Matrix))
            return false;

        // conversion
        Matrix other = (Matrix)obj;

        // differing sizes
        if (other.getWidth() != this.getWidth() && other.getHeight() != this.getHeight())
            return false;

        // check each part
        for (int y = 0; y < getHeight(); y++)
            for (int x = 0; x < getWidth(); x++) {
                if (Math.abs(this.getAt(y, x) -  other.getAt(y, x)) > EPSILON)
                    return false;
            }

        return true;
    }
}
