class Solution {
public:
    string simplifyPath(string path) {
        vector<string> rec;
        for (int i = 0; i < path.size(); i++) {
            while (i < path.size() && path[i] == '/') {
                i++;
            }
            if (i >= path.size()) break;
            string s = "";
            while (i < path.size() && path[i] != '/') {
                s += path[i];
                i++;
            }
            if (s == ".") {
                continue;
            } else if (s == "..") {
                if (!rec.empty()) {
                    rec.pop_back();
                }
                continue;
            } else {
                rec.push_back(s);
            }
        }
        string res = "";
        for (int i = 0; i < rec.size(); i++) {
            res += '/' + rec[i];
        }
        return res == "" ? "/" : res;
    }
};