/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
// O(nlogn)
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                if (a.start == b.start) {
                    return a.end - b.end;
                }
                return a.start - b.start;
            }
        });
        PriorityQueue<Interval> pq = new PriorityQueue<>(1, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });
        for (int i = 0; i < intervals.length; ++i) {
            if (pq.isEmpty() || pq.peek().end > intervals[i].start) {
                pq.offer(intervals[i]);
            } else {
                pq.poll();
                pq.offer(intervals[i]);
            }
        }
        return pq.size();
    }
}
