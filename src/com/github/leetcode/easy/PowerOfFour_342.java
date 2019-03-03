package com.github.leetcode.easy;

/**
 * https://leetcode.com/problems/power-of-four/
 * 
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?

 * @author Samuel.Cai
 */
public class PowerOfFour_342 {

	public static void main(String[] args) {
		System.out.println("Cai Test = " + isPowerOfFour(16));
		System.out.println("Cai Test = " + isPowerOfFour(5));
		System.out.println("Cai Test = " + isPowerOfFour(2));
		System.out.println("Cai Test = " + isPowerOfFour(8));
	}

	// 1 ms, faster than 100.00%
	// First,greater than 0.Second,only have one '1' bit in their binary notation,so we use x&(x-1) to delete the lowest '1',and if then it becomes 0,it prove that there is only one '1' bit.
	// Third,the only '1' bit should be locate at the odd location,for example,16.It's binary is 00010000.So we can use '0x55555555' to check if the '1' bit is in the right place.With this thought we can code it out easily!
	public static boolean isPowerOfFour(int n) {
		// How do you get '0x55555555' value?
		// 0x55555555 is 1010101010101010101010101010101 in binary with a length of 32
		// ...0101 0101 ---...0x55
		return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
	}
	
//	// 1 ms, faster than 100.00% 
	// problematic issue: refer to Approach #3 Mathematics https://leetcode.com/articles/power-of-three/
//	public static boolean isPowerOfFour(int n) {
//		return (Math.log10(n) / Math.log10(4)) % 1 == 0;
//    }
}
