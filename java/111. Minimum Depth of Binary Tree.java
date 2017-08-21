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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int lMinDepth = Integer.MAX_VALUE;
        int rMinDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            lMinDepth = minDepth(root.left);
        }
        if (root.right != null) {
            rMinDepth = minDepth(root.right);
        }
        return 1 + Math.min(lMinDepth, rMinDepth);
    }
}
