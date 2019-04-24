package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {

	public static void main(String[] args) {
		Permutations_46 obj = new Permutations_46();
		int[] a1 = {1, 2, 3};
		System.out.println("Cai Test = " + obj.permute(a1));
	}

	// 1 ms, faster than 99.82%
	
	// 关于TC 的讨论
	// https://stackoverflow.com/questions/41627749/time-complexity-of-permutation-function
	// Approach 1: DFS --- 
	// TC: O(n!)
	// SC: O(n) used + O(n) recursion + O(n * n!) solutions
	public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(nums, 0, used, cur, ans);
        return ans;
    }
	
	public void dfs(int[] nums, int s, boolean[] used, List<Integer> cur, List<List<Integer>> ans) {
		if (s == nums.length) {
			ans.add(new ArrayList<>(cur));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i]) continue;
			used[i] = true;
			cur.add(nums[i]);
			dfs(nums, s + 1, used, cur, ans);
			cur.remove(cur.size() - 1);
			used[i] = false;
		}
	}
}
