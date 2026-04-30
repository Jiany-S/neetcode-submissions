class MinStack {
    ArrayList<Integer> min;
    Stack<Integer> stack;
    int length;
    public MinStack() {
        stack = new Stack<>();
        min = new ArrayList<>();
        length = 0;
    }
    
    public void push(int val) {
        stack.push(val);
        if(length==0){
            min.add(val);
            length++;
            return;
        }
        min.add(Math.min(val,min.get(length-1)));
        length++;
    }
    
    public void pop() {
        stack.pop();
        min.remove(length-1);
        length--;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.get(length-1);
    }
}
