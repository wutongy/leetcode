// O(n) time, O(1) space
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, count = 0, j = 0;
        while (j < nums.length) {
            if (j == 0 || (nums[j] != nums[j - 1])) {
                nums[i++] = nums[j];
                count = 0;
            } else if (nums[j] == nums[j - 1] && count == 0) {
                nums[i++] = nums[j];
                ++count;
            }
            ++j;
        }
        return i;
    }
}
