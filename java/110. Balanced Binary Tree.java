/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// O(n)
public class Solution {
    private boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        treeHeight(root);
        return flag;
    }

    private int treeHeight(TreeNode root) {
        if (root == null || flag == false) {
            return 0;
        }
        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            flag = false;
            return 0;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
