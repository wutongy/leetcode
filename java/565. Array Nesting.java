// O(n)
class Solution {
    public int arrayNesting(int[] nums) {
        int maxsize = 0;
        for (int i = 0; i < nums.length; ++i) {
            int size = 0;
            for (int k = i; nums[k] >= 0; ++size) {
                int numsk = nums[k];
                nums[k] = -1;
                k = numsk;
            }
            maxsize = Integer.max(maxsize, size);
        }
        return maxsize;
    }
}
