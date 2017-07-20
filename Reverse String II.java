// O(n)
public class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder result = new StringBuilder();
        int start = 0;
        while ((s.length() - start) >= 2 * k) {
            result.append(new StringBuilder(s.substring(start, start + k)).reverse());
            result.append(s.substring(start + k, start + 2 * k));
            start += 2 * k;
        }
        if (s.length() - start <= k) {
            result.append(new StringBuilder(s.substring(start, s.length())).reverse());
        } else {
            result.append(new StringBuilder(s.substring(start, start + k)).reverse());
            result.append(s.substring(start + k, s.length()));
        }
        return result.toString();
    }
}
