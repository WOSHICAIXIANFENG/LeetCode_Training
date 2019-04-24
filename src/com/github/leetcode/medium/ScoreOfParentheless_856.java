package com.github.leetcode.medium;

public class ScoreOfParentheless_856 {

	public static void main(String[] args) {
		ScoreOfParentheless_856 obj = new ScoreOfParentheless_856();
		String s1 = "()";
		String s2 = "(())";
		String s3 = "()()";
		String s4 = "(()(()))";
		System.out.println("Cai Test = " + obj.scoreOfParentheses(s1));
		System.out.println("Cai Test = " + obj.scoreOfParentheses(s2));
		System.out.println("Cai Test = " + obj.scoreOfParentheses(s3));
		System.out.println("Cai Test = " + obj.scoreOfParentheses(s4));
		
		String s5 = "(()()((())))";
		System.out.println("Cai Test = " + obj.scoreOfParentheses(s5));
	}
	
	// 0 ms, faster than 100.00%
	
	// Approach 2: Counting --- scan from left to right, when we see '()', add 2^(d-1) to the answer
	// Convert the original string into a set of full balanced strings:
	// "(()(()))" ---> "(())" + "((()))"
	// "(()(()()))" ---> "(())" + "((()))" + "((()))"
	// TC: O(n)
	// SC: O(1)
//	public int scoreOfParentheses(String s) {
//		int len = s.length();
//		int sum = 0;
//		int d = 0;
//		for (int i = 0; i < len; i++) {
//			d += s.charAt(i) == '(' ? 1 : -1;
//			if (s.charAt(i) == '(' && s.charAt(i + 1) == ')') {//!!! since the string definitely will end with ')', the Short-circuit will avoid StringIndexOutOfBoundsException 
//				sum += 1 << (d -1);
//			}
//		}
//		return sum;
//	}

	// Approach 1: Recursion
	// TC: O(n) --- O(n^2)
	// best case "()()()..", worst case "((()))" --- you need to check the str is balanced in each () pair
	// SC: O(n)
	public int scoreOfParentheses(String s) {
        return score(s, 0, s.length() - 1);
    }
	
	private int score(String s, int l, int r) {
		// "()" ---> 1
		if (r - l == 1) return 1;
		int b = 0;
		for (int i = l; i < r; i++) {
			if (s.charAt(i) == '(') ++b;
			if (s.charAt(i) == ')') --b;
			if (b == 0) // balanced --> "()()()" --> "()" + "()()"
				return score(s, l, i) + score(s, i + 1, r);
		}
		// "(())" --- 2 * "()"
		return 2 * score(s, l + 1, r - 1);
	}
}
