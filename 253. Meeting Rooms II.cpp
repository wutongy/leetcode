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
    int minMeetingRooms(vector<Interval>& intervals) {
        vector<pair<int, int>> record;
        for (Interval i : intervals) {
            record.push_back({i.start, 1});
            record.push_back({i.end, -1});
        }
        sort(begin(record), end(record));
        int res = 0, accum = 0;
        for (auto elem : record) {
            res = max(res, accum += elem.second);
        }
        return res;
    }
};