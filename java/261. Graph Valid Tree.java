class Solution {
    private class UnionFind {
        int[] parent;
        int[] weight;
        int count;
        UnionFind(int n) {
            parent = new int[n];
            weight = new int[n];
            count = n;
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
            Arrays.fill(weight, 1);
        }

        int find(int cur) {
            while (parent[cur] != cur) {
                parent[cur] = parent[parent[cur]];
                cur = parent[cur];
            }
            return cur;
        }

        boolean union(int nA, int nB) {
            int rootA = parent[nA];
            int rootB = parent[nB];
            if (rootA == rootB) {
                return false;
            }
            --count;
            if (weight[rootA] <= weight[rootB]) {
                parent[rootA] = rootB;
                weight[rootB] += weight[rootA];
            } else {
                parent[rootB] = rootA;
                weight[rootA] += weight[rootB];
            }
            return true;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < edges.length; ++i) {
            if (!uf.union(edges[i][0], edges[i][1])) {
                return false;
            }
        }
        return uf.count == 1;
    }
}
