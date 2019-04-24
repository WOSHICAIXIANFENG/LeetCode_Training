package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCasePermutation_784 {

	public static void main(String[] args) {
		LetterCasePermutation_784 obj = new LetterCasePermutation_784();
		System.out.println("Cai Test = " + obj.letterCasePermutation("a1b2"));
		System.out.println("Cai Test = " + obj.letterCasePermutation("3z4"));
		System.out.println("Cai Test = " + obj.letterCasePermutation("12345"));
	}

	// S will consist only of letters or digits
	
	// 5 ms, faster than 66.59%
	// Approach 1: DFS
	// TC: O(n*2^l) l --- the # of letters ---- each solution takes O(n) time. we have 2^l solutions
	// SC: O(n) recursion depth + O(n*2^l) ---- stack + solutions
	
	// ASCII  A--Z  65 -- 90
	// a -- z: 97 -- 122
	// 'a' - 'A' = 32  ---- 'a' ^ (1 << 5) = 'A'  ----  'A' ^ (1 << 5) = 'a'
	public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        char[] chars = S.toCharArray();
        dfs(chars, 0, ans);
        System.out.println("Cai test after dfs = " + Arrays.toString(chars));
        return ans;
    }
	
	// 优点 --- dfs过程易于理解。缺点最后的 chars 并没有恢复到最初的样子。
	// [a, 1, b, 2] 变成了 [A, 1, B, 2]
	public void dfs2(char[] chars, int s, List<String> ans) {
		if (s == chars.length) {
			ans.add(new String(chars));
			return;
		}
		// for number go to next char then return.
		if (!Character.isLetter(chars[s])) {
			dfs2(chars, s + 1, ans);
			return;
		}
		
		// do lowercase then continue
		chars[s] = Character.toLowerCase(chars[s]);
		dfs2(chars, s + 1, ans);
		// do uppercase then continue
		chars[s] = Character.toUpperCase(chars[s]);
		dfs2(chars, s + 1, ans);
	}
	
	// 算法思想：先变最后面的letter，然后恢复，然后再变前一个letter
	// a1b1 --> a1B ---> a1B1 ---> a1 --> a --- A1b1 ----> A1B --- > A1B1 --> A1 --> a
	public void dfs(char[] s, int i, List<String> ans) {
		if (i == s.length) {
			//System.out.println("Cai Test str = " + new String(s));
			ans.add(new String(s));
			return;
		}
		// go to next char without change case
		dfs(s, i + 1, ans);
		if (!Character.isLetter(s[i])) return;
		// covert to lowercase or uppercase
		s[i] ^= 1 << 5;
		// go to next char with change case
		dfs(s, i + 1, ans);
		// !!! restore the case 
		s[i] ^= 1 << 5;
	}
}
