class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() < 3) return nums.size();
        int res = 1, left = 0, right = 1, cnt = 0;
        while (right < nums.size()) {
            if (nums[right] != nums[left] || cnt == 0) {
                if (nums[right] == nums[left]) {
                    cnt++;
                } else {
                    cnt = 0;
                }
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