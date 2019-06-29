package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses_93 {

	public static void main(String[] args) {
		// partition problem
		RestoreIPAddresses_93 obj = new RestoreIPAddresses_93();
		System.out.println("Cai Test = " + obj.restoreIpAddresses("25525511135"));
		System.out.println("Cai Test = " + Integer.MAX_VALUE);// 2147483647 --- 10位，所以1.1.1.x ---x 是可以
	
		// Special case  ---- 得出 "010", "01", "001", "00"并不是正确的IP地址段
		System.out.println("Cai Test = " + obj.restoreIpAddresses("010010"));
	}
	
	// 3 ms, faster than 25.77%
	// Approach 1 : DFS ---- each section has [1,3] digits
	// TC: O(2^n) --- at each index, we make a choice to partition or not partition, each index we need to take O(1) to check if it is valid
	// SC: O(1) --- at most 4 recursion depth
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();  
		if (s.length() < 4 || s.length() > 12)
			return res;
		
		dfs(s, 0, "", res);
		return res;
    }
	
	// address Index --- from [0, 3] --- cut the full IP address into 4 parts
	// cur --- current generated IP address
	public void dfs(String s, int index, String cur, List<String> res) {
		if (index == 3 && isValid(s)) {
			res.add(cur + s);
			return;
		}
		for (int i = 0; i < 3 && i < s.length() - 1; i++) {
			String substr = s.substring(0, i + 1);
			if (isValid(substr)) {
				dfs(s.substring(i + 1, s.length()), index + 1, cur + substr + ".", res);
			}
		}
	}
	
	// 2147483647 --- 10位，所以1.1.1.x ---其中x是可以被parse 成int的!
	public boolean isValid(String s) {
		// ignore special cases: "010", "01", "001", "00"
		if (s.startsWith("0")) {
			return s.equals("0");
		}
		int num = Integer.parseInt(s);
		return num <= 255 && num >= 0;
	}
}
