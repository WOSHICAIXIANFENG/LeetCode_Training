package com.github.leetcode.easy;

/**

Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

 * @author Samuel
 */
public class AddBinary_67 {

	public static void main(String[] args) {
		System.out.println("Cai Test addBinary = " + addBinary("11", "1"));
		System.out.println("Cai Test addBinary = " + addBinary("1010", "1011"));
		System.out.println("Cai Test addBinary = " + addBinary("111", "1000"));
		System.out.println("Cai Test addBinary = " + addBinary("101111", "10")); // 0001
	}
	
	// 3 ms, faster than 93.10%
	public static String addBinary(String a, String b) {
		if (a.length() < b.length())  return addBinary(b, a);
		
		int i = 1;
		int carry = 0;
		int aLen = a.length(); 
		int bLen = b.length();
		char[] result = new char[aLen];
		while (i <= aLen) {
			int sum = carry;
			sum += a.charAt(aLen - i) == '1' ? 1 : 0;
			sum += (i <= bLen && b.charAt(bLen - i) == '1') ? 1 : 0;
			carry = (sum & 2) == 2 ? 1 : 0;
			result[aLen - i] = (sum & 1) == 1 ? '1' : '0';
			i ++;
		}
		
		return carry == 1 ? "1" + new String(result) : new String(result);
	}
	
	
//	// 4 ms, faster than 63.57%
//	public static String addBinary(String a, String b) {
//		if (a == null || b == null) {
//			return null;
//		}
//
//		String result = "";
//		boolean hasCarry = false;
//		int aLength = a.length();
//		int bLength = b.length();
//		int length = aLength > bLength ? bLength : aLength;
//		for (int i = 0; i < length; i ++) {
//			if (a.charAt(aLength - 1 - i) == '1' && b.charAt(bLength - 1 - i) == '1') {
//				result = (hasCarry ? "1" : "0") + result;
//				hasCarry = true;
//			} else if (a.charAt(aLength - 1 - i) == '0' && b.charAt(bLength - 1 - i) == '0') {
//				result = (hasCarry ? "1" : "0") + result;
//				hasCarry = false;
//			} else {
//				result = (hasCarry ? "0" : "1") + result;
//			}
//		}
//		
//		// if two arrays have the same length, check hasCarray
//		String longerStr = aLength > bLength ? a: b;
//		if (longerStr != null) {
//			for (int i = longerStr.length() - 1 - length; i >= 0; i --) {
//				if (longerStr.charAt(i) == '1') {
//					result = (hasCarry ? "0" : "1") + result;
//				} else {
//					result = (hasCarry ? "1" : "0") + result;
//					hasCarry = false;
//				}
//			}
//		}
//	
//		result = hasCarry ? "1" + result : result;
//        return result;
//    }

}
