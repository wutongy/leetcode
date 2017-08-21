// O(n)
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int prev = 0, cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int nxt = prev + nums[i];
            if (cur > nxt) {
                nxt = cur;
            }
            prev = cur;
            cur = nxt;
        }
        return cur;
    }
}
