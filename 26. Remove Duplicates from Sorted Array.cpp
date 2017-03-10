class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() < 2) return nums.size();
        int res, left, right;
        res = right = 1, left = 0;
        while (right < nums.size()) {
            if (nums[right] != nums[left]) {
                nums[++left] = nums[right++];
                res++;
            } else {
                while (right < nums.size() && nums[right] == nums[left]) {
                    right++;
                }
            }
        }
        return res;
    }
};