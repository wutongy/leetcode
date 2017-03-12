class Solution {
public:
    int rob(vector<int>& nums) {
        int prevMax = 0, curMax = 0;
        for (int i = 0; i < nums.size(); i++) {
            int tmp = curMax;
            curMax = max(prevMax + nums[i], curMax);
            prevMax = tmp;
        }
        return curMax;
    }
};