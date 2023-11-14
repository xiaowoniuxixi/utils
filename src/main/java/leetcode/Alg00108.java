package leetcode;

import java.util.Random;

/**
 * @author hzzhou
 * @since 2023-11-09
 */
public class Alg00108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return genTree(nums, 0, nums.length - 1);
    }

    public TreeNode genTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        Random rand = new Random();
        rand.nextInt(2);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = genTree(nums, left, mid - 1);
        root.right = genTree(nums, mid + 1, right);
        return root;
    }

}
