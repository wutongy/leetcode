/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// O(m + n)
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, cur = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            if (head == null) {
                head = cur = new ListNode(val % 10);
            } else {
                cur.next = new ListNode(val % 10);
                cur = cur.next;
            }
            carry = val / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return head;
    }
}
