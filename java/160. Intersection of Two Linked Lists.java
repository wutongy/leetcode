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
        int lenA = 0, lenB = 0;
        ListNode curA = headA, curB = headB;
        while (curA != null) {
            ++lenA;
            curA = curA.next;
        }
        while (curB != null) {
            ++lenB;
            curB = curB.next;
        }
        while (lenA > lenB) {
            headA = headA.next;
            --lenA;
        }
        while (lenB > lenA) {
            headB = headB.next;
            --lenB;
        }
        while (headA != null && headB != null && headA.val != headB.val) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA == null ? null : headA;
    }
}

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //boundary check
    if(headA == null || headB == null) return null;

    ListNode a = headA;
    ListNode b = headB;

    //if a & b have different len, then we will stop the loop after second iteration
    while( a != b){
        //for the end of first iteration, we just reset the pointer to the head of another linkedlist
        a = a == null? headB : a.next;
        b = b == null? headA : b.next;
    }

    return a;
}
