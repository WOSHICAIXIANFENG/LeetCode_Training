package com.github.leetcode.easy;

public class LongestPalindrome_409 {

	public static void main(String[] args) {
		System.out.println("Cai Test = " + longestPalindrome("abccccdd"));
	}

	public static int longestPalindrome(String s) {
		int[] counter = new int[128];
		for (char c : s.toCharArray()) {
			counter[c]++;
		}
		
		int ans = 0;
		for (int count : counter) {
			ans += count / 2 * 2;
			if (ans % 2 == 0 && count % 2 != 0) {
				ans++;
			}
		}
        return ans;
    }
}
