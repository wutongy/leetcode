/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// O(nlogk)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        ListNode head, cur;
        head = cur = null;
        for (ListNode l : lists) {
            if (l != null) {
                pq.offer(l);
            }
        }
        while (!pq.isEmpty()) {
            ListNode l = pq.poll();
            if (head == null) {
                head = cur = l;
            } else {
                cur.next = l;
                cur = cur.next;
            }
            l = l.next;
            if (l != null) {
                pq.offer(l);
            }
        }
        return head;
    }
}
