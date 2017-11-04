package com.github.leetcode.easy;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * @author Samuel
 *
 */
public class PalindromeNumber_9 {

	public static void main(String[] args) {
		int t1 = 1234321;
		int t2 = Integer.MAX_VALUE;
		int t3 = 99;
		int t4 = 7;
		
		System.out.println("Samuel Test isPalindrome = " + isPalindrome(t1));
		System.out.println("Samuel Test isPalindrome = " + isPalindrome(t2));
		System.out.println("Samuel Test isPalindrome = " + isPalindrome(t3));
		System.out.println("Samuel Test isPalindrome = " + isPalindrome(t4));
	}
	
	/**
Time complexity : O(log{10}n). We divided the input by 10 for every iteration, so the time complexity is O(log_{10} n)O(log
​10n)
Space complexity : O(1)O(1).
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome(int x) {
		// if x is negative --- is it Palindrome?
		if (x < 0 || (x > 0 && x % 10 == 0)) {
			return false;
		}
		
		int revertedNumber = 0;
		// if it is Palindrome, revertedNumber should not big than x
		while (x > revertedNumber) {
			revertedNumber = revertedNumber * 10 + x % 10;
			x = x / 10;
		}
		
		// case1: 123321
		// case2: 12321
        return x == revertedNumber || x == revertedNumber/10;
    }

}
