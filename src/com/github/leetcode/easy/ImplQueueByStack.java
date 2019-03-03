package com.github.leetcode.easy;

import java.util.Stack;

public class ImplQueueByStack {

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();

		queue.push(1);
		queue.push(2);  
		System.out.println("Cai Test = " + queue.peek());  // returns 1
		System.out.println("Cai Test = " + queue.pop());   // returns 1
		System.out.println("Cai Test = " + queue.empty()); // returns false
	}
}

// 56 ms, faster than 76.28%
class MyQueue {
	private Stack<Integer> s1 = new Stack<>();
	private Stack<Integer> s2 = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        // 3 -->s1: 2,1 ---> s2:1,2
    	while (!s1.isEmpty()) {
    		s2.push(s1.pop());
    	}
    	//s1:3
    	s1.push(x);
    	//2,1,3
    	while (!s2.isEmpty()) {
    		s1.push(s2.pop());
    	}
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return s1.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return s1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}
