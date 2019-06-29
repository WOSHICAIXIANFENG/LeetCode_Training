package com.github.leetcode.medium;

public class DeleteOperationForTwoStrings_583 {

	public static void main(String[] args) {
		DeleteOperationForTwoStrings_583 obj = new DeleteOperationForTwoStrings_583();
		System.out.println("Cai Test = " + obj.minDistance("sea", "eat"));// 2
	}

	/**
	 * The length of given words won't exceed 500.
	 * 
	 */
	
	// Very clear Explanation!
	// https://www.youtube.com/watch?v=WF83Bm7ng1M
	
	// 你也可以降维 --- 使用一维数组去解决!!!
	
	// 4 ms, faster than 99.35%
	// Approach 1: DP --- Convert the problem to get longest common sub Array
	// TC: O(l1 * l2)
	// SC: O(l1 * l2)
	public int minDistance(String word1, String word2) {
		final int l1 = word1.length();
		final int l2 = word2.length();
		// dp array: dp[i][j] --- the longest common subArray from word1[0,i-1] word2[0,j-1]
		int[][] dp = new int[l1 + 1][l2 + 1];
//		// !!! initial dp array --- I merge it into my calculation loop
//		for (int i = 0; i < l1; i++) {
//			dp[i][0] = 0;
//		}
//		for (int j = 0; j < l2; j++) {
//			dp[0][j] = 0;
//		}
		
		for (int i = 0; i <= l1; i++)
			for (int j = 0; j <= l2; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? (dp[i - 1][j - 1] + 1) :
						Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		
		// you need to remove 'ans' chars to make two strings equals
		int ans = l1 + l2 - 2 * dp[l1][l2];
        return ans;
    }
}
