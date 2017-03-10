class Solution {
public:
    bool isOneEditDistance(string s, string t) {
        int diff = s.size() - t.size();
        diff = diff > 0 ? diff : -diff;
        if (diff > 1 || s == t) return false;
        int i = 0, j = 0;
        bool edited = false;
        while (i < s.size() && j < t.size()) {
            if (s[i] != t[j]) {
                if (edited) return false;
                edited = true;
                if (s.size() >= t.size()) {
                    i++;
                }
                if (s.size() <= t.size()) {
                    j++;
                }
            } else {
                i++;
                j++;
            }
        }
        return true;
    }
};