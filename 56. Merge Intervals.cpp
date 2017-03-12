/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:
    static bool myCompare(Interval& a, Interval &b) {
        return a.start < b.start || (a.start == b.start && a.end < b.end);
    }
    vector<Interval> merge(vector<Interval>& intervals) {
        if (intervals.size() < 2) return intervals; 
        sort(intervals.begin(), intervals.end(), myCompare);
        vector<Interval> res;
        res.push_back(intervals[0]);
        int i = 1;
        while (i < intervals.size()) {
            if (intervals[i].start <= res[res.size() - 1].end) {
                res[res.size() - 1].end = max(res[res.size() - 1].end, intervals[i].end);
            } else {
                res.push_back(intervals[i]);
            }
            i++;
        }
        return res;
    }
};