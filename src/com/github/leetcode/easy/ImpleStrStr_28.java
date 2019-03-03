package com.github.leetcode.easy;

public class ImpleStrStr_28 {

	public static void main(String[] args) {
		System.out.println("Cai Test strStr = " + strStr("hello", "ll"));//2
		System.out.println("Cai Test strStr = " + strStr("aaaaa", "ll"));//-1
		System.out.println("Cai Test strStr = " + strStr("aaaab", "b"));//4
		System.out.println("Cai Test strStr = " + strStr("aaaab", "bb"));//-1
		System.out.println("Cai Test strStr = " + strStr("Mississippi", "issip"));//4
	}
	
//	// 16 ms, faster than 17.41% 
//	// not using indexOf & subString() APIs
//	public static int strStr(String haystack, String needle) {
//		if (needle == null || haystack == null) {
//			return -1;
//		}
//		
//		if (needle.isEmpty()) {
//			return 0;
//		}
//		
//		int firstOccu = -1;
//		int startIndex = 0;
//		for (int i = 0; i < needle.length(); i ++) {
//			char currentChar = needle.charAt(i);
//			
//			//System.out.println("Cai Test startIndex = " + startIndex + " , currentChar = " + currentChar + " , i = " + i);
//			// haystack searching end, but needle still has chars remain
//			if (startIndex == haystack.length()) {
//				return -1;
//			}
//			
//			for (int j = startIndex; j < haystack.length(); j ++) {
//				// find currentChar, continue to find next char
//				if (haystack.charAt(j) == currentChar) {
//					if (firstOccu == -1) {
//						firstOccu = j;
//						//System.out.println("Cai Test firstOccu = " + firstOccu + ", j = " + j);
//					}
//					
//					startIndex = j + 1;// !!! not j++;
//					//System.out.println("Cai Test firstOccu = " + firstOccu + ", j = " + j + " , startIndex = " + startIndex);
//					break;
//				} else if (firstOccu != -1) {
//					// reset to find next 
//					startIndex = firstOccu + 1;
//					firstOccu = -1;
//					i = -1;
//					break;
//				}
//				
//				// the last char still can't find current char
//				if (j == haystack.length() - 1) {
//					return -1;// no occurrence
//				}
//			}
//		}
//		
//        return firstOccu;
//    }
	
	// 5 ms, faster than 99.06%
	public static int strStr(String haystack, String needle) {
		if (needle == null || haystack == null) {
			return -1;
		}
		
		if (needle.isEmpty()) {
			return 0;
		}
		
		int startIndex = 0;
		for (int i = 0; i < needle.length(); i ++) {
			char currentChar = needle.charAt(i);
			
			int indexOcur = haystack.indexOf(currentChar, startIndex);
			if (indexOcur == - 1) {
				return -1;
			}
			
			if (indexOcur + needle.length() <= haystack.length()) {
				String subStr = haystack.substring(indexOcur, indexOcur + needle.length());
				if (needle.equals(subStr)) {
					return indexOcur;
				} else {
					startIndex = indexOcur + 1;
					i = -1;
				}
			} else {
				return -1;
			}
		}
		
        return -1;
    }

}
