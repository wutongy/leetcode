class Solution {
public:
    int uniquePaths(int m, int n) {
        if (m >= n) swap(m, n);
        vector<int> paths(m, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                paths[j] += paths[j - 1];
            }
        }
        return paths[m - 1];
    }
};