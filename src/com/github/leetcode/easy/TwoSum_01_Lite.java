package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
// int[] numbers {-1, 0,1,5}, return true if 2 numbers add to given number
// {-1, 0, 1, 5}, 0 -> true
// {-1, 0, 1, 5}, 3 -> false
// {-1, 0, Integer.Max_Value, 5},

 * @author Samuel.Cai
 */
public class TwoSum_01_Lite {

	public static void main(String[] args) {
		// Test Case ---- all positive numbers
//		int[] nums = {2, 7, 11, 15};
//		int k = 9;
//		System.out.println("Samuel Test twoSum = " + findTwo(nums, k));
		
		// There are some negative numbers in array
		int[] nums = {-1, 0, 1, 5};
		int k1 = 0;
		int k2 = 3;
		
		System.out.println("Samuel Test twoSum = " + findTwo3(nums, k1));
		System.out.println("Samuel Test twoSum = " + findTwo3(nums, k2));
		
		// There are biggest Number in Array.
		int[] nums1 = {Integer.MAX_VALUE - 5, 5, Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1};
		int k3 = Integer.MAX_VALUE;
		System.out.println("Samuel Test Big Number sum = " + (Integer.MAX_VALUE + Integer.MAX_VALUE));
		System.out.println("Samuel Test twoSum = " + findTwo3(nums1, k3));
	}

	// n*O(n) --- solution
	public static boolean findTwo(int[] numbers, int k) {
		// for ArrayList ---- add() & get() is O(1) --- remove() & contains() is O(n)
		// O(n) for space complexity
		List<Integer> data = new ArrayList<>();

		for (int i = 0; i < numbers.length; i ++) {
			if (data.contains(k - numbers[i])) { // time complexity for contains(obj) --- O(n)
				return true;
			}
			data.add(numbers[i]);// O(1)
		}
		return false;
	}
	
	// O(n) --- solution
	public static boolean findTwo2(int[] numbers, int k) {
		// O(n) + O(n) for space complexity
		Map<Integer, Integer> data = new HashMap<>();

		for (int i = 0; i < numbers.length; i ++) {
			if (data.containsKey(k - numbers[i])) { // time complexity for containsKey(obj) --- O(1)
				return true;
			}
			data.put(numbers[i], i);// O(1)
		}
		return false;
	}
	
	// O(nlog(n)) --- solution
	// Special case ---- to solve big number
	public static boolean findTwo3(int[] numbers, int k) {
		if (numbers == null || numbers.length <= 1) {
			return false;
		}
		
		Arrays.sort(numbers);
		System.out.println(" numbers = " + Arrays.toString(numbers));
		int head = 0;
		int last = numbers.length - 1; // because there are some negative number in array. So last Index have to be numbers.length - 1
		
		while (head < last) {	
			// Bug: for Big Number, it will Out Of range to negative number
//			if (numbers[head] + numbers[last] == k) {
//				return true;
//			} else if (numbers[head] + numbers[last] > k) {
//				last --;
//			} else {
//				head ++;
//			}
			
			// !!! --- No Bug!!! --- amazing!!!
			double avg = numbers[head] + (numbers[last] - numbers[head]) / 2.0d;
			if (avg == k / 2d) {
				return true;
			} else if (avg >  k / 2d) {
				last --;
			} else {
				head ++;
			}
		}
		
		return false;
	}
}
