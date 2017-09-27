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
    public List<List<Integer>> findLeaves(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(root, 0, res);
        return res;
    }

    private int helper(TreeNode root, int flag, ArrayList<List<Integer>> res) {
        if (root == null) {
            return 0;
        }
        int Dep = Math.max(helper(root.left, flag - 1, res), helper(root.right, flag - 1, res)) + 1;
        if (res.size() < Dep) {
            res.add(new ArrayList<Integer>());
        }
        res.get(Dep - 1).add(root.val);
        return Dep;
    }
}
