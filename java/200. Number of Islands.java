// O(mn)
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == '1') {
                    ++count;
                    floodfill(grid, i, j);
                }
            }
        }
        return count;
    }

    private void floodfill(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; ++k) {
            int ii = i + dirs[k];
            int jj = j + dirs[k + 1];
            if (ii >= 0 && ii < grid.length && jj >= 0 && jj < grid[i].length && grid[ii][jj] == '1') {
                floodfill(grid, ii, jj);
            }
        }
    }
}


class Solution {
    class UnionFind {
        int[] parent;
        int[] count;
        int total;
        UnionFind(int n) {
            parent = new int[n];
            count = new int[n];
            Arrays.fill(parent, -1);
            Arrays.fill(count, 1);
        }

        int find(int n) {
            while (parent[n] != n) {
                parent[n] = parent[parent[n]];
                n = parent[n];
            }
            return n;
        }

        void union(int nA, int nB) {
            int rootA = find(nA), rootB = find(nB);
            if (rootA != rootB) {
                --total;
                if (count[rootA] <= count[rootB]) {
                    parent[rootA] = rootB;
                    count[rootB] += count[rootA];
                } else {
                    parent[rootB] = rootA;
                    count[rootA] += count[rootB];
                }
            }
        }

        void add(int n) {
            parent[n] = n;
            ++total;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[] dirs = new int[]{-1, 0, -1};
        UnionFind uf = new UnionFind(m * n);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    uf.add(i * n + j);
                    for (int k = 0; k < 2; ++k) {
                        int ii = i + dirs[k];
                        int jj = j + dirs[k + 1];
                        if (ii >= 0 && jj >= 0 && grid[ii][jj] == '1') {
                            uf.union(i * n + j, ii * n + jj);
                        }
                    }
                }
            }
        }
        return uf.total;
    }
}
