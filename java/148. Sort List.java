/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// O(nlogn) merge sort
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow, fast;
        slow = head;
        fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode n = slow.next;
        slow.next = null;
        ListNode h1 = sortList(head);
        ListNode h2 = sortList(n);
        ListNode newHead, cur;
        if (h1.val <= h2.val) {
            newHead = cur = h1;
            h1 = h1.next;
        } else {
            newHead = cur = h2;
            h2 = h2.next;
        }
        while (h1 != null || h2 != null) {
            if (h2 == null || (h1 != null && h1.val <= h2.val)) {
                cur.next = h1;
                cur = cur.next;
                h1 = h1.next;
            } else {
                cur.next = h2;
                cur = cur.next;
                h2 = h2.next;
            }
        }
        return newHead;
    }
}
