package com.github.leetcode.easy;

public class NumberOf1Bits_191 {

	public static void main(String[] args) {
		System.out.println("Cai Test = " + hammingWeight(-3));
		System.out.println("Cai Test = " + hammingWeight(3));
	}
	
	// 0 ms, faster than 100.00%
	//In Java, there is no unsigned integer type. In this case, the input will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
	// The run time depends on the number of 1-bits in n. 
	// In the worst case, all bits in n are 1-bits. In case of a 32-bit integer, the run time is O(1)
	public static int hammingWeight(int n) {
		int count = 0;
		while ( n != 0) {
			n = n & (n - 1);
			count++;
		}
		
		return count;
	}
	
	// Not use toBinaryString()
	// Time Complexity is O(1). Space Complexity is O(1).
//	public static int hammingWeight(int n) {
//		int count = 0;
//		int mask = 1;
//		for (int i = 0; i < 32; i++) {
//			if ((n & mask) != 0) {
//				count++;
//			}
//			mask <<= 1;
//		}
//		return count;
//	}

	// 1 ms, faster than 88.27%
//	public static int hammingWeight(int n) {
//		String bits = Integer.toBinaryString(n);
//		int count = 0;
//		for (int i = 0; i < bits.length(); i ++) {
//			if (bits.charAt(i) == '1') {
//				count++;
//			}
//		}
//		return count;
//	}
}
