package com.github.leetcode.easy;

/**
 * Solution Explanation: https://leetcode.com/problems/minimum-moves-to-equal-array-elements/discuss/93817/It-is-a-math-question
 * 
 * @author Samuel
 *
 */
public class MiniMoveToEqualArray_453 {

	public static void main(String[] args) {
		int[] a1 = {1,2,3};
		System.out.println("Cai Test = " + minMoves(a1));
		
		int[] a2 = {1,2,3,4}; //---> {4,4,4,4}
		System.out.println("Cai Test = " + minMoves(a2));
		
		int[] a3 = {-1, 1}; // 2
		System.out.println("Cai Test = " + minMoves(a3));
		
		int[] a4 = {-1, -2, -3}; 
		System.out.println("Cai Test = " + minMoves(a4));
	}
	
	// 5 ms, faster than 99.57%
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	
	// each movement will has n - 1 increase together. each time increase one
	// sum + moves * (n - 1) = x * n --- x is the final element value
	// x = minNum + moves; ---- the min will always be the min until it reach to x. 
	// because every move, other numbers(besides the max) will be increased too. Each time increase 1,
	// finally, we get sum - minNum * n = moves;
	public static int minMoves(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		// sum + result * (n - 1) == x * n; x == minNum + result
		// sum + result*n - result == minNum*n + result*n
		// result = sum - minNum*n; ---> n == nums.length;
		int sum = 0;
		int min = nums[0];
		for (int n : nums) {
			sum += n;
			min = Math.min(min, n);
		}
		return sum - min * nums.length;
	}
	
	// Wrong !!!
	// Wrong Answer ---- need to consider the negative value. [-1,1]
//	public static int minMoves(int[] nums) {
//		if (nums == null || nums.length == 0) return 0;
//		
//		int sum = 0;
//		int max = nums[0];
//		for (int num : nums) {
//			sum += num;
//			max = Math.max(max, num);
//		}
//		
//		int minimalNeed = max * nums.length - sum;
//		if (minimalNeed % 2 != 0) {
//			return minimalNeed;
//		}
//        return minimalNeed / 2;
//    }

}
