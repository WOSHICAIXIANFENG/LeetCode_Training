package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FizzBuzz_415 {

	public static void main(String[] args) {
		System.out.println("Cai Test fizzBuzz = " + fizzBuzz(105));
	}
	
	// 2 ms, faster than 89.46% 
	// question1:  has more maps ---> 
	/**
	 *  Divisible by 3
		Divisible by 5
		Divisible by 7
		Divisible by 3 and 5
		Divisible by 3 and 7
		Divisible by 7 and 3
		Divisible by 3 and 5 and 7
		Not divisible by 3 or 5 or 7.	
	 */
	// 3 ---> "Fizz" , 5 ---> "Buzz", 7 ---> "Jazz"
//	public static List<String> fizzBuzz(int n) {
//		List<String> result = new ArrayList<>();
//		for (int i = 1; i <= n; i ++) {
//			String ansStr = "";
//			boolean divideBy3 = i % 3 == 0;
//			boolean divideBy5 = i % 5 == 0;
//			if (divideBy3) {
//				ansStr += "Fizz";
//			}
//			if (divideBy5) {
//				ansStr += "Buzz";
//			}
//			
//			if ("".equals(ansStr)) {
//				result.add(Integer.toString(i));
//			} else {
//				result.add(ansStr);
//			}
//		}
//		return result;
//	}
	
	// question2:  Having a condition for every mapping is not feasible or may be we can say the code might get ugly and tough to maintain.
	// too many conditions
	// Approach 3: Hash it!
	// todo!
	
	public static List<String> fizzBuzz(int n) {
	    List<String> result = new ArrayList<String>();

	    // Hash map to store all fizzbuzz mappings.
	    Map<Integer, String> fizzBizzDict = new HashMap<>();
	    fizzBizzDict.put(7, "Jzzz");
	    fizzBizzDict.put(5, "Buzz");
	    fizzBizzDict.put(3, "Fizz");
	    
	    
	    for (int num = 1; num <= n; num++) {
	    	String ansStr = "";
	    	for (int key : fizzBizzDict.keySet()) { // by default the key set is sorted
	    		if (num % key == 0) {
	    			ansStr += fizzBizzDict.get(key);
	    		}
	    	}
	    	
	    	if (ansStr.isEmpty()) {
	    		result.add(Integer.toString(num));
	    	} else {
	    		result.add(ansStr);
	    	}
	    }
	    return result;
	}
	

	// 2 ms, faster than 89.46%
//	public static List<String> fizzBuzz(int n) {
//		List<String> result = new ArrayList<>();
//		for (int i = 1; i <= n; i ++) {
//			if (i % 15 == 0) {
//				result.add("FizzBuzz");
//			} else if (i % 5 == 0) {
//				result.add("Buzz");
//			} else if (i % 3 == 0) {
//				result.add("Fizz");
//			} else {
//				result.add(String.valueOf(i));
//			}
//		}
//		return result;
//    }
}
