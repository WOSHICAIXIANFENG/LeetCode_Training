package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum_39 {

	public static void main(String[] args) {
		CombinationSum_39 obj = new CombinationSum_39();
		int[] a1 = {2, 3, 6, 7};
		int[] a2 = {2, 3, 5};
		System.out.println("Cai Test = " + obj.combinationSum(a1, 7));
		System.out.println("Cai Test = " + obj.combinationSum(a2, 8));
	}

	// 2ms --- faster than 99.96%
	// Approach : DFS --- Calculate Combinations
	// TC: O(nlogN) + O(2^n) ---- there are n elements, each ele state is selected or not selected
	// SC: O(n) --- Recursion call, + O(kn) --- k is the ans.size(), n is the size of each ans;
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		if (candidates == null || candidates.length == 0) return ans;
		
        Arrays.sort(candidates);// O(nlgN)
        
        List<Integer> cur = new ArrayList<>();
        dfs(candidates, target, 0, cur, ans);
        return ans;
    }
	
	// s ---> start index
	public void dfs(int[] candidates, int target, int s, List<Integer> cur, List<List<Integer>> ans) {
		if (target == 0) {
			//ans.add(cur);//Wrong!!!
			// !!! you have to copy cur 
//			List<Integer> path = new ArrayList<>();
//			for (int val : cur) {
//				path.add(val);
//			}
//			ans.add(path);
			
			ans.add(new ArrayList<>(cur));
			return;
		}
		for (int i = s; i < candidates.length; ++i) {
			if (candidates[i] > target) break; // Optimized!!!
			cur.add(candidates[i]);
			// since the same number could be chosen unlimited times
			dfs(candidates, target - candidates[i], i, cur, ans);//the start index is 'i'
			cur.remove(cur.size() - 1);
		}
	}
}
