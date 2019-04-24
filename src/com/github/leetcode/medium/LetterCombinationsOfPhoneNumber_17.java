package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber_17 {

	public static void main(String[] args) {
		LetterCombinationsOfPhoneNumber_17 obj = new LetterCombinationsOfPhoneNumber_17();
		System.out.println("Cai Test = " + obj.letterCombinations("23"));
		//[ad, ae, af, bd, be, bf, cd, ce, cf]
	}
	
	// 1 ms, faster than 90.72%
	// [ad, bd, cd, ae, be, ce, af, bf, cf]
	// Approach 2: BFS --- BFS
	// TC: O(4^n)
	// SC: O(2 * 4^n) --- ans & nextLayerAns
	public List<String> letterCombinations(String digits) {
		List<String> ans = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return ans;
        
        Map<String, String> phone = new HashMap<String, String>() {{
        	put("0", " ");
        	put("1", "");
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
          }};
        
          // ans is the i layer Ans
          ans.add("");// i = 0, we put ""
          List<String> nextLayerAns;
          for (char digit : digits.toCharArray()) {
        	  nextLayerAns = new ArrayList<>();
        	  for (char ch : phone.get(Character.toString(digit)).toCharArray()) {
        		  // 把当前层的所用 solutions 加到上一层所有的ans上
        		  for (String str : ans) {
        			  nextLayerAns.add(str + ch);
	        	  }
    		  }
        	 
        	  ans = nextLayerAns;
          }
          
          return ans;
	}
	
	// 1 ms, faster than 90.72% 
	// Approach 1: DFS --- Single method version
//	// TC: O(4^n)
//	// SC: O(2 * 4^n)
//	public List<String> letterCombinations(String digits) {
//		List<String> ans = new ArrayList<>();
//        if (digits == null || digits.isEmpty()) return ans;
//        
//        Map<String, String> phone = new HashMap<String, String>() {{
//        	put("0", " ");
//        	put("1", "");
//            put("2", "abc");
//            put("3", "def");
//            put("4", "ghi");
//            put("5", "jkl");
//            put("6", "mno");
//            put("7", "pqrs");
//            put("8", "tuv");
//            put("9", "wxyz");
//          }};
//        
//          // ans is the i layer Ans
//          ans.add("");// i = 0, we put ""
//          List<String> nextLayerAns;
//          for (char digit : digits.toCharArray()) {
//        	  nextLayerAns = new ArrayList<>();
//        	  for (String str : ans) {
//        		  for (char ch : phone.get(Character.toString(digit)).toCharArray()) {
//        			  nextLayerAns.add(str + ch);
//        		  }
//        	  }
//        	  ans = nextLayerAns;
//          }
//          
//          return ans;
//	}

	// 1 ms, faster than 90.72%
	// Approach 1: DFS --- BackTracking
	// TC: O(3^n * 4^m) ---- n is the number of digits which map to 3 letters, m is ... map to 4 letters
	// SC: O(3^n * 4^m) ---- since we have to go throw each node, we have to keep 3^n * 4^m solutions.
//	public List<String> letterCombinations(String digits) {
//        List<String> ans = new ArrayList<>();
//        if (digits == null || digits.isEmpty()) return ans;
//        
//        Map<String, String> phone = new HashMap<String, String>() {{
//        	put("0", " ");
//        	put("1", "");
//            put("2", "abc");
//            put("3", "def");
//            put("4", "ghi");
//            put("5", "jkl");
//            put("6", "mno");
//            put("7", "pqrs");
//            put("8", "tuv");
//            put("9", "wxyz");
//          }};
//        
//          String cur = "";// start from "" to find a path in the char tree
//          dfs(digits, phone, 0, cur, ans);
//        return ans;
//    }
	
	public void dfs(String digits, Map<String, String> phone, int index, String cur, List<String> ans) {
		if (index == digits.length()) {
			ans.add(cur);// the leaf node, add the path into ans
			return;
		}
		
		String letters = phone.get(Character.toString(digits.charAt(index)));
		for (char ch : letters.toCharArray()) {
			dfs(digits, phone, index + 1, cur + ch, ans);
		}
	}
}
