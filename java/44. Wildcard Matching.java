// O(mn)
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i <= s.length(); ++i) {
            for (int j = 1; j <= p.length(); ++j) {
                char c = p.charAt(j - 1);
                if (c != '*') {
                    dp[i][j] = i > 0 && dp[i - 1][j - 1] && (c == '?' || c == s.charAt(i - 1));
                } else {
                    dp[i][j] = (i > 0 && dp[i - 1][j]) || dp[i][j - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
