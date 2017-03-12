class Solution {
public:
    int rob(vector<int>& nums) {
        if (nums.size() == 1) return nums[0];
        int prev1, cur1, prev2, cur2;
        prev1 = cur1 = prev2 = cur2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            int tmp;
            if (i != nums.size() - 1) {
                tmp = cur1;
                cur1 = max(cur1, prev1 + nums[i]);
                prev1 = tmp;
            }
            if (i != 0) {
                tmp = cur2;
                cur2 = max(cur2, prev2 + nums[i]);
                prev2 = tmp;
            }
        }
        return max(cur1, cur2);
    }
};