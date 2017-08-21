// O(n^2)
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int i = s.length() / 2;
        while (i >= 1) {
            if (s.length() % i == 0) {
                String cur = s.substring(0, i);
                int j;
                for (j = 2 * i; j <= s.length(); j += i) {
                    if (!s.substring(j - i, j).equals(cur)) {
                        break;
                    }
                }
                if (j > s.length()) {
                    return true;
                }
            }
            --i;
        }
        return false;
    }
}
