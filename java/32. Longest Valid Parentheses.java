// O(n) stack
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int maxL = 0;
        int left = -1;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    left = i;
                } else {
                    stack.pop();
                    maxL = Math.max(maxL, stack.isEmpty() ? i - left : i - stack.peek());
                }
            }
        }
        return maxL;
    }
}

// dp O(n)
class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        int curMax = 0;
        int[] longest = new int[s.length()];
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == ')' && i - longest[i - 1] - 1 >= 0 && s.charAt(i - longest[i - 1] - 1) == '(') {
                longest[i] = longest[i - 1] + 2 + ((i - longest[i - 1] - 2 >= 0) ? longest[i - longest[i - 1] - 2] : 0);
                curMax = Math.max(longest[i], curMax);
            }
        }
        return curMax;
    }
}
