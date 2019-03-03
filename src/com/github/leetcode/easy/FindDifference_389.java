package com.github.leetcode.easy;

public class FindDifference_389 {

	public static void main(String[] args) {
		System.out.println("Cai Test findTheDifference = " + findTheDifference("abcd", "abcde"));
		System.out.println("Cai Test findTheDifference = " + findTheDifference("abcd", "abecd"));
		System.out.println("Cai Test findTheDifference = " + findTheDifference("abcd", "caebd"));
	}
	
	// 3 ms, faster than 98.83%
	// Approach 2: Use bit manipulation to solve problems eaily and efficiently.
	// Time Complexity: O(n)
	public static char findTheDifference(String s, String t) {
		int ans = t.charAt(t.length() - 1);
		for (int i = 0; i < s.length(); i++) {
			ans ^= t.charAt(i);
			ans ^= s.charAt(i);
		}
		return (char) ans;
	}	

	// 3 ms, faster than 98.83% 
	// Approach 1: Use ascii value
	// Time Complexity: O(n)
//	public static char findTheDifference(String s, String t) {
//        int asciiValue = t.charAt(t.length() - 1); // get the last char
//        for(int i = 0; i < s.length(); ++i) {
//        	asciiValue += (int)t.charAt(i);
//        	asciiValue -= (int)s.charAt(i);
//        }
//        return (char)asciiValue;
//    }
}
