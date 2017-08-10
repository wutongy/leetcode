/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> list = new LinkedList<>();
        addLevel(list, 1, root);
        return list;
    }

    private void addLevel(LinkedList<List<Integer>> list, int level, TreeNode node) {
        if (node == null) {
            return;
        }
        if (list.size() < level) {
            list.addFirst(new LinkedList<Integer>());
        }
        list.get(list.size() - level).add(node.val);
        addLevel(list, level + 1, node.left);
        addLevel(list, level + 1, node.right);
    }
}
