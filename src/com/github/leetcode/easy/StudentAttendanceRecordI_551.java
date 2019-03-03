package com.github.leetcode.easy;

public class StudentAttendanceRecordI_551 {

	public static void main(String[] args) {
		System.out.println("Cai Test = " + checkRecord("PPALLP"));
		System.out.println("Cai Test = " + checkRecord("PPALLL"));
		System.out.println("Cai Test = " + checkRecord("LALL")); // !!! should return true
		System.out.println("Cai Test = " + checkRecord("AAAA"));
	}
	
	// 10 ms, faster than 8.21% 
	public static boolean checkRecord(String s) {
		return !s.matches(".*LLL.*|.*A.*A.*");
	}
	
	// 4 ms, faster than 97.18%
	// s.contains() take O(n)
//	public static boolean checkRecord(String s) {
//		return !s.contains("LLL") && s.indexOf('A') == s.lastIndexOf('A');
//	}

//	public static boolean checkRecord(String s) {
//		int indexA = s.indexOf('A');
//		if (indexA != -1 && indexA != s.lastIndexOf('A')) {
//			return false;
//		}
//		
//		int indexL = s.indexOf('L');
//		int indexLLast = s.lastIndexOf('L');
//		if (indexL != -1 && indexL != indexLLast) {
//			int nextIndex = s.indexOf('L', indexL + 1);
//			if (nextIndex != indexLLast) {
//				return false;
//			}
//		}
//		
//        return true;
//    }
}
