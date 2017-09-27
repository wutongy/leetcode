// O(n) UnionFind
class Solution {
    private class UnionFind {
        int count;
        int[] parent, rank;

        UnionFind(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        int find(int i) {
            while (parent[i] != i) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            if (rank[rootP] > rank[rootQ]) {
                parent[rootQ] = rootP;
            } else {
                parent[rootP] = rootQ;
                if (rank[rootP] == rank[rootQ]) {
                    rank[rootQ] += rank[rootP];
                }
            }
            --count;
        }

        int getCount() {
            return count;
        }
    }
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < edges.length; ++i) {
            uf.union(edges[i][0], edges[i][1]);
        }
        return uf.getCount();
    }
}
