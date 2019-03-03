package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 * 
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.

 * @author Samuel.Cai
 */
public class RangeSumQuery_303 {

	public static void main(String[] args) {
		int[] a1 = {-2, 0, 3, -5, 2, -1};
		NumArray numArr = new NumArray(a1);
		System.out.println("Cai Test = " + numArr.sumRange(0, 2));//  1
		System.out.println("Cai Test = " + numArr.sumRange(2, 5));// -1
		System.out.println("Cai Test = " + numArr.sumRange(0, 5));// -3
	}
}

// Approach 1: Brute Force ----- Time Limit Exceeded
// Time Complexity: O(n) time per query. Each sumRange query takes O(n) time.
// Space Complexity: O(1). Note that the data is a reference to nums and is not a copy of it.
//class NumArray {
//	int[] data;
//	
//    public NumArray(int[] nums) {
//        this.data = nums;
//    }
//
//    public int sumRange(int i, int j) {
//    	int sum = 0;
//    	for (int k = i; k <= j; k++) {
//    		sum += data[k];
//    	}
//        return sum;
//    }
//}

// For Approach 1: Imagine that sumRange is called one thousand time with exact same arguments, how could we speed that up?
// Approach 2: Use Cache
// Time Complexity: O(1) tiem per query. O(n^2) time pre-computation.
// Space complexity: O(n^2). since there are n candidates for both i and j;
//class NumArray {
//	final Map<Pair<Integer, Integer>, Integer> table = new HashMap<>();
//	
//    public NumArray(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//        	int sum = 0;
//        	for (int j = i; j < nums.length; j++) {
//        		sum += nums[j];
//        		table.put(new Pair<>(i, j),  sum);
//        	}
//        }
//    }
//
//    public int sumRange(int i, int j) {
//    	// Note: you must implement hashCode() and equals() method to avoid NPE. because the return type is int, it will lead unbox operation
//    	return table.get(new Pair<>(i, j));
//    }
//    
//    class Pair<T, E> {
//    	T i;
//    	E j;
//    	public Pair (T i , E j) {
//    		this.i = i;
//    		this.j = j;
//    	}
//		@Override
//		public int hashCode() {
//			final int prime = 31;
//			int result = 1;
//			result = prime * result + getOuterType().hashCode();
//			result = prime * result + ((i == null) ? 0 : i.hashCode());
//			result = prime * result + ((j == null) ? 0 : j.hashCode());
//			return result;
//		}
//		@Override
//		public boolean equals(Object obj) {
//			if (this == obj)
//				return true;
//			if (obj == null)
//				return false;
//			if (getClass() != obj.getClass())
//				return false;
//			Pair other = (Pair) obj;
//			if (!getOuterType().equals(other.getOuterType()))
//				return false;
//			if (i == null) {
//				if (other.i != null)
//					return false;
//			} else if (!i.equals(other.i))
//				return false;
//			if (j == null) {
//				if (other.j != null)
//					return false;
//			} else if (!j.equals(other.j))
//				return false;
//			return true;
//		}
//		private NumArray getOuterType() {
//			return NumArray.this;
//		}	
//    }
//}

// 65 ms, faster than 97.71%
// The above approach takes a lot of space, could we optimize it?
// Approach 3: Caching
// Time Complexity: O(1) time per query. O(n) time pre-computation. 
// Space complexity: O(n).
class NumArray {
	int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
        	sums[i + 1] = sums[i] + nums[i];
        }
    }
    
    // Range sum of [i, j] ----> sum[j+1] - sum[i];
    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
