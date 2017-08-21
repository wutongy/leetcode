// O(n)
public class Solution {
    public int countSegments(String s) {
       int count = 0;
       for (int i = 0; i < s.length();) {
           while (i < s.length() && s.charAt(i) == ' ') {
               ++i;
           }
           if (i >= s.length()) {
               break;
           }
           ++count;
           while (i < s.length() && s.charAt(i) != ' ') {
               ++i;
           }
        }
        return count;
    }
}
