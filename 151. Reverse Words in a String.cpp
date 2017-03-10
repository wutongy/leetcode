//Solution 1
class Solution {
public:
    void reverseWords(string &s) {
        int left, right;
        left = 0;
        while (left < s.size() && s[left] == ' ') {
            ++left;
        }
        right = s.size() - 1;
        while (right > left && s[right] == ' ') {
            --right;
        }
        reverse(s.begin() + left, s.begin() + right + 1);
        int curL = 0, curR = 0;
        while (left <= right) {
            if (curR != 0) {
                s[curR++] = ' ';
                curL = curR;
            }
            while (left <= right && s[left] != ' ') {
                s[curR] = s[left];
                ++curR, ++left;
            }
            reverse(s.begin() + curL, s.begin() + curR);
            do { left++; } while (left <= right && s[left] == ' ');
        }
        s.resize(curR);
    }
};

//Solution 2

void reverseWords(string &s) {
    istringstream is(s);
    string tmp;
    is >> s;
    while (is >> tmp) s = tmp + " " + s;
    if (s[0] == ' ') s = "";
}