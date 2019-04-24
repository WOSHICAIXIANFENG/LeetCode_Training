package com.github.leetcode.hard;

import java.util.Arrays;

public class FindKthSmallestPairDistance_719 {

	public static void main(String[] args) {
		int[] a1 = {1, 3, 1};
		System.out.println("Cai Test = " + smallestDistancePair(a1, 1));// 0
		
		int[] a2 = {1, 6, 1};
		System.out.println("Cai Test = " + smallestDistancePair(a2, 3));// 5
	}

	// 5 ms, faster than 100.00% 
	// Approach 2: Binary Search
	// For distance m, find at lest k pairs
	// Binary search m, compute # of pairs whose distances are <= m in O(n) using DP
	// dp[i] = # of pairs whose distances are <= m. 
	// dp[i] = dp[i-1] + (j - i - 1); j is the smallest index that nums[j] - nums[i] >= m
	
	// Time Complexity: 
	// sorting nlogN.  binary search O(logMax(nums)) --- each time consume another O(n) to compute # of pairs
	// O(nlog(max(n, nums))) = O(nlogN)
	// Space complexity: O(1)
	public static int smallestDistancePair(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		
		Arrays.sort(nums);
		int len = nums.length;
		int low = 0;
		int high = nums[len - 1] - nums[0];
		while (low <= high) {
			int mid = low + (high - low) / 2;
			// compute how many pairs that distance <= m
			// !!!! ---- here! we have to avoid O(n^2) time consume
			int count = 0;
			int j = 0;// j must start from 0
			for (int i = 0; i < len; i++) {
				// find j -- j is the biggest index that nums[j] <= nums[i]
				while (j < len - 1 && nums[j + 1] - nums[i] <= mid) {
					++j;
				}
				count += (j - i); // you have to make sure count value is correct when you initial j = 0
			}
			
			System.out.println(" M1 = " + mid + " ,count = " + count);
			// as 1 <= k <= len(nums) * (len(nums) - 1) / 2.
			// !!! '>=' not '>' !!!
			// '>' 是错误的 [1,3,1],1 --> 2 wrong. 因为你返回的是low，如果将== case放到 low = mid + 1; low 最终会 low > high
			if (count >= k) {
				high = mid - 1;
			} else {
				//System.out.println(" low = " + low + " , mid = " + mid + " , high = " + high);
				low = mid + 1;
			}
			
//			// 这也是错误的，错误分析，因为mid 可能是一个并不存在的distance!!!
//			// [1,3,1],1 ---> 1 distance 1 是不存在的!!!
//			if (count == k) {
//				return mid;
//			} else if (count > k) {
//				high = mid - 1;
//			} else {
//				//System.out.println(" low = " + low + " , mid = " + mid + " , high = " + high);
//				low = mid + 1;
//			}
		}
		
		return low;
	}
	
	// 425 ms, faster than 17.85%
	
	// n*(n-1)/2 pairs
	// Approach 1: Brute Force/ bucket sorting
	// Time Complexity: O(n^2)
	// Space Complexity: O(Max(nums))
//	public static int smallestDistancePair(int[] nums, int k) {
//		if (nums == null || nums.length == 0) {
//			return -1;
//		}
//		
//		// step1: sorted
//		Arrays.sort(nums);
//		
//		int len = nums.length;
//		int[] counter = new int[nums[len - 1] - nums[0] + 1];//!!!Dont forget '+1'
//		// step2: compute the freq of all pair distance 
//		for (int i = 0; i < len; i++) {
//			for (int j = i + 1; j < len; j++) {
//				//System.out.println("Cai test i = " + i + " , j = " + j);
//				counter[nums[j] - nums[i]]++;
//			}
//		}
//		
//		// step3: find kth samllest distance
//		for (int i = 0; i < counter.length; i++) {
//			k -= counter[i];
//			if (k <= 0) {
//				return i;
//			}
//		}
//        return -1;
//    }
}
