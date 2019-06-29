package com.github.leetcode.hard;

import java.util.Arrays;

public class MinimumAsciiDeleteSumTwoStrings_712 {

	public static void main(String[] args) {
		MinimumAsciiDeleteSumTwoStrings_712 obj = new MinimumAsciiDeleteSumTwoStrings_712();
		System.out.println("Cai Test = " + obj.minimumDeleteSum("sea", "eat"));//231
		System.out.println("Cai Test = " + obj.minimumDeleteSum("delete", "leet"));//403
	}

	/**
	 * 0 < s1.length, s2.length <= 1000.
	 * ----->>> recursion depth could be very large consume. 
	 * ------>>> it's better to convert memorized recursion to DP solution
	 */
	
	// 14 ms, faster than 66.67%
	// Approach 2: DP
	public int minimumDeleteSum(String s1, String s2) {
		final int l1 = s1.length();
		final int l2 = s2.length();
		//dp[i][j]: = min delete sum of (s1.substr(0, i), s2.substr(0, j))
		int[][] dp = new int[l1 + 1][l2 + 1];
		// initial dp array
		for (int i = 1; i <= l1; i++) {
			dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
		}
		for (int j = 1; j <= l2; j++) {
			dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
		}
		
		for (int i = 1; i <= l1; i++)
			for (int j = 1; j <= l2; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					// keep s1[i-1] and s2[j-1]
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
				}
			}
		
		return dp[l1][l2];
	}
	
	// 13 ms, faster than 78.41%
	// !!! Convert the String to charArray can speed it up to 99%
	// char[] s = s1.toCharArray(), t = s2.toCharArray();
	
	// Approach 1: Memorization + Recursion
	// TC: O(l1 * l2)
	// SC: O(l1 * l2)
	public int minimumDeleteSum2(String s1, String s2) {
		final int l1 = s1.length();
		final int l2 = s2.length();
		int[][] m = new int[l1 + 1][l2 + 1];
		// initialize: make each ele to MAX
		for (int[] a : m) {
			Arrays.fill(a, Integer.MAX_VALUE);
		}
		return dp(s1, l1, s2, l2, m);
    }
	
	public int dp(String s1, int i, String s2, int j, int[][] m) {
		if (i == 0 && j == 0) return 0;
		if (m[i][j] != Integer.MAX_VALUE) {
			return m[i][j];
		}
		if (i == 0) {// s1 is empty
			return m[i][j] = dp(s1, i, s2, j - 1, m) + s2.charAt(j - 1);
		}
		if (j == 0) {// s2 is empty
			return m[i][j] = dp(s1, i - 1, s2, j, m) + s1.charAt(i - 1);
		}
		
		if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
			return m[i][j] = dp(s1, i - 1, s2, j - 1, m);
		}
		
		return m[i][j] = Math.min(dp(s1, i - 1, s2, j, m) + s1.charAt(i - 1), 
				dp(s1, i, s2, j - 1, m) + s2.charAt(j - 1));
	}
}
