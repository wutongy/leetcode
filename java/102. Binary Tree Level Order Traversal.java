/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// O(n) time, O(n) space
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        int count = 1, nextCount = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        res.add(new ArrayList<>());
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            --count;
            res.get(res.size() - 1).add(cur.val);
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
                res.add(new ArrayList<>());
            }
        }
        return res;
    }
}
