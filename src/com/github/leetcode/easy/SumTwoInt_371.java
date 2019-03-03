package com.github.leetcode.easy;

public class SumTwoInt_371 {

	public static void main(String[] args) {
		System.out.println("Cai Test = " + getSum(1, 2));
		System.out.println("Cai Test = " + getSum(-2, 3));
		System.out.println("Cai Test = " + getSum(-1, 1));
		System.out.println("Cai Test = " + getSum(1, -1));
		
		System.out.println("Cai Test = " + getSubtract(1, -1));//2
		System.out.println("Cai Test = " + getSubtract(3, 1));//2
		System.out.println("Cai Test = " + getSubtract(1, 2));//-1
	}
	
	public static int getSubtract(int a, int b) {
		return getSum(a, ~b + 1);
	}
	
	// Iterative
	// 0 ms, faster than 100.00%
	public static int getSum(int a, int b) {
		if (a == 0) return b;
		if (b == 0) return a;
		
		while (b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		return a;
	}
	
	// 0 ms, faster than 100.00% 
	// Recursive solution
//	public static int getSum(int a, int b) {
//		return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
//	}

	// Not allowed to use the operator + and -.
//	public static int getSum(int a, int b) {
//		if (b == 0) {
//            return a;
//        }
//        
//        return getSum(a ^ b, (a & b) << 1); //!!! Don't forget ( )
//    }
}
