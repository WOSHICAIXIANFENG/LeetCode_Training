package com.github.leetcode.easy_top100;

public class SqrtX69_top24_P {

	public static void main(String[] args) {
		SqrtX69_top24_P obj = new SqrtX69_top24_P();
		System.out.println("Cai test = " + obj.mySqrt(4));// 2
		
		System.out.println("Cai test = " + obj.mySqrt(8));// 2, not 3!!!
		
		// special case 
		System.out.println("Cai test = " + obj.mySqrt(1));// 1
		System.out.println("Cai test = " + obj.mySqrt(0));// 0
		
		System.out.println("Cai test = " + obj.mySqrt(2147395599));// 46339
	}
	
	// 1 ms, faster than 100.00%
	// Approach 1:  Binary Search
	// TC: O(logN)
	// SC: O(1)
	public int mySqrt(int x) {
		// TODO
		return 0;
	}
}
