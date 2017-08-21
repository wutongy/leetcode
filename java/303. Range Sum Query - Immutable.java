// O(n)
class NumArray {
    int[] n;
    public NumArray(int[] nums) {
        n = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            n[i + 1] = n[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return n[j + 1] - n[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
