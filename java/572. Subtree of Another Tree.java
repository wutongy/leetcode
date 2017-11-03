/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// O(m + n)
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return serialize(s).contains(serialize(t));
    }

    private String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur == null) {
                sb.append(",#");
                continue;
            }
            sb.append(",");
            sb.append(cur.val);
            stack.push(cur.right);
            stack.push(cur.left);
        }
        return sb.toString();
    }
}
