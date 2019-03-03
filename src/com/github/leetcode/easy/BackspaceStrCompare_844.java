package com.github.leetcode.easy;

import java.util.Stack;

public class BackspaceStrCompare_844 {

	public static void main(String[] args) {
		System.out.println("Cai Test backspaceCompare = " + backspaceCompare("ab#c", "ad#c"));
		System.out.println("Cai Test backspaceCompare = " + backspaceCompare("ab##", "c#d#"));
		System.out.println("Cai Test backspaceCompare = " + backspaceCompare("a##c", "#a#c"));
		System.out.println("Cai Test backspaceCompare = " + backspaceCompare("a#c", "b"));
		System.out.println("Cai Test backspaceCompare = " + backspaceCompare("aa#b", "b"));
	}
	
	// 7 ms, faster than 32.22% 
	// Approach #1: Build String
	// Time Complexity: O(M + N)
	// Space Complexity: O(M + N).
	public static boolean backspaceCompare(String s, String t) {
		return buildStr(s).equals(buildStr(t));
	}
	
	public static String buildStr(String s) {
		Stack<Character> stack = new Stack<>();
		// loop --- from start to end!!!
		int i = 0;
		while (i < s.length()) {
			if (s.charAt(i) == '#') {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.add(s.charAt(i));
			}
			i++;
		}
		return String.valueOf(stack);//!!!
	}

	// 4 ms, faster than 98.08%
	// Approach #2: Tow Pointers
	// Time Complexity: O(M + N), where M,N are the lengths of S and T respectively.
	// Space Complexity: O(1).
//	public static boolean backspaceCompare(String s, String t) {
//		int i = s.length() - 1;
//		int j = t.length() - 1;
//		int skipS = 0;
//		int skipT = 0;
//		
//		while (i >= 0 || j >= 0) {
//			while (i >= 0) {
//				if (s.charAt(i) == '#') {
//					skipS++;
//					i--;
//				} else if (skipS > 0) {
//					skipS--;
//					i--;
//				} else {
//					break;
//				}
//			}
//			while (j >= 0) {
//				if (t.charAt(j) == '#') {
//					skipT++;
//					j--;
//				} else if (skipT > 0) {
//					skipT--;
//					j--;
//				} else {
//					break;
//				}
//			}
//			
//			if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
//				return false;
//			}
//			
//			// if one str has some remaining chars
//			if (i >= 0 && j < 0) {
//				return false;
//			} else if (j >= 0 && i < 0) {
//				return false;
//			}
//			
//			// simplify conditions
////			if ((i >= 0) != (j >=0)) {
////				return false;
////			}
//			
//			i--;
//			j--;
//		}
//        return true;
//    }
}
