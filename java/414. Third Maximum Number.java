// O(n) time, O(1) space
class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int maxNum = Integer.MIN_VALUE;
        for (int num : nums) {
            if (!pq.contains(num)) {
                maxNum = Math.max(maxNum, num);
                pq.add(num);
                if (pq.size() > 3) {
                    pq.poll();
                }
            }
        }
        return pq.size() == 3 ? pq.poll() : maxNum;
    }
}
