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
    public ListNode partition(ListNode head, int x) {
        ListNode less, greater, lhead, ghead;
        lhead = ghead = less = greater = null;
        while (head != null) {
            if (head.val < x) {
                if (less == null) {
                    lhead = head;
                    less = head;
                } else {
                    less.next = head;
                    less = less.next;
                }
            } else {
                if (greater == null) {
                    ghead = head;
                    greater = head;
                } else {
                    greater.next = head;
                    greater = greater.next;
                }
            }
            head = head.next;
        }
        if (greater != null) {
            greater.next = null;
        }
        if (lhead != null) {
            less.next = ghead;
            return lhead;
        }
        return ghead;
    }
}
