// O(n^2) time, O(n^2) space
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = A.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                map.put(-(A[i] + B[j]), map.getOrDefault(-(A[i] + B[j]), 0) +1);
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                res += map.getOrDefault(C[i] + D[j], 0);
            }
        }
        return res;
    }
}
