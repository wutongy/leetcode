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
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }

    private int helper(TreeNode root, boolean flag) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null && flag) {
            return root.val;
        } else {
            return helper(root.left, true) + helper(root.right, false);
        }
    }
}
