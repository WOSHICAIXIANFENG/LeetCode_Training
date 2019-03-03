package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-pattern/
 * 
 * Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

 * @author Samuel.Cai
 */
public class WordPattern_290 {

	public static void main(String[] args) {
		System.out.println("Cai Test wordPattern = " + wordPattern("abba", "dog cat cat dog"));
		System.out.println("Cai Test wordPattern = " + wordPattern("abba", "dog cat cat fish"));
		System.out.println("Cai Test wordPattern = " + wordPattern("aaaa", "dog cat cat dog"));
		System.out.println("Cai Test wordPattern = " + wordPattern("abba", "dog dog dog dog"));
		System.out.println("Cai Test wordPattern = " + wordPattern("abba", "fish cat cat dog"));
	}
	
	// 1 ms, faster than 99.58%
	// use single Map
	// Time Complexity: O(n) --- O(n^2)
	// HashMap.containsKey() fun is O(1) complexity
	// HashMap.containsValue() fun is O(n) complexity, you can use extra Set or Map to avoid use this function()
	public static boolean wordPattern(String pattern, String str) {
		if (pattern == null || str == null) {
			return false;
		}
		
		char[] charArray = pattern.toCharArray();
		String[] strArray = str.split(" ");
		
		if (charArray.length != strArray.length) {
			return false;
		}
		
		Map<Character, String> map = new HashMap<>();
		for (int i = 0; i < charArray.length; i++) {
			char currChar = charArray[i];
			String currStr = strArray[i];
			if (map.containsKey(currChar)) {
				if (!map.get(currChar).equals(currStr)) {
					return false;
				}
			} else if (map.containsValue(currStr)) {
				return false;
			}
			map.put(currChar, currStr);
		}
		return true;
	}

	// 1 ms, faster than 99.58% 
	// Time Complexity: O(n)
	// their index patterns are the same
//	public static boolean wordPattern(String pattern, String str) {
//		if (pattern == null || str == null) {
//			return false;
//		}
//		
//		char[] charArray = pattern.toCharArray();
//		String[] strArray = str.split(" ");
//		
//		if (charArray.length != strArray.length) {
//			return false;
//		}
//		
//		Map<Character, Integer> cMap = new HashMap<>();
//		Map<String, Integer> sMap = new HashMap<>();
//		for (int i = 0; i < charArray.length; i++) {
//			int indexChar = cMap.getOrDefault(charArray[i], -1);
//			int indexStr = sMap.getOrDefault(strArray[i], -1);
//			if (indexChar != indexStr) {
//				return false;
//			}
//			cMap.put(charArray[i], i);
//			sMap.put(strArray[i], i);
//		}
//		
//        return true;
//    }
}
