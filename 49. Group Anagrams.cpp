class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        if (strs.empty()) return vector<vector<string>>();
        unordered_map<string, vector<string>> hmap;
        for (string s : strs) {
            string copy = s;
            sort(copy.begin(), copy.end());
            hmap[copy].push_back(s);
        }
        vector<vector<string>> res(hmap.size());
        int i = 0;
        for (auto it = hmap.begin(); it != hmap.end(); it++, i++) {
            res[i] = (*it).second;
        }
        return res;
    }
};

//Solution: custom sort using counting sort
string strSort(string& s) {
    int count[26] = {0}, n = s.size();
    for (int i = 0; i < n; i++) {
        count[s[i] - 'a']++;
    }
    int p = 0;
    string t(n, 'a');
    for (int j = 0; j < 26; j++) {
        for (int i = 0; i < count[j]; i++) {
            t[p++] += j;
        }
    }
    return t;
}