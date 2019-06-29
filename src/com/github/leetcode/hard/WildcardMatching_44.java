package com.github.leetcode.hard;

public class WildcardMatching_44 {

	public static void main(String[] args) {
		WildcardMatching_44 obj = new WildcardMatching_44();
		System.out.println("Cai Test = " + obj.isMatch("aa", "a"));// false
		System.out.println("Cai Test = " + obj.isMatch("aa", "*"));// true
		System.out.println("Cai Test = " + obj.isMatch("cb", "?a"));// false
		System.out.println("Cai Test = " + obj.isMatch("adceb", "*a*b"));// true
		System.out.println("Cai Test = " + obj.isMatch("acdcb", "a*c?b"));//false!
	}

	// 11 ms, faster than 78.38%
	// Approach 1: DP
	// TC: O(l1 * l2)
	// SC: O(l1 * l2)
	public boolean isMatch(String s, String p) {
		final int l1 = s.length();
		final int l2 = p.length();
		// dp[i][j] --- is Match for s.substr(0,i), p.substr(0,j)
		boolean[][] dp = new boolean[l1 + 1][l2 + 1];// default value is false
		// initial dp 
		dp[0][0] = true;//!!! start point!!!
		// !!!! --- you have to i
		for (int j = 1; j <= l2; j++) {
			if (p.charAt(j - 1) == '*') {
				// if p is '*', make it as empty, os == dp[j-1]
				dp[0][j] = dp[0][j - 1];
			} else {
				//dp[0][j] = false; // you can ignore in Java language
			}
		}
		
		for (int i = 1; i <= l1; i++)
			for (int j = 1; j <= l2; j++) {
				if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*'){
					// * replace empty sequence or any sequence
					dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
				}
			}
		
        return dp[l1][l2];
    }
}
