class MyQueue {
    Stack<Integer> first = new Stack<>();
    Stack<Integer> second = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        first.push(x);
    }
    
    public int pop() {
        if(empty()){
            return -1;
        }
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        int removed = second.pop();
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return removed;
    }
    
    public int peek() {
         if(empty()){
            return -1;
        }
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        int peekItem = second.peek();
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return peekItem;
    }
    
    public boolean empty() {
        return first.isEmpty();
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