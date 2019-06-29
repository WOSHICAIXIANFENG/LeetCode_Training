package com.github.leetcode.hard;

import java.util.Arrays;

public class EditDistance_72 {

	public static void main(String[] args) {
		EditDistance_72 obj = new EditDistance_72();
		System.out.println("Cai Test = " + obj.minDistance("horse", "ros"));//3
		System.out.println("Cai Test = " + obj.minDistance("intention", "execution"));//5
	}
	
	// 7 ms, faster than 33.77% 
	// Approach 2: Iterative Way --- dp array -- two dimensions
	// TC: O(l1 * l2) ---- there are l1*l2 sub questions need to be solved
    // SC: O(l1 * l2)
	public int minDistance(String word1, String word2) {
		final int l1 = word1.length();
		final int l2 = word2.length();
		// dp array
		int[][] dp = new int[l1 + 1][l2 + 1];
		// initial dp array
		for (int i = 0; i < l1; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j < l2; j++) {
			dp[0][j] = j;
		}
		
		for (int i = 1; i <= l1; i++)
			for (int j = 1; j <= l2; j++) {
				int c = word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1;
				int insert = dp[i][j - 1];
				int delete = dp[i - 1][j];
				// dp[i-1][j-1] could cover replace & no change
				dp[i][j] = Math.min(dp[i - 1][j - 1] + c, Math.min(insert, delete) + 1);
			}
		
		return dp[l1][l2];
	}

	// 4 ms, faster than 93.67% 
	// Approach 1: Memorized Recursion
	// TC: O(l1 * l2) ---- there are l1*l2 sub questions need to be solved
	// SC: O(l1 * l2)
	public int minDistance2(String word1, String word2) {
		final int l1 = word1.length();
		final int l2 = word2.length();
		int[][] d = new int[l1 + 1][l2 + 1];
		for (int[] l : d) {
			Arrays.fill(l, -1);
		}
		
        return minDistance(word1, word2, l1, l2, d);
    }
	
	public int minDistance(String word1, String word2, int l1, int l2, int[][] mem) {
		if (l1 == 0) return l2;
		if (l2 == 0) return l1;
		if (mem[l1][l2] >= 0) return mem[l1][l2];
		
		int ans = 0;
		if (word1.charAt(l1 - 1) == word2.charAt(l2 - 1)) {
			ans = minDistance(word1, word2, l1 - 1, l2 - 1, mem);
		} else {
			// there are 3 operations -- insert, delete, replace
			int replace = minDistance(word1, word2, l1 - 1, l2 - 1, mem);
			int delete = minDistance(word1, word2, l1 - 1, l2, mem);
			int insert = minDistance(word1, word2, l1, l2 - 1, mem);
			ans = Math.min(Math.min(replace, delete), insert) + 1;
		}
		mem[l1][l2] = ans;
		return ans;
	}
}
