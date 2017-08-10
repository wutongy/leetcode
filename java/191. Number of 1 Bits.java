// O(1)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0, mask = 1;
        while (n != 0) {
            count += 1;
            n = n & (n - 1);
        }
        return count;
    }
}
