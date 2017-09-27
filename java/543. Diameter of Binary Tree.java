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
    public int diameterOfBinaryTree(TreeNode root) {
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
        result = Math.max(result, leftLen + rightLen);
        return Math.max(leftLen, rightLen) + 1;
    }
}
