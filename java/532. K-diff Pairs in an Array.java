// O(n)
class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums.length < 2 || k < 0) {
            return 0;
        }
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            if (!hmap.containsKey(num)) {
                if (hmap.containsKey(num - k)) {
                    ++result;
                }
                if (hmap.containsKey(num + k)) {
                    ++result;
                }
            } else if (k == 0 && hmap.containsKey(num) && hmap.get(num) == 1) {
                ++result;
            }
            hmap.put(num, hmap.getOrDefault(num, 0) + 1);
        }
        return result;
    }
}
