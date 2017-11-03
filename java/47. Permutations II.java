
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(nums, used, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int[] nums, boolean[] used, ArrayList<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (!used[i] && (i == 0 || nums[i] != nums[i - 1] || used[i - 1])) {
                used[i] = true;
                path.add(nums[i]);
                dfs(nums, used, path, res);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}
