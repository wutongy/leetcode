// O(mn) time, O(m + n) space
class Solution {
    public int findLonelyPixel(char[][] picture) {
        int x = picture.length, y = picture[0].length;
        int result = 0;
        int[] flags = new int[x + y];
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                if (picture[i][j] == 'B') {
                    flags[i] += 1;
                    flags[x + j] += 1;
                }
            }
        }
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                if (picture[i][j] == 'B' && flags[i] < 2 && flags[x + j] < 2) {
                    ++result;
                }
            }
        }
        return result;
    }
}
