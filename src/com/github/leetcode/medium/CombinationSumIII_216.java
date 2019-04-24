package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII_216 {

	public static void main(String[] args) {
		CombinationSumIII_216 obj = new CombinationSumIII_216();
		System.out.println("Cai test = " + obj.combinationSum3(3, 7));
		System.out.println("Cai test = " + obj.combinationSum3(3, 9));
	}
	
	// !!! About Time Complexity of Combinations
	// If both k and n are variables, then the complexity is O(n!/k!(n-k)!). 
	// But if k is constant - n!/k!(n-k)!=O(n!/k!(n-k)!)=O(n^k)
	
	// 3 ms, faster than 5.41%
	
	// Approach 2: Bit --- Use 9 bit binary string to represent a combination
	// 1. if i-th bit is 1, then number (i + 1) is used.
	// 2. total # of 1s should be k
	// TC: O(2^m) = O(2^9)
	// SC: O(k + k*# of ans) ---- k is the depth of recursion
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> cur = null;
		
		// 2^9, generate all combinations of [1,9]
		for (int i = 0; i < (1 << 9); i++) {
			cur = new ArrayList<>();
			int sum = 0;
			for (int j = 1; j <= 9; j++) {
				// check j-1 th bit is 1
				if ((i & (1 << (j - 1))) > 0) {
					sum += j;
					cur.add(j);
				}
			}
			if (sum == n && cur.size() == k) {
				ans.add(new ArrayList<>(cur));
			}
		}
		return ans;
	}
	
	
	
	
	// 1 ms, faster than 39.32%
	
	// Approach 1: DFS + BackTracking
	// TC: C(m, k) = C(9, k) = 9!/k!/(9-k)!
	// SC: O(k + k*# of ans) ---- k is the depth of recursion
//	public List<List<Integer>> combinationSum3(int k, int n) {
//		List<List<Integer>> ans = new ArrayList<>();
//		List<Integer> cur = new ArrayList<>();
//		dfs(k, n, 1, cur, ans);
//		return ans;
//    }
	
	// Use k numbers to sum == target
	public void dfs(int k, int target, int s, List<Integer> cur, List<List<Integer>> ans) {
		if (k == 0) {
			if (target == 0) {
				ans.add(new ArrayList<>(cur));
				return;
			}
		}
		
		// 实际并没有太大的效果!!!
		// Optimized Point. Avoid Unnecessary computation.
		if (9 - s + 1 + cur.size() < k) {
			return;
		}
		
		for (int i = s; i <= 9; i++) {
			if (i > target) break;
			cur.add(i);
			dfs(k - 1, target - i, i + 1, cur, ans);
			cur.remove(cur.size() - 1);
		}
	}
}
