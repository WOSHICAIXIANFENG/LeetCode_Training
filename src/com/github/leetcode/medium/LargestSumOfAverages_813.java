package com.github.leetcode.medium;

// http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-813-largest-sum-of-averages/
public class LargestSumOfAverages_813 {

	public static void main(String[] args) {
		LargestSumOfAverages_813 obj = new LargestSumOfAverages_813();
		int[] a1 = {9,1,2,3,9};
		System.out.println("Cai Test = " + obj.largestSumOfAverages(a1, 3));//20.0
		int[] a2 = {1,2,3,4,5,6,7};
		System.out.println("Cai Test = " + obj.largestSumOfAverages(a2, 4));//20.5
	}

	/**
	 * 1 <= A.length <= 100. 
	 * ------> Your solution can't be O(2^n)
	 * 1 <= A[i] <= 10000.
	 * ------> You solution possible to be O(k*n^2) or O(k*n)
	 * 1 <= K <= A.length.
	 */
	
	// 5 ms, faster than 77.18%
	// Approach 2: DP
	// dp[k][i]: max avg sum of first i elements partitioned into k groups.
	// TC: O(k * n^2)
	// SC: O(k * n)
	public double largestSumOfAverages(int[] A, int K) {
		final int n = A.length;
		double[] preSum = new double[n + 1];
		// dp[k][i]: max avg sum of first i elements grouping in k sets
		double[][] dp = new double[K + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			preSum[i] = preSum[i - 1] + A[i - 1];
			dp[1][i] = preSum[i] / i;
		}
		
		for (int k = 2; k <= K; k++)
			//!!! 分成k groups，你必须至少要使用到k个元素!!!
			for (int i = k; i <= n; i++) {
				// do calculation for different partion
				for (int j = k - 1; j < i; j++)
					dp[k][i] = Math.max(dp[k][i], dp[k - 1][j] + (preSum[i] - preSum[j])/(i - j));
			}		
		
		return dp[K][n];
	}
	
	// 2 ms, faster than 99.64% 
	// Approach 1: memorization recursion --- DFS
	// TC: O(k * n^2)
	// SC: O(k * n)
	public double largestSumOfAverages_dfs(int[] A, int K) {
		final int n = A.length;
		// define mem array
		// m[k][i]: max avg sum of first i elements partitioned into k groups
		double[][] m = new double[K + 1][n + 1];
		//!!!1 preSum 必须也定义成double type
		double[] preSum = new double[n + 1];
		for (int i = 1; i <= n; i++) {
			preSum[i] = preSum[i - 1] + A[i - 1];
		}
		
        return LSA(A, n, K, preSum, m);
    }
	
	// Top to down process
	// Largest sum of average for first n elements in A partioned into k groups
	public double LSA(int[] A, int n, int k, double[] preSum, double[][] m) {
		if (m[k][n] > 0) return m[k][n];
		if (k == 1) return preSum[n] / n;//!!!
		
		// !!! start from k - 1.  分成4份，i可以直接从 前 3开始算
		for (int i = k - 1; i < n; i++) {
			// since we have '(preSum[n] - preSum[i]) / (n - i)' ---> we have to make sure preSum is double[] type
			m[k][n] = Math.max(m[k][n], LSA(A, i, k - 1, preSum, m) + (preSum[n] - preSum[i]) / (n - i));
		}
		
		return m[k][n];
	}
}
