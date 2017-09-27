// O(n^2) precompute, O(1) query
class NumMatrix {
    private int[][] sumRegion;
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = row > 0 ? matrix[0].length : 0;
        sumRegion = new int[row + 1][col + 1];
        for (int i = 0; i < matrix.length; ++i) {
            int sum = 0;
            for (int j = 0; j < matrix[0].length; ++j) {
                sum += matrix[i][j];
                sumRegion[i + 1][j + 1] = sum + sumRegion[i][j + 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumRegion[row2 + 1][col2 + 1] - sumRegion[row1][col2 + 1] - sumRegion[row2 + 1][col1] + sumRegion[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
