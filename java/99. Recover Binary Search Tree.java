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
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode n1, n2, cur, before;
        n1 = n2 = before = null;
        cur = root;
        while (cur != null) {
            if (cur.left == null) {
                if (before != null && before.val >= cur.val) {
                    if (n1 == null) {
                        n1 = before;
                        n2 = cur;
                    } else {
                        n2 = cur;
                        //break;
                    }
                }
                before = cur;
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else if (prev.right == cur) {
                    prev.right = null;
                    if (before != null && before.val >= cur.val) {
                        if (n1 == null) {
                            n1 = before;
                            n2 = cur;
                        } else {
                            n2 = cur;
                            //break;
                        }
                    }
                    before = cur;
                    cur = cur.right;
                }
            }
        }
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
}
