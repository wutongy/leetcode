// O(mn)
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            explore(board, x, y);
        }
        return board;
    }

    private void explore(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E') {
            return;
        }
        int mines = adjMine(board, x, y);
        if (mines == 0) {
            board[x][y] = 'B';
            for (int i = -1; i <= 1; ++i) {
                for (int j = -1; j <= 1; ++j) {
                    explore(board, x + i, y + j);
                }
            }
        } else {
            board[x][y] = (char)('0' + mines);
        }
    }

    private int adjMine(char[][] board, int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                int xi = x + i;
                int yj = y + j;
                if (xi >= 0 && xi < board.length && yj >= 0 && yj < board[0].length && board[xi][yj] == 'M') {
                    ++count;
                }
            }
        }
        return count;
    }
}
