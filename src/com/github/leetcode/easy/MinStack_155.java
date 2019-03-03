package com.github.leetcode.easy;

import java.util.Stack;

/**
 * 
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

 * @author Samuel
 * 100 ms, faster than 64.67% 
 */
public class MinStack_155 {
	long min = Integer.MAX_VALUE;
    Stack<Long> stack;
    
    /** initialize your data structure here. */
    public MinStack_155() {
    	stack = new Stack<>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()) {
        	stack.push(0L);
        	min = x;
        } else {
        	stack.push(x - min);// Overflows INT scope when MIN_VALUE - MAX_VALUE, so we need to use Long for type of Stack Element
        	if (x < min) {
        		min = x;
        	}
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) return;
        
        long pop = stack.pop();
        
        if (pop < 0) min = min - pop; // if negative, increase the min value
    }
    
    public long top() {
        long top = stack.peek();
        if (top > 0) {
        	return top + min;
        } else {
        	return min;
        }
    }
    
    public long getMin() {
        return min;
    }
    
    // ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
    // [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
	public static void main(String[] args) {
		MinStack_155 minStack = new MinStack_155();
//		minStack.push(Integer.MAX_VALUE - 1);
//		minStack.push(Integer.MAX_VALUE - 1);
//		minStack.push(Integer.MAX_VALUE);
//		// stack: 0, 2, -1, min = -3
//		//System.out.println("Samuel Test minStack getMin = " + minStack.getMin());  // --> Returns -3.
//		
//		// stack: 0, 2,  min = -2
//		System.out.println("Samuel Test minStack getMin = " + minStack.top());   // --> Returns 0.
//		minStack.pop();
//		System.out.println("Samuel Test minStack getMin = " + minStack.getMin());  // --> Returns -3.
//		minStack.pop();
//		System.out.println("Samuel Test minStack getMin = " + minStack.getMin()); 
//		minStack.pop();
		
		System.out.println("-----------------------------------------------"); 
		// -------------------------------------
		minStack.push(Integer.MAX_VALUE);
		System.out.println("Samuel Test minStack getMin = " + minStack.top());
		System.out.println("Samuel Test minStack getMin = " + minStack.getMin()); 
		System.out.println("-----------------------------------------------"); 
		minStack.push(Integer.MIN_VALUE);
		System.out.println("Samuel Test minStack getMin = " + minStack.top());
		System.out.println("Samuel Test minStack getMin = " + minStack.getMin()); 
		minStack.pop();
		System.out.println("Samuel Test minStack getMin = " + minStack.getMin()); 
	}

}
