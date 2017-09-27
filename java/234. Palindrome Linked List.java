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
        ListNode slow = head, fast = head.next, prev = null;
        while (fast != null && fast.next != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
            fast = fast.next.next;
        }
        if (fast == null) {
            fast = slow.next;
            slow = prev;
        } else {
            fast = slow.next;
            slow.next = prev;
        }
        while (slow != null && fast != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}
