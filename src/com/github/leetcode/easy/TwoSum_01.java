package com.github.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 * 
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 * @author Samuel
 *
 */
public class TwoSum_01 {

	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int k = 9;
		System.out.println("Samuel Test twoSum = " + Arrays.toString(twoSum(nums, k)));//[0,1]
	}
	
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		// for HashMap --- get() & containsKey() --- O(1) time complexity
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i ++) {
			if (map.containsKey(target - nums[i])) {
				result[1] = i;
				result[0] = map.get(target - nums[i]);
				return result;
			}
			map.put(nums[i], i);
		}
        return result;
    }
}
