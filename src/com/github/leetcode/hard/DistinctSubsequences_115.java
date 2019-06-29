package com.github.leetcode.hard;

public class DistinctSubsequences_115 {

	public static void main(String[] args) {
		DistinctSubsequences_115 obj = new DistinctSubsequences_115();
		System.out.println("Cai Test = " + obj.numDistinct("rabbbit", "rabbit"));// 3
		System.out.println("Cai Test = " + obj.numDistinct("babgbag", "bag"));// 5
	}

	// 5 ms, faster than 71.54%
	// Approach 1: DP 
	// TC: O(l1 * l2)
	// SC: O(l1 * l2)
	public int numDistinct(String s, String t) {
		final int l1 = s.length();
		final int l2 = t.length();
		// dp[i][j]: # of sub seq of s[1.i] equals t[1.j]
		int[][] dp = new int[l1 + 1][l2 + 1];
		// initialize dp array
		for (int i = 0; i <= l1; i++) {
			// t is empty target, s is non-empty, we ignore s[i] to make it matches empty
			dp[i][0] = 1;
		}
		
		for (int i = 1; i <= l1; i++)
			for (int j = 1; j <= l2; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					// you can take char s[i-1] or skip it
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				} else {
					// skip s[i-1]
					dp[i][j] = dp[i - 1][j];
				}
			}
		
        return dp[l1][l2];
    }
}
