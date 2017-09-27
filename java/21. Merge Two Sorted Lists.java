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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode head, cur;
        if (l1.val <= l2.val) {
            head = cur = l1;
            l1 = l1.next;
        } else {
            head = cur = l2;
            l2 = l2.next;
        }
        while (l1 != null || l2 != null) {
            if (l2 == null || (l1 != null && l1.val <= l2.val)) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        return head;
    }
}
