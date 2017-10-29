package com.github.leetcode.easy;

/**
 * https://leetcode.com/problems/reverse-string/
 * 
 * Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".

 * @author Samuel
 *
 */
public class ReverseString_344 {

	public static void main(String[] args) {
		String str1 = "hello";
		String str2 = "same";
		
		System.out.println("Samuel Test reverseString = " + reverseString(str1));
		System.out.println("Samuel Test reverseString = " + reverseString(str2));
	}

	// time complexity: O(n/2)
	public static String reverseString(String s) {
		char[] ch = s.toCharArray();
		int mid = s.length() / 2;
		
		char temp;
		for (int i = 0; i < mid; i ++) {
			temp = ch[s.length() - 1 - i];
			ch[s.length() - 1 - i] = ch[i];
			ch[i] = temp;
		}
        return new String(ch);
    }
}
