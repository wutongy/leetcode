class Solution {
public:
    bool isPalindrome(string s) {
        int left = 0, right = s.size() - 1;
        while (left < right) {
            while (left < right && !isalnum(s[left])) left++;
            while (left < right && !isalnum(s[right])) right--;
            if (left < right) {
                if (toupper(s[left]) != toupper(s[right])) return false;
                left++;
                right--;
            }
        }
        return true;
    }
};