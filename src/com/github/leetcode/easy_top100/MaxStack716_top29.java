package com.github.leetcode.easy_top100;

import java.util.EmptyStackException;
import java.util.Stack;

public class MaxStack716_top29 {

	public static void main(String[] args) {
		MaxStack716_top29 obj = new MaxStack716_top29();
		
	}
	
	/**
	 * -1e7 <= x <= 1e7
	 * Number of operations won't exceed 10000.
     *
	 */
	
}

// Solution comes from :
// https://leetcode.com/articles/max-stack/

// Approach 1: Two Stacks.
// TC: A regular stack support pop, push, peek opertaions with O(1).  
// Another stack to keep the max value sequence.
// --- popMax fun O(n) --- peekMax fun O(1)
// SC: O(n)
class MaxStack {
	Stack<Integer> stack;
	Stack<Integer> maxStack;

	public MaxStack() {
		this.stack = new Stack<>();
		this.maxStack = new Stack<>();
	}

	// TC: O(1)
	public void push(int x) {
		stack.push(x);
		
		int max = x;
		if (!maxStack.isEmpty()) {
			max = Math.max(max, maxStack.peek());
		}
		maxStack.push(max);
	}

	// TC: O(1)
	public int pop() {
		if (stack.isEmpty()) {
			throw new EmptyStackException();
		}
		maxStack.pop();
		return stack.pop();
	}

	// TC: O(1)
	public int top() {
		if (stack.isEmpty()) {
			throw new EmptyStackException();
		}
		return stack.peek();
	}

	// TC: O(1)
	public int peekMax() {
		if (stack.isEmpty()) {
			throw new EmptyStackException();
		}
		return maxStack.peek();
	}

	// TC: O(n)
	public int popMax() {
		if (stack.isEmpty()) {
			throw new EmptyStackException();
		}
		int maxVal = peekMax();
		Stack<Integer> buffer = new Stack<>();
		while (top() != maxVal) {
			buffer.push(pop());//!!! call --> pop()
		}
		pop();// pop up the maxVal !!! call --> pop()
		while (!buffer.isEmpty()) {
			push(buffer.pop());// !!! call --> push()
		}
		return maxVal;
	}
}