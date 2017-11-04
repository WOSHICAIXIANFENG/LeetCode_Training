package com.github.leetcode.easy;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 

Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.

 * @author Samuel
 *
 */
public class ThirdMaximumNumber_414 {

	public static void main(String[] args) {
		int[] array1 = {3, 2, 1};
		int[] array2 = {1, 2};
		int[] array3 = {2, 2, 3, 1};
		
		System.out.println("Samuel Test thirdMax = " + thirdMax(array1));
		System.out.println("Samuel Test thirdMax = " + thirdMax(array2));
		System.out.println("Samuel Test thirdMax = " + thirdMax(array3));
	}
	
	// O(n) time complexity, O(1) space complexity
	public static int thirdMax(int[] nums) {
		Integer max1 = null, max2 = null, max3 = null;
		for (Integer n : nums) {
			if (n.equals(max1) || n.equals(max2) || n.equals(max3))  continue;
			
			if (max1 == null || n > max1) {
				max3 = max2;
				max2 = max1;
				max1 = n;
			} else if (max2 == null || n > max2) {
				max3 = max2;
				max2 = n;
			} else if (max3 == null || n > max3) {
				max3 = n;
			}
		}
		return max3 == null ? max1 : max3;
	}
	
	public static int thirdMax2(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.contains(i)) {
                pq.offer(i);
                set.add(i);
                if (pq.size() > 3) {
                	pq.poll();
                    //set.remove(pq.poll());
                }
            }
        }
        if (pq.size() < 3) {
            while (pq.size() > 1) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
