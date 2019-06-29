package com.github.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class RemoveKDigits_402 {

	public static void main(String[] args) {
		RemoveKDigits_402 obj = new RemoveKDigits_402();
		System.out.println("Cai Test = " + obj.removeKdigits("1432219", 3));
		System.out.println("Cai Test = " + obj.removeKdigits("10200", 1));
		System.out.println("Cai Test = " + obj.removeKdigits("10", 2));
		System.out.println("Cai Test = " + obj.removeKdigits("10", 1));
	}
	
	/**
	 * The length of num is less than 10002 and will be ≥ k.
	 * ---> so the Brute Force O(n^2) will time out, you have to figure out O(n) solution
	 */
	
//	// 7 ms, faster than 73.10%
//	// Approach 2: Use char[] to simulate Monotonous increase Stack --- 处理边界时并不容易!!! 忽略这种解法!
//	// TC: O(n)
//	// SC: O(n)
//	public String removeKdigits(String num, int k) {
//		final int n = num.length();
//		char[] stack = new char[n];
//		int digits = n - k;
//		int top = 0;
//		for (int i = 0; i < num.length(); i++) {
//			char c = num.charAt(i);
//			// keep stack is increase sort
//			while (k > 0 && top > 0 && stack[top - 1] > c) {
//				top--;// simulate pop up --- pop up means removing digits from the stack
//				k--;
//			}
//			stack[top++] = c;
//		}
//
//		// find the first char != '0'
//		int index = 0;
//		while (index < digits && stack[index] == '0') {
//			index++;
//		}
//		// case: 10,k=2 --> top == 0, index == 1
//		// System.out.println("Cai Test top = " + top + " ,index = " + index);
//		// System.out.println("Cai Test stack = " + Arrays.toString(stack));
//		return index == digits ? "0" : new String(stack, index, digits - index);
//	}
	
	// 6 ms, faster than 77.19%
	
	// Approach 1: Monotonous increase stack + k limit
	// TC: O(n)
	// SC: O(n) --- in the worst case, the stack will have n elements
	public String removeKdigits(String num, int k) {
		final int len = num.length();
		if (k >= len) return "0";
		
		Deque<Character> stack = new ArrayDeque<>();
		for (int i = 0; i < len; i++) {
			// keep stack is increase sort --- pop up means remove digit, so, we use strict small <
			while (k > 0 && !stack.isEmpty() && num.charAt(i) < stack.peek()) {
				stack.pop();
				k--;
			}
			stack.push(num.charAt(i));//!!!
		}
		
		// e.g --- 12354 ---> 1234 --> still need to pop 4,3
		while (k > 0) {
			stack.pop();
			k--;
		}
		
		// construct the number from the stack
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		sb.reverse();
		
		// corner case --- remove all starting char '0' 
		// !!! need > 1 not > 0, e.g. '10', k == 1 to output 0, not empty
		while (sb.length() > 1 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}
        return sb.toString();
    }
}
