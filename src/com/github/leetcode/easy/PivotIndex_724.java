package com.github.leetcode.easy;

public class PivotIndex_724 {

	public static void main(String[] args) {
		int[] a1 = {1, 7, 3, 6, 5, 6};
		int[] a2 = {1, 2, 3};
		int[] a3 = {-1,-1,-1,0,1,1};
		System.out.println("Cai Test pivotIndex = " + pivotIndex(a1));
		System.out.println("Cai Test pivotIndex = " + pivotIndex(a2));
		System.out.println("Cai Test pivotIndex = " + pivotIndex(a3));
	}
	
	// 17 ms, faster than 65.39%
	// Time Complexity: 2*O(n)
	// Space Complexity: O(1)
	public static int pivotIndex(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		
		int leftSum = 0;
		for (int i = 0; i < nums.length; i ++) {
			if (leftSum == sum - nums[i] - leftSum) {
				return i;
			}
			leftSum += nums[i];
		}
		return -1;
	}

//	// 237 ms, faster than 11.64% 
//	public static int pivotIndex(int[] nums) {
//		if (nums == null || nums.length <= 1) {
//			return -1;
//		}
//		
//		for (int i = 0; i < nums.length; i ++) {
//			int leftSum = 0, rightSum = 0;
//			for (int j = 0; j < i; j ++) {
//				leftSum += nums[j];
//			}
//			
//			for (int j = i + 1; j < nums.length; j ++) {
//				rightSum += nums[j];
//			}
//			
//			if (leftSum == rightSum) {
//				return i;
//			}
//		}
//        return -1;
//    }
}
