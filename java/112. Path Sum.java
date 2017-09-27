/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// iterative O(n)
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sums = new Stack<>();
        stack.push(root);
        sums.push(sum);
        while (!stack.isEmpty() && (root != null)) {
            int value = sums.pop();
            TreeNode top = stack.pop();
            if (top.left == null && top.right == null && top.val == value) {
                return true;
            }
            if (top.right != null) {
                stack.push(top.right);
                sums.push(value - top.val);
            }
            if (top.left != null) {
                stack.push(top.left);
                sums.push(value - top.val);
            }
        }
        return false;
    }
}
