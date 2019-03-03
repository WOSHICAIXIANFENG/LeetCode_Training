package com.github.leetcode.easy;

public class BinaryNumberWithAlterBits_693 {

	public static void main(String[] args) {
		System.out.println("Cai Test = " + hasAlternatingBits(5));
		System.out.println("Cai Test = " + hasAlternatingBits(7));
		System.out.println("Cai Test = " + hasAlternatingBits(11));
		System.out.println("Cai Test = " + hasAlternatingBits(10));
	}
	
	// 7 ms, faster than 61.22%
	// Time Complexity: O(1). For arbitrary inputs, we do O(w) work, where w is the number of bits in n.
	// however, w <= 32;
	// Space complexity: O(1), or alternatively O(w).
//	public static boolean hasAlternatingBits(int n) {
//		String bits = Integer.toBinaryString(n);
//		for (int i = 0; i < bits.length() - 1; i ++) {
//			if (bits.charAt(i) == bits.charAt(i + 1)) {
//				return false;
//			}
//		}
//        return true;
//    }
	
	// 6 ms, faster than 96.20%
	// Time Complexity: O(1). For arbitrary inputs, we do O(w) work, where w is the number of bits in n
	// w <= 32.
	// Space complexity: O(1)
	public static boolean hasAlternatingBits(int n) {
		int digit = n % 2;
		n = n / 2;
		while (n > 1) {
			if (digit == n % 2) {
				return false;
			}
			digit = n % 2;
			n = n / 2;
		}
		return true;
	}
}
