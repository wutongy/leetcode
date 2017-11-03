// O(n)
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length() == 0 || k == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 1, i = 0, j = 0;
        while (j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            if (map.size() > k) {
                while (map.size() > k) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if (map.get(s.charAt(i)) == 0) {
                        map.remove(s.charAt(i));
                    }
                    ++i;
                }
            }
            ++j;
            res = Math.max(res, j - i);
        }
        return res;
    }
}
