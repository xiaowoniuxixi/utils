package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hzzhou
 * @since 2023-11-09
 */
public class Alg01382 {
    List<Integer> inorderSeq = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        getInorder(root);
        return build(0, inorderSeq.size() - 1);
    }

    public void getInorder(TreeNode treeNode) {
        if (treeNode.left != null) {
            getInorder(treeNode.left);
        }
        inorderSeq.add(treeNode.val);
        if (treeNode.right != null) {
            getInorder(treeNode.right);
        }
    }

    public TreeNode build(int l, int right) {
        int mid = (l + right) >> 1;
        TreeNode root = new TreeNode(inorderSeq.get(mid));
        if (l <= mid - 1) {
            root.left = build(l, mid - 1);
        }
        if (mid + 1 <= right) {
            root.right = build(mid + 1, right);
        }
        return root;
    }

}
