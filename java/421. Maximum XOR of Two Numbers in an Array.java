// O(n)
class Solution {
    class Node {
        Node[] children;
        public Node() {
            children = new Node[2];
        }
    }
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Node root = new Node();
        for (int num : nums) {
            Node cur = root;
            for (int i = 31; i >= 0; --i) {
                int curBit = (num >>> i) & 1;
                if (cur.children[curBit] == null) {
                    cur.children[curBit] = new Node();
                }
                cur = cur.children[curBit];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            Node cur = root;
            int sum = 0;
            for (int i = 31; i >= 0; --i) {
                int curBit = (num >>> i) & 1;
                if (cur.children[curBit ^ 1] != null) {
                    sum |= (1 << i);
                    cur = cur.children[curBit ^ 1];
                } else {
                    cur = cur.children[curBit];
                }
                if (sum < max && max - sum >= (1 << i) - 1) {
                    break;
                }
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
