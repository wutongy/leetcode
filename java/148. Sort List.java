/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// O(nlogn) merge sort
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(fast));
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = null, cur = null;
        while (l1 != null || l2 != null) {
            ListNode next;
            if (l2 == null || (l1 != null && l1.val <= l2.val)) {
                next = l1;
                l1 = l1.next;
            } else {
                next = l2;
                l2 = l2.next;
            }
            if (head == null) {
                head = cur = next;
            } else {
                cur.next = next;
                cur = cur.next;
            }
        }
        return head;
    }
}
