// O(n)
class Solution {
    public int romanToInt(String s) {
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] vals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int i = 0, j = 0, res = 0;
        while (j < s.length()) {
            if (j + symbols[i].length() <= s.length() && s.substring(j, j + symbols[i].length()).equals(symbols[i])) {
                res += vals[i];
                j += symbols[i].length();
            } else {
                ++i;
            }
        }
        return res;
    }
}
