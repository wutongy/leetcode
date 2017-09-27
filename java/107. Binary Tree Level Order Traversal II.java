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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1, nextCount = 0;
        res.addFirst(new ArrayList<>());
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            res.getFirst().add(cur.val);
            --count;
            if (cur.left != null) {
                queue.offer(cur.left);
                nextCount++;
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                nextCount++;
            }
            if (count == 0 && nextCount != 0) {
                count = nextCount;
                nextCount = 0;
                res.addFirst(new ArrayList<>());
            }
        }
        return res;
    }
}
