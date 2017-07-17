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
    int accum = 0;
    public int findTilt(TreeNode root) {
        sumOfTree(root);
        return accum;
    }

    public int sumOfTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lSum = sumOfTree(node.left);
        int rSum = sumOfTree(node.right);
        accum += Math.abs(lSum - rSum);
        return node.val + lSum + rSum;
    }
}
