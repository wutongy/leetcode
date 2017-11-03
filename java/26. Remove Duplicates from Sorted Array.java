// O(n)
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (j == 0 || (nums[j] != nums[j - 1])) {
                nums[i++] = nums[j];
            }
            ++j;
        }
        return i;
    }
}
