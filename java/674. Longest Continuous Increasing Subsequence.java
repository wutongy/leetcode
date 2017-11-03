// O(n)
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int res = 1, len = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) {
                ++len;
            } else {
                res = Math.max(res, len);
                len = 1;
            }
        }

        return Math.max(res, len);
    }
}
