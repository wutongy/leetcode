// O(n^2)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (f[j] && dict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        HashSet<String> words = new HashSet<>(wordDict);
        return backtrack(s, 0, words, map);
    }

    private boolean backtrack(String s, int start, HashSet<String> words, HashMap<Integer, Boolean> map) {
        if (map.containsKey(start)) {
            return false;
        }
        if (start == s.length()) {
            return true;
        }
        for (int i = s.length(); i >= start + 1; --i) {
            if (words.contains(s.substring(start, i))) {
                if (backtrack(s, i, words, map)) {
                    return true;
                }
            }
        }
        map.put(start, false);
        return false;
    }
}
