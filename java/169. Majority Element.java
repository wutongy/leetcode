// O(n)
class Solution {
    public int majorityElement(int[] nums) {
        int count = 1, majorNum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == majorNum) {
                ++count;
            } else {
                --count;
                if (count < 0) {
                    majorNum = nums[i];
                    count = 1;
                }
            }
        }
        return majorNum;
    }
}
