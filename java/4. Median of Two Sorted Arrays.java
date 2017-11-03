// O(log(min(m, n)))
class Solution {
    private int findKth(int[] nums1, int idx1, int[] nums2, int idx2, int remain) {
        if (idx1 >= nums1.length) {
            return nums2[idx2 + remain - 1];
        } else if (idx2 >= nums2.length) {
            return nums1[idx1 + remain - 1];
        }
        if (remain == 1) {
            return Math.min(nums1[idx1], nums2[idx2]);
        }
        int mid1 = Integer.MAX_VALUE, mid2 = Integer.MAX_VALUE;
        if (idx1 + remain / 2 - 1 < nums1.length) {
            mid1 = nums1[idx1 + remain / 2 - 1];
        }
        if (idx2 + remain / 2 - 1 < nums2.length) {
            mid2 = nums2[idx2 + remain / 2 - 1];
        }
        if (mid1 < mid2) {
            return findKth(nums1, idx1 + remain / 2, nums2, idx2, remain - remain / 2);
        } else {
            return findKth(nums1, idx1, nums2, idx2 + remain / 2, remain - remain / 2);
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1.length + nums2.length) % 2 == 1) {
            return findKth(nums1, 0, nums2, 0, (nums1.length + nums2.length + 1) / 2);
        } else {
            return (findKth(nums1, 0, nums2, 0, (nums1.length + nums2.length + 1) / 2) + findKth(nums1, 0, nums2, 0, (nums1.length + nums2.length + 2) / 2)) / 2.0;
        }
    }
}

// O(log(min(m, n)))
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        if (n == 0) {
            throw new IllegalArgumentException("nums can not be empty");
        }
        int imin = 0, imax = m, halfLen = (m + n + 1) / 2;
        while (imin <= imax) {
            int i = imin + (imax - imin) / 2;
            int j = halfLen - i;
            if (i < m && nums2[j - 1] > nums1[i]) {
                imin = i + 1;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                imax = i - 1;
            } else {
                int maxLeft = 0, minRight = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return -1;
    }
}
