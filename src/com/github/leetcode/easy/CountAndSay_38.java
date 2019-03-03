package com.github.leetcode.easy;

public class CountAndSay_38 {

	public static void main(String[] args) {
		System.out.println("Cai Test countAndSay = " + countAndSay(1));
		System.out.println("Cai Test countAndSay = " + countAndSay(2));
		System.out.println("Cai Test countAndSay = " + countAndSay(3));
		System.out.println("Cai Test countAndSay = " + countAndSay(4));
		System.out.println("Cai Test countAndSay = " + countAndSay(5));
		System.out.println("Cai Test countAndSay = " + countAndSay(6));
		System.out.println("Cai Test countAndSay = " + countAndSay(7));
		System.out.println("Cai Test countAndSay = " + countAndSay(8));
		System.out.println("Cai Test countAndSay = " + countAndSay(9));
		System.out.println("Cai Test countAndSay = " + countAndSay(10));
	}

	// 3 ms, faster than 98.75% 
	public static String countAndSay(int n) {
		if (n == 1) {
			return "1";
		} else {
			return sayPreviousStr(countAndSay(n - 1));
		}
    }
	
	public static String sayPreviousStr(String preStr) {
		StringBuilder result = new StringBuilder();
		int count = 1;
		for (int i = 0; i < preStr.length(); i ++) {
			if (i + 1 < preStr.length() && preStr.charAt(i) == preStr.charAt(i + 1)) {
				count ++;
			} else {
				result.append(count).append(preStr.charAt(i));
				count = 1;
			}
		}
		return result.toString();
	}
}
