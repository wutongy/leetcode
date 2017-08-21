// O(n)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hset = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                hset.remove(nums[i - k - 1]);
            }
            if (!hset.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
