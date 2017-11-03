// O(n) time O(1) space
class Solution {
    public String removeDuplicateLetters(String s) {
        char[] stack = new char[26];
        boolean[] inStack = new boolean[128];
        int[] cnt = new int[128];
        int top = -1, len = s.length();
        for (int i = 0; i < len; ++i) {
            ++cnt[s.charAt(i)];
        }
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (inStack[c]) {
                --cnt[c];
                continue;
            }
            while (top >= 0 && cnt[stack[top]] > 0 && stack[top] > c) {
                inStack[stack[top--]] = false;
            }
            stack[++top] = c;
            inStack[c] = true;
            --cnt[c];
        }
        return String.valueOf(stack, 0, top + 1);
    }
}
