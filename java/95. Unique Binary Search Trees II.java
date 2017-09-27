/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// O(n!)
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<TreeNode>();
        }
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        } else if (start == end) {
            res.add(new TreeNode(start));
            return res;
        }
        for (int i = start; i <= end; ++i) {
            List<TreeNode> ltrees = helper(start, i - 1);
            List<TreeNode> rtrees = helper(i + 1, end);
            for (TreeNode left : ltrees) {
                for (TreeNode right : rtrees) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = left;
                    cur.right = right;
                    res.add(cur);
                }
            }
        }
        return res;
    }
}
