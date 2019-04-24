package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class FindTheShortestSuperStr_943 {

	public static void main(String[] args) {
		FindTheShortestSuperStr_943 obj = new FindTheShortestSuperStr_943();
		String[] a1 = {"alex","loves","leetcode"};
		String[] a2 = {"catg","ctaagt","gcta","ttca","atgcatc"};
		System.out.println("Cai Test = " + obj.shortestSuperstring(a1));
		System.out.println("Cai Test = " + obj.shortestSuperstring(a2));//gctaagttcatgcatc
	}

	// 1046 ms, faster than 6.44%
	
	// Approach 1: DFS/Backtracking --- try all Permutations. 
	// Preprocessing + Pruning are important to AC
	// TC: O(n!)
	// SC: O(n) used + O(n) recursion + O(# of ans)
	
	private int best_len;
	private List<Integer> best_path_index;
	
	// We may assume that no string in A is substring of another string in A.
	public String shortestSuperstring(String[] A) {
		int N = A.length;
		
		// 预处理比较放在 n!的过程里面 要好!!!
		// Populate overlaps
        int[][] overlaps = new int[N][N];
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < N; ++j) 
            	if (i != j) {
            		int m = Math.min(A[i].length(), A[j].length());
            		for (int k = m; k >= 0; --k)
            			if (A[i].endsWith(A[j].substring(0, k))) {
            				overlaps[i][j] = k;
            				break;
            			}
            	}
        
        // put index into cur
        List<Integer> cur = new ArrayList<>();
        boolean[] used = new boolean[A.length];
        best_len = Integer.MAX_VALUE;
        dfs(A, 0, used, 0, overlaps, cur);
        
        StringBuilder sb = new StringBuilder();
        sb.append(A[best_path_index.get(0)]);
        for (int k = 1; k < best_path_index.size(); k++) {
        	int i = best_path_index.get(k - 1);
        	int j = best_path_index.get(k);
        	sb.append(A[j].substring(overlaps[i][j]));
        }
        return sb.toString();
    }
	
	// the start index 's' can be omitted
	public void dfs(String[] strs, int s, boolean[] used, int cur_len, int[][] overlaps, List<Integer> cur) {
		// optimized point!!! speed up
		if (cur_len > best_len) return;
		
		if (s == strs.length) {
			best_len = cur_len;
			best_path_index = new ArrayList<>(cur);
			return;
		}
		for (int i = 0; i < strs.length; i++) {
			if (used[i]) continue;
			
			used[i] = true;
			cur.add(i);
			int new_len = (s == 0) ? strs[i].length() : cur_len + (strs[i].length() - overlaps[cur.get(cur.size() - 2)][i]); 
			dfs(strs, s + 1, used, new_len, overlaps, cur);
			cur.remove(cur.size() - 1);
			used[i] = false;
		}
	}
}
