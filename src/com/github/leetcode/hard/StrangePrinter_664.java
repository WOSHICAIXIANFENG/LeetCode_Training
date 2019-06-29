package com.github.leetcode.hard;

// http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-664-strange-printer/
public class StrangePrinter_664 {

	public static void main(String[] args) {
		StrangePrinter_664 obj = new StrangePrinter_664();
		System.out.println("Cai Test = " + obj.strangePrinter("aaabbb"));//2
		System.out.println("Cai Test = " + obj.strangePrinter("aba"));//2
	}
	
	/**
	 * Length of the given string will not exceed 100.
	 * -----> intuition -- your solution TC could at most be n^3
	 */
	// 9 ms, faster than 97.65%
	// Approach 1: Recursion with memorization --- top down --- (DP --- bottom up)
	// TC: O(n^3) --- there are n * n sub questions, each question you need to do k times loop
	// SC: O(n^2)
	public int strangePrinter(String s) {
        final int l = s.length();
        // define memory array:
        // m[i][j]: mini turn to print i to j
        int[][] m = new int[l][l];
        return turn(s.toCharArray(), 0, l - 1, m);
    }
	
	// Minimal turns to print s[i] to s[j]
	public int turn(char[] s, int i, int j, int[][] m) {
		// Empty string
		if (i > j) return 0;
		// solved
		if (m[i][j] > 0) return m[i][j];
		// default behavior: print s[i] to s[j-1] and print s[j]
		int ans = turn(s, i, j - 1, m) + 1;
		for (int k = i; k < j; k++) {
			if (s[k] == s[j]) {
				ans = Math.min(ans, turn(s, i, k, m) + turn(s, k+1, j - 1, m));
			}
		}
		return m[i][j] = ans;
	}
}
