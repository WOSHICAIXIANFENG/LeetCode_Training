package com.github.leetcode.easy_top100;

public class ValidAnagram242_top47 {

	public static void main(String[] args) {
		ValidAnagram242_top47 obj = new ValidAnagram242_top47();
		System.out.println("Cai Test  = " + obj.isAnagram("anagram", "nagaram"));// true
		System.out.println("Cai Test  = " + obj.isAnagram("rat", "cat"));// false
		// test unicode characters
		// System.out.println("Cai Test  = " + obj.isAnagram("+-rat^&*c", "cat*&^r-+"));
	}

	// 3 ms, faster than 94.09%
	
	// Fllow up:
	// What if the inputs contain unicode characters? How would you adapt your solution to such case?
	// Ans: Make the counter array to 128 --- // the standard ascii table has 128 chars
	public boolean isAnagram(String s, String t) {
		// corner case
		if (s == null || t == null || s.length() != t.length()) {
			return false;
		}
		
		// You may assume the string contains only lowercase alphabets.
		int[] counter = new int[26];
		for (char ch : s.toCharArray()) {
			counter[ch - 'a']++;
		}
		
		for (char ch : t.toCharArray()) {
			counter[ch - 'a']--;
			if (counter[ch - 'a'] < 0) {
				return false;
			}
		}
		return true;
	}
}
