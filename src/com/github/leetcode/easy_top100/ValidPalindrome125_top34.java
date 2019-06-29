package com.github.leetcode.easy_top100;

public class ValidPalindrome125_top34 {

	public static void main(String[] args) {
		ValidPalindrome125_top34 obj = new ValidPalindrome125_top34();
		System.out.println("Cai Test = " + obj.isPalindrome("A man, a plan, a canal: Panama"));// true
		System.out.println("Cai Test = " + obj.isPalindrome("race a car"));// false
	}

	/**
	 * For the purpose of this problem, we define empty string as valid palindrome.
	 * 
	 */
	
	// 5 ms, faster than 55.43% ---- convert s to Char[] could speed up!!!
	// Approach 1: Two pointers
	// TC: O(n)
	// SC: O(1)
	public boolean isPalindrome(String s) {
		final int n = s.length();
		// define two pointers
		int p1 = 0;
		int p2 = n - 1;
		while (p1 < p2) {
			Character ch1 = s.charAt(p1);
			Character ch2 = s.charAt(p2);
			if (Character.isLetterOrDigit(ch1) && Character.isLetterOrDigit(ch2)) {
				if (Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
					return false;
				}
				p1++;
				p2--;
			} else if (!Character.isLetterOrDigit(ch1)) {
				p1++;
			} else {
				p2--;
			}
		}
		return true;
	}
}
