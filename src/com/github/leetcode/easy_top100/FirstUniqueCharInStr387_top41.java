package com.github.leetcode.easy_top100;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharInStr387_top41 {

	public static void main(String[] args) {
		FirstUniqueCharInStr387_top41 obj = new FirstUniqueCharInStr387_top41();
		System.out.println("Cai Test = " + obj.firstUniqChar("leetcode"));// 0
		System.out.println("Cai Test = " + obj.firstUniqChar("loveleetcode"));// 2
	}
	
	// 6 ms, faster than 93.56%
	// You may assume the string contain only lowercase letters.
	// Improve --- Use array to represent hashmap
	public int firstUniqChar(String s) {
		int[] counter = new int[26];
		for (char ch : s.toCharArray()) {
			counter[ch - 'a']++;
		}
		for (int i = 0; i < s.length(); i++) {
			if (counter[s.charAt(i) - 'a'] == 1) {
				return i;
			}
		}
		return -1;
	}

	// You may assume the string contain only lowercase letters.
	
	// 43 ms, faster than 27.23%
	// Approach 1: HashMap
	// TC: O(n)
	// SC: O(n)
	public int firstUniqChar2(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		
		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;// it doesn't exist
	}
}
