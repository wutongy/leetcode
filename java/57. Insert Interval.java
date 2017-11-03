/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
// O(n)
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int i = 0;
        boolean contain = false;
        while (i < intervals.size()) {
            if (contain || intervals.get(i).end < newInterval.start) {
                res.add(intervals.get(i));
                ++i;
            } else if (intervals.get(i).start > newInterval.end) {
                res.add(newInterval);
                res.add(intervals.get(i));
                contain = true;
                ++i;
            } else {
                int left = Math.min(newInterval.start, intervals.get(i).start);
                int right= Math.max(newInterval.end, intervals.get(i).end);
                ++i;
                while (i < intervals.size() && right >= intervals.get(i).start) {
                    right = Math.max(right, intervals.get(i).end);
                    ++i;
                }
                res.add(new Interval(left, right));
                contain = true;
            }
        }
        if (!contain) {
            res.add(newInterval);
        }
        return res;
    }
}
