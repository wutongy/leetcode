// O(m)
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        if (s.length() == t.length()) {
            return s.equals(t);
        }
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                ++i;
            }
            ++j;
        }
        return i == s.length();
    }
}

// binary search O(len(s) * log(len(t)))
class Solution {
    public boolean isSubsequence(String s, String t) {
        List<Integer>[] idx = new List[256];
        for (int i = 0; i < t.length(); ++i) {
            if (idx[t.charAt(i)] == null) {
                idx[t.charAt(i)] = new ArrayList<>();
            }
            idx[t.charAt(i)].add(i);
        }

        int prev = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (idx[s.charAt(i)] == null) {
                return false;
            }
            int j = Collections.binarySearch(idx[s.charAt(i)], prev);
            if (j < 0) {
                j = -j - 1;
            }
            if (j == idx[s.charAt(i)].size()) {
                return false;
            }
            prev = idx[s.charAt(i)].get(j) + 1;
        }
        return true;
    }
}
