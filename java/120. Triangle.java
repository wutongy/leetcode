// O(n^2)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size(), n = triangle.get(m - 1).size();
        int[] dp = new int[m];
        for (int i = 0; i < n; ++i) {
            dp[i] = triangle.get(m - 1).get(i);
        }
        for (int i = m - 2; i >= 0; --i) {
            int[] temp = new int[i + 1];
            for (int j = i; j >= 0; --j) {
                temp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
            dp = temp;
        }
        return dp[0];
    }
}

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        List<Integer> cur = new ArrayList<>(triangle.get(triangle.size() - 1));
        for (int i = triangle.size() - 2; i >= 0; --i) {
            for (int j = 0; j <= i; ++j) {
                cur.set(j, triangle.get(i).get(j) + Math.min(cur.get(j), cur.get(j + 1)));
            }
        }
        return cur.get(0);
    }
}
