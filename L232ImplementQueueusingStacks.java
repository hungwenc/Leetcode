/*L232. Implement Queue using Stacks
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- 
which means only push to top, peek/pop from top, size, 
and is empty operations are valid.
Depending on your language, stack may not be supported natively. 
You may simulate a stack by using a list or deque (double-ended queue), 
as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, 
no pop or peek operations will be called on an empty queue).
*/
public class MyQueue {
    // Stack<Integer> s1 = new Stack<Integer>();
    // Stack<Integer> s2 = new Stack<Integer>();
    Stack<Integer> s1;
    Stack<Integer> s2;
    /** Initialize your data structure here. */
    public MyQueue() {
        this.s1 = new Stack<Integer>();
        this.s2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(s1.isEmpty()){
            //move
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
            //add new element
            s1.push(x);
            //reverse it
            // here we can't use for... s1.size(), because the size will change in each loop (because of s1.pop())
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }else{
            //move
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            //add new element
            s2.push(x);
            //reverse it
            // here we can't use for... s2.size(), because the size will change in each loop (because of s2.pop())
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s1.isEmpty()){
            return s2.pop();
        }else {
            return s1.pop();
        }
    }
    
    /** Get the front element. */
    public int peek() {
        if(s1.isEmpty()){
            return s2.peek();
        }else {
            return s1.peek();
        }   
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(s1.isEmpty() && s2.isEmpty()) return true;
        return false; 
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

