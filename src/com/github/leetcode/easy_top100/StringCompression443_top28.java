package com.github.leetcode.easy_top100;

import java.util.Arrays;

public class StringCompression443_top28 {

	public static void main(String[] args) {
		StringCompression443_top28 obj = new StringCompression443_top28();
		char[] a1 = {'a','a','b','b','c','c','c'};
		char[] a2 = {'a'};
		System.out.println("Cai Test = " + obj.compress(a1));//(a,2,b,2,c,3)5
		System.out.println("Cai Test = " + Arrays.toString(a1));
		System.out.println("Cai Test = " + obj.compress(a2));//1
		char[] a3 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
		System.out.println("Cai Test = " + obj.compress(a3));// (a,b,1,2) 4
	}

	// Could you solve it using only O(1) extra space?
	
	/**
	 * All characters have an ASCII value in [35, 126].
	 * 1 <= len(chars) <= 1000.
	 * ----> 
	 * 
	 * After you are done modifying the input array in-place, return the new length of the array.
	 * 
	 */
	
	// 1 ms, faster than 97.57%
	// Approach 1: Read & write from left to right
	// TC: O(n)
	// SC: O(1)
	public int compress(char[] chars) {
		final int m = chars.length;
		int index = 0;
		for (int i = 0; i < m; i++) {
			char ch = chars[i];
			// count ch from
			int count = 0;
			while (i < m && chars[i] == ch) {
				count++;
				i++;
			}
			
			if (count > 1) {
				// write ch and its count into chars
				chars[index++] = ch;
				char[] frequency = Integer.toString(count).toCharArray();
				for (char c : frequency) {
					chars[index++] = c;
				}
			} else {
				chars[index++] = ch;
			}
		}
		return index;
	}
}
