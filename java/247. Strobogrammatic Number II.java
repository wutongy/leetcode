class Solution {
    public List<String> findStrobogrammatic(int n) {
        String middle = "018";
        String outer = "0186969810";
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        dfs((n - 1) / 2, n / 2, middle, outer, "", res);
        return res;
    }

    private void dfs(int left, int right, String middle, String outer, String cur, List<String> res) {
        if (left == -1) {
            res.add(cur);
            return;
        }
        if (left == right) {
            for (int i = 0; i < middle.length(); ++i) {
                dfs(left - 1, right + 1, middle, outer, cur + middle.charAt(i), res);
            }
        } else {
            for (int i = 0; i < outer.length() / 2; ++i) {
                if (outer.charAt(i) != '0' || (left != 0)) {
                    dfs(left - 1, right + 1, middle, outer, outer.charAt(i) + cur + outer.charAt(outer.length() - 1 - i), res);
                }
            }
        }
    }
}
