// O(1)
class HitCounter {
    private class CounterNode {
        int timestamp;
        int count;
        CounterNode next;
        CounterNode(int timeStamp, int times) {
            this.timestamp = timeStamp;
            this.count = times;
        }
    }
    private CounterNode head;
    private CounterNode cur;
    private int counter;
    /** Initialize your data structure here. */
    public HitCounter() {
        head = null;
        cur = null;
        counter = 0;
    }

    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        ++counter;
        if (head == null) {
            head = new CounterNode(timestamp, 1);
            cur = head;
        } else if (cur.timestamp == timestamp) {
            ++cur.count;
        } else {
            CounterNode next = new CounterNode(timestamp, 1);
            cur.next = next;
            cur = cur.next;
        }
    }

    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (head != null && (timestamp - head.timestamp >= 300)) {
            counter -= head.count;
            head = head.next;
        }
        return counter;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
