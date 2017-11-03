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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null, prev = null, cur = head;
        while (cur != null && cur.next != null) {
            if (prev == null) {
                prev = newHead = cur.next;
            } else {
                prev.next = cur.next;
                prev = prev.next;
            }
            ListNode temp = cur.next.next;
            cur.next.next = cur;
            cur.next = temp;
            prev = prev.next;
            cur = cur.next;
        }
        return newHead;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// recursion
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head.next.next;
        ListNode newHead = head.next;
        head.next.next = head;
        head.next = swapPairs(tail);
        return newHead;
    }
}
