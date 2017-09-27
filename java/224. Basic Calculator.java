// O(n)
class Solution {
    public int calculate(String s) {
        int len = s.length(), sign = 1, result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = 0;
                while (i < len && Character.isDigit(s.charAt(i))) {
                    sum = sum * 10 + s.charAt(i) - '0';
                    ++i;
                }
                result += sum * sign;
                --i;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                result = result * stack.pop() + stack.pop();
            }
        }
        return result;
    }
}
