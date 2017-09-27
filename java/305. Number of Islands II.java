// Union Find
class Solution {
    private class UnionFind {
        int[] pos;
        int[] weight;
        int count;
        UnionFind(int m, int n) {
            count = 0;
            pos = new int[m * n];
            weight = new int[m * n];
            Arrays.fill(pos, -1);
        }

        int find(int n) {
            while (pos[n] != n) {
                pos[n] = pos[pos[n]];
                n = pos[n];
            }
            return n;
        }

        void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                --count;
                if (weight[i] <= weight[j]) {
                    pos[rootI] = rootJ;
                    if (weight[i] == weight[j]) {
                        ++weight[j];
                    }
                } else {
                    pos[rootJ] = rootI;
                }
            }
        }
    }
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        UnionFind uf = new UnionFind(m, n);
        int[] dirs = new int[]{-1, 0, 1, 0, -1};
        for (int i = 0; i < positions.length; ++i) {
            ++uf.count;
            int j = positions[i][0], k = positions[i][1];
            uf.pos[j * n + k] = j * n + k;
            for (int x = 0; x < 4; ++x) {
                int jj = j + dirs[x], kk = k + dirs[x + 1];
                if (jj >= 0 && jj < m && kk >= 0 && kk < n && uf.pos[jj * n + kk] != -1) {
                    uf.union(j * n + k, jj * n + kk);
                }
            }
            res.add(uf.count);
        }
        return res;
    }
}
