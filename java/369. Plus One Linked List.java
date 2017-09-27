/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode notNine = null;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val != 9) {
                notNine = cur;
            }
            cur = cur.next;
        }
        ++cur.val;
        if (cur.val == 10) {
            cur.val = 0;
            if (notNine == null) {
                cur = head;
                while (cur != null) {
                    cur.val = 0;
                    cur = cur.next;
                }
                ListNode newHead = new ListNode(1);
                newHead.next = head;
                return newHead;
            } else {
                ++notNine.val;
                notNine = notNine.next;
                while (notNine != null) {
                    notNine.val = 0;
                    notNine = notNine.next;
                }
            }
        }
        return head;
    }
}
