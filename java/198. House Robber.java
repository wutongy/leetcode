// O(n)
class Solution {
    public int rob(int[] nums) {
        int p2 = 0, p1 = 0;
        for (int i = 0; i < nums.length; ++i) {
            int temp = p1;
            p1 = Math.max(p2 + nums[i], p1);
            p2 = temp;
        }
        return p1;
    }
}
