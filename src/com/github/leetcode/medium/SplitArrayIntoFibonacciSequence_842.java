package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayIntoFibonacciSequence_842 {

	public static void main(String[] args) {
		SplitArrayIntoFibonacciSequence_842 obj = new SplitArrayIntoFibonacciSequence_842();
		System.out.println("Cai Test = " + obj.splitIntoFibonacci("123456579"));
		System.out.println("Cai Test = " + obj.splitIntoFibonacci("11235813"));
		System.out.println("Cai Test = " + obj.splitIntoFibonacci("112358130"));
		System.out.println("Cai Test = " + obj.splitIntoFibonacci("1101111"));
		
		// test max length of Integer
		System.out.println("Cai Test max int = " + Integer.MAX_VALUE);// 2147483647 -- max size is 10
		// !!!! --- 处理大数相加 
		System.out.println("Cai Test max long = " + (2147483647l + 2147483646l));
	}
	
	// 1 ms, faster than 100.00%
	
	// Approach 1: DFS/Backtracking/ Partition
	// TC: O(2^n) ---- combination problem
	// SC: O(n)
	public List<Integer> splitIntoFibonacci(String S) {
		List<Integer> ans = new ArrayList<>();
		if (S == null || S.isEmpty()) return ans;
		
		dfs(S, 0, ans);
        return ans;
    }
	
	// Find one ans is enough
	public boolean dfs(String s, int start, List<Integer> ans) {
		if (start == s.length()) {
			return ans.size() > 2;// at lest 3 nums make a Fabonacci sequence
		}
		
		// !!! Prune
		int max_len = s.charAt(start) == '0' ? 1 : 10;// 10 is the max integer length
		long num = 0;// use long to avoid out of integer range 
		
		// try to extract the Fibonacci num from start index
		for (int i = start; i < Math.min(start + max_len, s.length()); i++) {
			num = num * 10 + (s.charAt(i) - '0');
			if (num > Integer.MAX_VALUE) {
				break;
			}
			if (ans.size() >= 2) {
				// !!! you have to cast to long first, then do plus operation
				long twoSum = (long) ans.get(ans.size() - 1) + (long) ans.get(ans.size() - 2);
				if (twoSum < num) {
					break;
				}
				if (twoSum > num) {
					continue;
				}
			}
			
			// size() < 2 or num is Fibonacci num
			ans.add((int) num);
			// calculate next Fibonacci number
			if (dfs(s, i + 1, ans)) return true;
			// !!! backtracking
			ans.remove(ans.size() - 1); 
		}
		
		return false;
	}
	
}
