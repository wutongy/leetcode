class Solution {
public:
    int maxProduct(vector<int>& nums) {
        if (nums.size() == 1) return nums[0];
        int pMax = 0, nMax = 0, m = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] < 0) swap(pMax, nMax);
            pMax = max(pMax*nums[i], nums[i]);
            nMax = min(nMax*nums[i], nums[i]);
            m = max(m, pMax);
        }
        return m;
    }
};