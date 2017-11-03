// O(k)
class Solution {
    class UnionFind {
        int[] parent;
        int[] count;
        int num;

        UnionFind(int size) {
            num = 0;
            parent = new int[size];
            Arrays.fill(parent, -1);
            count = new int[size];
            Arrays.fill(count, 1);
        }

        int find(int node) {
            while (node != parent[node]) {
                parent[node] = parent[parent[node]];
                node = parent[node];
            }
            return node;
        }

        void union(int nA, int nB) {
            int rootA = find(nA);
            int rootB = find(nB);
            if (rootA != rootB) {
                if (count[rootA] <= count[rootB]) {
                    parent[rootA] = rootB;
                    count[rootB] += count[rootA];
                } else {
                    parent[rootB] = rootA;
                    count[rootA] += count[rootB];
                }
                --num;
            }
        }

        void addIsland(int i) {
            parent[i] = i;
            ++num;
        }

        int getCount() {
            return num;
        }
    }
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (m == 0 || n == 0 || positions.length == 0) {
            return res;
        }
        UnionFind uf = new UnionFind(m * n);
        int[] dirs = new int[]{-1, 0, 1, 0, -1};
        for (int i = 0; i < positions.length; ++i) {
            uf.addIsland(positions[i][0] * n + positions[i][1]);
            for (int j = 0; j < 4; ++j) {
                int ii = positions[i][0] + dirs[j];
                int jj = positions[i][1] + dirs[j + 1];
                if (ii >= 0 && ii < m && jj >= 0 && jj < n && uf.parent[ii * n + jj] != -1) {
                    uf.union(positions[i][0] * n + positions[i][1], ii * n + jj);
                }
            }
            res.add(uf.getCount());
        }
        return res;
    }
}
