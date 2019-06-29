package com.github.leetcode.easy_top100;

public class MissingNumber268_top22 {

	public static void main(String[] args) {
		MissingNumber268_top22 obj = new MissingNumber268_top22();
		int[] nums = {0,1,2,4,5}; //{0,1,3};
		System.out.println("Samuel Test missingNumber = " + obj.missingNumber(nums));
	}

	// Your algorithm should run in linear runtime complexity. 
	// Could you implement it using only constant extra space complexity?
	
	// !!!! Given an array containing n distinct numbers taken from 0, 1, 2, ..., n
	// !!!!  numbers from 0, 1, 2, ..., n
	
	// 0 ms, faster than 100.00%
	
	// Approach 1: XOR 
	// a ^ a = 0, 0 ^ a = a ---> a ^ b ^ b == a
	// TC: O(n)
	public int missingNumber(int[] nums) {
		final int n = nums.length;
		int x = 0;
//		for (int i = 1; i <= n; i++) {
//			x = x ^ i ^ nums[i - 1];
//		}
		
		// 因为 x 已经被初始化成了 0，所以就不能再 ^ i 了 
		// wrong !!! ----> it will get 6
		for (int i = 0; i < n; i++) {
			x = x ^ i ^ nums[i];
		}
		
		return x;
	}
	
	// 0 ms, faster than 100.00% 
	
	// Given an array containing n distinct numbers taken from 0, 1, 2, ..., n
	// Approach 2: Arithmetic Progression Sum Formula. 
	// TC: O(n)
	// SC: O(1)
	public int missingNumber2(int[] nums) {
		final int n = nums.length;
		// 因为 start from 0， 所以需要 n + 1
		int sum = (0 + n) * (n + 1) / 2;
		
		int sum2 = 0;
		for (int num : nums) {
			sum2 += num;
		}
		return sum - sum2;
	}
}
