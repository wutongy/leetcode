class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int lowest = INT_MAX;
        int maxProfit = 0;
        for (int p : prices) {
            if (p <= lowest) {
                lowest = p;
            } else {
                maxProfit = max(maxProfit, p - lowest);
            }
        }
        return maxProfit;
    }
};