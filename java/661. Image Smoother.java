// O(mn)
class Solution {
    private int[][] mx;
    public int[][] imageSmoother(int[][] M) {
        int[][] result = new int[M.length][M[0].length];
        mx = M;
        for (int i = 0; i < M.length; ++i) {
            for (int j = 0; j < M[0].length; ++j) {
                int accum = 0, count = 0;
                for (int x = -1; x <= 1; ++x) {
                    for (int y = -1; y <= 1; ++y) {
                        int temp = helper(i + x, j + y);
                        if (temp >= 0) {
                            accum += temp;
                            ++count;
                        }
                    }
                }
                result[i][j] = accum / count;
            }
        }
        return result;
    }

    private int helper(int i, int j) {
        if (i < 0 || i >= mx.length || j < 0 || j >= mx[0].length) {
            return  -1;
        }
        return mx[i][j];
    }
}
