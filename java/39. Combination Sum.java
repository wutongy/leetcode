class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, 0, target, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int[] candidates, int start, int target, ArrayList<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; ++i) {
            if (candidates[i] <= target) {
                path.add(candidates[i]);
                dfs(candidates, i, target - candidates[i], path, res);
                path.remove(path.size() - 1);
            }
        }
    }
}
