// O(n)
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0, j = 0, sum = 0, res = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= s && i <= j) {
                res = Math.min(res, j - i + 1);
                sum -= nums[i++];
            }
            ++j;
        }
        return res != Integer.MAX_VALUE ? res : 0;
    }
}
