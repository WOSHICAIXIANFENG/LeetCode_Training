package com.samuel.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		String s1 = "loveleetcode";
		String s2 = "tree";
		String s3 = "cccaaa";
		System.out.println("Samuel test result = " + frequencySort(s1));
		System.out.println("Samuel test result = " + frequencySort(s2));
		System.out.println("Samuel test result = " + frequencySort(s3));
	}
	
	public static String frequencySort(String s) {
		if (s == null || s.length() == 0) return s;
	    Map<Character, Integer> map = new HashMap<>();
	    
	    Character[] ch = new Character[s.length()];
	    for (int i = 0; i < s.length(); i++) {
	    	char c = s.charAt(i);
	        ch[i] = c;
	        map.put(c, map.getOrDefault(c, 0) + 1);
	    }
	    
	    //Arrays.sort(ch, Comparator.comparingInt(a -> -1*map.get(a)));
	    //return Arrays.toString(ch);
	    
//	    Arrays.sort(ch, new Comparator<Character>(){
//
//			@Override
//			public int compare(Character o1, Character o2) {
//				if (map.get(o1) == map.get(o2)) {
//					return o1.compareTo(o2);
//				} else {
//					return map.get(o2).compareTo(map.get(o1));
//				}
//			}
//	    });
	    
	    Arrays.sort(ch, Comparator.comparing(a -> -1*map.get(a)).thenComparing(a -> (char)a));
	    StringBuilder sb = new StringBuilder();
	    Arrays.stream(ch).forEach(c -> sb.append(c));
	    return sb.toString();
	}

}
