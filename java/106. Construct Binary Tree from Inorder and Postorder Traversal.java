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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length - 1, postorder, postorder.length - 1, map);
    }

    private TreeNode helper(int[] inorder, int istart, int iend, int[] postorder, int pend, HashMap<Integer, Integer> map) {
        if (istart > iend) {
            return null;
        } else if (istart == iend) {
            return new TreeNode(inorder[istart]);
        }
        TreeNode cur = new TreeNode(postorder[pend]);
        int idx = map.get(postorder[pend]);
        cur.left = helper(inorder, istart, idx - 1, postorder, pend - (iend - idx + 1), map);
        cur.right = helper(inorder, idx + 1, iend, postorder, pend - 1, map);
        return cur;
    }
}
