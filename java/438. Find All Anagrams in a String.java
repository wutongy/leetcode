class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] map = new int[26];
        Arrays.fill(map, -1);
        for (int i = 0; i < p.length(); ++i) {
            map[p.charAt(i) - 'a'] = Math.max(0, map[p.charAt(i) - 'a']) + 1;
        }
        int count = p.length();
        int i = 0, j = 0;
        while (j < s.length()) {
            if (map[s.charAt(j) - 'a'] < 0) {
                while (i < j) {
                    count++;
                    map[s.charAt(i) - 'a']++;
                    ++i;
                }
                i = j + 1;
            } else if (map[s.charAt(j) - 'a'] == 0) {
                while (i < j && s.charAt(i) != s.charAt(j)) {
                    map[s.charAt(i) - 'a']++;
                    count++;
                    ++i;
                }
                ++i;
            } else {
                --map[s.charAt(j) - 'a'];
                --count;
            }
            if (j - i + 1 == p.length() && count == 0) {
                    res.add(i);
            }
            ++j;
        }
        return res;
    }
}
