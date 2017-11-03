// O(mn)
class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int max = 0;
        int rowCount = 0;
        int[] colCount = new int[grid[0].length];
        for (int i = 0; i< grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 'W') {
                    continue;
                }
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowCount = killEnemiesRow(grid, i, j);
                }
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colCount[j] = killEnemiesCol(grid, i, j);
                }
                if (grid[i][j] == '0') {
                    max = Math.max(max, rowCount + colCount[j]);
                }
            }
        }
        return max;
    }

    private int killEnemiesRow(char[][] grid, int i, int j) {
        int count = 0;
        while (j < grid[0].length && grid[i][j] != 'W') {
            if (grid[i][j] == 'E') {
                ++count;
            }
            ++j;
        }
        return count;
    }

    private int killEnemiesCol(char[][] grid, int i, int j) {
        int count = 0;
        while (i < grid.length && grid[i][j] != 'W') {
            if (grid[i][j] == 'E') {
                ++count;
            }
            ++i;
        }
        return count;
    }
}
