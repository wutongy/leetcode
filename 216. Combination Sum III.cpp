class Solution {
public:
    vector<vector<int>> combinationSum3(int k, int n) {
        vector<vector<int> > res;
        vector<int> path;
        helper(k, n, path, res, 1);
        return res;
    }

    void helper(int cnt, int target, vector<int> path, vector<vector<int> > &res, int idx) {
        if (cnt == 0) {
            if (target == 0) {
                res.push_back(path);
            }
            return;
        } else if (target < 0 || idx > 9 || idx > target) {
            return;
        }
        for (int i = idx; i < 10; i++) {
            if (i > target) break;
            path.push_back(i);
            helper(cnt - 1, target - i, path, res, i + 1);
            path.pop_back();
        }
    }
};