package com.github.leetcode.medium;

public class DeleteAndEarn_740 {

	public static void main(String[] args) {
		DeleteAndEarn_740 obj = new DeleteAndEarn_740();
		int[] n1 = {3, 4, 2};
		System.out.println("Cai Test = " + obj.deleteAndEarn(n1));//6
		int[] n2 = {2, 2, 3, 3, 3, 4};
		System.out.println("Cai Test = " + obj.deleteAndEarn(n2));//9
	}
	
	/**
	 * The length of nums is at most 20000.
	 * ----> Your solution should be O(n) level
	 * 
	 * Key observations: If we take nums[i]
	 *  1. We can safely take all of its copies.
	 *  2. We can't take any of copies of nums[i - 1] and nums[i + 1]
	 *  
	 *  [2, 2, 3, 3, 3, 4] -> [0 2*2 3*3 4], rob([0 2*2 3*3 4]) = 9
	 */
	
	// 1 ms, faster than 100.00%
	// Approach 1: DP
	// TC: O(n+r) reduction + O(r) solving rob = O(n + r)
	// SC: O(r) --- r = max(nums) – min(nums) + 1
	public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
        	min = Math.min(min, num);
        	max = Math.max(max, num);
        }
        int[] points = new int[max - min + 1];
        for (int num : nums) {
        	points[num - min] += num;
        }
        // [2, 2, 3, 3, 3, 4] -> [2*2,3*3,4]
        return rob(points);
    }

	// DP to solve the problem
	public int rob(int[] points) {
		int dp1 = 0;
		int dp2 = 0;
		for (int i = 0; i < points.length; i++) {
			int dp = Math.max(dp1, dp2 + points[i]);
			dp2 = dp1;
			dp1 = dp;
		}
		return dp1;
	}
}
