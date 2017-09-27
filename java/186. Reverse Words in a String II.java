// O(n)
public class Solution {
    public void reverseWords(char[] s) {
        int i = 0, j = 0;
        while (j < s.length) {
            while (j < s.length && s[j] != ' ') {
                ++j;
            }
            for (int k = j - 1; k > i; --k, ++i) {
                char c = s[i];
                s[i] = s[k];
                s[k] = c;
            }
            ++j;
            i = j;
        }
        i = 0;
        j = s.length - 1;
        while (i < j) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
            ++i;
            --j;
        }
    }
}
