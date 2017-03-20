//Solution1
class Solution {
public:
    string longestPalindrome(string s) {
        const int size_s = s.size();
        int max_s = 0, max_l = 0;
        for (int i = 0; i < size_s;) {
            int start = i, end = i;
            while (end + 1 < size_s && s[end] == s[end + 1]) end++;
            i = end + 1;
            while (start - 1 >= 0 && end + 1 < size_s && s[start - 1] == s[end + 1]) {
                start--;
                end++;
            }
            if (end - start + 1 > max_l) {
                max_l = end - start + 1;
                max_s = start;
            }
        }
        return s.substr(max_s, max_l);
    }
};

//Solution2
string longestPalindrome(string s) {
    if (s.empty()) return "";
    string prep = "#";
    for (auto ch : s) {
        prep += ch;
        prep += "#";
    }
    const int size_p = prep.size();
    vector<int> dp(size_p, 0);
    int center = 0, bCur = 0;
    for (int i = 0; i < size_p; i++) {
        int mirror = center - (i - center);
        dp[i] = bCur <= i ? 0 : min(bCur - i, dp[mirror]);
        int start = i - dp[i], end = i + dp[i];
        while (start - 1 >= 0 && end + 1 < size_p && prep[start - 1] == prep[end + 1]) {
            --start;
            ++end;
            ++dp[i];
        }
        if (i + dp[i] > bCur) {
            bCur = i + dp[i];
            center = i;
        }
    }
    center = max_element(dp.begin(), dp.end()) - dp.begin();
    return s.substr((center - dp[center])/2, dp[center]);
}