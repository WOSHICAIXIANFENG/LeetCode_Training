package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharInStr_387 {

	public static void main(String[] args) {
		System.out.println("Cai Test = " + firstUniqChar("leetcode"));
		System.out.println("Cai Test = " + firstUniqChar("loveleetcode"));
	}
	
	// Better solution: Using indexOf & lastIndexOf
	// 6 ms, faster than 98.63%
	public static int firstUniqChar(String s) {
		int result = Integer.MAX_VALUE;
		for (char c = 'a'; c <= 'z'; c++) {
			int startIndex = s.indexOf(c);
			if (startIndex != -1 && startIndex == s.lastIndexOf(startIndex)) {
				result = Math.min(result, startIndex);
			}
		}
		return (result == Integer.MAX_VALUE) ? -1 : result;
	}

	//47 ms, faster than 40.93%
	// Time Complexity: 2O(n) --- n is the length of s.
//	public static int firstUniqChar(String s) {
//		Map<Character, Integer> map = new HashMap<>();
//		for (char c : s.toCharArray()) {
//			map.put(c, map.getOrDefault(c, 0) + 1);
//		}
//		for (int i = 0; i < s.length(); i++) {
//			if (map.get(s.charAt(i)) == 1) {
//				return i;
//			}
//		}
//        return -1;
//    }
}
