// O(n)
class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        int[] bloomDay = new int[flowers.length];
        for (int i = 0; i < flowers.length; ++i) {
            bloomDay[flowers[i] - 1] = i + 1;
        }
        int res = Integer.MAX_VALUE;
        int left = 0, right = k + 1, i = 0;
        while (i < bloomDay.length && right < bloomDay.length) {
            if (bloomDay[i] < bloomDay[left] || bloomDay[i] <= bloomDay[right]) {
                if (i == right) {
                    res = Math.min(res, Math.max(bloomDay[left], bloomDay[right]));
                }
                left = i;
                right = k + 1 + i;
            }
            ++i;
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
