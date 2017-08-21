// O(n)
public class Solution {
    public String countAndSay(int n) {
        StringBuilder prev = new StringBuilder("1");
        StringBuilder result = prev;
        for (int i = 1; i < n; i++) {
            result = new StringBuilder();
            int j = 0;
            while (j < prev.length()) {
                char c = prev.charAt(j);
                int count = 1;
                ++j;
                while (j < prev.length() && prev.charAt(j) == c) {
                    ++j;
                    ++count;
                }
                result.append(count);
                result.append(c);
            }
            prev = result;
        }
        return result.toString();
    }
}
