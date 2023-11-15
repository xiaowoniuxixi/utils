package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 丢失的数字
 *
 * @author hzzhou
 * @since 2023-11-14
 */
public class Alg00268 {
    /**
     * 方法一：排序
     *
     * @param nums
     * @return
     */
    public int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n;
    }

    /**
     * 方法二：哈希集合
     *
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int missing = -1;
        for (int i = 0; i <= n; i++) {
            if (!set.contains(i)) {
                missing = i;
                break;
            }
        }
        return missing;
    }

    /**
     * 方法三：位运算
     *
     * @param nums
     * @return
     */
    public int missingNumber3(int[] nums) {
        int xor = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        return xor;
    }

    /**
     * 方法四：数学
     *
     * @param nums
     * @return
     */
    public int missingNumber4(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1) / 2;
        int arrSum = 0;
        for (int i = 0; i < n; i++) {
            arrSum += nums[i];
        }
        return total - arrSum;
    }
}
