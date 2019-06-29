package com.github.leetcode.medium;

import java.util.Arrays;

public class KnightDialer_935 {

	public static void main(String[] args) {
		KnightDialer_935 obj = new KnightDialer_935();
		System.out.println("Cai Test = " + obj.knightDialer(1));// 10
		System.out.println("Cai Test = " + obj.knightDialer(2));// 20
		System.out.println("Cai Test = " + obj.knightDialer(3));// 46
	}

	/**
	 * 1 <= N <= 5000 ----> DP --- 统计类的问题
	 * 
	 */
	
	// 14 ms, faster than 93.90% 
	// Approach 2: DP --- one dimension
    // TC: O(N)
    // SC: O(1)
    public int knightDialer(int N) {
        final int kMod = 1_000_000_007;
        final int[][] dirs = {
            {4, 6}, {6, 8}, {7,9}, {4,8}, {9, 3, 0}, {}, {7, 0, 1}, {6, 2}, {1, 3}, {4, 2}
        }; 
        
        // define dp array
        int[] dp0 = new int[10];
        // initial dp0 array to 1
        Arrays.fill(dp0, 1);
        
        // do calculation
        for (int k = 1; k < N; k++) {
            int[] dp1 = new int[10];
            for (int i = 0; i < 10; i++) {
                for (int d : dirs[i]) {
                    dp1[i] = (dp1[i] + dp0[d]) % kMod;
                }
            }
            dp0 = dp1;
        }
        
        // figure out the ans
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans = (ans + dp0[i]) % kMod;
        }
        return ans;
    }

	// 45 ms, faster than 44.98%
	// Approach 1: DP
	// dp[k][i][j]: # of ways ends on pos(i,j) after k hops
	// Init: dp[0][i][j] = 1 except (3,0), (3,2)
	// TC: O(N * row * col) or O(K * 4 * 3 * 12)
	// SC: O(N * row * col) or O(mn) or O(4*3*8)
	public int knightDialer2(int N) {
		final int kMod = 1000000007;
		final int[][] dirs = { { -2, -1 }, { -2, 1 }, { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2 }, { 2, -1 }, { 2, 1 } };
		// define dp array
		int[][] dp0 = new int[4][3];
		for (int[] row : dp0) {
			Arrays.fill(row, 1);
		}
		dp0[3][0] = 0;
		dp0[3][2] = 0;

		// !!! here: k < N !!!
		for (int k = 1; k < N; k++) {
			int[][] dp1 = new int[4][3];
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 3; j++) {
					if (i == 3 && j != 1)
						continue;
					for (int d = 0; d < 8; d++) {
						int tx = i + dirs[d][0];
						int ty = j + dirs[d][1];
						if (tx < 0 || tx >= 4 || ty < 0 || ty >= 3)
							continue;
						dp1[i][j] = (dp1[i][j] + dp0[tx][ty]) % kMod;
					}
				}

			dp0 = dp1;
		}

		// Sums up all unique number after N hops
		int ans = 0;
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 3; j++)
				ans = (ans + dp0[i][j]) % kMod;

		return ans;
	}
}
