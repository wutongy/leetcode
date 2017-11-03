/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// O(n)
public class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode cur;
    public BSTIterator(TreeNode root) {
        cur = root;
        stack = new Stack<>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        while (cur != null || !stack.isEmpty()) {
            if (cur == null) {
                cur = stack.pop();
                return true;
            } else {
                stack.push(cur);
                cur = cur.left;
            }
        }
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        int res = cur.val;
        cur = cur.right;
        return res;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Morris Traversal O(1) time O(1) space
public class BSTIterator {
    TreeNode cur;
    public BSTIterator(TreeNode root) {
        cur = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cur != null;
    }

    /** @return the next smallest number */
    public int next() {
        while (cur != null) {
            if (cur.left == null) {
                int res = cur.val;
                cur = cur.right;
                return res;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    int res = cur.val;
                    cur = cur.right;
                    return res;
                }
            }
        }
        return -1;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
