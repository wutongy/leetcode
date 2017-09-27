// dp
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] amounts = new int[amount + 1];
        Arrays.fill(amounts, -1);
        amounts[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < coins.length; ++j) {
                if (i >= coins[j] && amounts[i - coins[j]] >= 0) {
                    if (amounts[i] == -1) {
                        amounts[i] = amounts[i - coins[j]] + 1;
                    } else {
                        amounts[i] = Math.min(amounts[i], 1 + amounts[i - coins[j]]);
                    }
                }
            }
        }
        return amounts[amount];
    }
}
