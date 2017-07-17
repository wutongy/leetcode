// O(n)
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0, accum = 0;
        for (int num : nums) {
            if (num == 1) {
                accum += 1;
            } else {
                result = Math.max(result, accum);
                accum = 0;
            }
        }
        return accum > result ? accum: result;
    }
}
