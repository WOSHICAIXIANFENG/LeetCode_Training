package com.github.leetcode.medium;

import java.util.HashMap;

public class SubarraySumK_560 {

	public static void main(String[] args) {
		int[] a1 = {1,1,1};
		int[] a2 = {3,4,7,2,-3,1,4,2};
		
		System.out.println("Cai Test subarraySum = " + subarraySum(a1, 2));
		System.out.println("Cai Test subarraySum = " + subarraySum(a2, 7));
	}
	
	// 18 ms, faster than 95.50%
	// O(n), the entire nums array is traversed only once
	// space complexity: O(n), Hashmap map can contain upto n distinct enties in the worst case
	public static int subarraySum(int[] nums, int k) {
		int count = 0, sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int i = 0; i < nums.length; i ++) {
			sum += nums[i];
			if (map.containsKey(sum - k))
				count += map.get(sum - k);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
        return count;
    }

}
