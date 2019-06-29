package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInStr_438 {

	public static void main(String[] args) {
		System.out.println("Cai Test = " + findAnagrams("cbaebabacd", "abc"));
		System.out.println("Cai Test = " + findAnagrams("abab", "ab"));
		System.out.println("Cai Test = " + findAnagrams("abeeeab", "ab"));
//		System.out.println("Cai Test = " + findAnagrams("abeeab", "aab"));
//		System.out.println("Cai Test = " + findAnagrams("eeaba", "ab"));
//		System.out.println("Cai Test = " + findAnagrams("eaeba", "ab"));
	}
	
	// 8 ms, faster than 96.05%
	// window --- [start--i] --- window's length is p's length()
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> ans = new ArrayList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0) return ans;
        
        int[] counter = new int[256]; // standard ascii table + extral space
        for (char c : p.toCharArray()) {
            counter[c]++;
        }
        
        int start = 0; //the start indices of p's anagrams in s
        int count = p.length();// user to check the timing.
        for (int i = 0; i < s.length(); i++) {
            // it means current char is in counter
            if (--counter[s.charAt(i)] >= 0) {
                count--;
            }
            
            // when all occurrences be eliminated
            if (count == 0) {
                ans.add(start);
            }
            
            // the window size is p.length() - 1
            if (i - start == p.length() - 1) {
                // move forward the start index (left pointer of window)
                if (++counter[s.charAt(start)] >= 1) {
                    count++;
                }
                start++;
            }
        }
        
        return ans;
    }
	
//	public static List<Integer> findAnagrams(String s, String p) {
//	       ///We will use sliding window template
//	       
//	       ArrayList<Integer> soln = new ArrayList<Integer>();
//	       
//	       //Check for bad input
//	       if (s.length() == 0 || p.length() == 0 || s.length() < p.length()){
//	           return new ArrayList<Integer>();
//	       }
//	       
//	       //Set up character hash
//	       //Keep track of how many times each character appears
//	       int[] chars = new int[26];
//	       for (Character c : p.toCharArray()){
//	           //Increment to setup hash of all characters currently in the window
//	           //Later on, these get DECREMENTED when a character is found
//	           //A positive count later on means that the character is still "needed" in the anagram
//	           //A negative count means that either the character was found more times than necessary
//	           //Or that it isn't needed at all
//	           chars[c-'a']++;
//	       }
//	       
//	       //Start = start poniter, end = end pointer,
//	       //len = length of anagram to find
//	       //diff = length of currently found anagram. If it equals
//	       //the length of anagram to find, it must have been found
//	       int start = 0, end = 0, len = p.length(), diff = len;
//	       
//	       char temp;
//	       //Before we begin this, the "window" has a length of 0, start and
//	       //end pointers both at 0
//	       for (end = 0; end < len; end++){
//	           //Process current char
//	           temp = s.charAt(end);
//	           
//	           //As discussed earlier, decrement it
//	           chars[temp-'a']--;
//	           
//	           //If it's still >= 0, the anagram still "needed" it so we count it towards the anagram by
//	           //decrementing diff
//	           if (chars[temp-'a'] >= 0){
//	               diff--;
//	           }
//	       }
//	       
//	       System.out.println("Cai Test diff = " + diff);
//	       //This would mean that s began with an anagram of p
//	       if (diff == 0){
//	           soln.add(0);
//	       }
//	       
//	       //At this point, start remains at 0, end has moved so that the window is the length of the anagram
//	       //from this point on we are going to be moving start AND end on each iteration, to shift the window
//	       //along the string
//	       while (end < s.length()){
//	           
//	           //Temp represents the current first character of the window. The character that is
//	           //going to be "left behind" as the window moves. 
//	           temp = s.charAt(start);
//	           
//	           //If it's not negative, this means that the character WAS part of the anagram. That means we
//	           //are one step "farther away" from completing an anagram. So we must increment diff.
//	           if (chars[temp-'a'] >= 0){
//	               diff++;
//	           }
//	           
//	           //Increment the hash value for this character, because it is no longer contained in the window
//	           chars[temp-'a']++;
//	           
//	           //Increment start to start shifting the window over by 1
//	           start++;
//	           
//	           //Temp represents the last character of the window, the "new" character from the window shift.
//	           //This character "replaces" the one we removed before so the window stays the same length (p.length())
//	           temp = s.charAt(end);
//	           
//	           //Decrement hash value for this character, because it is now a part of the window
//	           chars[temp-'a']--;
//	           
//	           //Again, if it's not negative it is part of the anagram. So decrement diff
//	           if (chars[temp-'a'] >= 0){
//	               diff--;
//	           }
//	           
//	           //If diff has reached zero, that means for the last p.length() iterations, diff was decremented and
//	           //NOT decremented, which means every one of those characters was in the anagram, so it must be an anagram
//	           
//	           //Note: If many windows in a row find anagrams, then each iteration will have diff incremented then decremented again
//	           if (diff == 0){
//	               soln.add(start);
//	           }
//	           
//	           //Increment for next iteration
//	           end++;
//	       }
//	       
//	       return soln;
//	    }
	
	// 8 ms, faster than 96.05%
//	public static List<Integer> findAnagrams(String s, String p) {
//		int left = 0;
//        int right = 0;
//        int sLen = s.length();
//        int pLen = p.length();
//        
//        int[] hash = new int[128]; // the standard ascii table size is 128
//        List<Integer> pos = new ArrayList<Integer>();
//        
//        for (int i = 0; i< pLen; i++) {
//            hash[p.charAt(i)]++;
//        }
//        int count = 0;
//        
//        while (right < sLen) {
//            if (hash[s.charAt(right)] > 0) {
//                hash[s.charAt(right)]--;
//                count++;
//                right++;
//            } else {
//                hash[s.charAt(left)]++;
//                count--;
//                left++;
//            }
//
//            if(count == pLen) {
//                pos.add(left);
//            }
//        }
//        return pos;
//	}
	
	// 197 ms, faster than 21.53% 
//	public static List<Integer> findAnagrams(String s, String p) {
//		List<Integer> results = new ArrayList<>();
//		int[] map = new int[128];
//		for (char c : p.toCharArray()) {
//			map[c]++;
//		}
//		
//		for (int i = 0; i <= s.length() - p.length(); i++) {
//			if (map[s.charAt(i)] > 0) {
//				int[] temp = map.clone();
//				temp[s.charAt(i)]--;
//				boolean match = true;
//				// try to find p.length() chars
//				for (int j = i + 1; j < i + p.length(); j++) {
//					if (temp[s.charAt(j)] == 0) {
//						match = false;
//						break;
//					} else {
//						temp[s.charAt(j)]--;
//					}
//				}
//				
//				if (match) {
//					results.add(i);
//				}
//			}
//		}
//		
//		return results;
//	}
	
	// my first solution
	// 528 ms, faster than 11.95%
	// Time Complexity: O(n*m)
//	public static List<Integer> findAnagrams(String s, String p) {
//		List<Integer> results = new ArrayList<>();
//		for (int i = 0; i <= s.length() - p.length(); i++) {
//			String subStr = s.substring(i, i + p.length());
//			if (isAnagrams(subStr, p)) {
//				results.add(i);
//			}
//		}
//        return results;
//    }
//
//	public static boolean isAnagrams(String p, String q) {
//		if (p == null || q == null || p.length() != q.length()) {
//			return false;
//		}
//		
//		int[] map = new int[128];
//		for (char c : p.toCharArray()) {
//			map[c]++;
//		}
//		for (char c : q.toCharArray()) {
//			if (map[c] == 0) {
//				return false;
//			} else {
//				map[c]--;
//			}
//		}
//		return true;
//	}
}
