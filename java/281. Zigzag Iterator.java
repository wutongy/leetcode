// O(n * size(n))
public class ZigzagIterator {
    Queue<Iterator<Integer>> queue;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if (v1.size() > 0) {
            queue.offer(v1.iterator());
        }
        if (v2.size() > 0) {
            queue.offer(v2.iterator());
        }
    }

    public int next() {
        Iterator<Integer> iter = queue.poll();
        int res = iter.next();
        if (iter.hasNext()) {
            queue.offer(iter);
        }
        return res;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
