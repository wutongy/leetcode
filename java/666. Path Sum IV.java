// O(n)
class Solution {
    int sum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    public int pathSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int num : nums) {
            map.put(num / 10, num % 10);
        }
        traverse(nums[0] / 10, 0);
        return sum;
    }
    private void traverse(int root, int preSum) {
        int level = root / 10;
        int pos = root % 10;
        int left = (level + 1) * 10 + pos * 2 - 1;
        int right = (level + 1) * 10 + pos * 2;
        int curSum = preSum + map.get(root);
        if (!map.containsKey(left) && !map.containsKey(right)) {
            sum += curSum;
            return;
        }
        if (map.containsKey(left)) {
            traverse(left, curSum);
        }
        if (map.containsKey(right)) {
            traverse(right, curSum);
        }
    }
}
