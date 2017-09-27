// O(n)
class Solution {
    public String rearrangeString(String s, int k) {
        if (s == null || k < 2) {
            return s;
        }
        int[] validPosition = new int[26];
        int[] letterCounts = new int[26];
        char[] res = new char[s.length()];
        for (char c : s.toCharArray()) {
            ++letterCounts[c - 'a'];
        }
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int nextLetter = findNext(letterCounts, validPosition, i);
            if (nextLetter == -1) {
                return "";
            }
            res[i] = (char)('a' + nextLetter);
            validPosition[nextLetter] = i + k;
            --letterCounts[nextLetter];
        }
        return new String(res);
    }
    private int findNext(int[] letterCounts, int[] validPosition, int index) {
        int max = 0, res = -1;
        for (int i = 0; i < 26; ++i) {
            if (letterCounts[i] > max && validPosition[i] <= index) {
                res = i;
                max = letterCounts[i];
            }
        }
        return res;
    }
}
