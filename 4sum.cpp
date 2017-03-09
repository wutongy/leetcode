#include <vector>
using namespace std;
class Solution {
public:
    vector<vector<int> > fourSum(vector<int>& nums, int target) {
        vector<vector<int> > result;
        if (nums.size() < 4) return result;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size() - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if (nums[i] + nums[nums.size() - 3] + nums[nums.size() - 2] + nums[nums.size() - 1] < target) continue;
            for (int j = i + 1; j < nums.size() - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if (nums[i] + nums[j] + nums[nums.size() - 2] + nums[nums.size() - 1] < target) continue;
                int twoSum = target - (nums[i] + nums[j]);
                int low = j + 1, high = nums.size() - 1;
                while (low < high) {
                    if (nums[low] + nums[high] == twoSum) {
                        result.push_back({nums[i], nums[j], nums[low], nums[high]});
                        do { low++;} while (nums[low] == nums[low - 1] && low < high);
                        do { high--;} while (nums[high] == nums[high + 1] && low < high);
                    } else if (nums[low] + nums[high] > twoSum) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return result;
    }
};