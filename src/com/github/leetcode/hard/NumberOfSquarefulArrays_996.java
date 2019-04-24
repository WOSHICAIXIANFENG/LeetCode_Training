package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfSquarefulArrays_996 {

	public static void main(String[] args) {
		NumberOfSquarefulArrays_996 obj = new NumberOfSquarefulArrays_996();
		int[] a1 = {1, 17, 8};
		int[] a2 = {2, 2, 2};
		System.out.println("Cai Test = " + obj.numSquarefulPerms(a1));// 2
		System.out.println("Cai Test = " + obj.numSquarefulPerms(a2));// 1
	}
	
	// 1 ms, faster than 99.37% 
	
	// Approach 1: DFS ---- Try all permutations with pruning
	// TC: O(n!) --- there are n! permutations for n-len array
	// SC: O(n) --- recursion depth
	
	private int ans;
	public int numSquarefulPerms(int[] A) {
       boolean[] used = new boolean[A.length];
       List<Integer> cur = new ArrayList<>();
       ans = 0;
       Arrays.sort(A);//!!! sorted to avoid duplicates
       dfs(A, used, cur);
       return ans;
    }
	
	// the start index 's' parameter could be omitted
	public void dfs(int[] nums, boolean[] used, List<Integer> cur) {
		if (cur.size() == nums.length) {
			ans++;
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i]) continue;
			// Avoid duplicates in the save level/depth of recursion
			if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
			
			// !!!
			// Prune invalid solutions before add new val into 'cur'
			if (!cur.isEmpty() && !squareful(cur.get(cur.size() - 1), nums[i])) continue;
			
			used[i] = true;
			cur.add(nums[i]);
			dfs(nums, used, cur);
			cur.remove(cur.size() - 1);
			used[i] = false;
		}
	}

	public boolean squareful(int x, int y) {
		int s = (int) Math.sqrt(x + y);
		return s * s == x + y;
	}
}
