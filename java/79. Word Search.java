class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0 || board.length == 0 || board[0].length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    HashSet<Integer> visited = new HashSet<>();
                    visited.add(i * board[0].length + j);
                    if (word.length() == 1 || dfs(board, i - 1, j, word, 1, visited) || dfs(board, i + 1, j, word, 1, visited) || dfs(board, i, j - 1, word, 1, visited) || dfs(board, i, j + 1, word, 1, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int idx, HashSet<Integer> visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited.contains(i * board[0].length + j) || board[i][j] != word.charAt(idx)) {
            return false;
        }
        if (idx == word.length() - 1) {
            return true;
        }
        visited.add(i * board[0].length + j);
        if (dfs(board, i - 1, j, word, idx + 1, visited) || dfs(board, i + 1, j, word, idx + 1, visited) || dfs(board, i, j - 1, word, idx + 1, visited) || dfs(board, i, j + 1, word, idx + 1, visited)) {
            return true;
        }
        visited.remove(i * board[0].length + j);
        return false;
    }
}
