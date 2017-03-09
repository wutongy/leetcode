class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        vector<int> result;
        unordered_map<int, int> hmap;
        for (int a: nums1) {
            hmap[a]++;
        }
        for (int b: nums2) {
            if (hmap.find(b) != hmap.end() && --hmap[b] >= 0) result.push_back(b);
        }
        return result;
    }
};