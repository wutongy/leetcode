class MyQueue {
    Stack<Integer> main;
    Stack<Integer> backup;
    /** Initialize your data structure here. */
    public MyQueue() {
        main = new Stack<>();
        backup = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        backup.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (main.isEmpty()) {
            while (!backup.isEmpty()) {
                main.push(backup.pop());
            }
        }
        return main.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (main.isEmpty()) {
            while (!backup.isEmpty()) {
                main.push(backup.pop());
            }
        }
        return main.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return main.isEmpty() && backup.isEmpty();
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
