// O(n)
public class MyQueue {
    private ArrayList<Integer> stackA, stackB;
    /** Initialize your data structure here. */
    public MyQueue() {
        stackA = new ArrayList<Integer>();
        stackB = new ArrayList<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackB.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stackA.isEmpty()) {
            int size = stackB.size();
            while (size > 0) {
                stackA.add(stackB.remove(size - 1));
                --size;
            }
        }
        return stackA.remove(stackA.size() - 1);
    }

    /** Get the front element. */
    public int peek() {
        Integer front = this.pop();
        stackA.add(front);
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackA.isEmpty() && stackB.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
