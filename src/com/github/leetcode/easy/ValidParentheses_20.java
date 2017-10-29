package com.github.leetcode.easy;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

 * @author Samuel
 *
 */
public class ValidParentheses_20 {

	public static void main(String[] args) {
		String str1 = "()";
		String str2 = "(";
		String str3 = "({[()]})";
		String str4 = "({{][}})";
		
		System.out.println("Samuel Test isValid = " + isValid(str1));
		System.out.println("Samuel Test isValid = " + isValid(str2));
		System.out.println("Samuel Test isValid = " + isValid(str3));
		System.out.println("Samuel Test isValid = " + isValid(str4));
	}
	
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		char[] chars = s.toCharArray();
		for (Character ch : chars) {
			if (ch == '(') {
				stack.push(')');
			} else if (ch == '[') {
				stack.push(']');
			} else if (ch == '{') {
				stack.push('}');
			} else {
				if (stack.isEmpty() || stack.pop() != ch) {
					return false;
				}
			}
		}
        return stack.isEmpty();
    }

}
