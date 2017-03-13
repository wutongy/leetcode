class MinStack {
private:
    stack<pair<int, int>> stk;
public:
    /** initialize your data structure here. */
    MinStack() {

    }

    void push(int x) {
        int min;
        if (stk.empty()) {
            min = x;
        } else {
            min = std::min(stk.top().second, x);
        }
        stk.push({x, min});
    }

    void pop() {
        stk.pop();
    }

    int top() {
        return stk.top().first;
    }

    int getMin() {
        return stk.top().second;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */