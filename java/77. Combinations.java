class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(1, n, k, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int start, int n, int k, ArrayList<Integer> path, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; ++i) {
            path.add(i);
            dfs(i + 1, n, k - 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}
