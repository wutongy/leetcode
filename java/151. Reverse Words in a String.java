// O(n)
public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int j = s.length() - 1;
        while (j >= 0) {
            while (j >= 0 && s.charAt(j) == ' ') {
                --j;
            }
            if (j >= 0) {
                int i = j - 1;
                while (i >= 0 && s.charAt(i) != ' ') {
                    --i;
                }
                if (sb.length() != 0) {
                    sb.append(" ");
                }
                sb.append(s.substring(i + 1, j + 1));
                j = i - 1;
            }
        }
        return sb.toString();
    }
}
