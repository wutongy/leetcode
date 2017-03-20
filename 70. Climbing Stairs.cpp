class Solution {
public:
    int climbStairs(int n) {
        int dp1 = 1, dp2 = 1;
        int i = 1;
        while (i < n) {
            int tmp = dp2;
            dp2 += dp1;
            dp1 = tmp;
            i++;
        }
        return dp2;
    }
};