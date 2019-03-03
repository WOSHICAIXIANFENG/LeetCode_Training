package com.github.leetcode.easy;

public class AddStrings_415 {

	public static void main(String[] args) {
		System.out.println("Cai Test addStrings = " + addStrings("3400123", "32"));
		System.out.println("Cai Test addStrings = " + addStrings("11", "999999"));
	}

	// 11 ms, faster than 90.42%
	public static String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--,j--) {
			int x = i < 0 ? 0 : num1.charAt(i) - '0';
			int y = j < 0 ? 0 : num2.charAt(j) - '0';
			sb.append((x + y + carry) % 10);
			// or, but append is better than insert
			sb.insert(0, (x + y + carry) % 10);
			carry = (x + y + carry) / 10;
		}
		return sb.reverse().toString();
		//return sb.toString();
    }
}
