package CublinoGame.ass2.helpers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Helpers{
    /**
     * shifts elements in an array to the right
     * @param arr the array to shift
     * @param n the amount to shift it by
     * @return the shifted array
     */
    public static int[] shift (int[] arr, int n) {
        // invalid array
        if (arr == null || arr.length == 0)
            return new int[] { };

        int k = Math.floorMod (-n, arr.length);
        return IntStream.concat(Arrays.stream(arr).skip (k), Arrays.stream(arr).limit (k)).toArray();
    }
}
