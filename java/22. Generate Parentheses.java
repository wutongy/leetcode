class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, n, n, new StringBuilder());
        return res;
    }

    private void helper(List<String> res, int leftP, int rightP, StringBuilder sb) {
        if (leftP == 0 && rightP == 0) {
            res.add(sb.toString());
            return;
        }
        if (leftP > 0) {
            sb.append("(");
            helper(res, leftP - 1, rightP, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rightP > leftP) {
            sb.append(")");
            helper(res, leftP, rightP - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
