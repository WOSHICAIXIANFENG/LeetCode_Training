package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {

	public static void main(String[] args) {
		Combinations_77 obj = new Combinations_77();
		System.out.println("Cai Test = " + obj.combine(4, 2));
	}

	// Approach : DFS --- Use DFS to calculate combination
	// TC: O(2^n) 
	// SC: O(ans*k)
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ans = new ArrayList<>();
		if (k <= 0 || k > n) return ans;
		List<Integer> cur = new ArrayList<>();
		// start element from 1
		dfs(n, k, 1, cur, ans);
		return ans;
    }
	
	// count ---> how many number I have collected. from [0, k)
	// s ---> s th number, s start from [1,n]
	public void dfs(int n, int k, int s, List<Integer> cur, List<List<Integer>> ans) {
		if (cur.size() == k) {
			ans.add(new ArrayList<>(cur));//!!!
			return;
		}
		
		// from 27 ms to 3 ms, faster than 90.18% --- 
		// Optimized Point!!!! Avoid unnecessary computation.
		if (n - s + 1 + cur.size() < k) {
			return;
		}
		
		for (int i = s; i <= n; i++) {
			cur.add(i);
			dfs(n, k, i + 1, cur, ans);
			cur.remove(cur.size() - 1);
		}
	}
}
