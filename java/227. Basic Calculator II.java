// O(n) time O(1) space
class Solution {
    public int calculate(String s) {
        int res = 0, prevNum = 0;
        char prevOp = '+';
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    ++i;
                }
                --i;
                if (prevOp == '+') {
                    res += num;
                    prevNum = num;
                } else if (prevOp == '-') {
                    res -= num;
                    prevNum = -1 * num;
                } else if (prevOp == '*') {
                    res -= prevNum;
                    prevNum *= num;
                    res += prevNum;
                } else if (prevOp == '/') {
                    res -= prevNum;
                    prevNum /= num;
                    res += prevNum;
                }
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                prevOp = s.charAt(i);
            }
            ++i;
        }
        return res;
    }
}
