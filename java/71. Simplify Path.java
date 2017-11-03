// O(n)
class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        int i = 0;
        while (i < path.length()) {
            while (i < path.length() && path.charAt(i) == '/') {
                ++i;
            }
            if (i >= path.length()) {
                break;
            }
            int j = i + 1;
            while (j < path.length() && path.charAt(j) != '/') {
                ++j;
            }
            String s = path.substring(i, j);
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!s.equals(".")) {
                stack.push(s);
            }
            i = j + 1;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/");
            sb.append(stack.pollLast());
        }
        if (sb.length() == 0) {
            sb.append("/");
        }
        return sb.toString();
    }
}
