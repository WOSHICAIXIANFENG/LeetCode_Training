package com.github.leetcode.easy;

public class RansomNote_383 {

	public static void main(String[] args) {
		System.out.println("Cai Test = " + canConstruct("a", "b"));
		System.out.println("Cai Test = " + canConstruct("aa", "ab"));
		System.out.println("Cai Test = " + canConstruct("aa", "aab"));
	}
	
	
	// 7 ms, faster than 98.02%
	public static boolean canConstruct(String ransomNote, String magazine) {
		int[] table = new int[126];
		for (char c : magazine.toCharArray()) {
			table[c]++;
		}
		for (char c: ransomNote.toCharArray()) {
			if (table[c] == 0) {
				return false;
			}
			table[c]--;
		}
		return true;
	}

	// 7 ms, faster than 98.02% 
	// Approach 1: User counter
//	public static boolean canConstruct(String ransomNote, String magazine) {
//        int[] counter = new int[26];
//        for (char c : magazine.toCharArray()) {
//        	counter[c - 'a']++;
//        }
//        for (char c : ransomNote.toCharArray()) {
//        	if (counter[c - 'a'] == 0) {
//        		return false;
//        	}
//        	counter[c - 'a']--;
//        }
//		return true;
//    }
}
