class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int left = 0, i = 0;
        while (i < nums.size()) {
            if (nums[i] != 0) {
                swap(nums[i], nums[left++]);
            }
            i++;
        }
    }
};