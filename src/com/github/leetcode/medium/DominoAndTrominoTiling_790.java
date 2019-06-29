package com.github.leetcode.medium;

public class DominoAndTrominoTiling_790 {

	public static void main(String[] args) {
		DominoAndTrominoTiling_790 obj = new DominoAndTrominoTiling_790();
		System.out.println("Cai Test = " + obj.numTilings(3));//5
		System.out.println("Cai Test = " + obj.numTilings(1));//1
		System.out.println("Cai Test = " + obj.numTilings(30));//312342182 
	}
	
	/**
	 * http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-790-domino-and-tromino-tiling/
	 * 
	 * dp[i][0]:  ways to cover i cols, both rows of i-th col are covered/tiled
     * dp[i][1]:  ways to cover i cols, only top row of i-th col is covered/tiled
     * dp[i][2]:  ways to cover i cols, only bottom row of i-th col is covered/tiled
     * 
     * N  will be in range [1, 1000]. Return your answer modulo 10^9 + 7.
     * -----> You have to use bigger type to avoid out of INT Range
     * 
	 */
	// 1 ms, faster than 70.09%
	// Approach 1: DP -- two dimension
	// TC: O(n)
	// SC: O(n)
	public int numTilings(int N) {
	   if (N <= 1) return 1; // edge case
	   
       final int kMod = 1000000007;
       long[][] dp = new long[N + 1][3];//!!! We have to use long type to avoid out of Int Range
       dp[0][0] = 1;//!!! make 0 cols be tiled
       dp[1][0] = 1;// make 1 cols be tiled
       for (int i = 2; i <= N; i++) {
    	   dp[i][0] = (dp[i - 1][0] + dp[i - 2][0] + dp[i - 1][1] + dp[i - 1][2]) % kMod;
    	   dp[i][1] = (dp[i - 2][0] + dp[i - 1][2]) % kMod;
    	   dp[i][2] = (dp[i - 2][0] + dp[i - 1][1]) % kMod;
       }
       return (int) dp[N][0];
    }
	
	// 0 ms, faster than 100.00% 
	// Approach 2: DP --- one dimension
	// Another way to think about this problem.
	// define: dp[i] ways to completely covert the i*2 board.
	// ----> reduce to the formula ---> dp[n] = 2*dp[n-1] + dp[n-3]
	public int numTilings2(int N) {
	   final int kMod = 1000000007;
	   if (N <= 1) return 1;//!!!
	   
	   long[] dp = new long[N + 1];//!!! You have to use long type to cover case '30'. dp[i - 1] * 2 will out of Int Range
	   dp[0] = 1;
	   dp[1] = 1;
	   dp[2] = 2;// tiled 2 cols --- || =
	   for (int i = 3; i <= N; i++) {
		   dp[i] = (dp[i - 3] + dp[i - 1] * 2) % kMod;
	   }
	   return (int) dp[N];
	}
}
