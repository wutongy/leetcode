/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// stack based O(n) time
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            if (cur == null) {
                cur = stack.pop();
                cur = cur.left;
            } else {
                res.addFirst(cur.val);
                stack.push(cur);
                cur = cur.right;
            }
        }
        return res;
    }
}

// Morris traversal O(n) time O(1) space
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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.right == null) {
                res.addFirst(cur.val);
                cur = cur.left;
            } else {
                TreeNode post = cur.right;
                while (post.left != null && post.left != cur) {
                    post = post.left;
                }
                if (post.left == null) {
                    post.left = cur;
                    res.addFirst(cur.val);
                    cur = cur.right;
                } else {
                    post.left = null;
                    cur = cur.left;
                }
            }
        }
        return res;
    }
}
