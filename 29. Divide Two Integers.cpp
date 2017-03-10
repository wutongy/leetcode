class Solution {
public:
    int divide(int dividend, int divisor) {
        int sign = dividend < 0 ^ divisor < 0 ? -1 : 1;
        long long n = abs((long long) dividend), m = abs((long long) divisor);
        long long q = 0;

        for (long long t = 0, i = 31; i >= 0; i--) {
            if (t + (m << i) <= n) {
                t += m << i, q |= 1LL << i;
            }
        }

        if (sign < 0) q = -q;
        return q >= INT_MAX ? INT_MAX : q <= INT_MIN ? INT_MIN : q;
    }
};