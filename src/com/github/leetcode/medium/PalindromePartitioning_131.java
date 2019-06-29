package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {

	public static void main(String[] args) {
		// partition problem
		PalindromePartitioning_131 obj = new PalindromePartitioning_131();
		System.out.println("Cai Test = " + obj.partition("aab"));
		
//		System.out.println("Cai Test isPalindrome = " + obj.isPalindrome("aab"));
//		System.out.println("Cai Test isPalindrome = " + obj.isPalindrome("aa"));
//		System.out.println("Cai Test isPalindrome = " + obj.isPalindrome("b"));
//		System.out.println("Cai Test isPalindrome = " + obj.isPalindrome("aba"));
	}

	// at each index, we make a choice to partition or not partition, 
	// if the string length is n and we could partition at each index for a string such as 'aaaaaaa',
	// time complexity would be O(2^n). However we also check if the given string is a palindrome or not 
	// at each step so the time complexity should actually be O(n*2^n)
	
	// 3 ms, faster than 80.66%
	// Approach 1 : DFS + Backtracking
	// TC: O(n*2^n)
	// SC: O(n) --- max depth of recursion
	public List<List<String>> partition(String s) {
		List<List<String>> ans = new ArrayList<>();
		if (s == null || s.length() == 0) return ans;
		
		List<String> cur = new ArrayList<>();
		dfs(s, 0, cur, ans);
        return ans;
    }
	
	// aab ---> 0, a ---- 1 a ---> 2 b ---> 3 ---> a, a, b
	// The normal dfs backtracking will need to check each substring for palindrome
	// start index
	public void dfs(String s, int start, List<String> cur, List<List<String>> ans) {
		// !!!
		if (start == s.length()) {
			ans.add(new ArrayList<>(cur));
			return;
		}
	
		for (int i = start; i < s.length(); i++) {
			String str = s.substring(start, i + 1);
			if (isPalindrome(str)) {
				cur.add(str);
				dfs(s, i + 1, cur, ans);
				cur.remove(cur.size() - 1);// backtracking
			}
		}
	}
	
	// a, aba, aaa, aa, baab --- true
	public boolean isPalindrome(String str) {
		int l = 0; 
		int r = str.length() - 1;
		while (l <= r) {
			if (str.charAt(l) != str.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
}
