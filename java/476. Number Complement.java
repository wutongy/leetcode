// O(1)
public class Solution {
    public int findComplement(int num) {
        //int mask = 1;
        // note: mask should not have 32th bit being 1.
//         while (mask <= num && mask >= 0) {
//             num ^= mask;
//             mask <<= 1;
//         }
//         return num;
//         return ~num & (Integer.highestOneBit(num) - 1);
        int i = 0, j = 0;
        while (i < num) {
            i += Math.pow(2, j);
            j += 1;
        }
        return i - num;
    }
}
