package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * 
 * Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

 * @author Samuel.Cai
 */
public class IntersectionOfTwoArray_350 {

	public static void main(String[] args) {
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		
		System.out.println("Samuel Test  intersect = " + Arrays.toString(intersect(nums1, nums2)));
	}
	
	public static int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		
		for (int i : nums1) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}
		
		for (int i : nums2) {
			if (map.containsKey(i) && map.get(i) > 0) {
				result.add(i);
				map.put(i, map.get(i) - 1);
			}
		}
		
		int[] temp = new int[result.size()];
		for (int i = 0; i < result.size(); i ++) {
			temp[i] = result.get(i);
		}
		return temp;
    }
	


}
