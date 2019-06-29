package com.github.leetcode.easy_top100;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class MinStack155_top18 {
	
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
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

// A better Idea !!!
// 45 ms, faster than 98.97%
class MinStack {
	private Node topNode;
	
	class Node {
		private int val;
		private int min;
		private Node preNode;
		
		public Node(int val, Node preNode) {
			this.val = val;
			this.min = preNode == null ? val : Math.min(val, preNode.min);
			this.preNode = preNode;
		}
	}
	
	public MinStack() {
		this.topNode = null;
	}
	
	// TC: O(1)
	public void push(int x) {
		topNode = new Node(x, topNode);
	}
	
	// TC: O(1)
	public void pop() {
		if (topNode == null) {
			throw new EmptyStackException();
		}
		topNode = topNode.preNode;
	}
	
	// TC: O(1)
	public int top() {
		if (topNode == null) {
			throw new EmptyStackException();
		}
		return topNode.val;
	}
	
	// TC: O(1)
	public int getMin() {
		if (topNode == null) {
			throw new EmptyStackException();
		}
		return topNode.min;
	}
}

//// 47 ms, faster than 70.92%
//class MinStack {
//	private int min = Integer.MAX_VALUE;
//	private int size = 0;
//	private List<Integer> stack;
//	
//	public MinStack() {
//		this.stack = new ArrayList<>();
//	}
//	
//	// TC: O(1)
//	public void push(int x) {
//		if (x < min) {
//			min = x;
//		}
//		size++;
//		stack.add(x);
//	}
//	
//	// TC: O(1)
//	public void pop() {
//		if (size == 0) {
//			throw new EmptyStackException();
//		}
//		int top = top();
//		size--;
//		stack.remove(size);
//		if (top == min) {
//			//!!! 
//			min = Integer.MAX_VALUE;//!!! Don't forget
//			resetMin();
//		}
//	}
//	
//	// TC: O(1)
//	public int top() {
//		if (size == 0) {
//			throw new EmptyStackException();
//		}
//		return stack.get(size - 1);// size - 1 , not size--!!!
//	}
//	
//	// TC: O(1)
//	public int getMin() {
//	  if (size == 0) {
//		  throw new EmptyStackException();
//	  }
//	  return min;
//	}
//	
//	// TC: O(n)
//	private void resetMin(){
//		for (int val : stack) {
//			min = Math.min(min, val);
//		}
//	}
//}
