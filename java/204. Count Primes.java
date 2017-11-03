// O(n)
class Solution {
    public int countPrimes(int n) {
        boolean[] visited = new boolean[n + 1];
        int res = 0;
        for (int i = 2; i < n; ++i) {
            if (!visited[i]) {
                ++res;
                for (int j = 2 * i; j < n; j += i) {
                    visited[j] = true;
                }
            }
        }
        return res;
    }
}
