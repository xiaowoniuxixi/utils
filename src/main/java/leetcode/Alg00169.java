package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 存在重复元素 II
 *
 * @author hzzhou
 * @since 2023-11-14
 */
public class Alg00169 {

    /**
     * 方法一：哈希表
     *
     * @param nums
     * @return
     */
    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        return counts;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);
        Map.Entry<Integer, Integer> majorityEntity = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntity == null || entry.getValue() > majorityEntity.getValue()) {
                majorityEntity = entry;
            }
        }
        return majorityEntity.getKey();
    }
}
