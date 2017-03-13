class Solution {
private:
    vector<int> diff = {-1, 0, 1, 0, -1};
public:
    bool exist(vector<vector<char>>& board, string word) {
        if (board.empty() || board[0].empty() || word.empty())
            return false;
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[0].size(); j++) {
                if (board[i][j] == word[0]) {
                    if (DFS(board, i, j, word, 0))
                        return true;
                }
            }
        }
        return false;
    }

    bool DFS(vector<vector<char>>& board, int i, int j, string &word, int p) {
        if (p == word.size())
            return true;
        if (i < 0 || i >= board.size() || j < 0 || j >= board[0].size() || board[i][j] == '\0' || board[i][j] != word[p])
            return false;
        int tmp = board[i][j];
        board[i][j] = '\0';
        for (int k = 0; k < 4; k++) {
            if (DFS(board, i + diff[k], j + diff[k + 1], word, p + 1))
                return true;
        }
        board[i][j] = tmp;
        return false;
    }
};