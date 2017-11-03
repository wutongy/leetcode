// O(n)
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int count = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count <<= 1;
        }
        return m * count;
    }
}
