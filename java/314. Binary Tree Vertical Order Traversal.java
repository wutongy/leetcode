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
    private class Node {
        TreeNode node;
        int idx;
        Node(TreeNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        int minIdx = 0, maxIdx = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0));
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            map.putIfAbsent(n.idx, new ArrayList<>());
            map.get(n.idx).add(n.node.val);
            minIdx = Math.min(minIdx, n.idx);
            maxIdx = Math.max(maxIdx, n.idx);
            if (n.node.left != null) {
                queue.offer(new Node(n.node.left, n.idx - 1));
            }
            if (n.node.right != null) {
                queue.offer(new Node(n.node.right, n.idx +1));
            }
        }
        List<List<Integer>> res = new ArrayList<>(maxIdx - minIdx + 1);
        for (int i = minIdx; i <= maxIdx; ++i) {
            res.add(map.get(i));
        }
        return res;
    }
}
