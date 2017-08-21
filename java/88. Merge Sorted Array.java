// O(n)
class solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n - 1;
        while (m >= 1 || n >= 1) {
            int mNum = m >= 1 ? nums1[m - 1] : Integer.MIN_VALUE;
            int nNum = n >= 1 ? nums2[n - 1] : Integer.MIN_VALUE;
            if (mNum >= nNum) {
                nums1[last--] = mNum;
                --m;
            } else {
                nums1[last--] = nNum;
                --n;
            }
        }
    }
}
