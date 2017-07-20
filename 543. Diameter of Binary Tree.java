/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return result;
    }

    public int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftLength = helper(node.left);
        int rightLength = helper(node.right);
        result = Math.max(result, leftLength + rightLength);
        return 1 + Math.max(leftLength, rightLength);
    }
}
