package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {

	public static void main(String[] args) {
		GenerateParentheses_22 obj = new GenerateParentheses_22();
		System.out.println("Cai Test = " + obj.generateParenthesis(3));
		System.out.println("Cai Test abc.substring = " + "abc".substring(0, 2));
	}
	
	// 1 ms, faster than 97.05%
	
	// Best Solution!!!
	// come from: https://leetcode.com/articles/generate-parentheses/
	// Approach 2: BackTracking
	// TC: O(4^n/sqrt(n)) --- there are 4^n/n*sqrt(n) ans will be generate, each sequence will cost at most O(n) time
	// SC: O(4^n/sqrt(n)) store solutions + O(2n) recursion
	public List<String> generateParenthesis(int n) {
		List<String> ans = new ArrayList<>();
		backtrack(0, 0, n, "", ans);
		return ans;	
	}
	
	public void backtrack(int open, int close, int max, String cur, List<String> ans) {
		if (cur.length() == max * 2) {
			ans.add(cur);
		}
		// handle '(' first, then ')'
		if (open < max) {
			backtrack(open + 1, close, max, cur + "(", ans);
		}
		// ")" always after enough "(", close < open can make sure all the results will be matched
		if (close < open) {
			backtrack(open, close + 1, max, cur + ")", ans);
		}
	}
	
	
	// 1 ms, faster than 97.05% 
	
	// Approach : DFS ----- Brute Force with prune
	// TC: O(n!)
	// SC: O(k + 2n)  ---- k solution, 2n recursion
	
	private String cur;
//	public List<String> generateParenthesis(int n) {
//        List<String> ans = new ArrayList<>();
//        cur = "";
//        if (n > 0) {
//        	dfs(n, n, ans);
//        }
//        return ans;
//    }

	// two pointers, l is for '(', r is for ')'
	// 特别注意  'cur' 不能作为 parameter传进去，不同于 c++的引用传递, Java中都是 copy
//	public void dfs(int l, int r, List<String> ans) {
//		// n pairs of (,) has been consumed
//		if (l + r == 0) {
//			ans.add(new String(cur));
//			return;
//		}
//		
//		//!!!! prune. l > r means the generate 'cur' has more ')' than '(', it is definitely will be unmatched 
//		//!!! remove --- avoid unmatched cases ')((())'
//		// r >= l 代表之前消费了l 个'('，之后有更多的 ')'需要。  r < l 代表剩下的 '(' 多于 ')'，‘)’目前消费得多，所以一定是unmatched
//		if (r < l) return;
//		
//		if (l > 0) {
//			cur += "(";
//			dfs(l - 1, r, ans);
//			cur = cur.substring(0, cur.length() - 1);
//		}
//		if (r > 0) {
//			cur += ")";
//			dfs(l, r - 1, ans);
//			cur = cur.substring(0, cur.length() - 1);
//		}
//	}
}
