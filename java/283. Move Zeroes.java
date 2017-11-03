// O(n)
class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0, i = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                ++left;
            }
            ++i;
        }
    }
}
