package com.github.leetcode.medium;

import java.util.Arrays;

public class PartitionEqualSubsetSum_416 {

	public static void main(String[] args) {
		PartitionEqualSubsetSum_416 obj = new PartitionEqualSubsetSum_416();
		int[] a1 = {1, 5, 11, 5};
		int[] a2 = {1, 2, 3, 5};
		System.out.println("Cai Test = " + obj.canPartition2(a1));// true
		System.out.println("Cai Test = " + obj.canPartition2(a2));// false
		
		// special cases --- to figure out the prune code 
		int[] a3 = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,100};
		System.out.println("Cai Test = " + a3.length);
		System.out.println("Cai Test = " + obj.canPartition2(a3));// false
	}
	
	// !!! Can't Cover case 3 without prune ---- if I put 100 in the end of array, it will timeout
	// Approach 3: DFS --- Since this question only needs use to cut into 2 Equal subsets, so we can use dfs to find first subset
	// TC: O(n*n ???) --- recursion is n, in each recusion, it has one loop
	// SC: O(n) --- the depth of recursion
	public boolean canPartition2(int[] nums) {
		int sum = 0;
		for (int num : nums)
			sum += num;
		if (nums == null || nums.length == 0 || sum % 2 != 0) 
			return false;
		
		Arrays.sort(nums);//!!! in order to cover case 3
		
		return dfs(nums, sum / 2, 0);
	}
	
	public boolean dfs(int[] nums, int targetSum, int start) {
		if (targetSum == 0) {
			return true; // find first equal subset
		} else if (targetSum > 0 && start < nums.length) {
			for (int i = start; i < nums.length; i++) {
				if (targetSum - nums[i] < 0) {
					return false;
				}
				
				//!!! covered case 3 ---- skip those duplicates, case 3中有98层1的使用，当返回的时候并不需要重复计算!!!
				if(i > start && nums[i] == nums[i - 1])
	                continue;
				
				if (dfs(nums, targetSum - nums[i], i + 1)) {
					return true;
				}
			}
		}
		return false;
	}
	
	// 6 ms, faster than 87.22% 
	// Approach 2: DP --- dp[i][j]: whether we can sum to j using first i numbers
	// dp[i][j] = true if dp[i-1][j - numi]. check dp[n-1][0] = true;
	// TC: O(n*sum)
	// SC: O(n*sum) ---> O(sum) --- our solution is O(sum), because we didn't swap the dp arr
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int num : nums)
			sum += num;
		if (nums == null || nums.length == 0 || sum % 2 != 0) 
			return false;
		
		// nums[i] will not exceed 100, size will not exceed 200, so we can use dp solution
		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;
		for (int num : nums) {
			// tricky!!! reverse direction to do the loop to avoid use another dp[sum+1] to swap.
			for (int i = sum; i >= 0; i--) {
				if (dp[i]) {
					dp[i + num] = true;
				}
				//!!! the first i nums' sum is the half
				if (dp[sum / 2]) {
					return true;
				}
			}
		}
		return false;
	}
	
	// Another Approach : use bit operation to brute force --- but TC will be O(2^n), it also will Time Out
	
	// Approach 1: Partition/Bracktracking problem --- fill out the bucket one by one
	// TC: O(n!) --- The array size will not exceed 200. --- it will Time Limit Exceeded on some special cases
	// SC: O(n)
//	public boolean canPartition(int[] nums) {
//		int sum = 0;
//		for (int num : nums)
//			sum += num;
//		if (nums == null || nums.length == 0 || sum % 2 != 0) 
//			return false;
//		
//		return canPartition(nums, 0, new boolean[nums.length], 2, 0, sum / 2);
//	}
	
	public boolean canPartition(int[] nums, int iterateStart, boolean[] used, int k, int curBucketSum, int targetBucketSum) {
		if (k == 1)
			return true;
		
		if (curBucketSum == targetBucketSum)
			return canPartition(nums, 0, used, k - 1, 0, targetBucketSum);
		
		for (int i = iterateStart; i < nums.length; i++) {
			if (!used[i] && curBucketSum + nums[i] <= targetBucketSum) {
				used[i] = true;
				if (canPartition(nums, i + 1, used, k, curBucketSum + nums[i], targetBucketSum)) {
					return true;
				}
				used[i] = false;//backtracking
			}
		}
		return false;
	}
}
