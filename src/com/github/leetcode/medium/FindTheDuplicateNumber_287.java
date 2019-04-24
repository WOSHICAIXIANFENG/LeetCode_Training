package com.github.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateNumber_287 {

	public static void main(String[] args) {
		int[] a1 = {1,3,4,2,2};
		int[] a2 = {3,1,3,4,2};
		System.out.println("Cai Test = " + findDuplicate(a1));//2
		System.out.println("Cai Test = " + findDuplicate(a2));//3
	}
	
	// rule1: nums is only readable.
	// rule2: space complexity must be O(1)
	// rule3: nums is not sorted.
	// 0 ms, faster than 100.00%
	// 答案来源于： https://leetcode.com/articles/find-the-duplicate-number/
	// Approach 3: Floyd's Tortoise and Hare (Cycle Detection)
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	public static int findDuplicate(int[] nums) {
		// [1,4,5,4,2,3] ----> slow = 3, fast = 3
		// Find the intersection point of the two runners.
		int tortoise = nums[0];
		int hare = nums[0];
		do {
			tortoise = nums[tortoise];
			hare = nums[nums[hare]];
		} while (tortoise != hare);
		
		// Find the 'entrance' to the cycle
		int p1 = nums[0];
		int p2 = tortoise;
		while (p1 != p2) {
			p1 = nums[p1];
			p2 = nums[p2];
		}
		return p1;
	}

	// array is not sorted
	// Approach 1: Sorting.
	// Time Complexity: O(nlgn)
	// Space Complexity: O(1) or O(n). if we cannot modify the input array, then we must allocate linear space for a copy of nums
//	public static int findDuplicate(int[] nums) {
//		Arrays.sort(nums);
//		for (int i = 1; i < nums.length; i++) {
//			if (nums[i] == nums[i - 1]) {
//				return nums[i];
//			}
//		}
//	    return -1;
//	}
	
	// Approach 2: Set
	// Time Complexity: O(n) -- Set in both Python and Java rely on underlying has tables. So insertion and lookup have 
	// amortized constant time complexities. Since it consists of a for loop, so O(n)
	// Space Complexity: O(n)
//	public static int findDuplicate(int[] nums) {
//		Set<Integer> seen = new HashSet<>();
//		for (int num : nums) {
//			if (seen.contains(num)) {
//				return num;
//			}
//			seen.add(num);
//		}
//		return -1;
//	}
}
