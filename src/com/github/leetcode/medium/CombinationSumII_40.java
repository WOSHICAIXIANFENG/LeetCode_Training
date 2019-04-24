package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumII_40 {

	public static void main(String[] args) {
		CombinationSumII_40 obj = new CombinationSumII_40();
		int[] a1 = {10,1,2,7,6,1,5};// 1,1,2,5,6,7,10
		int[] a2 = {2,5,2,1,2};// 1,2,2,2,5
		System.out.println("Cai Test = " + obj.combinationSum2(a1, 8));
		System.out.println("Cai Test = " + obj.combinationSum2(a2, 5));
	}

	// !!! each number may only be used once in the combination
	// how to remove duplicates?
	// 1. Use set
	// 2. Disallow same number in same depth
	
	// 2 ms, faster than 100.00%
	// Approach 2 : DFS ---- Use a loop to avoid use the duplicate number in the same deep
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		if (candidates == null || candidates.length == 0) return ans;
		List<Integer> cur = new ArrayList<>();
		Arrays.sort(candidates);
		dfs(candidates, target, 0, cur, ans);
		return ans;
	}
	
	public void dfs(int[] candidates, int target, int s, List<Integer> cur, List<List<Integer>> ans) {
		if (target == 0) {
//			List<Integer> combination = new ArrayList<>();
//			for (int val : cur) {
//				combination.add(val);
//			}
//			ans.add(combination);
			ans.add(new ArrayList<>(cur));
			return;
		}
		for (int i = s; i < candidates.length; i++) {
			if (candidates[i] > target) break;
			// !!! 同一层不可以使用多个duplicate 元素，duplicate无素是可以在下一层使用的，但是同一层不可以使用，这样可以避掉duplicate combination
			if ( i > s && candidates[i] == candidates[i - 1]) continue;
			
			cur.add(candidates[i]);
			// each number of the array may only be used one time, so here is 'i + 1'
			dfs(candidates, target - candidates[i], i + 1, cur, ans);
			cur.remove(cur.size() - 1);
		}
	}
	
	// 8 ms, faster than 69.47%
	// Approach 1 : DFS --- Use HashSet to avoid duplicate combination
	// TC: O(2^n)
	// SC: O(kn) --- k is the size of answer, n is the length of each answer
//	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//		List<List<Integer>> ans = new ArrayList<>();
//		if (candidates == null || candidates.length == 0) return ans;
//		List<Integer> cur = new ArrayList<>();
//		Arrays.sort(candidates);
//		
//		Set<List<Integer>> preAns = new HashSet<>();
//		dfs(candidates, target, 0, cur, preAns);
//		
//		for (List<Integer> list : preAns) {
//			ans.add(list);
//		}
//		return ans;
//    }
//	
//	public void dfs(int[] candidates, int target, int s, List<Integer> cur, Set<List<Integer>> ans) {
//		if (target == 0) {
//			List<Integer> path = new ArrayList<>();
//			for (int val : cur) {
//				path.add(val);
//			}
//			ans.add(path);
//			return;
//		}
//		for (int i = s; i < candidates.length; i++) {
//			if (candidates[i] > target) break;//!!!
//			cur.add(candidates[i]);
//			dfs(candidates, target - candidates[i], i + 1, cur, ans);//!!! i + 1
//			cur.remove(cur.size() - 1);
//		}
//	}
}
