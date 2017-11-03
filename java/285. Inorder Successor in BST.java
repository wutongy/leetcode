/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// O(logn)
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        TreeNode suc = null;
        if (p.right != null) {
            suc = p.right;
            while (suc.left != null) {
                suc = suc.left;
            }
            return suc;
        }
        while (root != null && root != p) {
            if (root.val < p.val) {
                root = root.right;
            } else {
                suc = root;
                root = root.left;
            }
        }
        return suc;
    }
}
