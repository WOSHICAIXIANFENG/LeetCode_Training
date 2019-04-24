package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumK_560 {

	public static void main(String[] args) {
		int[] a1 = {1,1,1};
		int[] a2 = {3,4,7,2,-3,1,4,2};
		
		System.out.println("Cai Test subarraySum = " + subarraySum(a1, 2));
		System.out.println("Cai Test subarraySum = " + subarraySum(a2, 7));
	}
	
	// Approach 1: Brute Force + Pre sum --- reduce the TC from O(n^3) to O(n^2)
	// Time Complexity: O(n^2)
	// Space Complexity: O(n) --- dp array
//	public static int subarraySum(int[] nums, int k) {
//		int n = nums.length;
//		int[] sums = new int[n + 1];
//		for (int i = 1; i <= n; i++) {
//			sums[i] = sums[i - 1] + nums[i - 1];
//		}
//		
//		int ans = 0;
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				if (sums[j + 1] - sums[i] == k) {
//					ans++;
//				}
//			}
//		}
//		return ans;
//	}
	
	// 18 ms, faster than 95.50%
	// Approach 2:  Count of Prefix Sum.
	// O(n), the entire nums array is traversed only once
	// space complexity: O(n), Hashmap map can contain upto n distinct enties in the worst case
	// nums[i] + ... + nums[j] = k --- how many?
	// nums[0] + ... + nums[i] = sum - k;
	// nums[0] + ... + .... + nums[j] = sum;
	// sum - k appear one time, k also appear one time.
	// how many sum - k appears === how many sub array sum equals k. 
	public static int subarraySum(int[] nums, int k) {
		int count = 0, sum = 0;
		// counter of pre sum
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);// pre sum == 0, at least appears 1 time.
		for (int i = 0; i < nums.length; i ++) {
			sum += nums[i];
			if (map.containsKey(sum - k))
				count += map.get(sum - k);
			
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
        return count;
    }
}
