package leetcode;

/**
 * @author hzzhou
 * @since 2023-11-15
 */
public class Alg00414 {
    public int thirdMax(int[] nums) {
        // todo 为什么初始化为Long：-2的31次方 <= nums[i] <= 2的31次方 - 1 （即int的范围，所以要用long）
        long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > a) {
                c = b;
                b = a;
                a = num;
            } else if (a > num && num > b) {
                c = b;
                b = num;
            } else if (b > num && num > c) {
                c = num;
            }
        }
        return c == Long.MIN_VALUE ? (int) a : (int) c;
    }
}
