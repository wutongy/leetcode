// O(n)
public class Solution {
    public int findLHS(int[] nums) {
        int result = 0;
        Map<Integer, Integer> hmap = new HashMap<>();
        Integer count = 0;
        for (int i = 0; i < nums.length; i++) {
            Integer countCur = hmap.getOrDefault(nums[i], 0) + 1;
            hmap.put(nums[i], countCur);
            count = hmap.get(nums[i] - 1);
            if (count != null) {
                result = Math.max(result, countCur + count);
            }
            count = hmap.get(nums[i] + 1);
            if (count != null) {
                result = Math.max(result, countCur + count);
            }
        }
        return result;
    }
}
