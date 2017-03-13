class Solution {
private:
    vector<int> copy;
public:
    Solution(vector<int> nums) {
        copy = nums;
        srand(time(0));
    }

    int pick(int target) {
        int ans;
        for (int i = 0, cnt = 1; i < copy.size(); i++) {
            if (copy[i] == target && ((rand() % cnt++) == 0))
                ans = i;
        }
        return ans;
    }
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */