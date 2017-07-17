// O(n)
public class Solution {
    public int minMoves(int[] nums) {
        // return IntStream.of(nums).sum() - nums.length * IntStream.of(nums).min().getAsInt();
        int result = 0;
        int minNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            minNum = Math.min(minNum, nums[i]);
        }
        for (int num : nums) {
            result += num - minNum;
        }
        return result;
    }
}
