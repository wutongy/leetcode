class Solution {
public:
    int strStr(string haystack, string needle) {
        int bound = haystack.size() - needle.size() + 1;
        for (int i = 0; i < bound; i++) {
            int j = 0;
            while (j < needle.size() && haystack[i + j] == needle[j])
                j++;
            if (j == needle.size())
                return i;
        }
        return -1;
    }
};