package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle_120 {

	public static void main(String[] args) {
		Triangle_120 obj = new Triangle_120();
		List<List<Integer>> t1 = new ArrayList<>();
		List<Integer> a0 = new ArrayList<>();
		a0.add(2);
		t1.add(a0);
		List<Integer> a1 = new ArrayList<>();
		a1.add(3); a1.add(4);
		t1.add(a1);
		List<Integer> a2 = new ArrayList<>();
		a2.add(6); a2.add(5); a2.add(7);
		t1.add(a2);
		List<Integer> a3 = new ArrayList<>();
		a3.add(4); a3.add(1); a3.add(8); a3.add(3);
		t1.add(a3);
		System.out.println("Cai Test = " + obj.minimumTotal(t1));//11
	}

	/**
	 * Bonus point if you are able to do this using only O(n) extra space, 
	 * where n is the total number of rows in the triangle.
	 * ----> DP --- two dimensions to one dimension
	 * 
	 */
	// 2 ms, faster than 89.96% 
	
	// each i-th row has i elements as its a triangle
	// Approach 2: DP --- with one dimension
	// TC: O(n^2)
	// SC: O(n)
	public int minimumTotal(List<List<Integer>> triangle) {
		final int row = triangle.size();
		final int col = triangle.get(row - 1).size();
		// define dp array
		int[] dp = new int[row + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		// set the starting pos
		dp[1] = triangle.get(0).get(0);
		// compute
		for (int i = 2; i <= row; i++) {
			int[] dpNextRow = new int[row + 1];
			Arrays.fill(dpNextRow, Integer.MAX_VALUE);//!!!
			for (int j = 1; j <= i; j++) {
				dpNextRow[j] = triangle.get(i - 1).get(j - 1) + 
						Math.min(dp[j], dp[j - 1]);
			}
			//System.out.println("Cai Test dp array = " + Arrays.toString(dp));
			dp = dpNextRow;
		}
		
		
		// extract the mini value from bottom line
		int ans = dp[1];
		for (int i = 2; i <= row; i++) {
			ans = Math.min(ans, dp[i]);
		}
        return ans;
	}
	
	// 2 ms, faster than 89.96%
	// !!!1 because it is a triangle, so the i-th row has i elements
	// Approach 1: DP
	// TC: O(n * n) -- n is # of row
	// SC: O(n * n)
	public int minimumTotal2(List<List<Integer>> triangle) {
		final int row = triangle.size();
		final int col = triangle.get(row - 1).size();
		// define dp array: dp[i][j] --- the miniTotal from (1,1) to (i,j)
		// dp[row][col] = t[row][col] + min(dp[row -1][col], dp[row-1][col-1])
		int[][] dp = new int[row + 1][col + 1];
		// initial dp
		for (int[] d : dp) {
			Arrays.fill(d, Integer.MAX_VALUE);
		}
		// set starting pos
		dp[1][1] = triangle.get(0).get(0);
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= i; j++) {
				if (i == 1 && j == 1) {
					continue;
				} else {
					dp[i][j] = triangle.get(i - 1).get(j - 1) + 
							Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
				}
			}
		}
		
		// extract the mini value from bottom line
		int ans = dp[row][1];
		for (int i = 2; i <= col; i++) {
			ans = Math.min(ans, dp[row][i]);
		}
        return ans;
    }
}
