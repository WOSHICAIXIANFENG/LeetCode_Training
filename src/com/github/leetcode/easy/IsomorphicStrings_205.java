package com.github.leetcode.easy;

import java.util.Arrays;

public class IsomorphicStrings_205 {

	public static void main(String[] args) {
		System.out.println("Cai Test isIsomorphic = " + isIsomorphic("egg", "add"));
		System.out.println("Cai Test isIsomorphic = " + isIsomorphic("foo", "bar"));
		System.out.println("Cai Test isIsomorphic = " + isIsomorphic("paper", "title"));
		System.out.println("Cai Test isIsomorphic = " + isIsomorphic("bar", "foo"));
		System.out.println("Cai Test isIsomorphic = " + isIsomorphic("s\\|d", "fooab"));
	}
	
	// 2 ms, faster than 99.33%
	// Integer array is faster than hashMap
	public static boolean isIsomorphic(String s, String t) {
        char[] sA = s.toCharArray();
        char[] tA = t.toCharArray();
        
        int length = s.length();
        if (length != t.length()) {
        	return false;
        }
        
        char[] sMap = new char[256];
        char[] tMap = new char[256];
        for (int i = 0; i < length; i ++) {
        	char sC = sA[i];
        	char tC = tA[i];
        	if (sMap[sC] == 0 && tMap[tC] == 0) {
        		sMap[sC] = tC;
        		tMap[tC] = sC;
        	} else {
        		// see, bar --> 
        		if (sMap[sC] != 0 && sMap[sC] != tC) {
        			return false;
        		} else if (tMap[tC] != 0 && tMap[tC] != sC) {
        			// bar, see
        			return false;
        		}
        		// egg, add --> 
        	}
        }
        return true;
	}
	
	// 21 ms, faster than 21.71%
	// O(n)
//	// Two Strings are isomorphic if the positions of the characters follow the same pattern.
//	public static boolean isIsomorphic(String s, String t) {
//		if (s == null || t == null) {
//			return false;
//		}
//		if (s.length() != t.length()) {
//			return false;
//		}
//		Map<Character, Integer> mapS = new HashMap<Character, Integer>();
//		Map<Character, Integer> mapT = new HashMap<Character, Integer>();
//		for (int i = 0; i < s.length(); i ++) {
//			int indexS = mapS.getOrDefault(s.charAt(i), -1);
//			int indexT = mapT.getOrDefault(t.charAt(i), -1);
//			
//			if (indexS != indexT) {
//				return false;
//			}
//			mapS.put(s.charAt(i), i);
//			mapT.put(t.charAt(i), i);
//		}
//		
//        return true;
//    }
	
//	// map.containsKey's time complexity is O(1).
//	// map.containsValue's time complexity is O(n), therefore might make the total time O(n^2)
//	public static boolean isIsomorphic(String s, String t) {
//		Map<Character, Character> map = new HashMap<Character, Character>();
//		for (int i = 0; i < t.length(); i ++) {
//			char a = s.charAt(i);
//			char b = t.charAt(i);
//			
//			if (map.containsKey(a)) {
//				if (!map.get(a).equals(b)) {
//					return false;
//				}
//			} else if (map.containsValue(b)) {
//				return false;
//			}
//			map.put(a, b);
//		}
//		return true;
//	}

}
