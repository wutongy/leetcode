// O(n^3)
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n][n];
        for (int k = 1; k <= n; ++k) {
            for (int left = 0; left + k - 1 < n; ++left) {
                int right = left + k - 1;
                int max = 0;
                for (int i = left; i <= right; ++i) {
                    int leftNum = left == 0 ? 1 : nums[left - 1];
                    int rightNum = right == n - 1 ? 1 : nums[right + 1];
                    int leftSum = (i == left) ? 0 : dp[left][i - 1];
                    int rightSum = (i == right) ? 0 : dp[i + 1][right];
                    max = Math.max(max, leftNum * nums[i] * rightNum + leftSum + rightSum);
                }
                dp[left][right] = max;
            }
        }
        return dp[0][n - 1];
    }
}
