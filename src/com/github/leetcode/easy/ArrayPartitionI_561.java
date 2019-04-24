package com.github.leetcode.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/array-partition-i/discuss/102170/Java-Solution-Sorting.-And-rough-proof-of-algorithm.
 * @author Samuel
 *
 */
public class ArrayPartitionI_561 {

	public static void main(String[] args) {
		int[] a1 = {1,4,3,2};
		System.out.println("Cai Test = " + arrayPairSum(a1));
	}

	// Assume in each pair i, bi >= ai.
	// Result = min(a1, b1) + min(a2, b2) + ... + min(an, bn) = a1 + a2 + ... an
	// a1 + b1 + a2 + b2 + ... + an + bn == Sum (which is a constant)
	// set --> di = bi - ai
	// a1 + a1 + d1 + a2 + a2 + d2 + ... + an + an + dn = 2Result + Sd == Sum (which is a constant)
	// Result = (Sum - Sd) / 2 ----- to get the max Result, we need to make Sd as small as possible.
	// What is small Sd? ---- !!! 
	// After sorting the array. ----> a1,b1,a2,b2,a3,b3..... an,bn
	// a1 + b1 + a2 + b2 + ... + an + bn - [(b1 - a1) + (b2 - a2) + ...(bn - an)] ----> 2(a1 + a2 + ... an)
	public static int arrayPairSum(int[] nums) {
		if (nums == null || nums.length < 2) return 0;
		
		// O(nLgN)
		Arrays.sort(nums);
		
		// O(n/2)
		int result = 0;
		// get 1,3,5,7,9...th' sum
		for (int i = 0; i < nums.length; i += 2) {
			result += nums[i];
		}
        return result;
    }
}
