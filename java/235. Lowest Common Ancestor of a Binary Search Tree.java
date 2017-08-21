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
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (p != root && q != root) {
            int pRes = 0, qRes = 0;
            if (p.val > root.val) {
                pRes = 1;
            }
            if (q.val > root.val) {
                qRes = 1;
            }
            if ((pRes ^ qRes) == 1) {
                return root;
            } else if (pRes == 0) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return p == root ? p : q;
    }
}
