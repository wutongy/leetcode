class Solution {
public:
    bool isValid(string s) {
        string open = "({[", close = ")}]";
        stack<char> stk;
        for (int i = 0; i < s.size(); i++) {
            auto pos = close.find(s[i]);
            if (pos != string::npos) {
                if (!stk.empty() && open[pos] == stk.top()) {
                    stk.pop();
                } else {
                    return false;
                }
            } else {
                stk.push(s[i]);
            }
        }
        return stk.empty() ? true : false;
    }
};