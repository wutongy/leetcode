// O(n)
class Solution {
    public boolean canJump(int[] nums) {
        int i = 0, maxReach = 0;
        while (i < nums.length && i <= maxReach) {
            if (i + nums[i] > maxReach) {
                maxReach = i + nums[i];
            }
            ++i;
        }
        return i >= nums.length;
    }
}
