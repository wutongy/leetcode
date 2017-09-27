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
class Solution {
    private int res;
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftPath = dfs(root.left);
        int rightPath = dfs(root.right);
        res = Math.max(res, leftPath + rightPath + root.val);
        return Math.max(0, Math.max(leftPath, rightPath) + root.val);
    }
}
