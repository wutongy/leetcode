/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
// O(n) time O(1) space
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode head = null, prev = null;
        while (root != null || head != null) {
            if (root == null) {
                root = head;
                head = prev = null;
            } else {
                if (root.left != null) {
                    if (head == null) {
                        head = prev = root.left;
                    } else {
                        prev.next = root.left;
                        prev = prev.next;
                    }
                }
                if (root.right != null) {
                    if (head == null) {
                        head = prev = root.right;
                    } else {
                        prev.next = root.right;
                        prev = prev.next;
                    }
                }
                root = root.next;
            }
        }
    }
}
