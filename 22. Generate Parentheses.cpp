class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> res;
        string path = "";
        DFS(n, 0, path, res);
        return res;
    }

    void DFS(int left, int unMatch, string &path, vector<string> &res) {
        if (left == 0 && unMatch == 0) {
            res.push_back(path);
            return;
        }
        if (left > 0) {
            path.push_back('(');
            DFS(left - 1, unMatch + 1, path, res);
            path.pop_back();
        }
        if (unMatch > 0) {
            path.push_back(')');
            DFS(left, unMatch - 1, path, res);
            path.pop_back();
        }
    }
};