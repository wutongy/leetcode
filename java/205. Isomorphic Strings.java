// O(n)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hmap = new HashMap<>();
        HashSet<Character> hset = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            if (hmap.containsKey(t.charAt(i))) {
                if (hmap.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }
            } else {
                if (hset.contains(s.charAt(i))) {
                    return false;
                }
                hmap.put(t.charAt(i), s.charAt(i));
                hset.add(s.charAt(i));
            }
        }
        return true;
    }
}

// O(n)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] m = new int[512];
        for (int i = 0; i < s.length(); i++) {
            if (m[s.charAt(i)] != m[t.charAt(i) + 256]) {
                return false;
            }
            m[s.charAt(i)] = m[t.charAt(i) + 256] = i + 1;
        }
        return true;
    }
}
