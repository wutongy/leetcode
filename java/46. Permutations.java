// O(n!)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new ArrayList<Integer>(), res, new HashSet<Integer>());
        return res;
    }

    private void dfs(int[] nums, ArrayList<Integer> path, List<List<Integer>> res, HashSet<Integer> used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int n : nums) {
            if (!used.contains(n)) {
                used.add(n);
                path.add(n);
                dfs(nums, path, res, used);
                path.remove(path.size() - 1);
                used.remove(n);
            }
        }
    }
}
