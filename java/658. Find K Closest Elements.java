// O(logn + k)
class Solution {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = arr.size() - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr.get(mid) == x) {
                break;
            } else if (arr.get(mid) > x) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        int count = 0;
        int lo = i - 1, hi = i;
        while (count < k && (lo >= 0 || hi <= arr.size() - 1)) {
            if (hi > arr.size() - 1 || lo >= 0 && Math.abs(x - arr.get(lo)) <= Math.abs(x - arr.get(hi))) {
                --lo;
            } else {
                ++hi;
            }
            ++count;
        }
        lo = Math.max(lo + 1, 0);
        count = k;
        while (count-- > 0) {
            res.add(arr.get(lo++));
        }
        return res;
    }
}
