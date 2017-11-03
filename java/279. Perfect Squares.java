// O(n^(3/ 2))
class Solution {
    public int numSquares(int n) {
        if (n < 1) {
            return -1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            int num = i;
            for (int j = 1; j * j <= i; ++j) {
                num = Math.min(num, dp[i - j * j] + 1);
            }
            dp[i] = num;
        }
        return dp[n];
    }
}
