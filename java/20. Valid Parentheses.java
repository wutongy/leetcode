// O(n)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        String starts = "({[", ends = ")}]";
        for (int i = 0; i < s.length(); ++i) {
            int index;
            if ((index = starts.indexOf(s.charAt(i))) != -1) {
                stack.push(ends.charAt(index));
            } else if (stack.isEmpty() || stack.pop() != s.charAt(i)) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
