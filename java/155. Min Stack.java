// O(n)
class MinStack {
    private ArrayList<Integer> stack;
    int index;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<>();
        index = -1;
    }

    public void push(int x) {
        int minNum = Integer.MAX_VALUE;
        if (index > 0) {
            minNum = stack.get(index - 1);
        }
        stack.add(Math.min(x, minNum));
        stack.add(x);
        index += 2;
    }

    public void pop() {
        if (index > 0) {
            stack.remove(index);
            stack.remove(index - 1);
            index -= 2;
        }
    }

    public int top() {
        return stack.get(index);
    }

    public int getMin() {
        return stack.get(index - 1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

class MinStack {
    int min;
    Stack<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
