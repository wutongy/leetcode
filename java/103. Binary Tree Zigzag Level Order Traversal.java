/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean forward = true;
        int size = 1;
        while (!q.isEmpty()) {
            LinkedList<Integer> curLevel = new LinkedList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode cur = q.poll();
                if (forward) {
                    curLevel.addLast(cur.val);
                } else {
                    curLevel.addFirst(cur.val);
                }
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
            res.add(curLevel);
            size = q.size();
            forward = !forward;
        }
        return res;
    }
}
