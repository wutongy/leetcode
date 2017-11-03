// O(n^2)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length, n = board[0].length;
        int[][] count = new int[27][10];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if (count[i][num] == 1) {
                        return false;
                    } else {
                        count[i][num]++;
                    }
                    if (count[9 + j][num] == 1) {
                        return false;
                    } else {
                        count[9 + j][num]++;
                    }
                    if (count[18 + (i / 3) * 3 + (j / 3)][num] == 1) {
                        return false;
                    } else {
                        count[18 + (i / 3) * 3 + (j / 3)][num]++;
                    }
                }
            }
        }
        return true;
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] bitset = new int[27];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] != '.') {
                    int n = Integer.valueOf(board[i][j]);
                    if ((bitset[i] & (1 << n)) != 0 || (bitset[9 + j] & (1 << n)) != 0 || (bitset[18 + (i / 3) * 3 + (j / 3)] & (1 << n)) != 0) {
                        return false;
                    }
                    bitset[i] |= 1 << n;
                    bitset[9 + j] |= 1 << n;
                    bitset[18 + (i / 3) * 3 + (j / 3)] |= 1 << n;
                }
            }
        }
        return true;
    }
}
