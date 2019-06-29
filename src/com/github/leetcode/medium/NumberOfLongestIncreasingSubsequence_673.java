package com.github.leetcode.medium;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence_673 {

	public static void main(String[] args) {
		NumberOfLongestIncreasingSubsequence_673 obj = new NumberOfLongestIncreasingSubsequence_673();
		int[] n1 = {1, 3, 5, 4, 7};
		System.out.println("Cai Test = " + obj.findNumberOfLIS(n1));//2
		int[] n2 = {2,2,2,2,2};
		System.out.println("Cai Test = " + obj.findNumberOfLIS(n2));//5
	}

	/**
	 * Length of the given array will be not exceed 2000 and 
	 * the answer is guaranteed to be fit in 32-bit signed int.
	 * -----> so your solution TC should be <= N^2
	 * 
	 * http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-673-number-of-longest-increasing-subsequence/
	 * 
	 */
	
	// 7 ms, faster than 98.65%
	
	// Approach 1: DP
	// TC: O(n^2)
	// SC: O(n)
	public int findNumberOfLIS(int[] nums) {
	    if (nums == null || nums.length == 0) return 0;
	    final int n = nums.length;
	    // f[i] --- the length of LIS end with nums[i]
	    int[] f = new int[n];
	    Arrays.fill(f, 1);// initial f[i] to 1
	    // c[i] --- the number of LIS end with nums[i]
	    int[] c = new int[n];
	    Arrays.fill(c, 1);
	    
	    int maxLen = 1;
	    for (int i = 1; i < n; i++) {
	    	for (int j = 0; j < i; j++) {
	    		if (nums[i] > nums[j]) {
	    			if (f[j] + 1 > f[i]) {
	    				f[i] = f[j] + 1;
	    				c[i] = c[j];
	    				maxLen = Math.max(maxLen, f[i]);
	    			} else if (f[j] + 1 == f[i]) {
	    				c[i] += c[j];
	    			}
	    		}
	    	}
	    }
	    System.out.println("Cai Test f = " + Arrays.toString(f));
	    System.out.println("Cai Test c = " + Arrays.toString(c));
	    
	    int count = 0;
	    for (int i = 0; i < n; i++)
	    	if (f[i] == maxLen) {
	    		count += c[i];
	    	}
	    
	    return count;
	}
}
