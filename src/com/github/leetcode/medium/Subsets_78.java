package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {

	public static void main(String[] args) {
		Subsets_78 obj = new Subsets_78();
		int[] a1 = {1, 2, 3};
		System.out.println("Cai Test = " + obj.subsets(a1));
	}

	// Approach 2: Bit operation ---- state: n bits int / string
	// i-th bit 0: not selected.  1: selected
	// TC: O(n* 2^n) 
	// SC: O(1)
	// TODO in the future
	
	// ============== 0 ms solution, faster > 100% --- best version of DFS -- backtracking
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums,0, new ArrayList<>(), res);
        return res;
    }
    
    private void helper(int[] nums, int index, List<Integer> sub, List<List<Integer>> res) {
        res.add(new ArrayList<>(sub));
        
        for (int i= index; i < nums.length; i++) {
            sub.add(nums[i]);
            helper(nums, i + 1, sub, res);
            sub.remove(sub.size() - 1);
        }
        return;
    }
	
	// 1 ms, faster than 84.77%
	// Approach 1: DFS --- backtracking
	// TC: O(n*2^N)
	// SC: O(k*n) --- k --- the size of ans, n is the length of each answer --- it will take O(n) times recursion
//	public List<List<Integer>> subsets(int[] nums) {
//		List<List<Integer>> ans = new ArrayList<>();
//		
//		List<Integer> cur = new ArrayList<>();
//		for (int k = 0; k <= nums.length; k++) {
//			dfs(nums, k, 0, cur, ans);
//		}
//		return ans;
//    }
	
	// k --- k numbers in the combination -- values from [0, n]
	// s --- start index, from 0-th index to n-1 th index
	public void dfs(int[] nums, int k, int s, List<Integer> cur, List<List<Integer>> ans) {
		if (cur.size() == k) {
			ans.add(new ArrayList<>(cur));
			return;
		}
		
		// optimized point!!! avoid unnecessary computation
		if (nums.length - s + cur.size() < k) {
			return;
		}
		
		for (int i = s; i < nums.length; i++) {
			cur.add(nums[i]);
			// each ele of array can only be used one time
			dfs(nums, k, i + 1, cur, ans);
			cur.remove(cur.size() - 1);
		}
	}
}
