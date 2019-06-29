package com.github.leetcode.medium;

import java.util.Arrays;

// http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-221-maximal-square/

public class MaximalSquare_221 {

	public static void main(String[] args) {
		MaximalSquare_221 obj = new MaximalSquare_221();
		char[][] m1 = {
				{'1', '0', '1', '0', '0'},	
				{'1', '0', '1', '1', '1'},	
				{'1', '1', '1', '1', '1'},	
				{'1', '0', '0', '1', '0'}
		};
		System.out.println("Cai Test = " + obj.maximalSquare(m1));// 4
		char[][] m2 = {
				{'1'}
		};
		System.out.println("Cai Test = " + obj.maximalSquare(m2));// 1
	}
	
	// !!! Perfect DP code !!! ---- DP的方法只能用来求解Square类，cell全是1的问题。
	
    // Approach 2: DP --- two dimensions 
	// dp[x][y]: max square len/size can achieve at (x,y) as the bottom-right
    // dp[x][y] = min(dp[x-1][y-1], dp[x-1][y], dp[x][y-1]) + 1.
    
	// TC: O(n^2)
	// SC: O(n^2)
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        	return 0;
        }
        final int m = matrix.length;
        final int n = matrix[0].length;
        // define dp array
        int[][] dp = new int[m + 1][n + 1];
        // initial dp array to 0
        int ans = 0;
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    ans = Math.max(ans, dp[i][j] * dp[i][j]);
                }
            }
        
        return ans;
	}
	
	// 4 ms, faster than 96.79%
	
//	// Approach 2: DP
//	// dp[x][y]: max square len/size can achieve at (x,y) as the bottom-right
//	// TC: O(n^2)
//	// SC: O()
//	public int maximalSquare_my_dp(char[][] matrix) {
//		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//        	return 0;
//        }
//        final int m = matrix.length;
//        final int n = matrix[0].length;
//            
//        // define dp array
//        int[][] dp = new int[m][n];
//        // initial dp array -- first row & col
//        for (int j = 0; j < n; j++) {
//        	dp[0][j] = matrix[0][j] - '0';
//        }
//        for (int i = 0; i < m; i++) {
//        	dp[i][0] = matrix[i][0] - '0';
//        }
//        // set the start point --- already done in above code
//        
//        int ans = 0;
//        // handle the first row and col value
//        for (int j = 0; j < n; j++) {
//        	ans = Math.max(ans, dp[0][j]);
//        }
//        for (int i = 0; i < m; i++) {
//        	ans = Math.max(ans, dp[i][0]);
//        }
//        
//        for (int i = 1; i < m; i++)
//        	for (int j = 1; j < n; j++) {
//        		dp[i][j] = matrix[i][j] - '0';
//        		if (matrix[i][j] != '1') {
//        			continue;
//        		}
//        		dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
//        		ans = Math.max(ans, dp[i][j] * dp[i][j]);
//        	}
//        return ans;
//	}

	// 这是通用方法，你可以求得 以任何cell为点的 matrix 中的元数和 
	
	// Approach 1: Optimized Brute Force to check each potential top-left cell
	// Having a fun to compute sum(0:x, 0:y) in O(1).
	// TC: O(n^3) + O(n^2) pre sum calculation
	// SC: O(n^2)
	public int maximalSquare2(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        	return 0;
        }
        final int m = matrix.length;
        final int n = matrix[0].length;
        // pre compute sums by dp
        // sum[i][j] --- sum from (1,1) to (i,j)
        int[][] sums = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
        	for (int j = 1; j <= n; j++) {
        		sums[i][j] = matrix[i - 1][j - 1] - '0'
        				+ sums[i - 1][j]
        				+ sums[i][j - 1]
        				- sums[i - 1][j - 1];		
        	}
        
        // compute max square
        int ans = 0;
        for (int i = 1; i <= m; i++)
        	for (int j = 1; j <= n; j++) {
        		// for each potential top-left vertex, compute square area
        		// start from max len
        		for (int k = Math.min(m - i + 1, n - j + 1); k > 0; k--) {
        			// the area val start from (i,j) with k length
        			int sum = sums[i + k - 1][j + k -1]
        					- sums[i + k - 1][j - 1]
        					- sums[i - 1][j + k - 1]
        					+ sums[i - 1][j - 1];
        			
        			// check if the it is full of 1 --- 这里可以换成其他逻辑来 做其他题目!!!
        			if (sum == k * k) {
        				ans = Math.max(ans, sum);
        				break;//!!!
        			}
        		}
        	}
        return ans;
    }
}
