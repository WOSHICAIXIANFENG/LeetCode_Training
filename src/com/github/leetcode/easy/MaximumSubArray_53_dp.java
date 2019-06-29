package com.github.leetcode.easy;

public class MaximumSubArray_53_dp {

	public static void main(String[] args) {
		int[] a1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 }; // 6 -- [4,-1,2,1]
		int[] a2 = { -2, 1, -3, 4, -1, 2, 1, -5, 6 }; // 7 -- [4,-1,2,1,-5,6]
		int[] a3 = { -2, -1, -3, -4, -1, 2, 1 }; // 3
		int[] a4 = { -2, -1, -3, -4, -1, -2, -1 }; // -1
		System.out.println("Cai Test " + maxSubArray(a1));
		System.out.println("Cai Test " + maxSubArray(a2));
		System.out.println("Cai Test " + maxSubArray(a3));
		System.out.println("Cai Test " + maxSubArray(a4));
	}
	
	// DP with SC O(1)
	public static int maxSubArray(int[] nums) {
		int ans = nums[0];
		int f = nums[0];
		for (int i = 1; i < nums.length; i++) {
			f = Math.max(f + nums[i], nums[i]);
			ans = Math.max(ans, f);
		}
		return ans;
	}
	
	// 1 ms, faster than 94.47%
	// Approach 1: DP ---- one-dimensional
	// TC: O(n)
	// SC: O(n)
	public static int maxSubArray2(int[] nums) {
		// f[i] // maxSubArray(0..i)
		// f[i] = f[i - 1] > 0 ? nums[i] + f[i - 1] : nums[i].
		int[] f = new int[nums.length];
		f[0] = nums[0];
		int max = nums[0];
		for (int i = 1; i < nums.length; i ++) {
			f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
			max = Math.max(max, f[i]);
		}
		return max;
    }
}
