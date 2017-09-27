// O(1)
class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = res * 10 + tail;
            if ((newResult - tail) / 10 != res) {
                return 0;
            }
            res = newResult;
            x /= 10;
        }
        return res;
    }
}
