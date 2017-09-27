// O(1)
class PhoneDirectory {
    Queue<Integer> queue;
    int max;
    Set<Integer> used;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        queue = new LinkedList<>();
        max = maxNumbers;
        used = new HashSet<>();
        for (int i = 0; i < maxNumbers; ++i) {
            queue.offer(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (!queue.isEmpty()) {
            int res = queue.poll();
            used.add(res);
            return res;
        }
        return -1;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (number >= max || number < 0 || used.contains(number)) {
            return false;
        }
        return true;
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (used.contains(number)) {
            used.remove(number);
            queue.offer(number);
            max = Math.max(max, number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
