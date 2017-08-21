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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            ++count;
            cur = cur.next;
        }
        cur = head;
        ListNode prev = null, next = head.next, fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
            fast = fast.next.next;
        }
        cur.next = prev;
        if (count % 2 != 0) {
            next = next.next;
        }
        while (cur != null) {
            if (cur.val != next.val) {
                return false;
            }
            cur = cur.next;
            next = next.next;
        }
        return true;
    }
}
