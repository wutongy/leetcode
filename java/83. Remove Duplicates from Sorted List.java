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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode after = head.next;
        while (after != null) {
            if (after.val != cur.val) {
                cur.next = after;
                cur = after;
            }
            after = after.next;
        }
        cur.next = null;
        return head;
    }
}
