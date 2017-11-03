// O(n)
class MovingAverage {

    /** Initialize your data structure here. */
    Deque<Integer> dq;
    int sum, cap;
    public MovingAverage(int size) {
        sum = 0;
        cap = size;
        dq = new ArrayDeque<>();
    }

    public double next(int val) {
        sum += val;
        dq.offer(val);
        if (cap == 0) {
            sum -= dq.poll();
        } else {
            --cap;
        }
        return sum * 1.0 / dq.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
