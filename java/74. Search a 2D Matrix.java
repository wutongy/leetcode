// O(logm + logn)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int mi = 0, mj = matrix.length - 1;
        while (mi <= mj) {
            int mid = mi + (mj - mi) / 2;
            if (matrix[mid][matrix[mid].length - 1] == target) {
                return true;
            } else if (matrix[mid][matrix[mid].length - 1] > target) {
                mj = mid - 1;
            } else {
                mi = mid + 1;
            }
        }
        if (mi > matrix.length - 1) {
            return false;
        }
        int ni = 0, nj = matrix[mi].length - 1;
        while (ni <= nj) {
            int mid = ni + (nj - ni) / 2;
            if (matrix[mi][mid] == target) {
                return true;
            } else if (matrix[mi][mid] > target) {
                nj = mid - 1;
            } else {
                ni = mid + 1;
            }
        }
        return false;
    }
}
