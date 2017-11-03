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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }
        ListNode before = null, cur = head, end = head, newHead = head;
        int count = 1;
        while (end != null) {
            while (count < k && end.next != null) {
                ++count;
                end = end.next;
            }
            if (count != k) {
                break;
            }
            count = 1;
            ListNode after = end.next;
            ListNode prev = cur, tail = cur;
            cur = cur.next;
            while (prev != end) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            if (newHead == head) {
                newHead = prev;
            }
            if (before != null) {
                before.next = prev;
            }
            before = tail;
            tail.next = cur;
            end = cur;
        }
        return newHead;
    }
}
