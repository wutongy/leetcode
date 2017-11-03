class Solution {
    public int[][] imageSmoother(int[][] M) {
        int[][] res = new int[M.length][M[0].length];
        int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};;
        for (int i = 0; i < M.length; ++i) {
            for (int j = 0; j < M[0].length; ++j) {
                int count = 1, sum = M[i][j];
                for (int k = 0; k < 8; ++k) {
                    int ii = i + dirs[k][0];
                    int jj = j + dirs[k][1];
                    if (ii >= 0 && ii < M.length && jj >= 0 && jj < M[0].length) {
                        sum += M[ii][jj];
                        ++count;
                    }
                }
                res[i][j] = sum / count;
            }
        }
        return res;
    }
}
