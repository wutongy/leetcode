// O(n^2)
class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int len = 0;
        for (int i = 0; i < s.length(); ++i) {
            int j = i, k = i;
            while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
                --j;
                ++k;
            }
            if (k - j - 1 > len) {
                len = k - j - 1;
                res = s.substring(j + 1, k);
            }
            j = i;
            k = i + 1;
            while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
                --j;
                ++k;
            }
            if (k - j - 1 > len) {
                len = k - j - 1;
                res = s.substring(j + 1, k);
            }
        }
        return res;
    }
}


// dp O(n^2)
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = null;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}
