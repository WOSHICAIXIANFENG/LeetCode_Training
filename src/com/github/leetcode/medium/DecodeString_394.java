package com.github.leetcode.medium;

// Two failure Try
public class DecodeString_394 {

	public static void main(String[] args) {
		DecodeString_394 obj = new DecodeString_394();
		String s1 = "3[a]2[bc]";
		String s2 = "3[a2[c]]";
		String s3 = "2[abc]3[cd]ef";
		//System.out.println("Cai Test = " + obj.decodeString(s1));
		//System.out.println("Cai Test = " + obj.decodeString(s2));
		//System.out.println("Cai Test = " + obj.decodeString(s3));
		
		System.out.println("Cai Test = " + obj.decodeString("3[b]")); // 可以测试出 Approach 2 的index 无法带回的问题！
	}
	
	// Approach 2: Recursion
	// TC: 
	// SC: 
	public String decodeString(String s) {
		String temp = s + ']';//!!! make dfs could be return
		return dfs(temp, 0);
	}
	
	// start: from digit or the char after [
	// end: the char after ]
	// e.g --- 3[a]2[bc] --- a]2[bc]
	// !!! 特别注意  int index 并不能将下一段计算后的结果带回，所以我们不得不用 全局变量!!!
	public String dfs(String s, int index) {
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
					String rest = dfs(s, index);
					System.out.println("Cai Test k = " + k + " , rest = " + rest);
					while (k > 0) {
						ans += rest;
						k--;
					}
					System.out.println("Cai Test k = " + k + " , ans = " + ans + " index = " + index);
				} else {
					// char
					ans += s.charAt(index++);
				}
			}
		}
	}

	// 没有解出来！！！
	// Approach 1: Recursion 
	// TC: O(n) --- O(n^2)
	// best case: "3[a]2[b]" --> "3[a]" + "2[b]"
	// worst case: "3[a2[b]]" --> 3 * "[a2[b]]"
	// SC: O(n)
//	public String decodeString(String s) {
//        return decode(s, 0, s.length() - 1);
//    }
	
//	public String decode(String s, int l, int r) {
//		if (!hasDigit(s, l, r)) {
//			return s.substring(l, r);
//		}
//		int b = 0;
//		for (int i = l; i <= r; i++) {
//			// i is letter, i + 1 is digit
//			if (s.charAt(i) == '[') ++b;
//			if (s.charAt(i) == ']') --b;
//			if (b == 0) {
//				// balance is inside
//				return decode(s, l, i + 1) + decode(s, i + 1, r);
//			}
//		}
//		// "3[a2[b]]" --> 3 * [a2[b]] 
//		int leftBrack = s.indexOf("[");
//		int repeat = Integer.parseInt(s.substring(0, leftBrack));
//		String ans = "";
//		while (repeat > 0) {
//			ans += decode(s, leftBrack, r);
//			repeat--;
//		}
//		return ans;
//	}
//	
//	private boolean isDigit(char ch) {
//		return ch >= '0' && ch <= '9';
//	}
//	
//	private boolean isalpha(char ch) {
//		return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'); 
//	}
//	
//	private boolean hasDigit(String s, int from, int to) {
//		if (s == null || from < 0 || to >= s.length()) return false;
//		boolean ans = false;
//		for (int i = from + 1; i < to; i++) {
//			if (isDigit(s.charAt(i))) {
//				return true;
//			}
//		}
//		return ans;
//	}
}
