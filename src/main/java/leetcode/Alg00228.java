package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hzzhou
 * @since 2023-11-14
 */
public class Alg00228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            // 连续区间的起点
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            // 经过一个while，high变为连续区间的终点
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            ret.add(temp.toString());
        }
        return ret;
    }
}
