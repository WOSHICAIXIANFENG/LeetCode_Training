package com.github.leetcode.easy_top100;

public class CountAndSay38_top44 {

	public static void main(String[] args) {
		CountAndSay38_top44 obj = new CountAndSay38_top44();
		System.out.println("Cai Test countAndSay = " + obj.countAndSay(1));
		System.out.println("Cai Test countAndSay = " + obj.countAndSay(2));
		System.out.println("Cai Test countAndSay = " + obj.countAndSay(3));
		System.out.println("Cai Test countAndSay = " + obj.countAndSay(4));
		System.out.println("Cai Test countAndSay = " + obj.countAndSay(5));
		System.out.println("Cai Test countAndSay = " + obj.countAndSay(6));
		System.out.println("Cai Test countAndSay = " + obj.countAndSay(7));
		System.out.println("Cai Test countAndSay = " + obj.countAndSay(8));
		System.out.println("Cai Test countAndSay = " + obj.countAndSay(9));
		System.out.println("Cai Test countAndSay = " + obj.countAndSay(10));
	}

	// 1 ms, faster than 98.89% 
	// Approach 1: Recursion !!!
	// TC: O(n * len) --- l is the avg len of number
	public String countAndSay(int n) {
		if (n == 1) {
			return "1";
		} 
		return sayPreviousStr(countAndSay(n - 1));
	}
	
	public String sayPreviousStr(String preNumStr) {
		StringBuilder sb = new StringBuilder();
		int count = 1;
		final int l = preNumStr.length();
		for (int i = 0; i < l; i++) {
			// if numStr has continues same char
			while (i < l - 1 && preNumStr.charAt(i) == preNumStr.charAt(i + 1)) {
				count++;
				i++;
			}
			sb.append(count).append(preNumStr.charAt(i));
			// !!!!
			count = 1;// Don't forget to reset count val
		}
		return sb.toString();
	}
}
