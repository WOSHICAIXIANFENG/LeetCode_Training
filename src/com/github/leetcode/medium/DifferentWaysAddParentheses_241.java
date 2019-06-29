package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaysAddParentheses_241 {

	public static void main(String[] args) {
		// partition problem 
		DifferentWaysAddParentheses_241 obj = new DifferentWaysAddParentheses_241();
		System.out.println("Cai Test = " + obj.diffWaysToCompute("2-1-1"));
		System.out.println("Cai Test = " + obj.diffWaysToCompute("2*3-4*5"));
	}

	// idea ---> ways("2*3-4*5") = 
	// ways("2") Xop ways("3-4*5") 
	//  U  ways("2*3") Xop ways("4*5")
	//  U  ways("2*3-4*) Xop ways("5")
	
	// 3 ms, faster than 37.86% 
	// Approach : Recusion ---
	// TC: ???
	// SC: 
	public List<Integer> diffWaysToCompute(String input) {
		// Memorized !!!
		Map<String, List<Integer>> map = new HashMap<>();
        return ways(input, map);
    }
	
	public List<Integer> ways(String input, Map<String, List<Integer>> map) {
		// some partitions are the same, so cache can help us speed up
		if (map.containsKey(input)) return map.get(input);
		
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			char op = input.charAt(i);
			// Split the input by an op
			if (op == '+' || op == '-' || op == '*') {
				String left = input.substring(0, i);
				String right = input.substring(i + 1);
				List<Integer> leftAns = ways(left, map);
				List<Integer> rightAns = ways(right, map);
				
				//  Combine the solution --- 求笛卡尔积
				for (int a : leftAns) 
					for (int b : rightAns)
						ans.add(calculate(a, b, op));
			}
		}
		
		// single number, e.g. s = "3"
		if (ans.isEmpty()) {
			ans.add(Integer.parseInt(input));
		}
		
		// memorize the answer for input
		map.put(input, ans);
		return ans;
	}
	
	public int calculate(int a, int b, char op) {
		switch (op) {
		case '*': return a * b;
		case '-': return a - b;
		case '+': return a + b;
		}
		return 0;
	}
}
