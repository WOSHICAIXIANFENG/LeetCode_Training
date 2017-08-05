package com.github.leetcode.easy;

/**
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. 
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. 
 * If it does not exist, output -1 for this number.
 * Note:
 *  All elements in nums1 and nums2 are unique.
 *  The length of both nums1 and nums2 would not exceed 1000.
 *  
 * @author Samuel
 */
public class NextGreaterElement_496 {

	public static void main(String[] args) {
		int[] nums1 = new int[] {2,4};
		int[] nums2 = {1,2, 3,4};
		
		
		int[] result = nextGreaterElement(nums1, nums2);
		System.out.print("Samuel Test result = [");
		for (int re : result) {
			System.out.print(re + ",");
		}
		System.out.println("]");
	}

	public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] result = new int[findNums.length];
        for (int i = 0; i < findNums.length; i ++) {
        	int find = findNums[i];
        	
        	int match = -1;
        	boolean encount = false;
        	for (int num : nums) {
        		if (find == num) {
        			encount = true;
        		}
        		
        		if (encount && num > find) {
        			match = num;
        			break;
        		}
        	}
        	
        	result[i] = match;
        }
        
        return result;
    }
}
