// O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = 1;
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        for (int n : nums) {
            if (set.contains(n)) {
                int len = 1;
                int cur = n + 1;
                while (set.contains(cur)) {
                    ++len;
                    set.remove(cur);
                    ++cur;
                }
                cur = n - 1;
                while (set.contains(cur)) {
                    ++len;
                    set.remove(cur);
                    --cur;
                }
                res = Math.max(res, len);
            }
        }
        return res;
    }
}
