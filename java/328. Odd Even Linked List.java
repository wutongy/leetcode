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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode oddHead = head, evenHead = head.next, even = head.next;
        while (oddHead.next != null && evenHead != null && evenHead.next != null) {
            oddHead.next = oddHead.next.next;
            evenHead.next = evenHead.next.next;
            oddHead = oddHead.next;
            evenHead = evenHead.next;
        }
        oddHead.next = even;
        return head;
    }
}
