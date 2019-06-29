package com.github.leetcode.easy_top100;

import java.util.HashMap;
import java.util.Map;

public class VerifyAlienDict953_top43 {

	public static void main(String[] args) {
		VerifyAlienDict953_top43 obj = new VerifyAlienDict953_top43();
		String[] s1 = {
				"hello","leetcode"
		};
		String order = "hlabcdefgijkmnopqrstuvwxyz";
		System.out.println("Cai Test = " + obj.isAlienSorted(s1, order));// true
		
		String[] s2 = {
				"word","world","row"
		};
		String o2 = "worldabcefghijkmnpqstuvxyz";
		System.out.println("Cai Test = " + obj.isAlienSorted(s2, o2));// false
		
		String[] s3 = {
				"apple","app"
		};
		String o3 = "abcdefghijklmnopqrstuvwxyz";
		System.out.println("Cai Test = " + obj.isAlienSorted(s3, o3));// false
	}

	/**
	 * 1 <= words.length <= 100
	 * 1 <= words[i].length <= 20
	 * order.length == 26
	 * 
	 */
	
	// 0 ms, faster than 100.00%
	
	// do it better --- You can use int[26] to simplify the HashMap
	public boolean isAlienSorted(String[] words, String order) {
		int[] map = new int[26];
		for (int i = 0; i < order.length(); i++) {
			map[order.charAt(i) - 'a'] = i;
		}
		
		for (int i = 1; i < words.length; i++) {
			if (compare(map, words[i - 1], words[i]) < 0) {
				return false;
			}
		}
		return true;
	}
	
	public int compare(int[] dict, String w1, String w2) {
		for (int i = 0; i < w1.length(); i++) {
			char ch1 = w1.charAt(i);
			if (i >= w2.length()) {
				return -1;
			} else if (dict[ch1 - 'a'] < dict[w2.charAt(i) - 'a']) {
				return 1;
			} else if (dict[ch1 - 'a'] > dict[w2.charAt(i) - 'a']) {
				return -1;
			}
		}
		return 1;
	}
 	
	// 1 ms, faster than 47.18%
	// Approach 1: Use hashMap to put the order info to make get ele in O(1)
	// TC: O(n * m)
	private Map<Character, Integer> map = null;
	public boolean isAlienSorted2(String[] words, String order) {
		map = new HashMap<>();
		for (int i = 0; i < order.length(); i++) {
			map.put(order.charAt(i), i);
		}
		
		// traverse all words
		for (int i = 1; i < words.length; i++) {
			if (!isWordsInAscending(words[i - 1], words[i])) {
				return false;
			}
		}
        return true;
    }
	
	public boolean isWordsInAscending(String w1, String w2) {
		for (int i = 0; i < w1.length(); i++) {
			char ch = w1.charAt(i);
			if (i >= w2.length()) {
				return false;
			} else if (map.get(ch) > map.get(w2.charAt(i))) {
				return false;
			} else if (map.get(ch) < map.get(w2.charAt(i))) {
				return true;
			}
		}
		return true;
	}
}
