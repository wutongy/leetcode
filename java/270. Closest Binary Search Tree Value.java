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
    public int closestValue(TreeNode root, double target) {
        Double diff = Double.MAX_VALUE;
        int result = 0;
        TreeNode cur = root;
        while (cur != null) {
            double abs = Math.abs(target - cur.val);
            if (abs < diff) {
                diff = abs;
                result = cur.val;
            }
            if (cur.val > target) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return result;
    }
}
