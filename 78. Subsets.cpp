class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int> > res;
        sort(nums.begin(), nums.end());
        vector<int> path;
        helper(nums, 0, path, res);
        return res;
    }

    void helper(vector<int>& nums, int idx, vector<int> path, vector<vector<int> > &res) {
        res.push_back(path);
        if (idx == nums.size()) {
            return;
        }
        for (int i = idx; i < nums.size(); i++) {
            if (i != idx && nums[i] == nums[i - 1])
                continue;
            path.push_back(nums[i]);
            helper(nums, i + 1, path, res);
            path.pop_back();
        }
    }
};