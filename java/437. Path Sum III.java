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
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0, 1);
        return helper(root, 0, sum, hmap);
    }

    private int helper(TreeNode root, int curSum, int target, HashMap<Integer, Integer> hmap) {
        if (root == null) {
            return 0;
        }
        curSum += root.val;
        int res = hmap.getOrDefault(curSum - target, 0);
        hmap.put(curSum, hmap.getOrDefault(curSum, 0) + 1);
        res += helper(root.left, curSum, target, hmap) + helper(root.right, curSum, target, hmap);
        hmap.put(curSum, hmap.get(curSum) - 1);
        return res;
    }
}
