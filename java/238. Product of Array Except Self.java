// O(n)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int accum = 1;
        for (int i = 0; i < nums.length; ++i) {
            res[i] = accum;
            accum *= nums[i];
        }
        accum = 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            res[i] *= accum;
            accum *= nums[i];
        }
        return res;
    }
}
