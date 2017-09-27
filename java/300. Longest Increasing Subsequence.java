// O(nlogn)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int n : nums) {
            int i = Arrays.binarySearch(dp, 0, len, n);
            if (i < 0) {
                i = - (i + 1);
            }
            dp[i] = n;
            if (i == len) {
                ++len;
            }
        }
        return len;
    }
}
