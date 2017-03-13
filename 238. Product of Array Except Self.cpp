class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
        vector<int> res(n, 1);
        int left = 1, right = 1;
        for (int i = 0, j = nums.size() - 1; i < nums.size() - 1; i++, j--) {
            left *= nums[i];
            right *= nums[j];
            res[i + 1] *= left;
            res[j - 1] *= right;
        }
        return res;
    }
};