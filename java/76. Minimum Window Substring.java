// O(n)
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        String res = "";
        for (int i = 0; i < t.length(); ++i) {
            Character c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int i = 0, j = 0, count = t.length();
        while (j < s.length()) {
            if (map.containsKey(s.charAt(j))) {
                if (map.get(s.charAt(j)) > 0) {
                    --count;
                }
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                if (count == 0) {
                    while (i <= j) {
                        if (map.containsKey(s.charAt(i))) {
                            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                            if (map.get(s.charAt(i)) > 0) {
                                ++count;
                                break;
                            }
                        }
                        ++i;
                    }
                    if (res.length() == 0 || j - i + 1 < res.length()) {
                        res = s.substring(i, j + 1);
                    }
                    ++i;
                }
            }
            ++j;
        }
        return res;
    }
}
