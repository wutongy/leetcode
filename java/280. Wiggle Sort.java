// O(nlogn)
class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int i = 1, j = 2;
        while (j < nums.length) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i += 2;
            j += 2;
        }
    }
}

// O(n)
class Solution {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            if ((i % 2 == 1) != (nums[i] >= nums[i - 1])) {
                int cache = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = cache;
            }
        }
    }
}
