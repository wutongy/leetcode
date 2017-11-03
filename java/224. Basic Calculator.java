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

class Solution {
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> signs = new Stack<>();
        int sum = 0;
        Character sign = '+';
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ' ') {
                continue;
            } else if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    ++i;
                }
                sum = calc(sum, sign, num);
                --i;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                sign = s.charAt(i);
            } else if (s.charAt(i) == '(') {
                nums.push(sum);
                sum = 0;
                signs.push(sign);
                sign = '+';
            } else if (s.charAt(i) == ')') {
                sum = calc(nums.pop(), signs.pop(), sum);
            }
        }
        return sum;
    }

    private int calc(int num1, Character op, int num2) {
        if (op == '+') {
            return num1 + num2;
        }
        return num1 - num2;
    }
}
