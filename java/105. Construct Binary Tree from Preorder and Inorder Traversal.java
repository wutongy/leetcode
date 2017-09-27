/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// O(n^2)
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int pstart, int[] inorder, int istart, int iend) {
        if (istart > iend) {
            return null;
        } else if (istart == iend) {
            return new TreeNode(inorder[istart]);
        }
        TreeNode cur = new TreeNode(preorder[pstart]);
        int i = istart;
        while (i <= iend) {
            if (inorder[i] == preorder[pstart]) {
                break;
            }
            ++i;
        }
        cur.left = helper(preorder, pstart + 1, inorder, istart, i - 1);
        cur.right = helper(preorder, pstart + i - istart + 1, inorder, i + 1, iend);
        return cur;
    }
}
