// O(n)
public class Solution {
    public int maxSubArray(int[] nums) {
        int result, accum, min;
        result = accum = min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            accum += nums[i];
            result = Math.max(result, Math.max(accum, accum - min));
            min = Math.min(min, accum);
        }
        return result;
    }
}
