package com.github.leetcode.medium;

// Two failure Try
public class DecodeString_394_final {

	public static void main(String[] args) {
		DecodeString_394_final obj = new DecodeString_394_final();
		String s1 = "3[a]2[bc]";
		String s2 = "3[a2[c]]";
		String s3 = "2[abc]3[cd]ef";
		System.out.println("Cai Test = " + obj.decodeString(s1));
		System.out.println("Cai Test = " + obj.decodeString(s2));
		System.out.println("Cai Test = " + obj.decodeString(s3));
		
		System.out.println("Cai Test = " + obj.decodeString("3[b]")); // 可以测试出 Approach 2 的index 无法带回的问题！
	}
	
	 // idea --- scan the string from left to right, start from digit or the char after '[' end until meet ']'
	//  0 ms, faster than 100.00%
	
	// String.charAt(index) ---- TC: O(1)
	// Approach : Recursion
	// TC: O(n)
	// SC: O(n)
	
	private int index;
	public String decodeString(String s) {
		String temp = s + ']';//!!! make dfs could be return
		index = 0;
		return dfs(temp);
	}
	
	// start: from digit or the char after [
	// end: the char after ]
	// e.g --- 3[a]2[bc] --- a]2[bc]
	public String dfs(String s) {
		String ans = "";
		while (true) {
			if (s.charAt(index) == ']') {
				index++;
				return ans;
			} else {
				if (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
					// extract number k
					int k = 0;
					while (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
						k = k * 10 + s.charAt(index++) - '0';
					}
					index++;//skip '['
					String rest = dfs(s);
					//System.out.println("Cai Test k = " + k + " , rest = " + rest);
					while (k > 0) {
						ans += rest;
						k--;
					}
					//System.out.println("Cai Test k = " + k + " , ans = " + ans + " index = " + index);
				} else {
					// char
					ans += s.charAt(index++);
				}
			}
		}
	}
}
