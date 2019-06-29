package com.github.leetcode.hard;

public class InterleavingString_97 {

	public static void main(String[] args) {
		InterleavingString_97 obj = new InterleavingString_97();
		System.out.println("Cai Test = " + obj.isInterleave("aabcc", "dbbca", "aadbbcbcac"));//true
		System.out.println("Cai Test = " + obj.isInterleave("aabcc", "dbbca", "aadbbbaccc"));//false
	}

	// 2 ms, faster than 86.61%
	// Approach 1: DP --- 
	// TC: O(l1 * l2)
	// SC: O(l1 * l2)
	public boolean isInterleave(String s1, String s2, String s3) {
        final int l1 = s1.length();
        final int l2 = s2.length();
        final int l3 = s3.length();
        if (l1 + l2 != l3) {
            return false;
        }
        // dp[i][j]: whether s3.substr(0, i+j) is a interleave of s1.substr(0,i) and s2.substr(0,j)
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        // initialize the dp array
        dp[0][0] = true;
        for (int i = 1; i <= l1; i++) {
            // if s2 is empty, check each char with s1
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j <= l2; j++) {
            // if s1 is empty, check each char with s2
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        
        // do calculation
        for (int i = 1; i <= l1; i++)
            for (int j = 1; j <= l2; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1) ||
                           (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)));
            }
        
        return dp[l1][l2];
    }
}
