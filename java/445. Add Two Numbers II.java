/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    class Res {
        int carry;
        ListNode next;
        Res(int val, ListNode n) {
            carry = val;
            next = n;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1, n2 = l2;
        int len1 = 0, len2 = 0;
        while (n1 != null) {
            ++len1;
            n1 = n1.next;
        }
        while (n2 != null) {
            ++len2;
            n2 = n2.next;
        }
        ListNode newHead = null;
        Res res = helper(l1, len1, l2, len2);
        if (res.carry != 0) {
            newHead = new ListNode(res.carry);
            newHead.next = res.next;
        } else {
            newHead = res.next;
        }
        return newHead;
    }

    private Res helper(ListNode l1, int len1, ListNode l2, int len2) {
        if (len1 == 0 && len2 == 0) {
            return new Res(0, null);
        }
        Res nextRes;
        ListNode cur;
        if (len1 != len2) {
            if (len1 > len2) {
                cur = new ListNode(l1.val);
                nextRes = helper(l1.next, len1 - 1, l2, len2);
            } else {
                cur = new ListNode(l2.val);
                nextRes = helper(l1, len1, l2.next, len2 - 1);
            }
        } else {
            cur = new ListNode(l1.val + l2.val);
            nextRes = helper(l1.next, len1 - 1, l2.next, len2 - 1);
        }
        cur.next = nextRes.next;
        cur.val += nextRes.carry;
        int carry = cur.val / 10;
        cur.val %= 10;
        return new Res(carry, cur);
    }
}
