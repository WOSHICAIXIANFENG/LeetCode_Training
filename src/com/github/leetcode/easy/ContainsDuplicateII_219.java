package com.github.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers and an integer k, 
 * find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] 
 * and the absolute difference between i and j is at most k.
 * @author Samuel
 *
 */
public class ContainsDuplicateII_219 {

	public static void main(String[] args) {
		int[] nums1 = {1,2,3,4,5,6,7,2};
		int[] nums2 = {3,2,8,7,3,1,4,5,6};
		int k1 = 6;
		int k2 = 3;
		System.out.println("Samuel Test containsNearbyDuplicate = " + containsNearbyDuplicate(nums1, k1));
		System.out.println("Samuel Test containsNearbyDuplicate = " + containsNearbyDuplicate(nums2, k2));

	}
	
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> data = new HashSet<>();
        for (int i = 0; i < nums.length; i ++) {
        	if (i > k) {
        		data.remove(nums[i - k - 1]);
        	}
        	if (!data.add(nums[i])) {
        		return true;
        	}
        }
        
        return false;
    }

}
