// O(n^2)
class Solution {
    public int[][] generateMatrix(int n) {
        int beginRow = 0, endRow = n - 1;
        int beginCol = 0, endCol = n - 1;
        int[][] res = new int[n][n];
        int i = 1;
        while (beginRow <= endRow && beginCol <= endCol) {
            for(int j = beginCol; j <= endCol; ++j) {
                res[beginRow][j] = i++;
            }
            beginRow++;
            for(int j = beginRow; j <= endRow; ++j) {
                res[j][endCol] = i++;
            }
            endCol--;
            // if (beginRow > endRow || beginCol > endCol) {
            //     break;
            // }
            for (int j = endCol; j >= beginCol; --j) {
                res[endRow][j] = i++;
            }
            endRow--;
            for (int j = endRow; j >= beginRow; --j) {
                res[j][beginCol] = i++;
            }
            beginCol++;
        }
        return res;
    }
}
