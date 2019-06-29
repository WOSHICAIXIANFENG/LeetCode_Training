package com.github.leetcode.easy;

public class ClimbingStairs_70_s2 {
	
	// optimize SC -- O(n) --> O(1)
	public int climbStairs2(int n) {
		int f2 = 1;
        int f1 = 1;
        int cur = 1;
        for (int i = 2; i <= n; i++) {
            cur = f2 + f1;
            f1 = f2;
            f2 = cur;
        }
        return cur;
	}

	// 0 ms, faster than 100.00%
	
	// Approach 1: DP using Fibonacci Series
    // TC: O(n)
    // SC: O(n)
    public int climbStairs(int n) {
    	if (n <= 1) {
            return 1;
        }
        int[] fibonacci = new int[n + 1];
        fibonacci[1] = 1;
        fibonacci[2] = 2;
        for (int i = 3; i <= n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci[n];
    }
}
