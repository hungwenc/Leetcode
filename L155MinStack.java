/*L155. Min Stack
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
*/
// sol1. use two stacks
public class MinStack {
    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> min_stack;
    int min = Integer.MAX_VALUE;
    public MinStack() {
        stack = new Stack<Integer>();
        min_stack = new Stack<Integer>(); // track min value
    }
    
    // only push and pop will affect the min value
    public void push(int x) {
        // *wrong : if(min_stack.isEmpty() || x <= min){ 
        if(min_stack.isEmpty() || x <= min_stack.peek()){ // watch out here!
            min_stack.push(x);
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        System.out.println(stack.peek().equals(min_stack.peek()));
        System.out.println(stack.peek() == min_stack.peek());
        if(stack.peek().equals(min_stack.peek())){
            min_stack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_stack.peek();
    }
}

// sol2. use only one stack
/*
public class MinStack {
    long min;
    Stack<Long> stack;

    public MinStack(){
        stack=new Stack<>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(0L);
            min=x;
        }else{
            stack.push(x-min);//Could be negative if min value needs to change
            if (x<min) min=x;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        
        long pop=stack.pop();
        
        if (pop<0)  min=min-pop;//If negative, increase the min value
        
    }

    public int top() {
        long top=stack.peek();
        if (top>0){
            return (int)(top+min);
        }else{
           return (int)(min);
        }
    }

    public int getMin() {
        return (int)min;
    }
}

*/

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
