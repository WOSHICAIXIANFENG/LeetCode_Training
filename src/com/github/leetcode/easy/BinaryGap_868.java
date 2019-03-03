package com.github.leetcode.easy;

public class BinaryGap_868 {

	public static void main(String[] args) {
		System.out.println("Cai Test = " + binaryGap(22));
		System.out.println("Cai Test = " + binaryGap(5));
		System.out.println("Cai Test = " + binaryGap(6));
		System.out.println("Cai Test = " + binaryGap(8));
	}
	
	// A better solution to use -- bit operators
	// 6 ms, faster than 100.00%
	// Time complexity: O(log2^N). Note tht logN is the number of digits in the binary representation of N.
	// Space complexity: O(1).
	public static int binaryGap(int N) {
		int result = 0;
		int n = N;
		int previous = -1;
		for (int i = 0; i < 32; i++) {
			if ((n & 1) == 1) {
				if (previous != -1) {
					result = Math.max(result, i - previous);
				}
				previous = i;
			}
			n >>= 1;
		}
		
		return result;
	}
	
	// 8 ms, faster than 84.24%
//	public static int binaryGap(int N) {
//		String bitsStr = Integer.toBinaryString(N);
//		int result = 0;
//		int preIndex = -1;
//		for (int i = 0; i < bitsStr.length(); i++) {
//			char ch = bitsStr.charAt(i);
//			if (ch == '1') {
//				if (preIndex == -1) {
//					preIndex = i;
//				} else {
//					if (i - preIndex > result) {
//						result = i - preIndex;
//					}
//					preIndex = i;
//				}
//			}
//		}
//	    return result;
//	}

}
