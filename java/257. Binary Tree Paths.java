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
public class Solution {
    private ArrayList<String> res = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return res;
        }
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            helper(root.left);
            helper(root.right);
        }
        return res;
    }

    private void helper(TreeNode cur) {
        if (cur == null) {
            return;
        }
        sb.append("->");
        sb.append(cur.val);
        if (cur.left == null && cur.right == null) {
            res.add(sb.toString());
        } else {
            helper(cur.left);
            helper(cur.right);
        }
        int ln = sb.length();
        sb.delete(ln - 2 - String.valueOf(cur.val).length(), ln);
    }
}
