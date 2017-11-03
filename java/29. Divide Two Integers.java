// O(logn)
class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend < 0) ^ (divisor < 0)) {
            sign = -1;
        }
        long num = Math.abs((long) dividend);
        long den = Math.abs((long) divisor);
        int times = 1;
        long res = 0;
        while ((den << 1) < num) {
            times <<= 1;
            den <<= 1;
        }
        while (times > 0) {
            while (num >= den) {
                res += times;
                num -= den;
            }
            den >>>= 1;
            times >>>= 1;
        }
        res *= sign;
        return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)res;
    }
}
