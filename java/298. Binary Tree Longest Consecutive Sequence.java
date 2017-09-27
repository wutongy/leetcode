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
    private int result;
    public int longestConsecutive(TreeNode root) {
        result = 0;
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLen = dfs(root.left);
        int rightLen = dfs(root.right);
        int res = 1;
        if (root.left != null && root.val + 1 == root.left.val) {
            ++leftLen;
            res = Math.max(res, leftLen);
        }
        if (root.right != null && root.val + 1 == root.right.val) {
            ++rightLen;
            res = Math.max(res, rightLen);
        }
        result = Math.max(result, res);
        return res;
    }
}
