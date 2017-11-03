// O(n^3)
class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int l = 2; l <= n; ++l) {
            for (int i = 1; i + (l - 1) <= n; ++i) {
                dp[i][i + (l - 1)] = Integer.MAX_VALUE;
                for (int j = i; j <= i + (l - 1); ++j) {
                    int cost = 0;
                    if (j == n) {
                        cost = j + dp[i][j - 1];
                    } else {
                        cost = j + Math.max(dp[i][j - 1], dp[j + 1][i + (l - 1)]);
                    }
                    dp[i][i + (l - 1)] = Math.min(dp[i][i + (l - 1)], cost);
                }
            }
        }
        return dp[1][n];
    }
}
