class Solution {
    public String parseTernary(String expression) {
        if (expression.length() == 0) {
            return "";
        }
        Stack<String> stack = new Stack<>();
        int i = expression.length() - 1, j = expression.length() - 1;
        while (i >= 0) {
            while (i >= 0 && expression.charAt(i) != ':' && expression.charAt(i) != '?') {
                --i;
            }
            if (i != j) {
                stack.push(expression.substring(i + 1, j + 1));
            }
            if (expression.charAt(i) == '?'){
                if (expression.charAt(i - 1) == 'T') {
                    String s1 = stack.pop();
                    stack.pop();
                    stack.push(s1);
                } else {
                    stack.pop();
                }
                i -= 2;
                j = i;
            } else {
                --i;
                j = i;
            }
        }
        return stack.pop();
    }
}
