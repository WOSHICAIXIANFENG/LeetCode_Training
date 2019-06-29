package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationSumIV_377 {

	public static void main(String[] args) {
		CombinationSumIV_377 obj = new CombinationSumIV_377();
		int[] n1 = {1, 2, 3};
		System.out.println("Cai Test = " + obj.combinationSum4(n1, 4));
	}
	
	// Given an integer array with all positive numbers and no duplicates, 
	// find the number of possible combinations that add up to a positive integer target.
	
	// http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-377-combination-sum-iv/
	
	/**
	 * What if negative numbers are allowed in the given array?
     * How does it change the problem?
     * What limitation we need to add to the question to allow negative numbers?
	 * 
	 */
	
	// 1 ms, faster than 86.69% 
	// Approach 2: DP  
	// TC: O(target * n)
	// SC: O(target) ---> O(1)
	public int combinationSum4(int[] nums, int target) {
		// dp[i] -- # of combinations sum up to target
		int[] dp = new int[target + 1];
		// Initialize dp array
		dp[0] = 1;// empty num sequence to sum up to 0
		
		// 使用DP是 bottom to up的过程，你必须从1到 target一直算上去。
		for (int i = 1; i <= target; i++) 
			// # of target equals Sum{ # of target - num}
			for (int num : nums) {
				if (i - num >= 0) {
					dp[i] += dp[i - num];
				}
			}
		
		return dp[target];
	}

	// 0 ms, faster than 100.00%
	// Approach 1: Recursion + Memorization
	// dp(nums, target): --> all combinations that uses nums to sum up to target
	// TC: O(sum{target/num_i})
	// SC: O(target)
	public int combinationSum4_2(int[] nums, int target) {
		int[] m = new int[target + 1];
		Arrays.fill(m, -1);
		m[0] = 1;// start point!!! --- user empty num sequence to sum up to 0
        return dp(nums, target, m);
    }
	
	// Top down process
	// # of combinations that could use nums to sum up to the target
	public int dp(int[] nums, int target, int[] m) {
		if (target < 0) return 0;
		if (m[target] != -1) return m[target];//!!!
		int ans = 0;
		// target - num 避免了很多不必须的 loop，所以速度快过 DP 
		for (int num : nums) {
			ans += dp(nums, target - num, m);
		}
		m[target] = ans;
		return ans;
	}
	
//	public List<List<Integer>> combinationSum4(int[] nums, int target) {
//		List<List<Integer>> ans = new ArrayList<>();
//		Map<Integer, List<List<Integer>>> mem = new HashMap<>();
////		List<List<Integer>> empty = new ArrayList<>();
////		empty.add(new ArrayList<>());
////		mem.put(0, empty);
//		
//		ans = combinationSum(nums, target, mem);
//        return ans;
//    }
//	
//	public List<List<Integer>> union(List<List<Integer>> combinations, int num) {
//		if (combinations != null) {
//			for (List<Integer> combination: combinations) {
//				combination.add(num);
//			}
//		}
//		System.out.println("Cai Test ------ combinations = " + combinations);
//		return combinations;
//	}
//	
//	public List<List<Integer>> combinationSum(int[] nums, int target, Map<Integer, List<List<Integer>>> mem) {
//		if (mem.containsKey(target)) {
//			return mem.get(target);
//		}
//		if (target == 0) {
//			List<List<Integer>> empty = new ArrayList<>();
//			empty.add(new ArrayList<>());
//			mem.put(target, empty);
//			return empty;
//		}
//			
//		List<List<Integer>> ans = new ArrayList<>();
//		for (int num : nums) {
//			if (target - num >= 0) {
//				List<List<Integer>> temps = union(combinationSum(nums, target - num, mem), num);
//				for (List<Integer> temp : temps) {
//					ans.add(temp);
//				}
//			}
//		}
//		mem.put(target, ans);
//		return ans;
//	}
}
