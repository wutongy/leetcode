// O(2^n)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, n, new StringBuilder(), res);
        return res;
    }

    private void backtrack(int start, int end, StringBuilder sb, List<String> res) {
        if (start == 0 && end == 0) {
            res.add(sb.toString());
            return;
        }
        if (start > 0) {
            sb.append("(");
            backtrack(start - 1, end, sb, res);
            sb.setLength(sb.length() - 1);
        }
        if (end > start) {
            sb.append(")");
            backtrack(start, end - 1, sb, res);
            sb.setLength(sb.length() - 1);
        }
    }
}
