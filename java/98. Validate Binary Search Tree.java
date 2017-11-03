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
    public boolean isValidBST(TreeNode root) {
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur == null) {
                cur = stack.pop();
                if (pre != null && pre.val >= cur.val) {
                    return false;
                }
                pre = cur;
                cur = cur.right;
            } else {
                stack.push(cur);
                cur = cur.left;
            }
        }
        return true;
    }
}
