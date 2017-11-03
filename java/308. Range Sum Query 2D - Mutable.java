// update O(n), sumRegion O(m)
class NumMatrix {
    private int[][] sum;
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            sum = new int[0][0];
        } else {
            sum = new int[matrix.length][matrix[0].length + 1];
        }
        for (int i = 0; i < matrix.length; ++i) {
            int total = 0;
            for (int j = 0; j < matrix[0].length; ++j) {
                sum[i][j] = total;
                total += matrix[i][j];
            }
            sum[i][matrix[0].length] = total;
        }
    }

    public void update(int row, int col, int val) {
        int diff = val - (sum[row][col + 1] - sum[row][col]);
        if (sum.length != 0 && sum[0].length != 0) {
            for (int j = col + 1; j < sum[row].length; ++j) {
                sum[row][j] += diff;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        if (sum.length != 0 && sum[0].length != 0) {
            for (int i = row1; i <= row2; ++i) {
                res += sum[i][col2 + 1] - sum[i][col1];
            }
        }
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
