class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        //if (nums.size() == 1) return nums[0];
        int res = INT_MIN, cur = 0;
        for (int i = 0; i < nums.size(); i++) {
            cur += nums[i];
            res = max(res, cur);
            if (cur < 0) {
                cur = 0;
            }
        }
        return res;
    }
};