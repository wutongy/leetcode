class Solution {
public:
    string countAndSay(int n) {
        string s = "1";
        for (int i = 2; i <= n; i++) {
            char target;
            int cnt = 0, pos = 0;
            string tmp = "";
            while (pos < s.size()) {
                if (cnt == 0) {
                    target = s[pos];
                    cnt = 1;
                } else if (s[pos] == target) {
                    cnt++;
                } else {
                    tmp += to_string(cnt) + target;
                    cnt = 1;
                    target = s[pos];
                }
                pos++;
            }
            tmp += to_string(cnt) + target;
            s.swap(tmp);
        }
        return s;
    }
};