package leetcode;

/**
 * 2656. K 个元素的最大和
 *
 * @author hzzhou
 * @since 2023-11-15
 */
public class Alg02656 {

    public static void main(String[] args) {
        int[] grid = new int[]{7, 1, 5, 3, 6, 4};
        Alg02656 alg = new Alg02656();
        System.out.println(alg.maximizeSum(grid, 2));
    }

    public int maximizeSum(int[] nums, int k) {
        int maxValue = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > maxValue) {
                maxValue = num;
            }
        }
        int endValue = (maxValue + k - 1);
        if (maxValue == endValue) {
            return maxValue;
        }
        return (maxValue + endValue) * k / 2;
    }
}
