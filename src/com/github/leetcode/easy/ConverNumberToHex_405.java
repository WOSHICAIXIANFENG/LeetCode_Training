package com.github.leetcode.easy;

public class ConverNumberToHex_405 {

	public static void main(String[] args) {
		System.out.println("Cai Test toHex = " + Integer.toString(15, 2));
		System.out.println("Cai Test toHex = " + Integer.toString(15, 8));
		System.out.println("Cai Test toHex = " + Integer.toString(15, 16));
		System.out.println("Cai Test test = " + 0xf);
		System.out.println("Cai Test test = " + 0x0f);
		System.out.println("Cai Test test = " + 0xf0);
		System.out.println("Cai Test toHex = " + toHex(0));
		System.out.println("Cai Test toHex = " + toHex(10));
		// 26 --- 16 + 8 + 2 ---  0000 0000 0000 0000 0000 0000 0001 1010
		System.out.println("Cai Test toHex = " + toHex(26));
		System.out.println("Cai Test 6666 toHex = " + toHex(-1));// need to use >>>
	}
	
	// 3 ms, faster than 100.00%
	// Better solution --- avoid '+' add Strings
	private static char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
	public static String toHex(int num) {
		if (num == 0) return "0";
		StringBuilder sb = new StringBuilder();
		while (num != 0) {
			sb.append(map[num & 0xf]);
			num >>>=4;
		}
		return sb.reverse().toString();
	}

//	private static String hexStr =  "0123456789abcdef"; 
//	// 4 ms, faster than 75.76%
//	public static String toHex(int num) {
//        if (num == 0) {
//        	return "0";
//        }
//        String result = "";
//        while (num != 0) { // !!! num could be negative number, so, here is num != 0
//        	// num & 15, num & 1111 
//        	result = hexStr.charAt(num & 0xf) + result;
//        	num >>>= 4; // use Unsigned right shift >>> to add 0 in the start 
//        }
//        return result;
//    }
}
