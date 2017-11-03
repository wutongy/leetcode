// O(mn)
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dist = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); ++i) {
            if (i != 0) {
                dist[i][0] = dist[i - 1][0] + 1;
            }
            for (int j = 1; j <= word2.length(); ++j) {
                if (i == 0) {
                    dist[0][j] = dist[0][j - 1] + 1;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dist[i][j] = dist[i - 1][j - 1];
                } else {
                    dist[i][j] = Math.min(dist[i - 1][j - 1], Math.min(dist[i][j - 1], dist[i - 1][j])) + 1;
                }
            }
        }
        return dist[word1.length()][word2.length()];
    }
}
