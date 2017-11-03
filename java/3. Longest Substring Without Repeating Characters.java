// O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0, res = 0;
        while (j < s.length()) {
            if (set.contains(s.charAt(j))) {
                while (s.charAt(i) != s.charAt(j)) {
                    set.remove(s.charAt(i));
                    ++i;
                }
                ++i;
            } else {
                set.add(s.charAt(j));
            }
            res = Math.max(res, j - i + 1);
            ++j;
        }
        return res;
    }
}
