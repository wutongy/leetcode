// O(n)
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int result = 0, accum = 0;
        for (int i = 0; i < k; i++) {
            accum += nums[i];
        }
        result = accum;
        for (int i = k; i < nums.length; i++) {
            accum -= nums[i - k];
            accum += nums[i];
            result = Math.max(result, accum);
        }
        return (double) result / k;
    }
}
