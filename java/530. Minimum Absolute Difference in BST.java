/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int getMinimumDifference(TreeNode root) {
        int result = Integer.MAX_VALUE;
        TreeNode preNode;
        TreeNode cur, pre;
        cur = pre = preNode = null;
        if (root == null) {
            return result;
        }
        cur = root;
        while (cur != null) {
            if (cur.left == null) {
                if (preNode != null) {
                    result = Math.min(result, cur.val - preNode.val);
                }
                preNode = cur;
                cur = cur.right;
            } else {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    result = Math.min(result, cur.val - preNode.val);
                    preNode = cur;
                    cur = cur.right;
                }
            }
        }
        return result;
    }
}
