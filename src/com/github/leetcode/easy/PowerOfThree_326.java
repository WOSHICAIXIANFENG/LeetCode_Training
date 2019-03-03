package com.github.leetcode.easy;

public class PowerOfThree_326 {

	public static void main(String[] args) {
		System.out.println("Cai Test  = " + isPowerOfThree(27));
		System.out.println("Cai Test  = " + isPowerOfThree(0));
		System.out.println("Cai Test  = " + isPowerOfThree(9));
		System.out.println("Cai Test  = " + isPowerOfThree(45));
	}

//	// 12 ms, faster than 99.94%
//	public static boolean isPowerOfThree(int n) {
		// 3^19 = 1162261467, which is the maximum value and close value to max Integer of Java
//		return n > 0 && 1162261467 % n == 0;
//	}
	
//	// 14 ms, faster than 59.74%
//	public static boolean isPowerOfThree(int n) {
//		//after 19, 3^20, 21,22.... will over the max Integer value, that's why we use Math.pow() API
//        return n > 0 && Math.pow(3, 31) % n == 0;
//    }
	
	// Mathematics: https://leetcode.com/articles/power-of-three/
	// This solution is problematic because we start using double s, which means we are subject to precision errors. This means, we should never use == when comparing doubles. That is because the result of Math.log10(n) / Math.log10(3) could be 5.0000001 or 4.9999999. 
	public static boolean isPowerOfThree(int n) {
		return (Math.log10(n) / Math.log10(3)) % 1 == 0;
	}
	
//	// 32 ms, faster than 7.28%
//	// Time Complexity: 2*O(log3^n) --- Integer.toString(,) String.matches()  --- O(log3^n)
//	// Space Complexity: O(log3^n) --- The string of the base 3 representation of the number.
//	public static boolean isPowerOfThree(int n) {
//		return Integer.toString(n, 3).matches("^10*$");
//	}
	
//	// 13 ms, faster than 84.66%
//	// Time complexity: O(log3^n)
//	// Space complexity: O(1)
//	public static boolean isPowerOfThree(int n) {
//		if (n < 1) {
//			return false;
//		}
//		
//		while (n % 3 == 0) {
//			n = n /3;
//		}
//		return n == 1;
//	}
}
