// O(n)
class Solution {
    private boolean isAlphaNumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !isAlphaNumeric(s.charAt(i))) {
                ++i;
            }
            while (i < j && !isAlphaNumeric(s.charAt(j))) {
                --j;
            }
            if (i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }
}
