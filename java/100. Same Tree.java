/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 */
// O(n)
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null) ^ (q == null)) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// serialize O(n)
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        StringBuilder sp = new StringBuilder();
        StringBuilder sq = new StringBuilder();
        preOrder(p, sp);
        preOrder(q, sq);
        return sp.toString().equals(sq.toString());
    }

    private void preOrder(TreeNode cur, StringBuilder sb) {
        if (cur == null) {
            sb.append(",#");
            return;
        }
        if (sb.length() != 0) {
            sb.append(",");
        }
        sb.append(cur.val);
        preOrder(cur.left, sb);
        preOrder(cur.right, sb);
    }
}
