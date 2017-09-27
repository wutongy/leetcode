/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// O(logn) on average
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == root || q == root) {
            return root;
        }
        if ((p.val > root.val) ^ (q.val > root.val)) {
            return root;
        }
        return p.val > root.val ? lowestCommonAncestor(root.right, p, q) : lowestCommonAncestor(root.left, p, q);
    }
}
