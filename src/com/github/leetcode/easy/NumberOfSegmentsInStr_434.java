package com.github.leetcode.easy;

public class NumberOfSegmentsInStr_434 {

	public static void main(String[] args) {
		System.out.println("Cai Test = " + countSegments(" I do like you, xxx"));

	}
	
	// Approach #2 Using Language Builtins
	// Time is O(n), Space is O(1)
	public static int countSegments(String s) {
		 int segmentCount = 0;
		 for (int i = 0; i < s.toCharArray().length; i++) {
			 if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
				 segmentCount++;
			 }
		 }
		 return segmentCount;
	}

	// Time Complexity: O(n) 
	// All builtin language functionality used here runs in either O(n) or O(1) time, so the entire algorithm runs in linear time
	// Space Complexity: O(1)
	// split() return an array/list of O(n) length
	
//	// Approach #1 Using Language Builtins
//	public static int countSegments(String s) {
//		// since "".split("\\s+").length is 1.
//		String trimmed = s.trim();
//		if ("".equals(trimmed)) {
//			return 0;
//		}
//		// \s stands for "whitespace character". Again, which characters this actually includes, depends on the regex flavor. In all flavors discussed in this tutorial, it includes [ \t\r\n\f]. 
//		// That is: \s matches a space, a tab, a line break, or a form feed.
//		// \s 匹配任何空白字符，包括空格、制表符、换页符等等。等价于 [ \f\n\r\t\v]。注意 Unicode 正则表达式会匹配全角空格符。
//		// + 匹配前面的子表达式一次或多次。要匹配 + 字符。
//        return trimmed.split("\\s+").length;
//    }
}
