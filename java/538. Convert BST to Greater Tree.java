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
    private int accum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode rnode = convertBST(root.right);
        TreeNode newRoot = new TreeNode(root.val  + accum);
        newRoot.right = rnode;
        accum += root.val;
        newRoot.left = convertBST(root.left);
        return newRoot;
    }
}
