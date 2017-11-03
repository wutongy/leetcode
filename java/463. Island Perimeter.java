// O(n^2)
class Solution {
    public int islandPerimeter(int[][] grid) {
        int[] dirs = new int[]{-1, 0, 1, 0, -1};
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    return helper(grid, i, j, new boolean[grid.length][grid[0].length], dirs);
                }
            }
        }
        return 0;
    }

    private int helper(int[][] grid, int i, int j, boolean[][] visited, int[] dirs) {
        visited[i][j] = true;
        int res = 0;
        for (int k = 0; k < 4; ++k) {
            int ii = i + dirs[k];
            int jj = j + dirs[k + 1];
            if (ii < 0 || ii >= grid.length || jj < 0 || jj >= grid[0].length || grid[ii][jj] == 0) {
                ++res;
            } else if (!visited[ii][jj]) {
                res += helper(grid, ii, jj, visited, dirs);
            }
        }
        return res;
    }
}

// O(n^2)

public class Solution {
    public int islandPerimeter(int[][] grid) {
        int islands = 0, neighbours = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++;
                    if (i < grid.length - 1 && grid[i+ 1][j] == 1) {
                        neighbours++;
                    }
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {
                        neighbours++;
                    }
                }
            }
        }
        return islands * 4 - neighbours * 2;
    }
}
