// O(mn)
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i <= s.length(); ++i) {
            for (int j = 1; j <= p.length(); ++j) {
                if (i != 0 && (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) && dp[i - 1][j - 1]) {
                    dp[i][j] = true;
                }
                if (p.charAt(j - 1) == '*' && (dp[i][j - 1] || (i > 0 && dp[i - 1][j]))) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
