package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII_47 {

	public static void main(String[] args) {
		PermutationsII_47 obj = new PermutationsII_47();
		int[]  a1 = {1, 1, 2};
		System.out.println("Cai Test = " + obj.permuteUnique(a1));
	}

	// 1 ms, faster than 100.00%
	// Approach 1: DFS 
	// TC: O(n!)
	// SC: O(n) used + O(n) recursion + O(n* ans) --- ans # size of solutions
	// return all possible unique permutations.
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		boolean[] used = new boolean[nums.length];
		List<Integer> cur = new ArrayList<>();
		
		// sorted at first
		Arrays.sort(nums);
		dfs(nums, 0, used, cur, ans);
		return ans;
    }
	
	// s --- the start index, value from [0, nums.length)
	public void dfs(int[] nums, int s, boolean[] used, List<Integer> cur, List<List<Integer>> ans) {
		if (s == nums.length) {
			System.out.println("Cai cur = " + cur);
			ans.add(new ArrayList<>(cur));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i]) continue;
			
			// ignore the duplicates in the same level/depth of recursion. !!!  && !used[i - 1]
			// 画图帮助实现，这里 也可以为 && used[i - 1]
			if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
						
			used[i] = true;
			
			cur.add(nums[i]);
			dfs(nums, s + 1, used, cur, ans);
			cur.remove(cur.size() - 1);
			
			used[i] = false;
		}
	}
}
