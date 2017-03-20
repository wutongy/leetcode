//Solution1
class Solution {
private:
    struct myCompare {
        bool operator() (const int& a, const int& b) {
            return a > b ? true : false;
        }
    };

public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, myCompare> pq;
        for (int i = 0; i < nums.size(); i++) {
            if (pq.size() < k) {
                pq.push(nums[i]);
            } else if (nums[i] > pq.top()) {
                pq.pop();
                pq.push(nums[i]);
            }
        }
        return pq.top();
    }
};

//Solution2
private:
    int partition (vector<int>& nums, int left, int right) {
        swap(nums[left], nums[left + random() % (right - left + 1)]);
        int pivot = nums[left], slow = left + 1, fast = left + 1;
        while (fast <= right) {
            if (pivot < nums[fast]) {
                swap(nums[slow++], nums[fast]);
            }
            fast++;
        }

        swap(nums[left], nums[--slow]);
        return slow;
    }

public:
    int findKthLargest(vector<int>& nums, int k) {
        int l = 0, r = nums.size() - 1;
        k--;

        while (l <= r) {
            int n = partition(nums, l, r);
            if (n == k)
                return nums[n];
            if (n < k) {
                l = n + 1;
            } else {
                r = n - 1;
            }
        }
        return -1;
    }