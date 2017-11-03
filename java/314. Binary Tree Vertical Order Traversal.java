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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> depth = new LinkedList<>();
        nodes.offer(root);
        depth.offer(0);
        int min = 0;
        while (!nodes.isEmpty()) {
            TreeNode cur = nodes.poll();
            int curDepth = depth.poll();
            min = Math.min(min, curDepth);
            map.putIfAbsent(curDepth, new ArrayList<>());
            map.get(curDepth).add(cur.val);
            if (cur.left != null) {
                nodes.offer(cur.left);
                depth.offer(curDepth - 1);
            }
            if (cur.right != null) {
                nodes.offer(cur.right);
                depth.offer(curDepth + 1);
            }
        }
        List<List<Integer>> res = new ArrayList<>(map.size());
        for (int i = 0; i < map.size(); ++i) {
            res.add(map.get(min + i));
        }
        return res;
    }
}
