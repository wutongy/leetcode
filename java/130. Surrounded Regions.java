// O(mn)
class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length <= 1 || board[0].length <= 1) {
            return;
        }
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; ++i) {
            if (board[i][0] == 'O') {
                helper(board, i, 0);
            }
            if (board[i][cols - 1] == 'O') {
                helper(board, i, cols - 1);
            }
        }
        for (int i = 1; i < cols - 1; ++i) {
            if (board[0][i] == 'O') {
                helper(board, 0, i);
            }
            if (board[rows - 1][i] == 'O') {
                helper(board, rows - 1, i);
            }
        }
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (board[i][j] == 'I') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void helper(char[][] board, int r, int c) {
        board[r][c] = 'I';
        if (r - 1 > 0 && board[r - 1][c] == 'O') {
            helper(board, r - 1, c);
        }
        if (r + 1 < board.length - 1 && board[r + 1][c] == 'O') {
            helper(board, r + 1, c);
        }
        if (c + 1 < board[0].length - 1 && board[r][c + 1] == 'O') {
            helper(board, r, c + 1);
        }
        if (c - 1 > 0 && board[r][c - 1] == 'O') {
            helper(board, r, c - 1);
        }
    }
}
