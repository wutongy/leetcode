// O(n)
class Solution {
    public int lengthLongestPath(String input) {
        int res = 0, len = 0;
        String[] strs = input.split("\n");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < strs.length; ++i) {
            int depth = 0;
            int j = 0;
            while (j < strs[i].length() && strs[i].charAt(j) == '\t') {
                ++depth;
                ++j;
            }
            while (!stack.isEmpty() && stack.size() > depth) {
                len -= stack.pop().length();
            }
            stack.push(strs[i].substring(j));
            len += stack.peek().length();
            int index = stack.peek().indexOf(".");
            if (index != -1 && index != stack.peek().length() - 1) {
                res = Math.max(res, len + stack.size() - 1);
            }
        }
        return res;
    }
}
