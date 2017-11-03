// O(mn)
class Solution {
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                int count = countLiveNbr(board, i, j);
                if (board[i][j] == 1) {
                    if (count == 2 || count == 3) {
                        board[i][j] |= 1 << 1;
                    }
                } else if (count == 3) {
                    board[i][j] |= 1 << 1;
                }
            }
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                board[i][j] >>>= 1;
            }
        }
    }

    private int countLiveNbr(int[][] board, int i, int j) {
        int[] dirs = new int[]{1, 0, -1, 0, 1, 1, -1, -1, 1};
        int count = 0;
        for (int k = 0; k < 8; ++k) {
            int ii = i + dirs[k];
            int jj = j + dirs[k + 1];
            if (ii >= 0 && ii < board.length && jj >= 0 && jj < board[0].length && (board[ii][jj] & 1) == 1) {
                ++count;
            }
        }
        return count;
    }
}
