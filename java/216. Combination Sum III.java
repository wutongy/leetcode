// O(2^9)
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(k, n, 1, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int k, int n, int start, ArrayList<Integer> path, List<List<Integer>> res) {
        if (k == 0) {
            if (n == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = start; i <= 9; ++i) {
            if (i <= n) {
                path.add(i);
                dfs(k - 1, n - i, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
}
