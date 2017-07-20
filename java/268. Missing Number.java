// O(n)
public class Solution {
    public int missingNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result += num;
        }
        return (nums.length) * (1 + nums.length) / 2 - result;
    }
}
