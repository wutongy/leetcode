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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                --k;
                if (k == 0) {
                    return cur.val;
                }
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    --k;
                    if (k == 0) {
                        return cur.val;
                    }
                    cur = cur.right;
                }
            }
        }
        return -1;
    }
}
