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
        if (m == n) {
            return head;
        }
        ListNode before = null, cur = head;
        int i = 1;
        while (i < m) {
            before = cur;
            cur = cur.next;
            ++i;
        }
        ListNode prev = cur, tail = cur;
        cur = cur.next;
        while (i < n) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            ++i;
        }
        tail.next = cur;
        if (before != null) {
            before.next = prev;
            return head;
        }
        return prev;
    }
}
