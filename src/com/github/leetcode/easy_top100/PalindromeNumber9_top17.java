package com.github.leetcode.easy_top100;

public class PalindromeNumber9_top17 {

	public static void main(String[] args) {
		PalindromeNumber9_top17 obj = new PalindromeNumber9_top17();
		int t1 = 1234321;
		int t2 = Integer.MAX_VALUE;
		int t3 = 99;
		int t4 = 7;
		
		System.out.println("Samuel Test isPalindrome = " + obj.isPalindrome(t1));// true
		System.out.println("Samuel Test isPalindrome = " + obj.isPalindrome(t2));// false
		System.out.println("Samuel Test isPalindrome = " + obj.isPalindrome(t3));// true
		System.out.println("Samuel Test isPalindrome = " + obj.isPalindrome(t4));// true
		
		// special case
		System.out.println("Samuel Test isPalindrome = " + obj.isPalindrome(0));// true
	}
	
	// Could you solve it without converting the integer to a string?
	
	// 6 ms, faster than 100.00%
	// TC: O(log{10}x) ---- 
	public boolean isPalindrome(int x) {
		// pruning 0 ending number or negative number
		if (x < 0 || (x > 0 && x % 10 == 0)) {
			return false;
		}
		
		// 12321 ---> 1232, 1 ---> 123, 12 ---> 12, 123
		// only check half number of digits
		int reverseHalf = 0;
		while (reverseHalf < x) {
			int lastDigit = x % 10;
			reverseHalf = reverseHalf * 10 + lastDigit;
			x = x / 10;
		}
		
		if (reverseHalf == x || reverseHalf / 10 == x) {
			return true;
		}
		return false;
	}
	
	// TC: O(log{10}n)
	// SC: O(1)
	public boolean isPalindrome2(int x) {
		int origin = x;
		int reverse = 0;
		int m = x;
		while (m != 0) {
			int lastDigit = m % 10;
			reverse = reverse * 10 + lastDigit;
			m = m / 10;
		}
		if (origin == reverse) {
			return true;
		}
		return false;
	}

}
