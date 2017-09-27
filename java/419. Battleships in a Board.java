// O(n^2) O(1) space
class Solution {
    public int countBattleships(char[][] board) {
        int result = 0;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == 'X' && newOne(board, i, j - 1)  && newOne(board, i - 1, j)) {
                    ++result;
                }
            }
        }
        return result;
    }

    private boolean newOne(char[][] board, int i, int j) {
        return !(i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == 'X');
    }
}
