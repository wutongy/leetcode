/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
// O(n)
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode cur, nextHead;
        nextHead = root;
        cur = null;
        while (nextHead != null) {
            if (cur == null) {
                cur = nextHead;
                nextHead = cur.left;
            } else {
                cur.left.next = cur.right;
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
        }
    }
}
