package com.github.leetcode.easy_top100;

import java.util.LinkedList;
import java.util.Stack;

public class ValidParentheses20_top4 {

	public static void main(String[] args) {
		ValidParentheses20_top4 obj = new ValidParentheses20_top4();
		
		String str1 = "()";
		String str2 = "(";
		String str3 = "({[()]})";
		String str4 = "({{][}})";
		
		System.out.println("Samuel Test isValid = " + obj.isValid(str1));// true
		System.out.println("Samuel Test isValid = " + obj.isValid(str2));// false
		System.out.println("Samuel Test isValid = " + obj.isValid(str3));// true
		System.out.println("Samuel Test isValid = " + obj.isValid(str4));// false
	}

	// 1 ms, faster than 98.58%
	// Approach 1: Stack
	// TC: O(n)
	// SC: O(n)
	public boolean isValid(String s) {
		// put the right side into stack
		final char[] chars = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (char ch : chars) {
			if (ch == '(') {
				stack.push(')');
			} else if (ch == '[') {
				stack.push(']');
			} else if (ch == '{') {
				stack.push('}');
			} else {
				// !!! pruning !!!
				if (stack.isEmpty() || stack.pop() != ch) {
					return false;
				}
			}
		}
		return stack.isEmpty();//!!! "]]]]"
	}
	
//	// My solution ---- 不简洁，我还可以做得更好一些!!!
//	// Approach 1: Stack
//	// TC: O(n)
//	// SC: O(n)
//	public boolean isValid(String s) {
//		char[] chs = s.toCharArray();
//		final int n = chs.length;
//		Stack<Character> stack = new Stack<>();
//		for (int i = 0; i < n; i++) {
//			char ch = chs[i];
//			if (ch == '(' || ch == '{' || ch == '[') {
//				stack.push(ch);
//			} else {
//				if (!stack.isEmpty()) {
//					if (ch == ')' && stack.peek() == '(') {
//						stack.pop();
//					} else if (ch == ']' && stack.peek() == '[') {
//						stack.pop();
//					} else if (ch == '}' && stack.peek() == '{') {
//						stack.pop();
//					}
//				}
//			}
//		}
//		
//		return stack.isEmpty();
//	}
}
