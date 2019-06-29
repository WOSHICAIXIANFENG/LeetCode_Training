package com.github.leetcode.medium;

public class MatchsticksToSquare_473 {

	public static void main(String[] args) {
		MatchsticksToSquare_473 obj = new MatchsticksToSquare_473();
		int[] a1 = {1,1,2,2,2};
		int[] a2 = {3,3,3,3,4};
		System.out.println("Cai Test = " + obj.makesquare(a1));// true
		System.out.println("Cai Test = " + obj.makesquare(a2));// false
	}

	// Same with Leetcode PartitionToKEqualSumSubsets_698, k is 4
	
	// 7 ms, faster than 95.62% 
	// since The length of the given matchstick array will not exceed 15. so Backtracking solution works
	// Approach 1: Backtracking ---- fill out 4 buckets, one by one
	// TC: O(n!)
	// SC: O(n)
	public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) return false;
        int sum = 0;
        for (int num : nums) {
        	sum += num;
        }
        if (sum % 4 != 0) {
        	return false;
        }
        return canPartition(nums, 0, new boolean[nums.length], 4, 0, sum / 4);
    }
	
	public boolean canPartition(int[] nums, int iterateStart, boolean[] used, int k, int cur, int targetSum) {
		if (k == 1) {
			return true;
		}
		if (cur == targetSum) {
			return canPartition(nums, 0, used, k - 1, 0, targetSum);
		}
		for (int i = iterateStart; i < nums.length; i++) {
			if (!used[i] && cur + nums[i] <= targetSum) {
				used[i] = true;
				// if we can fill out this bucket, we need to return true
				if (canPartition(nums, i + 1, used, k, cur + nums[i], targetSum)) {
					return true;
				}
				used[i] = false;//backtracking
			}
		}
		return false;
	}
}
