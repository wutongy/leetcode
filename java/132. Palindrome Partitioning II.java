// O(n^2) time O(n) space
class Solution {
    public int minCut(String s) {
        if (s.length() < 2) {
            return 0;
        }
        int[] cut = new int[s.length() + 1];
        for (int i = 0; i <= s.length(); ++i) {
            cut[i] = i - 1;
        }
        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; i - j >= 0 && i + j < s.length() && s.charAt(i - j) == s.charAt(i + j); ++j) {
                cut[i + j + 1] = Math.min(cut[i + j + 1], cut[i - j] + 1);
            }
            for (int j = 1; i - j + 1 >= 0 && i + j < s.length() && s.charAt(i - j + 1) == s.charAt(i + j); ++j) {
                cut[i + j + 1] = Math.min(cut[i + j + 1], 1 + cut[i - j + 1]);
            }
        }
        return cut[s.length()];
    }
}
