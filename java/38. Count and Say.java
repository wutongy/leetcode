//
class Solution {
    public String countAndSay(int n) {
        StringBuilder cur = new StringBuilder();
        StringBuilder next;
        cur.append("1");
        for (int i = 1; i < n; ++i) {
            next = new StringBuilder();
            int j = 0;
            while (j < cur.length()) {
                int k = j + 1;
                while (k < cur.length() && cur.charAt(k) == cur.charAt(k - 1)) {
                    ++k;
                }
                next.append(k - j);
                next.append(cur.charAt(j));
                j = k;
            }
            cur = next;
        }
        return cur.toString();
    }
}
