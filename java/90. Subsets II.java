// O(2^n)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int[] nums, int start, ArrayList<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; ++i) {
            if (i == start || nums[i] != nums[i - 1]) {
                path.add(nums[i]);
                dfs(nums, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
}
