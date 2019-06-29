package com.github.leetcode.easy_top100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum_top1 {

	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int k = 9;
		System.out.println("Samuel Test twoSum = " + Arrays.toString(twoSum(nums, k)));//[0,1]
	}
	
	// 3 ms, faster than 62.50%
	// Approach 1: HashMap
	// TC: O(N)
	// SC: O(1)
	public static int[] twoSum(int[] nums, int target) {
		// value --> index
		Map<Integer, Integer> hashMap = new HashMap<>();
		// define ans
		int[] ans = new int[2];
		final int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (hashMap.containsKey(target - nums[i])) {
				ans[0] = hashMap.get(target - nums[i]);
				ans[1] = i;
			} else {
				hashMap.put(nums[i], i);
			}
		}
		return ans;
	}

}
