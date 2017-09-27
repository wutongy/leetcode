// O(logn)
class Solution {
    public int mySqrt(int x) {
        if (x < 0) {
            return -1;
        } else if (x == 0) {
            return 0;
        }
        int l = 1, r = x / 2 + 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m <= x / m && x / (m + 1) < m + 1) {
                return m;
            } else if (x / m < m) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return 0;
    }
}
