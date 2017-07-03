// O(1)
public class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y, count = 0;
        for (int i = 0; i < 31; i++) {
            count += xor & 1;
            xor >>= 1;
        }
        return count;
    }
}
