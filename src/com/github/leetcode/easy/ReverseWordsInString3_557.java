package com.github.leetcode.easy;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 * @author Samuel
 *
 */
public class ReverseWordsInString3_557 {

	public static void main(String[] args) {
		String str = "Let's take LeetCode contest";
		
		System.out.println("Samuel Test t1 = " + reverseString("samuel"));
		System.out.println("Samuel Test result = " + reverseWords(str));
	}
	
	
	public static String reverseWords(String s) {
        return Stream.of(s.split(" ")).map(a -> new StringBuffer(a).reverse().toString()).collect(Collectors.joining(" "));
    }
	
	public static String reverseString(String ss) {
		//Optional<String> result = Stream.of(ss.toCharArray()).map(a -> a + "").reduce((a,b) -> b + a);
		return new StringBuffer(ss).reverse().toString();
	}

}
