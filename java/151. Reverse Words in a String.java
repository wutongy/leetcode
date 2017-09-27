// O(n)
public class Solution {
    public String reverseWords(String s) {
        int i = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            int j = i;
            while (j >= 0 && s.charAt(j) == ' ') {
                --j;
            }
            if (j >= 0) {
                i = j;
                while (j >= 0 && s.charAt(j) != ' ') {
                    --j;
                }
                if (sb.length() != 0) {
                    sb.append(" ");
                }
                sb.append(s.substring(j + 1, i + 1));
            }
            i = j;
        }
        return sb.toString();
    }
}
