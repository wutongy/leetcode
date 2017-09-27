// O(n)
class Solution {
    public String simplifyPath(String path) {
        Deque<String> dq = new LinkedList<>();
        int i = 0;
        while (i < path.length()) {
            if (path.charAt(i) != '/') {
                int j = i + 1;
                while (j < path.length() && path.charAt(j) != '/') {
                    ++j;
                }
                String s = path.substring(i, j);
                if (s.equals("..")) {
                    if (!dq.isEmpty()) {
                        dq.pollLast();
                    }
                } else if (!s.equals(".")) {
                    dq.offer(s);
                }
                i = j;
            }
            ++i;
        }
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append('/');
            sb.append(dq.poll());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
