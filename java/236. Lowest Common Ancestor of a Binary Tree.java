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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> dqA = new ArrayDeque<>();
        Deque<TreeNode> dqB = new ArrayDeque<>();
        dfs(root, p, dqA);
        dfs(root, q, dqB);
        while (dqA.size() > dqB.size()) {
            dqA.pollLast();
        }
        while (dqB.size() > dqA.size()) {
            dqB.pollLast();
        }
        while (dqA.peekLast() != dqB.peekLast()) {
            dqA.pollLast();
            dqB.pollLast();
        }
        return dqA.peekLast();
    }

    private boolean dfs(TreeNode root, TreeNode target, Deque<TreeNode> dq) {
        if (root == null) {
            return false;
        }
        dq.offer(root);
        if (root == target || dfs(root.left, target, dq) || dfs(root.right, target, dq)) {
            return true;
        }
        dq.pollLast();
        return false;
    }
}
