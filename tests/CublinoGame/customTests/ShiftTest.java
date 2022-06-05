package CublinoGame.customTests;

import CublinoGame.ass2.helpers.Helpers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ShiftTest {
    private void test(int[] in, int shift, int[] expected) {
        int[] out = Helpers.shift(in, shift);
        assertArrayEquals(expected, out, "\nExpected Helpers.shift(" + Arrays.toString(in) + ", " + shift + ")" +
                "\nto be " + Arrays.toString(expected) +
                "\nbut got " + Arrays.toString(out) + ".\n");
    }

    // whitebox tests

    @Test
    public void testEmpty() {
        // null case
        test (null, 69, new int[] {});

        // empty array
        for (int i = 0; i < 100; i++)
            test (new int[] {}, i, new int[] {});
    }

    @Test
    public void testOutOfBounds() {
        test (new int[] {1,2,3,4}, 10, new int[] {3,4,1,2});
    }

    // blackbox tests
    @Test
    public void testShiftsSimple () {
        int[] preshift = new int[] {4,5,6,7};
        int shift = 2;
        int[] postshift = new int[] {6,7,4,5};
        test (preshift, shift, postshift);
    }

    @Test
    public void testPositiveShifts () {
        int[][] preshift = new int[][] {
                new int[] { 0,4,6,9,1,},
                new int[] { 0,4,6,9,1,},
                new int[] { 0,4,6,9,1,},
                new int[] { 0,4,6,9,1,},
                new int[] { 10,5,10,8,4,},
                new int[] { 10,5,10,8,4,},
                new int[] { 10,5,10,8,4,},
                new int[] { 10,5,10,8,4,},
                new int[] { 6,5,9,5,9,},
                new int[] { 6,5,9,5,9,},
                new int[] { 6,5,9,5,9,},
                new int[] { 6,5,9,5,9,},
                new int[] { 4,7,2,3,2,},
                new int[] { 4,7,2,3,2,},
                new int[] { 4,7,2,3,2,},
                new int[] { 4,7,2,3,2,},
                new int[] { 3,4,6,8,5,},
                new int[] { 3,4,6,8,5,},
                new int[] { 3,4,6,8,5,},
                new int[] { 3,4,6,8,5,},
                new int[] { 6,10,5,8,6,},
                new int[] { 6,10,5,8,6,},
                new int[] { 6,10,5,8,6,},
                new int[] { 6,10,5,8,6,},
                new int[] { 5,4,1,6,8,},
                new int[] { 5,4,1,6,8,},
                new int[] { 5,4,1,6,8,},
                new int[] { 5,4,1,6,8,},
                new int[] { 4,10,7,5,0,},
                new int[] { 4,10,7,5,0,},
                new int[] { 4,10,7,5,0,},
                new int[] { 4,10,7,5,0,},
                new int[] { 6,2,9,7,4,},
                new int[] { 6,2,9,7,4,},
                new int[] { 6,2,9,7,4,},
                new int[] { 6,2,9,7,4,},
                new int[] { 9,1,9,1,0,},
                new int[] { 9,1,9,1,0,},
                new int[] { 9,1,9,1,0,},
                new int[] { 9,1,9,1,0,},
        };

        int[] shift = new int[] {0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, };

        int[][] postshift = new int[][] {
                new int[] {0,4,6,9,1,},
                new int[] {1,0,4,6,9,},
                new int[] {9,1,0,4,6,},
                new int[] {6,9,1,0,4,},
                new int[] {10,5,10,8,4,},
                new int[] {4,10,5,10,8,},
                new int[] {8,4,10,5,10,},
                new int[] {10,8,4,10,5,},
                new int[] {6,5,9,5,9,},
                new int[] {9,6,5,9,5,},
                new int[] {5,9,6,5,9,},
                new int[] {9,5,9,6,5,},
                new int[] {4,7,2,3,2,},
                new int[] {2,4,7,2,3,},
                new int[] {3,2,4,7,2,},
                new int[] {2,3,2,4,7,},
                new int[] {3,4,6,8,5,},
                new int[] {5,3,4,6,8,},
                new int[] {8,5,3,4,6,},
                new int[] {6,8,5,3,4,},
                new int[] {6,10,5,8,6,},
                new int[] {6,6,10,5,8,},
                new int[] {8,6,6,10,5,},
                new int[] {5,8,6,6,10,},
                new int[] {5,4,1,6,8,},
                new int[] {8,5,4,1,6,},
                new int[] {6,8,5,4,1,},
                new int[] {1,6,8,5,4,},
                new int[] {4,10,7,5,0,},
                new int[] {0,4,10,7,5,},
                new int[] {5,0,4,10,7,},
                new int[] {7,5,0,4,10,},
                new int[] {6,2,9,7,4,},
                new int[] {4,6,2,9,7,},
                new int[] {7,4,6,2,9,},
                new int[] {9,7,4,6,2,},
                new int[] {9,1,9,1,0,},
                new int[] {0,9,1,9,1,},
                new int[] {1,0,9,1,9,},
                new int[] {9,1,0,9,1,},
        };

        for (int i = 0; i < shift.length; i++) {
            test (preshift[i], shift[i], postshift[i]);
        }
    }

    @Test
    public void testNegativeShifts() {
        int[][] preshift = new int[][] {
                new int[] { 7,4,10,7,2,},
                new int[] { 7,4,10,7,2,},
                new int[] { 7,4,10,7,2,},
                new int[] { 7,4,10,7,2,},
                new int[] { 7,4,10,7,2,},
                new int[] { 7,4,10,7,2,},
                new int[] { 7,4,10,7,2,},
                new int[] { 7,4,10,7,2,},
                new int[] { 7,4,10,7,2,},
                new int[] { 3,10,7,2,0,},
                new int[] { 3,10,7,2,0,},
                new int[] { 3,10,7,2,0,},
                new int[] { 3,10,7,2,0,},
                new int[] { 3,10,7,2,0,},
                new int[] { 3,10,7,2,0,},
                new int[] { 3,10,7,2,0,},
                new int[] { 3,10,7,2,0,},
                new int[] { 3,10,7,2,0,},
                new int[] { 0,8,1,0,3,},
                new int[] { 0,8,1,0,3,},
                new int[] { 0,8,1,0,3,},
                new int[] { 0,8,1,0,3,},
                new int[] { 0,8,1,0,3,},
                new int[] { 0,8,1,0,3,},
                new int[] { 0,8,1,0,3,},
                new int[] { 0,8,1,0,3,},
                new int[] { 0,8,1,0,3,},
                new int[] { 0,8,2,7,10,},
                new int[] { 0,8,2,7,10,},
                new int[] { 0,8,2,7,10,},
                new int[] { 0,8,2,7,10,},
                new int[] { 0,8,2,7,10,},
                new int[] { 0,8,2,7,10,},
                new int[] { 0,8,2,7,10,},
                new int[] { 0,8,2,7,10,},
                new int[] { 0,8,2,7,10,},
                new int[] { 10,1,5,9,6,},
                new int[] { 10,1,5,9,6,},
                new int[] { 10,1,5,9,6,},
                new int[] { 10,1,5,9,6,},
                new int[] { 10,1,5,9,6,},
                new int[] { 10,1,5,9,6,},
                new int[] { 10,1,5,9,6,},
                new int[] { 10,1,5,9,6,},
                new int[] { 10,1,5,9,6,},
                new int[] { 2,7,7,7,9,},
                new int[] { 2,7,7,7,9,},
                new int[] { 2,7,7,7,9,},
                new int[] { 2,7,7,7,9,},
                new int[] { 2,7,7,7,9,},
                new int[] { 2,7,7,7,9,},
                new int[] { 2,7,7,7,9,},
                new int[] { 2,7,7,7,9,},
                new int[] { 2,7,7,7,9,},
                new int[] { 4,1,8,0,0,},
                new int[] { 4,1,8,0,0,},
                new int[] { 4,1,8,0,0,},
                new int[] { 4,1,8,0,0,},
                new int[] { 4,1,8,0,0,},
                new int[] { 4,1,8,0,0,},
                new int[] { 4,1,8,0,0,},
                new int[] { 4,1,8,0,0,},
                new int[] { 4,1,8,0,0,},
                new int[] { 2,3,1,9,2,},
                new int[] { 2,3,1,9,2,},
                new int[] { 2,3,1,9,2,},
                new int[] { 2,3,1,9,2,},
                new int[] { 2,3,1,9,2,},
                new int[] { 2,3,1,9,2,},
                new int[] { 2,3,1,9,2,},
                new int[] { 2,3,1,9,2,},
                new int[] { 2,3,1,9,2,},
                new int[] { 2,3,2,7,6,},
                new int[] { 2,3,2,7,6,},
                new int[] { 2,3,2,7,6,},
                new int[] { 2,3,2,7,6,},
                new int[] { 2,3,2,7,6,},
                new int[] { 2,3,2,7,6,},
                new int[] { 2,3,2,7,6,},
                new int[] { 2,3,2,7,6,},
                new int[] { 2,3,2,7,6,},
                new int[] { 9,6,6,7,1,},
                new int[] { 9,6,6,7,1,},
                new int[] { 9,6,6,7,1,},
                new int[] { 9,6,6,7,1,},
                new int[] { 9,6,6,7,1,},
                new int[] { 9,6,6,7,1,},
                new int[] { 9,6,6,7,1,},
                new int[] { 9,6,6,7,1,},
                new int[] { 9,6,6,7,1,},
        };
        int[] shift = new int[] {
                -5, -4, -3, -2, -1, 0, 1, 2, 3, -5, -4, -3, -2, -1, 0, 1, 2, 3, -5, -4, -3, -2, -1, 0, 1, 2, 3, -5, -4, -3, -2, -1, 0, 1, 2, 3, -5, -4, -3, -2, -1, 0, 1, 2, 3, -5, -4, -3, -2, -1, 0, 1, 2, 3, -5, -4, -3, -2, -1, 0, 1, 2, 3, -5, -4, -3, -2, -1, 0, 1, 2, 3, -5, -4, -3, -2, -1, 0, 1, 2, 3, -5, -4, -3, -2, -1, 0, 1, 2, 3, };
        int[][] postshift = new int[][]{
                new int[]{7, 4, 10, 7, 2,},
                new int[]{2, 7, 4, 10, 7,},
                new int[]{7, 2, 7, 4, 10,},
                new int[]{10, 7, 2, 7, 4,},
                new int[]{4, 10, 7, 2, 7,},
                new int[]{7, 4, 10, 7, 2,},
                new int[]{2, 7, 4, 10, 7,},
                new int[]{7, 2, 7, 4, 10,},
                new int[]{10, 7, 2, 7, 4,},
                new int[]{3, 10, 7, 2, 0,},
                new int[]{0, 3, 10, 7, 2,},
                new int[]{2, 0, 3, 10, 7,},
                new int[]{7, 2, 0, 3, 10,},
                new int[]{10, 7, 2, 0, 3,},
                new int[]{3, 10, 7, 2, 0,},
                new int[]{0, 3, 10, 7, 2,},
                new int[]{2, 0, 3, 10, 7,},
                new int[]{7, 2, 0, 3, 10,},
                new int[]{0, 8, 1, 0, 3,},
                new int[]{3, 0, 8, 1, 0,},
                new int[]{0, 3, 0, 8, 1,},
                new int[]{1, 0, 3, 0, 8,},
                new int[]{8, 1, 0, 3, 0,},
                new int[]{0, 8, 1, 0, 3,},
                new int[]{3, 0, 8, 1, 0,},
                new int[]{0, 3, 0, 8, 1,},
                new int[]{1, 0, 3, 0, 8,},
                new int[]{0, 8, 2, 7, 10,},
                new int[]{10, 0, 8, 2, 7,},
                new int[]{7, 10, 0, 8, 2,},
                new int[]{2, 7, 10, 0, 8,},
                new int[]{8, 2, 7, 10, 0,},
                new int[]{0, 8, 2, 7, 10,},
                new int[]{10, 0, 8, 2, 7,},
                new int[]{7, 10, 0, 8, 2,},
                new int[]{2, 7, 10, 0, 8,},
                new int[]{10, 1, 5, 9, 6,},
                new int[]{6, 10, 1, 5, 9,},
                new int[]{9, 6, 10, 1, 5,},
                new int[]{5, 9, 6, 10, 1,},
                new int[]{1, 5, 9, 6, 10,},
                new int[]{10, 1, 5, 9, 6,},
                new int[]{6, 10, 1, 5, 9,},
                new int[]{9, 6, 10, 1, 5,},
                new int[]{5, 9, 6, 10, 1,},
                new int[]{2, 7, 7, 7, 9,},
                new int[]{9, 2, 7, 7, 7,},
                new int[]{7, 9, 2, 7, 7,},
                new int[]{7, 7, 9, 2, 7,},
                new int[]{7, 7, 7, 9, 2,},
                new int[]{2, 7, 7, 7, 9,},
                new int[]{9, 2, 7, 7, 7,},
                new int[]{7, 9, 2, 7, 7,},
                new int[]{7, 7, 9, 2, 7,},
                new int[]{4, 1, 8, 0, 0,},
                new int[]{0, 4, 1, 8, 0,},
                new int[]{0, 0, 4, 1, 8,},
                new int[]{8, 0, 0, 4, 1,},
                new int[]{1, 8, 0, 0, 4,},
                new int[]{4, 1, 8, 0, 0,},
                new int[]{0, 4, 1, 8, 0,},
                new int[]{0, 0, 4, 1, 8,},
                new int[]{8, 0, 0, 4, 1,},
                new int[]{2, 3, 1, 9, 2,},
                new int[]{2, 2, 3, 1, 9,},
                new int[]{9, 2, 2, 3, 1,},
                new int[]{1, 9, 2, 2, 3,},
                new int[]{3, 1, 9, 2, 2,},
                new int[]{2, 3, 1, 9, 2,},
                new int[]{2, 2, 3, 1, 9,},
                new int[]{9, 2, 2, 3, 1,},
                new int[]{1, 9, 2, 2, 3,},
                new int[]{2, 3, 2, 7, 6,},
                new int[]{6, 2, 3, 2, 7,},
                new int[]{7, 6, 2, 3, 2,},
                new int[]{2, 7, 6, 2, 3,},
                new int[]{3, 2, 7, 6, 2,},
                new int[]{2, 3, 2, 7, 6,},
                new int[]{6, 2, 3, 2, 7,},
                new int[]{7, 6, 2, 3, 2,},
                new int[]{2, 7, 6, 2, 3,},
                new int[]{9, 6, 6, 7, 1,},
                new int[]{1, 9, 6, 6, 7,},
                new int[]{7, 1, 9, 6, 6,},
                new int[]{6, 7, 1, 9, 6,},
                new int[]{6, 6, 7, 1, 9,},
                new int[]{9, 6, 6, 7, 1,},
                new int[]{1, 9, 6, 6, 7,},
                new int[]{7, 1, 9, 6, 6,},
                new int[]{6, 7, 1, 9, 6,},
        };

        for (int i = 0; i < shift.length; i++) {
            test (preshift[i], shift[i], postshift[i]);
        }
    }
}
