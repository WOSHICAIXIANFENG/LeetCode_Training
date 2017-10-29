package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * 
 * Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.

 * @author Samuel
 *
 */
public class IntersectionOfTwoArrays_349 {

	public static void main(String[] args) {
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2,1};
		
		System.out.println("Samuel Test  intersect = " + Arrays.toString(intersection(nums1, nums2)));

	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<>();
		List<Integer> result = new ArrayList<>();
		
		for (int i : nums1) {
			set1.add(i);
		}
		
		for (int i : nums2) {
			if (set1.contains(i)) {
				result.add(i);
				set1.remove(i);
			}
		}
		
		int[] results = new int[result.size()];
		for (int i = 0; i < result.size(); i ++) {
			results[i] = result.get(i);
		}
		return results;
	}
}
