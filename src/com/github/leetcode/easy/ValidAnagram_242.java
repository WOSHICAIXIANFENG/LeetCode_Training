package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_242 {

	public static void main(String[] args) {
		System.out.println("Cai Test  = " + isAnagram("anagram", "nagaram"));
		System.out.println("Cai Test  = " + isAnagram("rat", "cat"));
		// test unicode characters
		// System.out.println("Cai Test  = " + isAnagram("+-rat^&*c", "cat*&^r-+"));
	}
	
	// 1 ms, faster than 100.00% 
	public static boolean isAnagram(String s, String t) {
		if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        
        // standard ascii table has 128 elements.
        int[] map = new int[128];
        for (char c: s.toCharArray()) {
            map[c]++;
        }
        
        for( char c: t.toCharArray()) {
            if (map[c] == 0) return false;
            else map[c]--;
        }
        
        return true;
	}
	
	// 18 ms, faster than 26.30% 
	// What if the inputs contain unicode characters? How would you adapt your solution to such case?
//	public static boolean isAnagram(String s, String t) {
//		Map<Character, Integer> table = new HashMap<>();
//		for (int i = 0; i < s.length(); i++) {
//			int count = table.getOrDefault(s.charAt(i), 0);
//			table.put(s.charAt(i), count + 1); // !!! not count++
//		}
//		
//		for (int i = 0; i < t.length(); i++) {
//			int count = table.getOrDefault(t.charAt(i), 0);
//			if (count == 0) {
//				return false;
//			} else {
//				table.put(t.charAt(i), count - 1);
//			}
//		}
//		return true;
//	}
	
	// 5 ms, faster than 57.88%
	// Approach 2.2: Hash Table
	// Time Complexity: O(n)
	// Space Complexity: O(1) ---- O(w), w is 26.
//	public static boolean isAnagram(String s, String t) {
//		int[] table = new int[26];
//		for (int i = 0; i < s.length(); i++) {
//			table[s.charAt(i) - 'a']++;
//		}
//		
//		for (int i = 0; i < t.length(); i++) {
//			table[t.charAt(i) - 'a']--;
//			if (table[t.charAt(i) - 'a'] < 0) {
//				return false;
//			}
//		}
//		return true;
//	}
	
//	// Approach 2: Use a counter
//	public static boolean isAnagram(String s, String t) {
//		int[] counter = new int[26];
//		for (int i = 0; i < s.length(); i++) {
//			counter[s.charAt(i) - 'a']++;
//			counter[t.charAt(i) - 'a']--;
//		}
//		
//		for (int count : counter) {
//			if (count < 0) {
//				return false;
//			}
//		}
//		return true;
//	}
	
	// Approach 1: Sorting.
	// Time complexity: O(nlgn) --- sorting cost O(nlgn) and compare two chars array costs O(n).
	// Space complexity: O(1).
//	public static boolean isAnagram(String s, String t) {
//		if (s == null || t== null) {
//			return false;
//		}
//		
//		if (s.length() != t.length()) {
//			return false;
//		}
//		
//		char[] chars1 = s.toCharArray();
//		char[] chars2 = t.toCharArray();
//		Arrays.sort(chars1);
//		Arrays.sort(chars2);
//		
//        //return new String(chars1).equals(new String(chars2));
//		return Arrays.equals(chars1, chars2);
//    }

}
