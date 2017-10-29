package com.github.leetcode.easy;

/**
 * https://leetcode.com/problems/implement-strstr/
 * 
 * Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 * @author Samuel.Cai
 *
 */
public class ImplementStrstr_28 {

	public static void main(String[] args) {
		String h1 = "123Samuel";
		String h2 = "Sa123SauelSam";
		String n1 = "Sam";
		
		System.out.println("Samuel Test strStr = " + strStr(h1, n1));
		System.out.println("Samuel Test strStr = " + strStr(h2, n1));
	}

	// time complexity:  n*O(1) ---- n*O(n)
	public static int strStr(String haystack, String needle) {
		if (haystack == null || needle == null)   return -1;
		
		int l1 = haystack.length();
		int l2 = needle.length();
		if (l1 < l2) {
			return -1;
		} else if (l2 == 0) {
			return 0;
		}
		
		int interval = l1 - l2;
		for (int i = 0; i <= interval; i ++) {
			// for String.substring() API --- <= java6 ---- O(1): it just created a new String with the same underlying char[]
			// and a different offset and length
			// >= Java7 update 6 ----- O(n): The char[] sharing was eliminated, and the offset and length fields were removed. substring() now just copies all the characters into a new String.
			if (haystack.substring(i, i + l2).equals(needle)) {
				return i;
			}
		}
		
        return -1;
    }
}
