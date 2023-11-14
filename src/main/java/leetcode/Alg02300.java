package leetcode;

import java.util.Arrays;

/**
 * @author hzzhou
 * @since 2023-11-10
 */
public class Alg02300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length, m = potions.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            long t = (success + spells[i] - 1) / spells[i] - 1;
            res[i] = m - binarySearch(potions, 0, m - 1, t);
        }
        return res;
    }

    public int binarySearch(int[] arr, int l, int h, long target) {
        int res = h + 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (arr[mid] > target) {
                res = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}
