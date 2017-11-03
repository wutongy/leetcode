// O(n)
class Solution {
    public int firstUniqChar(String s) {
        int res = -1;
        int[] idx = new int[26];
        Arrays.fill(idx, -1);
        for (int i = 0; i < s.length(); ++i) {
            if (idx[s.charAt(i) - 'a'] == -1) {
                idx[s.charAt(i) - 'a'] = i;
            } else {
                idx[s.charAt(i) - 'a'] = s.length();
            }
        }
        for (int i = 0; i < 26; ++i) {
            if (idx[i] >= 0 && idx[i] < s.length()) {
                if (res == -1) {
                    res = idx[i];
                } else {
                    res = Math.min(res, idx[i]);
                }
            }
        }
        return res;
    }
}
