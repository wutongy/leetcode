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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        ListNode fake_head = new ListNode(0);
        fake_head.next = head;
        ListNode pre = fake_head;
        for (int i = 0; i < m - 1; ++i) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode prev = null;
        for (int i = 0; i <= n - m; ++i) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        pre.next.next = cur;
        pre.next = prev;
        ListNode newHead = fake_head.next;
        fake_head.next = null;
        return newHead;
    }
}
