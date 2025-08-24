class MinStack {
    Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (!stack.isEmpty()) {
            int top[] = stack.peek();
            int min = Math.min(top[1], val);
            stack.push(new int[] { val, min });

        } else {

            stack.push(new int[] { val, val });
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        int top[] = stack.peek();
        return top[0];
    }

    public int getMin() {
        int top[] = stack.peek();
        return top[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */