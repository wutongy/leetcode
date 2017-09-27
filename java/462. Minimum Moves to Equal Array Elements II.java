// O(nlogn)
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int count = 0;
        while (i < j) {
            count += nums[j] - nums[i];
            ++i;
            --j;
        }
        return count;
    }
}
// expected : O(n)
class Solution {
    public int minMoves2(int[] nums) {
        int sum = 0, median = quickselect(nums, nums.length / 2 + 1, 0, nums.length - 1);
        for (int i = 0; i < nums.length; ++i) {
            sum += Math.abs(nums[i] - median);
        }
        return sum;
    }
    private int quickselect(int[] nums, int k, int start, int end) {
        int l = start, r = end, pivot = nums[l + (r - l) / 2];
        while (l <= r) {
            while (nums[l] < pivot) {
                ++l;
            }
            while (nums[r] > pivot) {
                --r;
            }
            if (l >= r) {
                break;
            }
            swap(nums, l++, r--);
        }
        if (l - start + 1 > k) {
            return quickselect(nums, k, start, l - 1);
        }
        if (l - start + 1 == k && l == r) {
            return nums[l];
        }
        return quickselect(nums, k - r + start - 1, r + 1, end);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
