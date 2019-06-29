package com.github.leetcode.easy_top100;

public class AddBinary67_top20 {

	public static void main(String[] args) {
		AddBinary67_top20 obj = new AddBinary67_top20();
		System.out.println("Cai Test addBinary = " + obj.addBinary("11", "1"));
		System.out.println("Cai Test addBinary = " + obj.addBinary("1010", "1011"));
		System.out.println("Cai Test addBinary = " + obj.addBinary("111", "1000"));
		System.out.println("Cai Test addBinary = " + obj.addBinary("101111", "10")); // 110001
	}

	// !!! Key Point ---> try to make b has the same size as a
	// 0000bbb --> aaaaaa
	
	// 1 ms, faster than 99.94%
	// TC: O(max(m,n))
	public String addBinary(String a, String b) {
		if (a.length() < b.length()) return addBinary(b, a);
		final int m = a.length();
		final int n = b.length();
		
		final char[] result = new char[m];
		int carry = 0;
		
		int i = 1;
		while (i <= m) {
			int sum = carry;
			sum += a.charAt(m - i) == '1' ? 1 : 0;
			sum += (i <= n && b.charAt(n - i) == '1') ? 1 : 0;
			// 1+1, 1+c1, c1+1, 1+1+c1 --> put 3,2 ---> carry 1
			carry = (sum & 2) == 2 ? 1 : 0;
			// ---> take 1
			result[m - i] = (sum & 1) == 1 ? '1' : '0';
			i++;
		}
		
		return carry == 1 ? "1" + new String(result) : new String(result);
	}
}
