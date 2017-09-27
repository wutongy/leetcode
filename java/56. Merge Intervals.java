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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        intervals.sort(new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        int i = 0;
        while (i < intervals.size()) {
            int j = i + 1, right = intervals.get(i).end;
            while (j < intervals.size() && intervals.get(j).start <= right) {
                right = Math.max(right, intervals.get(j).end);
                ++j;
            }
            res.add(new Interval(intervals.get(i).start, right));
            i = j;
        }
        return res;
    }
}
