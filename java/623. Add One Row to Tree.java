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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode head = new TreeNode(v);
            head.left = root;
            return head;
        }
        helper(root, v, d);
        return root;
    }
    private void helper(TreeNode root, int v, int d) {
        if (root == null) {
            return;
        }
        if (d == 2) {
            TreeNode lnode = new TreeNode(v);
            lnode.left = root.left;
            root.left = lnode;
            TreeNode rnode = new TreeNode(v);
            rnode.right = root.right;
            root.right = rnode;
        } else {
            helper(root.left, v, d - 1);
            helper(root.right, v, d - 1);
        }
    }
}
