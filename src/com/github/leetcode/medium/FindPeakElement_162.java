package com.github.leetcode.medium;

/**
 * The array may contain multiple peaks, 
 * in that case return the index to any one of the peaks is fine.
 * 
 * @author Samuel
 *
 */
public class FindPeakElement_162 {

	public static void main(String[] args) {
		int[] a1 = {1,2,3,1};
		int[] a2 = {1,2,1,3,5,6,4};
		System.out.println("Cai Test = " + findPeakElement(a1));
		System.out.println("Cai Test = " + findPeakElement(a2));
	}

	// !!!! Your solution should be in logarithmic complexity.
	// Approach 3: Iterative Binary Search
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	public static int findPeakElement(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] > nums[mid + 1]) {
				high = mid;// since mid could == low, we can't pass 'mid - 1'
			} else {
				low = mid + 1;//since mid could == low, we need 'mid + 1' to avoid stack overflow
			}
		}
		return low;
	}
	
	// !!!! Your solution should be in logarithmic complexity.
	// Approach 2: Recursive Binary Search
	// Time Complexity: O(logN). We reduce the search space in half at every step. 
	// Thus, the total search space will be consumed in logN steps.
	// Space Complexity: O(logN) --- the depth of recursion tree will go upto logN
//	public static int findPeakElement(int[] nums) {
//        return search(nums, 0, nums.length - 1);
//    }
//	
//	// 2 ms, faster than 100.00%
//	// there is no same element sequence.
//	public static int search(int[] nums, int l, int r) {
//		if (l == r) {
//			return l;
//		}
//		int mid = l + (r - l) / 2; // mid will be >= l. that why will need mid + 1 to avoid Stack Overflow
//		if (nums[mid] > nums[mid + 1]) {
//			return search(nums, l, mid);// since mid could == l, that's why we can't pass mid - 1
//		} else {
//			// there is no same element sequence.
//			return search(nums, mid + 1, r); // !!! without + 1 --- will Stack Overflow
//		}
//	}
	
	// 2 ms, faster than 100.00%
	// !!! find any one of the peak is ok!
	// Approach 1: Linear Scan
	// Time Complexity: O(n)
	// Space Complexity: O(1)
//	public static int findPeakElement(int[] nums) {
//		// can be simplify to 3 cases: peak in first ele, peak in last ele, peak is in middle
//		for (int i = 0; i < nums.length - 1; i++) {
//			if (nums[i] > nums[i + 1])
//				return i;
//		}
//        return nums.length - 1;
//    }
}
