/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// O(n^2)
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if ((s == null) && (t == null)) {
            return true;
        } else if ((s == null) || (t == null)) {
            return false;
        } else if (s.val == t.val) {
            if (helper(s, t)) {
                return true;
            }
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean helper(TreeNode s, TreeNode t) {
        if ((s == null) && (t == null)) {
            return true;
        } else if ((s == null) || (t == null)) {
            return false;
        } else if (s.val != t.val) {
            return false;
        }
        return helper(s.left, t.left) && helper(s.right, t.right);
    }
}

// O(n + m) Time O(n+m) Space
public boolean isSubtree(TreeNode s, TreeNode t) {
    // Use KMP to ensure linear time
    return serialize(s).contains(serialize(t));
}

public String serialize(TreeNode root) {
    StringBuilder res = new StringBuilder();
    serialize(root, res);
    return res.toString();
}

private void serialize(TreeNode cur, StringBuilder res) {
    if (cur == null) {
        res.append(",#");
        return;
    }
    res.append("," + cur.val);
    serialize(cur.left,res);
    serialize(cur.right, res);
}
