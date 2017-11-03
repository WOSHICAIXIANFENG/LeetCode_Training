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
 *
 */
public class MinStack_155 {
	int min = Integer.MAX_VALUE;
    Stack<Integer> stack;
    
    /** initialize your data structure here. */
    public MinStack_155() {
    	stack = new Stack<>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()) {
        	stack.push(0);
        	min = x;
        } else {
        	stack.push(x - min);
        	if (x < min) {
        		min = x;
        	}
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) return;
        
        int pop = stack.pop();
        
        if (pop < 0) min = min - pop; // if negative, increase the min value
    }
    
    public int top() {
        int top = stack.peek();
        if (top > 0) {
        	return top + min;
        } else {
        	return min;
        }
    }
    
    public int getMin() {
        return min;
    }
	public static void main(String[] args) {
		MinStack_155 minStack = new MinStack_155();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		// stack: 0, 2, -1, min = -3
		System.out.println("Samuel Test minStack getMin = " + minStack.getMin());  // --> Returns -3.
		minStack.pop();
		// stack: 0, 2,  min = -2
		System.out.println("Samuel Test minStack getMin = " + minStack.top());   // --> Returns 0.
		System.out.println("Samuel Test minStack getMin = " + minStack.getMin());  // --> Returns -3.
	}

}
