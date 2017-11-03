// O(n)
class Solution {
    public int maxProfit(int[] prices) {
        int buyOne = Integer.MIN_VALUE, saleOne = 0, buyTwo = Integer.MIN_VALUE, saleTwo = 0;
        for (int i = 0; i < prices.length; ++i) {
            buyOne = Math.max(buyOne, -prices[i]);
            saleOne = Math.max(saleOne, prices[i] + buyOne);
            buyTwo = Math.max(buyTwo, saleOne - prices[i]);
            saleTwo = Math.max(saleTwo, prices[i] + buyTwo);
        }
        return saleTwo;
    }
}
