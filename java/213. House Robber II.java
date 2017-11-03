// O(n)
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int start, int end) {
        int m1 = 0, m2 = 0;
        for (int i = start; i <= end; ++i) {
            int temp = m2;
            m2 = Math.max(m2, nums[i] + m1);
            m1 = temp;
        }
        return m2;
    }
}
