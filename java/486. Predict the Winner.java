// O(2^n) time, O(n^2) space
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int n = nums.length;
        int dp[][] = new int[n][n];

        for (int i = 0; i < n; ++i) {
            dp[i][i] = nums[i];
        }
        for (int len = 1; len < n; ++len) {
            for (int i = 0; i < n - len; ++i) {
                int j = i + len;
                dp[i][j] = Math.max(nums[j] - dp[i][j - 1], nums[i] - dp[i + 1][j]);
            }
        }
        return dp[0][n - 1] >= 0;
    }
}
