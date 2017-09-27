// O(n) time, O(1) space
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        if (k >= s.length()) {
            return s.length();
        }
        int[] map = new int[256];
        int count = 0, maxLen = 0, begin = 0, end = 0;
        while (end < s.length()) {
            if (map[s.charAt(end++)]++ == 0) {
                ++count;
                while (count > k) {
                    if (--map[s.charAt(begin++)] == 0) {
                        --count;
                    }
                }
            }
            maxLen = Math.max(maxLen, end - begin);
        }
        return maxLen;
    }
}
