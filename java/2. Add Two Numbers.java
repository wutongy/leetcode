/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// O(m + n)
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head, cur;
        head = cur = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = 0, n2 = 0;
            if (l1 != null) {
                n1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                n2 = l2.val;
                l2 = l2.next;
            }
            int sum = n1 + n2 + carry;
            ListNode newNode = new ListNode(sum % 10);
            if (head == null) {
                head = cur = newNode;
            } else {
                cur.next = newNode;
                cur = cur.next;
            }
            carry = sum / 10;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return head;
    }
}
