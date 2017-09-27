// O(n)time O(1) space
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null) {
            return result;
        }
        for (int i = 0; i < nums.length; ++i) {
            int location = Math.abs(nums[i]) - 1;
            if (nums[location] < 0) {
                result.add(Math.abs(nums[i]));
            } else {
                nums[location] *= -1;
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Math.abs(nums[i]);
        }
        return result;
    }
}
