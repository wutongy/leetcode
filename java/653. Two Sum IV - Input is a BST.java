/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// O(n）
public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        Set<Integer> hset = new HashSet<>();
        ArrayList<TreeNode> stack = new ArrayList<>();
        stack.add(root);
        while (stack.size() != 0) {
            TreeNode cur = stack.remove(0);
            if (hset.contains(k - cur.val)) {
                return true;
            }
            hset.add(cur.val);
            if (cur.left != null) {
                stack.add(cur.left);
            }
            if (cur.right != null) {
                stack.add(cur.right);
            }
        }
        return false;
    }
}
