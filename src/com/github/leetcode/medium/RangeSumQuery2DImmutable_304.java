package com.github.leetcode.medium;

public class RangeSumQuery2DImmutable_304 {

	public static void main(String[] args) {
		int[][] m1 = {
				{3, 0, 1, 4, 2},
				{5, 6, 3, 2, 1},
				{1, 2, 0, 1, 5},
				{4, 1, 0, 1, 7},
				{1, 0, 3, 0, 5}
		};
		NumMatrix obj = new NumMatrix(m1);
		System.out.println("Cai Test = " + obj.sumRegion(2, 1, 4, 3));// 8
		System.out.println("Cai Test = " + obj.sumRegion(1, 1, 2, 2));// 11
		System.out.println("Cai Test = " + obj.sumRegion(1, 2, 2, 4));// 12
	}

}

/**
 * You may assume that the matrix does not change. 
 *  ----> so, we can do some pre-process computation.
 *  
 * There are many calls to sumRegion function.
 *  ----> need pre-compute process to speed up
 *  
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 *  ----> 
 *  
 *  Brute Force Solution: will take O(m * n) each time
 *  
 */

// 56 ms, faster than 92.11%

// idea: Having a function to compute sum(0..x, 0..y) in O(1). 
// then we can compute sum(x1..x2, y1..y2) in O(1).

// http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-304-range-sum-query-2d-immutable/

class NumMatrix {
	private int[][] sums;
	
	// TC: O(m * n)
    public NumMatrix(int[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        // define dp array to compute sums value
        // sums_[i][j] = sum(matrix[0][0] ~ matrix[i-1][j-1])
        this.sums = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
        	for (int j = 1; j <= n; j++) {
        		sums[i][j] = matrix[i-1][j-1]
        				+ sums[i - 1][j]
        				+ sums[i][j - 1]
        				- sums[i - 1][j - 1];
        	}
    }
    
    // TC: O(1)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] 
        		- sums[row2 + 1][col1]
        		- sums[row1][col2 + 1]
        		+ sums[row1][col1];
    }
}

