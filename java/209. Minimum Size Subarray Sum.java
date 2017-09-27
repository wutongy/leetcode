// O(n)
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int res = nums.length + 1;
        int i = 0, j = 0, sum = 0;
        while (j < nums.length) {
            sum += nums[j];
            if (sum >= s) {
                while (i < j && sum - nums[i] >= s) {
                    sum -= nums[i++];
                }
                res = Math.min(res, j - i + 1);
            }
            ++j;
        }
        return (res == nums.length + 1) ? 0 : res;
    }
}
