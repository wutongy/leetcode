class Solution {
public:
    int jump(vector<int>& nums) {
        return helper(nums, 0, 0, 0);
    }

    int helper(vector<int>& nums, int idx, int threshold, int accum) {
        if (idx == nums.size() - 1)
            return 0;
        else if (nums[idx] + idx >= nums.size() - 1)
            return accum + 1;
            threshold++;
            int maxIdx = threshold, maxDist = nums[threshold] + threshold, upper = idx + nums[idx];
            for (int i = ++threshold; i <= upper; i++) {
                if (nums[i] + i > maxDist) {
                    maxIdx = i;
                    maxDist = i + nums[i];
                }
            }
        return helper(nums, maxIdx, upper, accum + 1);
    }
};