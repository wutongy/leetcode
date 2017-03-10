class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<pair<int, int>>& edges) {
        vector<unordered_set<int>> graph(n);
        for (auto e : edges) {
            graph[e.first].insert(e.second);
            graph[e.second].insert(e.first);
        }
        vector<int> degree(n, 0);
        for (int i = 0; i < n; i++) degree[i] = graph[i].size();
        for (int remain = n, j; remain> 2; ) {
            vector<int> del;
            for (j = 0; j < n; j++) {
                if (degree[j] == 1) {
                    remain--;
                    del.push_back(j);
                    degree[j] = -1;
                }
            }
            for (auto k : del) {
                for (auto neigh : graph[k]) {
                    degree[neigh]--;
                }
            }
        }
        vector<int> res;
        for (int i = 0; i < n; i++) {
            if (degree[i] >= 0) {
                res.push_back(i);
            }
        }
        return res;
    }
};