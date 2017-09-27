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
    private int row, res;
    public int findBottomLeftValue(TreeNode root) {
        row = res = 0;
        helper(root, 1);
        return res;
    }

    private void helper(TreeNode root, int dep) {
        if (root == null) {
            return;
        }
        if (dep > row) {
            row = dep;
            res = root.val;
        }
        helper(root.left, dep + 1);
        helper(root.right, dep + 1);
    }
}
