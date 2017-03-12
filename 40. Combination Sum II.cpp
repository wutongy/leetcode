class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<vector<int> > res;
        sort(candidates.begin(), candidates.end());
        vector<int> path;
        helper(candidates, 0, target, path, res);
        return res;
    }

    void helper(vector<int> &candidates, int idx, int target, vector<int> path, vector<vector<int> > &res) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            res.push_back(path);
            return;
        } else if (idx >= candidates.size() || candidates[idx] > target) {
            return;
        }
        for (int i = idx; i < candidates.size(); i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;
            path.push_back(candidates[i]);
            helper(candidates, i + 1, target - candidates[i], path, res);
            path.pop_back();
        }
    }
};