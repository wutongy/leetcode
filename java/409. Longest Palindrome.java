// O(n)
class Solution {
    public int longestPalindrome(String s) {
        int[] counter = new int[52];
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) >= 'a') {
                ++counter[s.charAt(i) - 'a' + 26];
            } else {
                ++counter[s.charAt(i) - 'A'];
            }
        }
        boolean hasOddCounter = false;
        int res = 0;
        for (int i = 0; i < 52; ++i) {
            if (counter[i] % 2 == 0) {
                res += counter[i];
            } else {
                hasOddCounter = true;
                res += counter[i] - 1;
            }
        }
        return res + (hasOddCounter ? 1 : 0);
    }
}
