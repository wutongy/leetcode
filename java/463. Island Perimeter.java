// O(n^2)
public class Solution {
    private int l, h;
    private int result = 0;
    int[] diff = {1, 0, -1, 0, 1};
    public int islandPerimeter(int[][] grid) {
        l = grid.length;
        h = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result += calculatePerimeter(grid, i, j);
                }
            }
        }
        return result;
    }

    private int calculatePerimeter(int[][] grid, int x, int y) {
        int accum = 0;
        for (int i = 0; i < diff.length - 1; i++) {
            int newX = x + diff[i];
            int newY = y + diff[i + 1];
            if (newX < 0 || newX >= l || newY < 0 || newY >= h) {
                accum += 1;
            } else if (grid[newX][newY] == 0) {
                accum += 1;
            }
        }
        return accum;
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
