#include <vector>
using namespace std;
class Solution {
public:
    vector<vector<int> > threeSum(vector<int>& nums) {
        vector<vector<int> > result;
        int n = nums.size();
        if (n < 3) return result;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) break;
            if (nums[i] + nums[n - 1] + nums[n - 2] < 0) continue;
            int low = i + 1, high = n - 1;
            while (low < high) {
                if (nums[i] + nums[low] + nums[high] == 0) {
                    result.push_back({nums[i], nums[low], nums[high]});
                    do { low++; } while (nums[low] == nums[low - 1] && low < high);
                    do { high--; } while (nums[high] == nums[high + 1] && low < high);
                } else if (nums[i] + nums[low] + nums[high] < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return result;
    }
};