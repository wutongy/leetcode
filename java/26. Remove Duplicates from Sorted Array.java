// O(n)
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int i = 0, j = 1;
        while (j < nums.length) {
            while (j < nums.length && nums[j] == nums[i]) {
                ++j;
            }
            if (j < nums.length) {
                ++i;
                nums[i] = nums[j];
                ++j;
            }
        }
        return i + 1;
    }
}
