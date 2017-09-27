// O(2 ^ n)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, 0, target, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int[] candidates, int start, int target, ArrayList<Integer> path, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; ++i) {
            if (i == start || candidates[i] != candidates[i - 1]) {
                path.add(candidates[i]);
                dfs(candidates, i + 1, target - candidates[i], path, res);
                path.remove(path.size() - 1);
            }
        }
    }
}
