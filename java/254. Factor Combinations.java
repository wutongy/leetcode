class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 2) {
            return res;
        }
        helper(n, new ArrayList<Integer>(), 2, res);
        return res;
    }

    private void helper(int n, ArrayList<Integer> path, int cur, List<List<Integer>> res) {
        if (n < 2) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (path.size() != 0) {
            path.add(n);
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
        }
        for (int i = cur; i <= (int)Math.sqrt(n); ++i) {
            if (n % i == 0) {
                path.add(i);
                helper(n / i, path, i, res);
                path.remove(path.size() - 1);
            }
        }
    }
}
