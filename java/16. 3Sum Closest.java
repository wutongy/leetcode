// O(n^2)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0, minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int j = i + 1, k = nums.length - 1, sum = target - nums[i];
                while (j < k) {
                    if (nums[j] + nums[k] == sum) {
                        return target;
                    } else if (nums[j] + nums[k] > sum) {
                        if (nums[j] + nums[k] - sum < minDiff) {
                            minDiff = nums[j] + nums[k] - sum;
                            res = nums[i] + nums[j] + nums[k];
                        }
                        --k;
                    } else {
                        if (sum - nums[j] - nums[k] < minDiff) {
                            minDiff = sum - nums[j] - nums[k];
                            res = nums[i] + nums[j] + nums[k];
                        }
                        ++j;
                    }
                }
            }
        }
        return res;
    }
}
