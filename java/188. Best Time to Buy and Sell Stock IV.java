// O(nk) time, O(nk) space
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k > prices.length / 2) {
            return maxP(prices);
        }
        int[][] hold = new int[prices.length][k + 1];
        int[][] unhold = new int[prices.length][k + 1];
        hold[0][0] = -prices[0];
        for (int i = 1; i < prices.length; ++i) {
            hold[i][0] = Math.max(hold[i - 1][0], -prices[i]);
        }
        for (int j = 1; j <= k; ++j) {
            hold[0][j] = -prices[0];
        }
        for (int i = 1; i < prices.length; ++i) {
            for (int j = 1; j <= k; ++j) {
                hold[i][j] = Math.max(unhold[i - 1][j] - prices[i], hold[i- 1][j]);
                unhold[i][j] = Math.max(hold[i - 1][j - 1] + prices[i], unhold[i - 1][j]);
            }
        }
        return unhold[prices.length - 1][k];
    }

    private int maxP(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
