/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
// O(n) time O(1) space
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode copyNode = new RandomListNode(cur.label);
            copyNode.next = cur.next;
            cur.next = copyNode;
            cur = cur.next.next;
        }
        RandomListNode newHead = head.next;
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        while (cur != null) {
            RandomListNode temp = cur.next.next;
            cur.next.next = cur.next.next == null ? null : cur.next.next.next;
            cur.next = temp;
            cur = cur.next;
        }
        return newHead;
    }
}

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
// hashmap based O(n) time O(n) space
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<Integer, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head, newHead = null;
        while (cur != null) {
            RandomListNode newNode = new RandomListNode(cur.label);
            if (newHead == null) {
                newHead = newNode;
            }
            map.put(cur.label, newNode);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            RandomListNode rln = map.get(cur.label);
            if (cur.next != null) {
                rln.next = map.get(cur.next.label);
            }
            if (cur.random != null) {
                rln.random = map.get(cur.random.label);
            }
            cur = cur.next;
        }
        return newHead;
    }
}
