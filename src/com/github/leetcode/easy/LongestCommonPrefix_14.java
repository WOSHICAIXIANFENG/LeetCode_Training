package com.github.leetcode.easy;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * @author Samuel.Cai
 *
 */
public class LongestCommonPrefix_14 {

	public static void main(String[] args) {
		String[] array1 = {"abcd", "abcd13", "ab", "abababab"};
		String[] array2 = {"abcd", "abc13", "abc", "abcababab"};
		String[] array3 = {"abcd", "abc123", "abcdab", "ab34", "a56"};
		
		System.out.println("Samuel Test longestCommonPrefix = " + longestCommonPrefix(array1));
		System.out.println("Samuel Test longestCommonPrefix = " + longestCommonPrefix(array2));
		System.out.println("Samuel Test longestCommonPrefix = " + longestCommonPrefix(array3));
	}

	// Time Complexity: ---- n (the number of array) * k: average length of string
	// If you want to avoid using indexOf method, this will work. Runtime of this solution will be O(nk)
	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) return "";
		
		String prefix = strs[0];
		for (String str : strs) {
			// java String.indexOf() --- time complexity -- O(n+m) average and O(n*m) worst case.
			while (str.indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
			}
		}
		
        return prefix;
    }
}
