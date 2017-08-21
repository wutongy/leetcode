/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// O(n)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0;
        ListNode a = headA;
        while (a != null) {
            ++countA;
            a = a.next;
        }
        int countB = 0;
        ListNode b = headB;
        while (b != null) {
            ++countB;
            b = b.next;
        }
        while (countA > countB) {
            headA = headA.next;
            --countA;
        }
        while (countB > countA) {
            headB = headB.next;
            --countB;
        }
        while (headA != null && headB != null && headA.val != headB.val) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
