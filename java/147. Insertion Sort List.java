/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// O(n^2)
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode helper = new ListNode(0);
        ListNode pre = helper;
        ListNode cur = head;
        while (cur != null) {
            pre = helper;
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return helper.next;
    }
}
