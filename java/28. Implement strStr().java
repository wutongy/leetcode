// O(mn)
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        } else if (haystack.length() == 0 || haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); ++i) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 1;
                while (j < needle.length()) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                    ++j;
                }
                if (j == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }
}
