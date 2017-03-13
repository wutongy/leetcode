//Solution1
class Solution {
public:
    bool search(vector<int>& nums, int target) {
        return helper(nums, 0, nums.size() - 1, target); 
    }

    bool helper(vector<int>& nums, int left, int right, int &target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] == nums[right]) {
                return helper(nums, left, mid - 1, target) || helper(nums, mid + 1, right, target);
            } else {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
};

//Solution2
bool search(int A[], int n, int key) {
    int l = 0, r = n - 1;
    while (l <= r) {
        int m = l + (r - l) / 2;
        if (A[m] == key) return true;
        if (A[l] < A[m]) {
            if (A[l] <= key && key < A[m])
                r = m - 1;
            else
                l = m + 1;
        } else if (A[l] > A[m]) {
            if (A[m] < key && key <= A[r])
                l = m + 1;
            else
                r = m - 1;
        } else {
            l++;
        }
    }
    return false;
}