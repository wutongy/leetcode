// O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hmap.containsKey(target - nums[i])) {
                result[0] = hmap.get(target - nums[i]);
                result[1] = i;
                break;
            } else {
                hmap.put(nums[i], i);
            }
        }
        return result;
    }
}
