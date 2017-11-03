// HashMap O(n)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> used = new HashSet<>();
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(j)) {
                    return false;
                }
            } else if (used.contains(t.charAt(j))) {
                return false;
            } else {
                map.put(s.charAt(i), t.charAt(j));
                used.add(t.charAt(j));
            }
            ++i;
            ++j;
        }
        return true;
    }
}

//
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] m1 = new int[256], m2 = new int[256];
        for (int i = 0; i < s.length(); ++i) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
                return false;
            }
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
