// O(logn)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums.length == 0) {
            return res;
        }
        int i = 0, j = nums.length - 1, mid = -1;
        while (i <= j) {
            mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        if (nums[mid] != target) {
            return res;
        }
        i = 0;
        int newL = mid;
        while (i <= newL) {
            int newMid = i + (newL - i) / 2;
            if (nums[newMid] == target) {
                newL = newMid - 1;
            } else {
                i = newMid + 1;
            }
        }
        res[0] = i;
        j = nums.length - 1;
        int newR = mid;
        while (newR <= j) {
            int newMid = newR + (j - newR) / 2;
            if (nums[newMid] == target) {
                newR = newMid + 1;
            } else {
                j = newMid - 1;
            }
        }
        res[1] = j;
        return res;
    }
}
