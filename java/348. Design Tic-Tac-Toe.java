// O(n) time O(n) space
class TicTacToe {
    int[] board;
    int len;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new int[2 * n + 2];
        len = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int val = player == 1 ? 1 : -1;
        board[row] += val;
        if (board[row] == len || board[row] == -len) {
            return player;
        }
        board[len + col] += val;
        if (board[len + col] == len || board[len + col] == -len) {
            return player;
        }
        if (row == col) {
            board[2 * len] += val;
        }
        if (board[2 * len] == len || board[2 * len] == -len) {
            return player;
        }
        if (row == len - 1 - col) {
            board[2 * len + 1] += val;
        }
        if (board[2 * len + 1] == len || board[2 * len + 1] == -len) {
            return player;
        }
        // if (board[row] == len || board[row] == -len || board[len + col] == len || board[len + col] == -len || board[2 * len] == len || board[2 * len] == -len || board[2 * len + 1] == len || board[2 * len + 1] == -len) {
        //     return player;
        // }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
