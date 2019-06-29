package com.github.leetcode.medium;

public class LongestIncreasingSubsequence_300 {

	public static void main(String[] args) {
		LongestIncreasingSubsequence_300 obj = new LongestIncreasingSubsequence_300();
		int[] n1 = {10,9,2,5,3,7,101,18};
		// 2,3,7,101 or  2,5,7,101
		System.out.println("Cai Test = " + obj.lengthOfLIS(n1));
		int[] n2 = {-2, -1};
		System.out.println("Cai Test = " + obj.lengthOfLIS(n2));
	}

	// longest increasing subsequence, 并没有说连续!!!说明你可以跳过一些元素!!!
	
	// Approach 1: DP
	// def: f[1] = length of LIS ends with nums[i] (nums[i] must be used)
	// TC: O(n^2)
	// SC: O(n)
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		final int n = nums.length;
		// lenth of LIS ends with nums[i]
		int[] f = new int[n];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, LIS(nums, i, f));
		}
		return ans;
	}
	
	// Recursion + Memorized Array to get f[i]
	// longest increasing subsequence ends with nums[r]
	public int LIS(int[] nums, int r, int[] f) {
		if (r == 0) {
			f[r] = 1;
			return 1;
		}
		if (f[r] > 0) return f[r];//!!! use memory/dp array to avoid duplicate calculation
		int ans = 1;//!!!
		for (int i = 0; i < r; i++) {
			if (nums[r] > nums[i]) {
				ans = Math.max(ans, LIS(nums, i, f) + 1);
				// or --> ans = Math.max(ans, f[i] + 1);
			}
		}
		f[r] = ans;
		return ans;
	}
	
	
	// 9 ms, faster than 61.92%
	
	// Approach 2: DP
	// def: f[1] = length of LIS ends with nums[i] (nums[i] must be used)
	// TC: O(n^2)
	// SC: O(n)
	public int lengthOfLIS2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		final int n = nums.length;
		int[] f = new int[n];
		// initial dp array to 1
		for (int i = 0; i < n; i++)
			f[i] = 1;
			
		int maxLen = 1;//!!!
		for (int i = 1; i < n; i++)
			for (int j = 0; j < i; j++)
				if (nums[i] > nums[j]) {
					f[i] = Math.max(f[i], f[j] + 1);
					maxLen = Math.max(maxLen, f[i]);
				}
        return maxLen;
    }
}
