// O(n^n)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[] board = new boolean[5 * n - 2];
        List<List<String>> res = new ArrayList<>();
        dfs(board, 0, n, new ArrayList<String>(), res);
        return res;
    }

    private void dfs(boolean[] board, int idx, int n, ArrayList<String> path, List<List<String>> res) {
        if (idx == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            sb.append(".");
        }
        for (int i = 0; i < n; ++i) {
            if (board[i] == false && board[i + idx + n] == false && board[i - idx + 4 * n - 2] == false) {
                sb.setCharAt(i, 'Q');
                path.add(sb.toString());
                board[i] = true;
                board[i + idx + n] = true;
                board[i - idx + 4 * n - 2] = true;
                dfs(board, idx + 1, n, path, res);
                board[i - idx + 4 * n - 2] = false;
                board[i + idx + n] = false;
                board[i] = false;
                path.remove(path.size() - 1);
                sb.setCharAt(i, '.');
            }
        }
    }
}
