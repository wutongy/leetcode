// O(n)
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (max > 0) {
                max += nums[i];
            } else {
                max = nums[i];
            }
            res = Math.max(res, max);
        }
        return res;
    }
}
