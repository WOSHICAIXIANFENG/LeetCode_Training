package com.github.leetcode.easy;

public class PowerOfTwo_231 {

	public static void main(String[] args) {
		System.out.println("Cai Test  = " + isPowerOfTwo(8));
		System.out.println("Cai Test  = " + isPowerOfTwo(10));
		System.out.println("Cai Test  = " + isPowerOfTwo(256));
	}

//	public static boolean isPowerOfTwo(int n) {
//        return n > 0 && Math.pow(2, 31) % n == 0;
//    }
	
//	public static boolean isPowerOfTwo(int n) {
//		return n > 0 && Integer.bitCount(n) == 1;
//	}
	
	// 1 ms, faster than 100.00%
	public static boolean isPowerOfTwo(int n) {
		return n > 0 && (n & (n - 1)) == 0;
	}
}
