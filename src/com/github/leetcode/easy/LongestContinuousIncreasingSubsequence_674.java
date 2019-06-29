package com.github.leetcode.easy;

import java.util.Arrays;

public class LongestContinuousIncreasingSubsequence_674 {

	public static void main(String[] args) {
		LongestContinuousIncreasingSubsequence_674 obj = new LongestContinuousIncreasingSubsequence_674();
		int[] n1 = {1,3,5,4,7};
		int[] n2 = {2,2,2,2,2};
		System.out.println("Cai Test = " + obj.findLengthOfLCIS(n1));//3
		System.out.println("Cai Test = " + obj.findLengthOfLCIS(n2));//1
	}
	
	/**
	 * Length of the array will not exceed 10,000.
	 * ----> your solution TC should be <= O(n^2)
	 * 
	 */
	
	// 1 ms, faster than 99.88%
	// Approach DP --- with out extra SC
	// SC: O(1)
	public int findLengthOfLCIS(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		final int n = nums.length;
		// dp variable
		int f = 1;// len of LCIS end with nums[i]
		int maxLen = 1;
		for (int i = 1; i < n; i++) {
			if (nums[i] > nums[i - 1]) {
				f++;
				maxLen = Math.max(maxLen, f);
			} else {
				f = 1;
			}
		}
		return maxLen;
	}
	
	// 2 ms, faster than 40.37%
	
	// Approach 1: DP --- def: f[i] = LCIS till nums[i]. nums[i] must be used
	// TC: O(n)
	// SC: O(n)
	public int findLengthOfLCIS2(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		final int n = nums.length;
		// the len of LCIS end with nums[i]
		int[] f = new int[n];
		Arrays.fill(f, 1);
		int maxLen = 1;//!!!
		for (int i = 1; i < n; i++) {
			if (nums[i] > nums[i - 1]) {
				f[i] = f[i - 1] + 1;
				maxLen = Math.max(maxLen, f[i]);
			} else {
				f[i] = 1;
			}
		}
		return maxLen;
	}
}
