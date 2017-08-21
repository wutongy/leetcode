/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// O(n)
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head, cur;
        head = cur = null;
        while (l1 != null || l2 != null) {
            ListNode nxt = l1;
            if (l1 == null || (l2 != null && l1.val > l2.val)) {
                nxt = l2;
                l2 = l2.next;
            } else {
                l1 = l1.next;
            }
            if (head == null) {
                head = cur = nxt;
            } else {
                cur.next = nxt;
                cur = nxt;
            }
        }
        return head;
    }
}
