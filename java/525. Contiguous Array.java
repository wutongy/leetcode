// O(n)
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int diff = 0;
        int len = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                --diff;
            } else {
                ++diff;
            }
            if (map.containsKey(diff)) {
                len = Math.max(len, i - map.get(diff));
            } else {
                map.put(diff, i);
            }
        }
        return len;
    }
}
