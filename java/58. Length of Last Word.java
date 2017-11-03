// O(n)
class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            --i;
        }
        if (i >= 0) {
            int j = i - 1;
            while (j >= 0 && s.charAt(j) != ' ') {
                --j;
            }
            return i - j;
        }
        return 0;
    }
}
