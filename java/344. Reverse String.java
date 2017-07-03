public class Solution {
    public String reverseString(String s) {
//         StringBuilder sb = new StringBuilder(s);
//         return sb.reverse().toString();
        char[] ca = s.toCharArray();
        int begin = 0, end = s.length() - 1;
        while (begin < end) {
            char c = ca[begin];
            ca[begin] = ca[end];
            ca[end] = c;
            begin++;
            end--;
        }
        return new String(ca);
    }
}
