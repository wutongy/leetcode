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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        int queueSize = 1;
        while (queueSize > 0) {
            int maxNum = Integer.MIN_VALUE;
            for (int i = 0; i < queueSize; ++i) {
                TreeNode cur = queue.pollLast();
                maxNum = Math.max(maxNum, cur.val);
                if (cur.left != null) {
                    queue.addFirst(cur.left);
                }
                if (cur.right != null) {
                    queue.addFirst(cur.right);
                }
            }
            result.add(maxNum);
            queueSize = queue.size();
        }
        return result;
    }
}
