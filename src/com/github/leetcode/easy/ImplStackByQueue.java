package com.github.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class ImplStackByQueue {

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(2);  
		//System.out.println("Cai Test = " + stack.top());   // returns 2
		//System.out.println("Cai Test = " + stack.pop()); // returns 2
		System.out.println("Cai Test = " + stack.empty());   // returns false
		
		System.out.println("Cai Test = " + stack.pop());
		System.out.println("Cai Test = " + stack.top());
		System.out.println("Cai Test = " + stack.empty());
	}
}

// 57 ms, faster than 63.49%
// push(), empty(), top() --- O(1)
// pop() --- O(n)
//class MyStack {
//    private Queue<Integer> q1 = new LinkedList<>();
//    private Queue<Integer> q2 = new LinkedList<>();
//    private int top;
//    
//    /** Initialize your data structure here. */
//    public MyStack() {
//        
//    }
//    
//    /** Push element x onto stack. */
//    public void push(int x) {
//        q1.add(x);
//        top = x;
//    }
//    
//    /** Removes the element on top of the stack and returns that element. */
//    public int pop() {
//        // 1, 2, 3
//        while (q1.size() > 1) {
//        	top = q1.remove();
//            q2.add(top);
//        }
//        int t = q1.remove();
//        Queue<Integer> temp = q2;
//        q2 = q1;
//        q1 = temp;
//        return t;
//    }
//    
//    /** Get the top element. */
//    public int top() {
//        return top;
//    }
//    
//    /** Returns whether the stack is empty. */
//    public boolean empty() {
//        return q1.isEmpty();
//    }
//}

// 57 ms, faster than 63.49%
// push() --- O(n)
class MyStack {
	private Queue<Integer> queue = new LinkedList<>();
	
    /** Initialize your data structure here. */
    public MyStack() {
    	
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        while (size > 1) {
        	queue.add(queue.remove());
        	size --;
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
    	return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
    	return queue.isEmpty();
    }
}