// O(n)
class Solution {
    private boolean isAlphanumeric(char a) {
        if ((a >= 'a' && a <= 'z') || (a >='A' && a <= 'Z') || (a >= '0' && a <= '9')) {
            return true;
        }
        return false;
    }
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !isAlphanumeric(s.charAt(i))) {
                ++i;
            }
            while (i < j && !isAlphanumeric(s.charAt(j))) {
                --j;
            }
            if (i != j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }
}
