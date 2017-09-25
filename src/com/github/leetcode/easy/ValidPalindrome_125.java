package com.github.leetcode.easy;

/**
 * 
 * 
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

 * @author Samuel
 *
 */
public class ValidPalindrome_125 {

	public static void main(String[] args) {
		String str1 = "A man, a plan, a canal: Panama";
		String str2 = "race a car";
		
		System.out.println("Cai Test isPalindrome str1 = " + isPalindrome(str1));
		System.out.println("Cai Test isPalindrome str2 = " + isPalindrome(str2));
	}
	
	public static boolean isPalindrome(String s) {
		if (s.isEmpty()) {
			return true;
		}
		
		int head = 0; 
		int tail = s.length() - 1;
		char cHead, cTail;
		while (head <= tail) {
			cHead = s.charAt(head);
			cTail = s.charAt(tail);
			if (!Character.isLetterOrDigit(cHead)) {
				head ++;
			}
			
			if (!Character.isLetterOrDigit(cTail)) {
				tail --;
			}
			
			if (Character.isLetterOrDigit(cHead) && Character.isLetterOrDigit(cTail)) {
				if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
					return false;
				}
				head ++;
				tail --;
			}
		}
		
		return true;
	}

}
