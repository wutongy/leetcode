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
    private int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> me : map.entrySet()) {
            if (me.getValue() == max) {
                res.add(me.getKey());
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    private int helper(TreeNode n, Map<Integer, Integer> map) {
        if (n == null) {
            return 0;
        }
        int sum = helper(n.left, map) + helper(n.right, map) + n.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        max = Math.max(max, map.get(sum));
        return sum;
    }
}
