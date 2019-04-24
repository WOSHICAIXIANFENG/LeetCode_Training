package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII_90 {

	public static void main(String[] args) {
		SubsetsII_90 obj = new SubsetsII_90();
		int[] a1 = {1, 2, 2};
		System.out.println("Cai Test = " + obj.subsetsWithDup(a1));
	}

	// 1 ms, faster than 100.00%
	// Approach 1:  DFS --- Backtracking
	// TC: O(n*2^n)
	// SC: O(k*n) --- k is the len of subsets, n is the len of each combination
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
        helper(nums,0, new ArrayList<>(), res);
        return res;
    }
    
    private void helper(int[] nums, int s, List<Integer> sub, List<List<Integer>> res) {
        res.add(new ArrayList<>(sub));
        
        for (int i= s; i < nums.length; i++) {
        	if (i > s && nums[i] == nums[i - 1]) continue;
        	
            sub.add(nums[i]);
            helper(nums, i + 1, sub, res);
            sub.remove(sub.size() - 1);
        }
        return;
    }
}
