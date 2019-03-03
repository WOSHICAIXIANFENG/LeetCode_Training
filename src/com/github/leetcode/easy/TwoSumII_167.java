package com.github.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**

Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution and you may not use the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

 * @author Samuel
 *
 */
public class TwoSumII_167 {

	public static void main(String[] args) {
		// negative numbers contains
		int[] nums = {2,7,11,15}; // already sorted in ascending order
		int target = 9;
		
		// output [1,2]
		System.out.println("Samuel Test twoSum = " + Arrays.toString(twoSum2(nums, target))); 
		
		int[] numsBig = {3, Integer.MAX_VALUE - 3,Integer.MAX_VALUE - 2,Integer.MAX_VALUE - 1};
		int targetBig = Integer.MAX_VALUE;
		System.out.println("Samuel Test twoSum = " + Arrays.toString(twoSum(numsBig, targetBig))); 
		System.out.println("Samuel Test twoSum = " + Arrays.toString(twoSum2(numsBig, targetBig))); 
	}

	// O(n) solution
	public static int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		// for HashMap --- get() and containsKey() method --- time complexity O(1)
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numbers.length; i ++) {
			if (map.containsKey(target - numbers[i])) {
				result[1] = i + 1;
				result[0] = map.get(target - numbers[i]);
			}
			map.put(numbers[i], i + 1);
		}
        return result;
    }
	
	// O(n) solution2 by two pointers
	public static int[] twoSum2(int[] numbers, int target) {
		int[] result = new int[2];
		// because numbers is sorted, so we can use two pointers solution
		int head = 0;
		int last = numbers.length - 1;
		while (head < last) {
			double avg = numbers[head] + (numbers[last] - numbers[head])/2d;
			if (avg == target/2d) {
				result[1] = last + 1;
				result[0] = head + 1;
				return result;
			} else if (avg > target/2d) {
				last --;
			} else {
				head ++;
			}
		}
		
        return result;
    }
}
