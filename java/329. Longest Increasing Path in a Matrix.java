// O(mn)
class Solution {
        private final int[][] dirs = {{1, 0}, {-1, 0},{0, 1}, {0, -1}};
    private boolean ispeak(int[][] matrix, boolean[][] marked, int i, int j) {
        if (i > 0 && !marked[i-1][j] && matrix[i-1][j] > matrix[i][j]) return false;
        if (i < matrix.length-1 && !marked[i+1][j] && matrix[i+1][j] > matrix[i][j]) return false;
        if (j > 0 && !marked[i][j-1] && matrix[i][j-1] > matrix[i][j]) return false;
        if (j < matrix[0].length-1 && !marked[i][j+1] && matrix[i][j+1] > matrix[i][j]) return false;
        return true;
    }
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int len = 0;
        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][] marked = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (ispeak(matrix, marked, i, j)) queue.add(new int[]{i, j});
            }
        }
        while (!queue.isEmpty()) {
            len++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] p = queue.poll();
                marked[p[0]][p[1]] = true;
                for (int j = 0; j < 4; j++) {
                    int r = p[0]+dirs[j][0], c = p[1]+dirs[j][1];
                    if (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length && !marked[r][c] && ispeak(matrix, marked, r, c)) {
                        if (matrix[r][c] != matrix[p[0]][p[1]]) queue.add(new int[]{r, c});
                    }
                }
            }
        }
        return len;
    }
}
