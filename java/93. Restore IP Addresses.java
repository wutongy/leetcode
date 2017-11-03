class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(s, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void dfs(String s, int start, int part, StringBuilder sb, List<String> res) {
        if (part == 4) {
            if (start == s.length()) {
                res.add(sb.toString());
            }
            return;
        }
        int sum = 0;
        int len = sb.length();
        for (int i = start; i < s.length(); ++i) {
            sum = sum * 10 + (s.charAt(i) - '0');
            if (sum < 256) {
                int curLen = sb.length();
                if (part != 0) {
                    sb.append(".");
                }
                sb.append(sum);
                dfs(s, i + 1, part + 1, sb, res);
                sb.setLength(curLen);
                if (i == start && s.charAt(i) == '0') {
                    break;
                }
            } else {
                break;
            }
        }
        sb.setLength(len);
    }
}
