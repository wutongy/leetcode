// O(mn)
class Solution {
    private class UnionFind {
        int[] parent;
        int[] count;
        int total;
        UnionFind(int num) {
            total = num;
            parent = new int[num];
            for (int i = 0; i < num; ++i) {
                parent[i] = i;
            }
            count = new int[num];
            Arrays.fill(count, 1);
        }

        int findRoot(int s) {
            while (parent[s] != s) {
                parent[s] = parent[parent[s]];
                s = parent[s];
            }
            return s;
        }

        void union(int s1, int s2) {
            int rootA = findRoot(s1);
            int rootB = findRoot(s2);
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

        int getTotal() {
            return total;
        }
    }
    public int findCircleNum(int[][] M) {
        UnionFind uf = new UnionFind(M.length);
        for (int i = 0; i < M.length - 1; ++i) {
            for (int j = i + 1; j < M.length; ++j) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getTotal();
    }
}
