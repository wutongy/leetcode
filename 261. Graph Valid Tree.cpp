//Solution1 (DFS)
class Solution {
public:
    bool validTree(int n, vector<pair<int, int>>& edges) {
        vector<vector<int>> neighbors(n, vector<int>{});
        for (pair<int, int>& p : edges) {
            neighbors[p.first].push_back(p.second);
            neighbors[p.second].push_back(p.first);
        }
        vector<bool> visited(n, false);
        if (hasCycle(neighbors, 0, -1, visited))
            return false;
        for (bool v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
    bool hasCycle(vector<vector<int>> &neighbors, int kid, int parent, vector<bool> &visited) {
        if (visited[kid]) return true;
        visited[kid] = true;
        for (auto &nbr : neighbors[kid]) {
            if (nbr != parent && hasCycle(neighbors, nbr, kid, visited))
                return true;
        }
        return false;
    }
};

//Solution2 (Union-Find)
class Solution {
private:
    int findParent(int cur, int parent[]) {
        while (cur != parent[cur]) {
            cur = parent[cur] = parent[parent[cur]];
        }
        return cur;
    }

public:
    bool validTree(int n, vector<pair<int, int>>& edges) {
        int parent[n], weight[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            weight[i] = 1;
        }
        for (auto e : edges) {
            int a = findParent(e.first, parent), b = findParent(e.second, parent);
            if (a == b) {
                return false;
            } else {
                if (weight[a] < weight[b]) { swap(a, b); }
                parent[b] = a, weight[a] += weight[b], n--;
            }
        }

        return n == 1;
    }
};

//Solution3: Another way to determine if cycle exists
class Solution {
public:
    bool validTree(int n, vector<pair<int, int> >& edges) {
        if (edges.size() != n - 1) return false;
        int component = 0;
        vector<int> v[n];
        vector<bool> visited(n, false);

        for (auto edge: edges) {
            v[edge.first].push_back(edge.second);
            v[edge.second].push_back(edge.first);
        }

        for (int i = 0; i < n ; i++) {
            if (!visited[i]) {
                ++component;
                DFS(v, visited, i);
            }
        }

        return component == 1;
    }

    void DFS(vector<int> v[], vector<bool>& visited, int index) {
        if (visited[index]) return;
        visited[index] = true;
        for (int j = 0; j < v[index].size(); ++j) {
            DFS(v, visited, v[index][j]);
        }
    }
};
