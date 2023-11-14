package leetcode;

/**
 * @author hzzhou
 * @since 2023-11-13
 */
public class Alg00136 {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
