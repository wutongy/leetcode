public class MovingAverage {

    /** Initialize your data structure here. */
    LinkedList<Integer> ll;
    int sum;
    int len;
    public MovingAverage(int size) {
        ll = new LinkedList<>();
        sum = 0;
        len = size;
    }

    public double next(int val) {
        ll.addLast(val);
        sum += val;
        if (ll.size() > len) {
            int firstElem = ll.removeFirst();
            sum -= firstElem;
            return sum * 1.0 / len;
        }
        return sum * 1.0 / ll.size();
    }
}
