// O(n)
class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }
        HashMap<Character, String> hmap = new HashMap<>();
        HashSet<String> hset = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (hmap.containsKey(pattern.charAt(i))) {
                if (!hmap.get(pattern.charAt(i)).equals(strs[i])) {
                    return false;
                }
            } else if (hset.contains(strs[i])) {
                return false;
            } else {
                hset.add(strs[i]);
                hmap.put(pattern.charAt(i), strs[i]);
            }
        }
        return true;
    }
}

public boolean wordPattern(String pattern, String str) {
    String[] words = str.split(" ");
    if (words.length != pattern.length()) {
        return false;
    }
    Map index = new HashMap();
    for (Integer i = 0; i < words.length; ++i) {
        if (index.put(pattern.charAt(i), i) != index.put(words[i], i)) {
            return false;
        }
    }
    return true;
}
