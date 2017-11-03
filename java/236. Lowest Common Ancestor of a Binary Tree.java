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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        parent.put(root, null);
        stack.push(root);
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }
}
