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
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        String lnode = tree2str(t.left);
        String rnode = tree2str(t.right);
        StringBuffer strBuf = new StringBuffer(String.valueOf(t.val));
        if (!lnode.equals("")) {
            strBuf.append("(").append(lnode).append(")");
            if (!rnode.equals("")) {
                strBuf.append("(").append(rnode).append(")");
            }
        } else if (!rnode.equals("")) {
            strBuf.append("()(").append(rnode).append(")");
        }
        return strBuf.toString();
    }
}

public class Solution {
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        helper(sb,t);
        return sb.toString();
    }
    public void helper(StringBuilder sb,TreeNode t){
        if(t!=null){
            sb.append(t.val);
            if(t.left!=null||t.right!=null){
                sb.append("(");
                helper(sb,t.left);
                sb.append(")");
                if(t.right!=null){
                    sb.append("(");
                helper(sb,t.right);
                sb.append(")");
                }
            }
        }
    }
}
