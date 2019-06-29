package com.github.leetcode.easy_top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays349_top46 {

	public static void main(String[] args) {
		IntersectionOfTwoArrays349_top46 obj = new IntersectionOfTwoArrays349_top46();
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2,1};
		
		System.out.println("Samuel Test  intersect = " + Arrays.toString(obj.intersection(nums1, nums2)));
	}
	
	// 2 ms, faster than 98.19%
	// follow up: Can you do it with O(1) space consume?
	// Then they ask you to solve it under these constraints:
	// O(n) time and O(1) space (the resulting array of intersections is not taken into consideration).
	// You are told the lists are sorted.
	
	// 1 ms, faster than 99.85%
	// TC: O(nlogN) + O(m + n)
	// SC: O(1)
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) 
			return new int[] {};
		
		// step1: sort the arrays
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		int[] tmp = new int[nums1.length];
		// step2: use two pointers to traverse all elements
		int p1 = 0; 
		int p2 = 0;
		// count the # of intersections
		int k = 0;
		while (p1 < nums1.length && p2 < nums2.length) {
			if (nums1[p1] == nums2[p2]) {
				if (k == 0 || tmp[k - 1] != nums1[p1]) {
					tmp[k++] = nums1[p1];
				}
				p1++;
				p2++;
			} else if (nums1[p1] > nums2[p2]) {
				p2++;
			} else {
				p1++;
			}
		}
		
		
		int[] ans = new int[k];
        for(int l = 0; l < k; l++){
        	ans[l] = tmp[l];
        }
        
        return ans;
	}
	
	// My solution ---- could be more clean/simplify
	public int[] intersection3(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) 
			return new int[] {};
		
		// step1: sort the arrays
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		// use double pointers to avoid using extra space --- no hashSet
		List<Integer> inters = new ArrayList<>();
		int pl = 0; int pr = 0;
		while (pl < nums1.length && pr < nums2.length) {
			int l1 = nums1[pl];
			int l2 = nums2[pr];
			if (l1 == l2) {
				inters.add(l1);
				// skip same elements 
				while (pl < nums1.length && l1 == nums1[pl])
					pl++;
				while (pr < nums2.length && l2 == nums2[pr])
					pr++;
				continue;
			} else if (l1 > l2) {
				while (pr < nums2.length && l2 == nums2[pr])
					pr++;
			} else {
				while (pl < nums1.length && l1 == nums1[pl])
					pl++;
			}
		}
		
		// define ans
		int[] ans = new int[inters.size()];
		int i = 0;
		for (int inter : inters) {
			ans[i++] = inter;
		}
		return ans;
	}

	// 2 ms, faster than 98.13% 
	// Approach 1: Two Set
	// TC: O(n + m)
	// SC: O(n + m)
	public int[] intersection2(int[] nums1, int[] nums2) {
		Set<Integer> hashSet = new HashSet<>();
		for (int num : nums1) {
			hashSet.add(num);
		}
		
		Set<Integer> results = new HashSet<>();
		for (int num : nums2) {
			if (hashSet.contains(num)) {
				results.add(num);
			}
		}
		
		int[] ans = new int[results.size()];
		int i = 0;
		for (int inter : results) {
			ans[i++] = inter;
		}
		return ans;
	}
}
