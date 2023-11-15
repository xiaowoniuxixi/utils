package leetcode;

/**
 * @author hzzhou
 * @since 2023-11-14
 */
public class Alg00303 {
    int[] sums;
    //    public NumArray(int[] nums) {
    public Alg00303(int[] nums) {
        int n = nums.length;
        sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }
}
