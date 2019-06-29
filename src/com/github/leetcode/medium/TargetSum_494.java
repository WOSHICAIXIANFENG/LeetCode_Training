package com.github.leetcode.medium;

// http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-494-target-sum/

public class TargetSum_494 {

	public static void main(String[] args) {
		TargetSum_494 obj = new TargetSum_494();
		int[] n1 = {1, 1, 1, 1, 1};
		System.out.println("Cai Test = " + obj.findTargetSumWays(n1, 5));//1
		System.out.println("Cai Test = " + obj.findTargetSumWays(n1, 3));//5
	}

	/**
	 * The length of the given array is positive and will not exceed 20.
	 * ----> if your solution TC is 2^20 --- that also could pass
	 * 
	 * The sum of elements in the given array will not exceed 1000.
	 * -----> DP solution !!!  k*n
	 */
	
	// Approach 2: DP --- one dimensions
	// TC: O(n * sum)
	// SC: O(n * sum)
	public int findTargetSumWays(int[] nums, int S) {
		final int n = nums.length;
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum < Math.abs(S)) return 0;
		final int offset = sum;
		final int sumRange = 2 * sum + 1;
		// define dp array
		int[] ways = new int[sumRange];
		// initial dp array
		ways[offset] = 1;// only 1 way: use 0 eles to sum up to 0
		for (final int num : nums) {
			int[] tmp = new int[sumRange];
			for (int j = num; j < sumRange - num; j++) {
				tmp[j - num] += ways[j];
				tmp[j + num] += ways[j];
			}
			ways = tmp;
		}
		return ways[S + offset];
	}
	
	// 6 ms, faster than 79.64%
	// Approach 2: DP ---- two dimensions
	// TC: O(n * sum)
	// SC: O(n * sum)
	public int findTargetSumWays_2(int[] nums, int S) {
		final int n = nums.length;
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum < Math.abs(S)) return 0;
		final int offset = sum;
		// define dp array
		// dp[i][Sum] --- # of first i eles to sum up to Sun
		int[][] dp = new int[n + 1][2 * sum + 1];
		dp[0][offset] = 1;// one way: first 0 nums sums up to 0
		for (int i = 0; i < n; i++) {
			for (int j = nums[i]; j < 2 * sum + 1 - nums[i]; j++) {
				if (dp[i][j] > 0) {
					dp[i + 1][j + nums[i]] += dp[i][j];// dp solution -- better than dfs
					dp[i + 1][j - nums[i]] += dp[i][j];
				}
			}
		}
		return dp[n][S + offset];// # of sum up to S by using n eles
	}
	
	
	// 340 ms, faster than 39.80%
	// Approach 1: DFS ----
	// TC: O(2^n) ---- each bit could be - or +, so there are 2^n combinations
	// SC: O(n)
	
	private int ans;
	public int findTargetSumWays_dfs(int[] nums, int S) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum < Math.abs(S)) return 0;// pruning!!!
		
		ans = 0;
		dfs(nums, 0, S);
        return ans;
    }
	
	// DFS Alg ---- user the first i nums to sum up to s
	public void dfs(int[] nums, int i, int s) {
		if (i == nums.length) {
			if (s == 0) {
				ans++;//!!! 所找到一种solution，就+1。所以它比DP慢
			}
			return;
		}
		// Union 
		dfs(nums, i + 1, s - nums[i]);
		dfs(nums, i + 1, s + nums[i]);
	}
}
