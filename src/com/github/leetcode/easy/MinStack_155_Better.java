package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

// 97 ms, faster than 79.50% 
public class MinStack_155_Better {
	int index;
	List<Integer> numbers;
	int min;
	
	public MinStack_155_Better() {
		index = 0;
		numbers = new ArrayList<Integer>();
		min = Integer.MAX_VALUE;
	}
	
	//time complexity O(1)
	public void push(int x) {
		numbers.add(x);
		index ++;
		if (x < min) {
			min = x;
		}
	}

	//time complexity O(1) ---- O(n)
	public void pop() {
		if (index < 1) {
			throw new EmptyStackException();
		}
		
		int removeOne = top();
		index --;
		numbers.remove(index);
		if (removeOne == min) {
			if (numbers.size() > 0) {
				min = top();// pick up any element from the remaining array
				findMin();
			} else {
				min = Integer.MAX_VALUE;// Don't forget!!!
			}
		}
	}
	
	//time complexity O(n)
	private void findMin(){
		for (int num : numbers) {
			if (num < min) {
				min = num;
			}
		}
    }
	
	//time complexity O(1)
	public int top() {
		if (index < 1) {
			throw new EmptyStackException();
		}
		
        return numbers.get(index - 1);
    }

	//time complexity O(1)
    public int getMin() {
    	if (index < 1) {
			throw new EmptyStackException();
		}
    	
        return min;
    }
	
	public static void main(String[] args) {
		MinStack_155_Better minStack = new MinStack_155_Better();
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
