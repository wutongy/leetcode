class Solution {
    public void sortColors(int[] nums) {
        int red = 0, l = 0, r = nums.length - 1;
        while (l <= r) {
            if (nums[l] == 0) {
                int temp = nums[red];
                nums[red++] = nums[l];
                nums[l++] = temp;
            } else if (nums[l] == 1) {
                ++l;
            } else if (nums[l] == 2) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                --r;
            }
        }
    }
}
