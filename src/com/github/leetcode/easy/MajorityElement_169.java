package com.github.leetcode.easy;

import java.util.Arrays;

public class MajorityElement_169 {

	public static void main(String[] args) {
		int[] a1 = {3,2,3};
		int[] a2 = {2,2,1,1,1,2,2};
		System.out.println("Cai Test majorityElement = " + majorityElement(a1));
		System.out.println("Cai Test majorityElement = " + majorityElement(a2));
	}
	
//	// 26 ms, faster than 15.72% 
//	// time complexity: O(n/2)
//	// At most, the HashMap can contain n - n/2 associations, so it occupies O(n) space.
//	public static int majorityElement(int[] nums) {
//		Map<Integer, Integer> counts = countNums(nums);
//		Map.Entry<Integer, Integer> majorityEntry = null;
//		for (Map.Entry<Integer, Integer> entry: counts.entrySet()) {
//			if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
//				majorityEntry = entry;
//			}
//		}
//		return majorityEntry.getKey();
//	}
//	
//	// time complexity: O(n)
//	// space complexity: O(n)
//	public static Map<Integer, Integer> countNums(int[] nums) {
//		Map<Integer, Integer> counts = new HashMap<>();
//		for (int num : nums) {
//			if (!counts.containsKey(num)) {
//				counts.put(num, 1);
//			} else {
//				counts.put(num, counts.get(num) + 1);
//			}
//		}
//		return counts;
//	}

//	// 3 ms, faster than 100.00% 
//	// time complexity: O(nlgn)
//	// space complexity: O(1) or O(n)
//	public static int majorityElement(int[] nums) {
//		Arrays.sort(nums);
//	    return nums[nums.length/2];
//	}
	
	// 6 ms, faster than 53.36%
	public static int majorityElement(int[] nums) {
		Arrays.sort(nums);
	    
        int element = nums[0];
        int count = 1;
        for (int i = 1; i< nums.length; i++) {
            if (nums[i] == element) {
                count++;
            } else {
                if (count > nums.length/2) {
                    break;
                }
                element = nums[i];
                count = 1;
            }
        }
        return element;
    }
}
