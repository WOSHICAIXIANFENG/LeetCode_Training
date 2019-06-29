package com.github.leetcode.medium;

import java.util.Arrays;

public class PartitionToKEqualSumSubsets_698 {

	public static void main(String[] args) {
		PartitionToKEqualSumSubsets_698 obj = new PartitionToKEqualSumSubsets_698();
		int[] a1 = {4, 3, 2, 3, 5, 2, 1};
		System.out.println("Cai Test = " + obj.canPartitionKSubsets(a1, 4));// true
	}

	// 1 ms, faster than 100.00% 
	
	// Best solution --- easy to understand!!!
	// https://www.youtube.com/watch?v=qpgqhp_9d1s
	
	// 由于这是k等分，它并不像2等分，我只要找出一个 subset就可以了，我需要用填充bucket的方法(dfs) 找出 k-1个subsets才行！！！
	
	// Approach 2: Partition/Backtracking issue --- fill out bucket one by one. 
	// TC: O(n!) ---- 1 <= k <= len(nums) <= 16
	// SC: O(n) --- used and depth of recursion
	public boolean canPartitionKSubsets(int[] nums, int k) {
		if (nums == null || nums.length == 0) return false;
		int sum = 0;
		for (int num : nums)
			sum += num;
		if (k < 0 || k > nums.length || sum % k != 0) {
			return false;
		}
		return canPartition(nums, 0, new boolean[nums.length], k, 0, sum / k);
	}
	
	// Try to fill out the current bucket --- k-th bucket
	public boolean canPartition(int[] nums, int iterationStart, boolean[] used, int k, int inProgressBucketSum, int targetBucketSum) {
		// we don't need to fill out the last bucket
		if (k == 1) {
			return true;
		}
		
		if (inProgressBucketSum == targetBucketSum) {
			return canPartition(nums, 0, used, k - 1, 0, targetBucketSum);
		}
		
		for (int i = iterationStart; i < nums.length; i++) {
			if (!used[i] && inProgressBucketSum + nums[i] <= targetBucketSum) {
				used[i] = true;
				if (canPartition(nums, i + 1, used, k, inProgressBucketSum + nums[i], targetBucketSum))
					return true;
				
				used[i] = false;
			}
		}
		
		return false;
	}
	
	// Approach 1: Partition --- Recursion
	// TC: O(n!) ---- 1 <= k <= len(nums) <= 16
	// SC: O(n)
//	public boolean canPartitionKSubsets(int[] nums, int k) {
//		if (nums == null || nums.length == 0) return false;
//		
//		int sum = 0;
//		for (int num : nums)
//			sum += num;
//		if (sum % k != 0) return false;
//		
//		Arrays.sort(nums);
//		
//		return dfs(nums, 0, k, sum / k, 0);
//    }
	
//	// used count 
//	public boolean dfs(int[] nums, int cur, int k, int target, int used) {
//		if (k == 0) return used == (1 << nums.length) - 1;
//		for (int i = 0; i < nums.length; i++) {
//			if ((used & (1 << i)) > 0) continue;
//			int t = cur + nums[i];
//		    if (t > target) break; // Important
//		    int new_used = used | (1 << i);
//		    if (t == target && dfs(nums, target, 0, k - 1, new_used)) return true; 
//	        else if (dfs(nums, target, t, k, new_used)) return true;
//		}
//		return false;
//	}
//	
//	public int sum(int[] nums, int start, int end) {
//		int sum = 0;
//		for (int i = start; i < end; i++)
//			sum += nums[i];
//		return sum;
//	}
}
