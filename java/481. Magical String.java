// O(n)
class Solution {
    public int magicalString(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 3) {
            return 1;
        }
        int[] a = new int[n + 1];
        a[0] = 1; a[1] = 2; a[2] = 2;
        int num = 0, i = 2, len = 3, res = 1;
        while (len < n) {
            int moves = a[i];
            for (int j = 0; j < moves; ++j) {
                a[len + j] = num + 1;
            }
            if (num == 0) {
                res += Math.min(moves, n - len);
            }
            num = 1 - num;
            ++i;
            len += moves;
        }
        return res;
    }
}
