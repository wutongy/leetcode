/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// O(n)
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            ++len;
            cur = cur.next;
        }
        k %= len;
        if (k == 0) {
            return head;
        }
        cur = head;
        ListNode fast = head;
        int i = 0;
        while (i < k) {
            fast = fast.next;
            ++i;
        }
        while (fast.next != null) {
            cur = cur.next;
            fast = fast.next;
        }
        ListNode newHead = cur.next;
        fast.next = head;
        cur.next = null;
        return newHead;
    }
}
