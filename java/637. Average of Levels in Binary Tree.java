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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> bfs = new ArrayList<>();
        bfs.add(root);
        while(bfs.size() != 0) {
            List<TreeNode> newBFS = new ArrayList<>();
            long accum = 0;
            for (int i = 0; i < bfs.size(); i++) {
                TreeNode cur = bfs.get(i);
                accum += cur.val;
                if (cur.left != null) {
                    newBFS.add(cur.left);
                }
                if (cur.right != null) {
                    newBFS.add(cur.right);
                }
            }
            result.add((double)accum / bfs.size());
            bfs = newBFS;
        }
        return result;
    }
}
