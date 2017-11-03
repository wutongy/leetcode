// O(logn)
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        double ans = 1;
        if (n < 0) {
            x = 1 / x;
            n = -(++n);
            ans *= x;
        }
        while (n > 0) {
            if ((n & 1) != 0) {
                ans *= x;
            }
            x *= x;
            n >>= 1;
        }
        return ans;
    }
}

class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        double sub = myPow(x, n / 2);
        return sub * sub * (((n & 1) == 1) ? (n < 0 ? 1 / x : x): 1);
    }
}
