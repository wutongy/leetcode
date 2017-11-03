// O(n)
class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        int sign = 1, i = 0;
        long sum = 0;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            if (str.charAt(0) == '-') {
                sign = -1;
            }
            ++i;
        }
        while (i < str.length()) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) (sign * sum);
            }
            sum = sum * 10 + (str.charAt(i) - '0');
            if (sign == 1 && sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && sign * sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            ++i;
        }
        return (int) (sign * sum);
    }
}
