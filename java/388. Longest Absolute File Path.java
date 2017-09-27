// stack O(n)
class Solution {
    public int lengthLongestPath(String input) {
        Stack<String> stack = new Stack<>();
        String[] ss = input.split("\\n");
        int prevTab = -1;
        int len = 0, maxLen = 0;
        for (int i = 0; i < ss.length; ++i) {
            int j = 0, count = 0;
            while (ss[i].charAt(j) == '\t') {
                ++j;
                ++count;
            }
            if (count <= prevTab) {
                while (prevTab >= count) {
                    String s = stack.pop();
                    if (s.length() == len) {
                        len = 0;
                    } else {
                        len -= 1 + s.length();
                    }
                    --prevTab;
                }
            }
            stack.push(ss[i].substring(j));
            if (len != 0) {
                ++len;
            }
            len += ss[i].length() - j;
            prevTab = count;
            int index = ss[i].indexOf(".");
            if (index != -1 && index != ss[i].length() - 1) {
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}

// use array instead of stack
class Solution {
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        int[] stack = new int[paths.length + 1];
        int maxLen = 0;
        for (String s: paths) {
            int lev = s.lastIndexOf("\t") + 1, curLen = stack[lev + 1] = stack[lev] + s.length() - lev + 1;
            if (s.contains(".")) {
                maxLen = Math.max(maxLen, curLen - 1);
            }
        }
        return maxLen;
    }
}
