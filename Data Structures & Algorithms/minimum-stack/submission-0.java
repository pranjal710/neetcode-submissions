class MinStack {

    Stack<int[]> stack;

    public MinStack() {
        this.stack = new Stack<>();
    }
    
    public void push(int val) {
        if(this.stack.size() == 0) {
            this.stack.push(new int[]{val, val});
        } else {
            this.stack.push(new int[]{val, Math.min(val, this.stack.peek()[1])});
        }
    }
    
    public void pop() {
        this.stack.pop();
    }
    
    public int top() {
        return this.stack.peek()[0];
    }
    
    public int getMin() {
        return this.stack.peek()[1];
    }
}
