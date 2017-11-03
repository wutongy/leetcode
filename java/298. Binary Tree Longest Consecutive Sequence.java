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
    private int res = 0;
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return res;
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int len = 1;
        if (root.left != null) {
            int leftLen = helper(root.left);
            if (root.val + 1 == root.left.val) {
                len = Math.max(len, 1 + leftLen);
            }
        }
        if (root.right != null) {
            int rightLen = helper(root.right);
            if (root.val + 1 == root.right.val) {
                len = Math.max(len, 1 + rightLen);
            }
        }
        res = Math.max(res, len);
        return len;
    }
}
