package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.management.relation.RoleUnresolved;

/**
 * 
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 * 
 *  Example 1:
 *   Input: ["Hello", "Alaska", "Dad", "Peace"]
 *   Output: ["Alaska", "Dad"]
 *  Note:
 *   You may use one character in the keyboard more than once.
 *   You may assume the input string will only contain letters of alphabet.
 * @author Samuel.Cai
 */
public class KeyboardRow_500 {

	public static void main(String[] args) {
		String[] teStrings = new String[] {"Hello", "Alaska", "Dad", "Peace"};
		
		String[] result = findWords(teStrings);
		
		System.out.println("Samuel Test results = " + result.length);
		System.out.println("Samuel Test results = " + result[0]);
		System.out.println("Samuel Test results = " + result[1]);
		
//		String regex = "[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*";
//		System.out.println("Samuel Test regex1 = " + "Hello".toLowerCase().matches(regex));
//		System.out.println("Samuel Test regex1 = " + "Alaska".toLowerCase().matches(regex));
//		System.out.println("Samuel Test regex1 = " + "Dad".toLowerCase().matches(regex));
//		System.out.println("Samuel Test regex1 = " + "Peace".toLowerCase().matches(regex));
	}
	
	
	public static String[] findWords(String[] words) {
		String[] rows = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"}; 
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < rows.length; i ++) {
			for (char c : rows[i].toCharArray()) {
				map.put(c, i);
			}
		}
		
		List<String> reStrings = new LinkedList<>();
		for (String word : words) {
			if (word.isEmpty()) continue;
			
			int index = map.get(word.toUpperCase().charAt(0));
			for (char c : word.toUpperCase().toCharArray()) {
				if (map.get(c) != index) {
					index = -1;
					break;
				}
			}
			
			if (index != -1) 
				reStrings.add(word);
		}
		
		return reStrings.toArray(new String[0]);
	}
	
	
//	public static String[] findWords(String[] words) {
//		return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
//		
//		String[] result = null;
//		List<String> temp = new ArrayList<>();
//		
//		String row1 = "QWERTYUIOP";
//		String row2 = "ASDFGHJKL";
//		String row3 = "ZXCVBNM";
//		
//		for (String word : words ) {
//			char[] letters = word.toUpperCase().toCharArray();
//			
//			int lastRow = 0;
//			for (char c : letters) {
//				if (lastRow != 0) {
//					if (row1.contains(c + "") && lastRow != 1) {
//						break;
//					} else if (row2.contains(c + "") && lastRow != 2) {
//						break;
//					} else if (row3.contains(c + "") && lastRow != 3) {
//						break;
//					}
//				} else {
//					if (row1.contains(c + "")) {
//						lastRow = 1;
//					} else if (row2.contains(c + "")) {
//						lastRow = 2;
//					} else {
//						lastRow = 3;
//					}
//				}
//			}
//			
//		}
//        return temp.toArray(result);
//    }

}
