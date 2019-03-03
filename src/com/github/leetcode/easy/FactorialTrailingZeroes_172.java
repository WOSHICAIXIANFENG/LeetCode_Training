package com.github.leetcode.easy;

// https://leetcode.com/problems/factorial-trailing-zeroes/discuss/52367/My-explanation-of-the-Log(n)-solution
public class FactorialTrailingZeroes_172 {

	public static void main(String[] args) {
		System.out.println("Cai Test trailingZeroes = " + trailingZeroes(5));
		System.out.println("Cai Test trailingZeroes = " + trailingZeroes(3));
		System.out.println("Cai Test trailingZeroes = " + trailingZeroes(10));
	}
	
	// 12 ms, faster than 78.20%  
	// log5(n)
	public static int trailingZeroes(int n) {
		int count = 0;
		while (n != 0) {
			count += n / 5;
			n = n / 5;
		}
		return count;
	}
	
//	public static int trailingZeroes(int n) {
//		int result = 0;
//		for (int i = 5; i <= n; i *= 5) {
//			result += n / i;
//			if (i >= Integer.MAX_VALUE / 5) {
//				break;
//			}
//		}
//		return result;
//	}

//	// Runtime: 18 ms, faster than 13.91%. Memory Usage: 26.8 MB, less than 42.94%
//	// 10 is the product of 2 and 5. In n!, we need to know how many 2 and 5, and the number of zeros is the minimum 
//	// of the number of 2 and the number of 5. Since multiple of 2 is more than multiple of 5, the number of zeros is dominant by the number of 5.
//	// return n/5 + n/25 + n/125 + n/625 + n/3125 + ...
//	// a call stack depth of Log5(n). Time complexity would be O(log5n)
//	public static int trailingZeroes(int n) {
//		return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
//	}
}
