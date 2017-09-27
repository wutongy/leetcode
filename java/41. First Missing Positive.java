// O(n)
class Solution {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] - 1 >= 0 && nums[i] - 1 < nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            } else {
                ++i;
            }
        }
        i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
            ++i;
        }
        return nums.length + 1;
    }
}
