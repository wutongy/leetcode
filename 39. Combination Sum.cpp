class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int> > res;
        vector<int> path;
        sort(candidates.begin(), candidates.end());
        helper(candidates, 0, target, path, res);
        return res;
    }

    void helper(vector<int>& candidates, int idx, int target, vector<int> path, vector<vector<int> > &res) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            res.push_back(path);
            return;
        } else if (candidates[idx] > target) {
            return;
        }
        while (idx < candidates.size()) {
            path.push_back(candidates[idx]);
            helper(candidates, idx, target - candidates[idx], path, res);
            path.pop_back();
            idx++;
        }
    }
};