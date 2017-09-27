// O(n)
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++count[s.charAt(i) - 'a'];
        }
        for (int i = 0; i < t.length(); ++i) {
            if (count[t.charAt(i) - 'a']-- == 0) {
                return false;
            }
        }
        return s.length() == t.length();
    }
}
