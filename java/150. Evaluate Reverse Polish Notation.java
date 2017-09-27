// O(n)
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) {
                stack.push(Integer.valueOf(s));
            } else {
                Integer n1 = stack.pop();
                Integer n2 = stack.pop();
                if (s.equals("+")) {
                    stack.push(n2 + n1);
                } else if (s.equals("-")) {
                    stack.push(n2 - n1);
                } else if (s.equals("*")) {
                    stack.push(n2 * n1);
                } else {
                    stack.push(n2 / n1);
                }
            }
        }
        return stack.pop();
    }
}
