// worst case O(n)
class Solution {
    public int findMin(int[] nums) {
        int res = Integer.MAX_VALUE;
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == nums[i] && nums[mid] == nums[j]) {
                res = Math.min(res, nums[mid]);
                ++i;
                --j;
            } else if (nums[mid] >= nums[i]) {
                res = Math.min(res, nums[i]);
                i =  mid + 1;
            } else {
                res = Math.min(res, nums[mid]);
                j = mid - 1;
            }
        }
        return res;
    }
}
