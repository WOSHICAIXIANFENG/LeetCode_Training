package com.github.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.

Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]
Note:
The given array size will in the range [2, 10000].
The given array's numbers won't have any order.

 * @author Samuel
 *
 */
public class SetMismatch_645 {

	public static void main(String[] args) {
//		int[] nums = {1,2,2,4};
		int[] nums = {3,2,4,4};
		System.out.println("Samuel Test findErrorNums = " + Arrays.toString(findErrorNums(nums)));
		System.out.println("Samuel Test findErrorNums = " + Arrays.toString(findErrorNums2(nums)));
		System.out.println("Samuel Test findErrorNums = " + Arrays.toString(findErrorNums3(nums)));
	}

	/**
	 * 
 Time complexity : O(n)O(n). Traversing over numsnums of size nn takes O(n)O(n) time. 
 Considering each number from 11 to nn also takes O(n)O(n) time.
 Space complexity : O(n)O(n). mapmap can contain atmost nn entries for each of the numbers from 11 to nn.
	 */
	public static int[] findErrorNums(int[] nums) {
		int dup = 0; 
		int missing = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
				dup = i;
			} else {
				map.put(i, 1);
			}
		}
		
		for (int i = 0; i < nums.length; i ++) {
			if (!map.containsKey(i + 1)) {
				missing = i + 1;
			}
		}
		
        return new int[] {dup, missing};
    }
	
	//Time complexity : O(n)O(n). Traversing over numsnums of size nn takes O(n)O(n) time. Considering each number from 11 to nn also takes O(n)O(n) time.
    //Space complexity : O(n)O(n). arrarr can contain atmost nn elements for each of the numbers from 11 to nn.
	public static int[] findErrorNums2(int[] nums) {
		int dup = 0; 
		int missing = 0;
		int[] temp = new int[nums.length]; 
		for (int n : nums) {
			if (temp[n-1] != 0) {
				dup = n;
			} 
			temp[n-1] += 1;
		}
		
		for (int i = 0; i < nums.length; i ++) {
			if (temp[i] == 0) {
				missing = i + 1;
			}
		}
		return new int[]{dup, missing};
	}
	
	
	// !!! ----- There is error case ---- {3,2,4,4};
	//Time complexity : O(n). Two traversals over the numsnums array of size nn are done.
    //Space complexity : O(1). Constant extra space is used.
	public static int[] findErrorNums3(int[] nums) {
		int dup = -1, missing = 1;
        for (int n: nums) {
            if (nums[Math.abs(n) - 1] < 0)
                dup = Math.abs(n);
            else
                nums[Math.abs(n) - 1] *= -1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0)
                missing = i + 1;
        }
        return new int[]{dup, missing};
	}
}
