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

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// merge sort O(avglen(n)logk)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1) {
            return null;
        }
        return partition(lists, 0, lists.length - 1);
    }

    private ListNode partition(ListNode[] lists, int s, int e) {
        if (s == e) {
            return lists[s];
        }
        int mid = s + (e - s) / 2;
        return merge(partition(lists, s, mid), partition(lists, mid + 1, e));
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
