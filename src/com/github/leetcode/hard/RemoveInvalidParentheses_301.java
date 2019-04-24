package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses_301 {

	public static void main(String[] args) {
		RemoveInvalidParentheses_301 obj = new RemoveInvalidParentheses_301();
		System.out.println("Cai Test = " + obj.removeInvalidParentheses("()())()"));
		System.out.println("Cai Test = " + obj.removeInvalidParentheses("(a)())()"));
		System.out.println("Cai Test = " + obj.removeInvalidParentheses(")("));
	}

	// 4 ms, faster than 69.82%
	
	// Approach : Backtracking or DFS
	// TC: O(2^(l+r)) --- l -- size of redundant '(', r -- size of redundant ')'
	// SC: O(l+r)^2 --- O(n^2)
	public List<String> removeInvalidParentheses(String s) {
        // step1: compute how many '(' or ')' needs to remove
		int l = 0;
		int r = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				l += 1;
			}
			if (l == 0) {
				if (ch == ')') r += 1;
			} else {
				if (ch == ')') l -= 1;
			}
		}
		
		// step2: 
		List<String> ans = new ArrayList<>();
		dfs(s, 0, l, r, ans);
		return ans;
    }
	
	// l/r: number of left/right parentheses to remove
	// Try all possible ways to remove r ')'s and l '('s. 
	public void dfs(String s, int start, int l, int r, List<String> ans) {
		// nothing to remove.
		if (l == 0 && r == 0) {
			if (isValid(s)) {
				ans.add(s);
				return;
			}
		}
		for (int i = start; i < s.length(); i++) {
			// we only remove the first parenthes if there are consecutive ones  to avoid duplicate results
			if (i > start && s.charAt(i) == s.charAt(i - 1)) continue;
			
			// remove ')' first!!! make prefex valid
			if (s.charAt(i) == ')') {
				if (r > 0) {
					String cur = s.substring(0, i) + s.substring(i + 1);
					dfs(cur, i, l, r - 1, ans);
				}
			}
			if (s.charAt(i) == '(') {
				if (l > 0) {
					String cur = s.substring(0, i) + s.substring(i + 1);
					dfs(cur, i, l - 1, r, ans);
				}
			}
		}
	}
	
	public boolean isValid(String s) {
		int count = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '(') ++count;
			if (ch == ')') --count;
			if (count < 0) return false;
 		}
		return count == 0;
	}
}
