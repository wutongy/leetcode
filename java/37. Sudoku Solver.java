class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] map = new boolean[27][10];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    map[i][num] = true;
                    map[9 + j][num] = true;
                    map[18 + (i / 3) * 3 + (j / 3)][num] = true;
                }
            }
        }
        dfs(board, 0, 0, map);
    }

    private boolean dfs(char[][] board, int i, int j, boolean[][] map) {
        if (i == 9 && j == 0) {
            return true;
        }
        if (board[i][j] != '.') {
            if (j + 1 < 9) {
                return dfs(board, i, j + 1, map);
            } else {
                return dfs(board, i + 1, 0, map);
            }
        }
        for (int k = 1; k <= 9; ++k) {
            if (!map[i][k] && !map[9 + j][k] && !map[18 + (i / 3) * 3 + (j / 3)][k]) {
                board[i][j] = (char)(k + '0');
                map[i][k] = true;
                map[9 + j][k] = true;
                map[18 + (i / 3) * 3 + (j / 3)][k] = true;
                if (j + 1 < 9) {
                    if(dfs(board, i, j + 1, map)) {
                        return true;
                    }
                } else if(dfs(board, i + 1, 0, map)) {
                    return true;
                }
                map[i][k] = false;
                map[9 + j][k] = false;
                map[18 + (i / 3) * 3 + (j / 3)][k] = false;
            }
            board[i][j] = '.';
        }
        return false;
    }
}
