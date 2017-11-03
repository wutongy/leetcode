// O(n^n)
class Solution {
    public int totalNQueens(int n) {
        boolean[] board = new boolean[5 * n - 2];
        return dfs(0, n, board);
    }

    private int dfs(int idx, int n, boolean[] board) {
        if (idx == n) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (board[i] == false && board[i + idx + n] == false && board[i - idx + 4 * n - 2] == false) {
                board[i] = true;
                board[i + idx + n] = true;
                board[i - idx + 4 * n - 2] = true;
                count += dfs(idx + 1, n, board);
                board[i] = false;
                board[i + idx + n] = false;
                board[i - idx + 4 * n - 2] = false;
            }
        }
        return count;
    }
}
