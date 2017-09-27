// O(n)
class Solution {
    public int totalHammingDistance(int[] nums) {
        int res = 0, n = nums.length;
        for (int j = 0; j < 32; ++j) {
            int bitCount = 0;
            for (int i = 0; i < n; ++i) {
                bitCount += (nums[i] >> j) & 1;
            }
            res += bitCount * (n - bitCount);
        }
        return res;
    }
}
