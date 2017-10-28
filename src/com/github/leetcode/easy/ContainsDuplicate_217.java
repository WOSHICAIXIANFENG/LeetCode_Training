package com.github.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_217 {

	public static void main(String[] args) {
		int[] nums1 = {2,3,4,5,6,7,2};
		System.out.println("Samuel Test containsDuplicate = " + containsDuplicate(nums1));
	}
	
	/**
	 * Time Complexity: O(n). We do search() and insert() for n times and each operation takes constant time
	 * Space Complexity: O(n). The space used by a hash table is linear with the number of elements in it.
	 * 
	 * @param nums
	 * @return
	 */
	public static boolean containsDuplicate(int[] nums) {
		// for HashSet --- contains() & add() ---- O(1)
        Set<Integer> data = new HashSet<>();
        for (int i : nums) {
        	if (data.contains(i)) {
        		return true;
        	}
        	data.add(i);
        }
        return false;
    }

}
