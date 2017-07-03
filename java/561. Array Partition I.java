// O(nlogn)
public class Solution {
    public int arrayPairSum(int[] nums) {
        int[] nums_copy = new int[nums.length];
        System.arraycopy(nums, 0, nums_copy, 0, nums.length);
        Arrays.sort(nums_copy);
        int accum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            accum += nums_copy[i];
        }
        return accum;
    }
}
