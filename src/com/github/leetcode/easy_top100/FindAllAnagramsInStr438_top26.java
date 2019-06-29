package com.github.leetcode.easy_top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInStr438_top26 {

	public static void main(String[] args) {
		FindAllAnagramsInStr438_top26 obj = new FindAllAnagramsInStr438_top26();
		System.out.println("Cai Test = " + obj.findAnagrams("cbaebabacd", "abc"));
		System.out.println("Cai Test = " + obj.findAnagrams("abab", "ab"));
	}

	/**
	 *  both strings s and p will not be larger than 20,100.
	 *  --------> solution's TC needs to below O(n^2) --- N^2 过万就会out of time Limited
	 *  
	 */
	
	// How to improve?  ---- can we use only one array 
//	public List<Integer> findAnagrams(String s, String p) {
//		List<Integer> ans = new ArrayList<>();
//        if (s == null || p == null || s.length() == 0 || p.length() == 0) return ans;
//        final int m = s.length();
//        final int l = p.length();// window size
//       
//	}
	
	// 7 ms, faster than 85.19%
	
	// Approach 1: Sliding Window + HashTable
	// Use a hashtable to represent p and the sliding window.
	// TC: O(s*26 or s*128) --> O(n)
	// SC: O()
	public List<Integer> findAnagrams(String s, String p) {
		final int m = s.length();
		final int l = p.length();
		List<Integer> ans = new ArrayList<>();
		int[] vp = new int[26];
		int[] vs = new int[26];
		for (char c : p.toCharArray()) {
			vp[c - 'a']++;
		}
		
		for (int i = 0; i < m; i++) {
			char ch = s.charAt(i);
			if (i >= l) {
				vs[s.charAt(i - l) - 'a']--;
			}
			vs[ch - 'a']++;
			// check if vs == vp
			if (Arrays.equals(vp, vs)) {
				ans.add(i - l + 1);
			}
		}
		
		return ans;
	}
}
