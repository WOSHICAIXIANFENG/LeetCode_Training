package com.github.leetcode.easy;

import java.util.Arrays;

public class StringCompression_443 {

	public static void main(String[] args) {
		char[] a1 = {'a','a','b','b','c','c','c'};
		char[] a2 = {'a'};
		System.out.println("Cai Test = " + compress(a1));//(a,2,b,2,c,3)5
		System.out.println("Cai Test = " + Arrays.toString(a1));
		System.out.println("Cai Test = " + compress(a2));//1
		char[] a3 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
		System.out.println("Cai Test = " + compress(a3));// (a,b,1,2) 4
	}
	
	// Better solution --- use while, not for()
	public static int compress(char[] chars) {
		int writeIndex = 0;
		int index = 0;
		while (index < chars.length) {
			char currChar = chars[index];
			// find the first different char
			int count = 0; // how many occurs for current Char
			while (index < chars.length && chars[index] == currChar) {
				count++;
				index++;
			}
			
			// set the current char into correct write index
			chars[writeIndex++] = currChar;
			// count maybe is big than 10
			if (count > 1) {
				for (char c : Integer.toString(count).toCharArray()) {
					chars[writeIndex++] = c;
				}
			}
		}
		
		return writeIndex;
	}
	
	//3 ms, faster than 100.00%
	// Time Complexity: O(n)
	// Space Complexity: O(1)
//	public static int compress(char[] chars) {
//		int writeIndex = 0;
//		for (int i = 0; i < chars.length; i++) {
//			char currChar = chars[i];
//			int count = 0;
//			while (i < chars.length && chars[i] == currChar) {
//				i++;
//				count++;
//			}
//			i--; // set back to the last same char index
//			chars[writeIndex++] = currChar;
//			
//			if (count > 1) {
//				for (char c: Integer.toString(count).toCharArray()) {
//					chars[writeIndex++] = c;
//				}
//			}
//		}
//		
//		return writeIndex;
//    }
}
