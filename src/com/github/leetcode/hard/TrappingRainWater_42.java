package com.github.leetcode.hard;

import java.util.Arrays;

// https://leetcode.com/articles/trapping-rain-water/
// 四种方法，逐步递进！！！
public class TrappingRainWater_42 {

	public static void main(String[] args) {
		TrappingRainWater_42 obj = new TrappingRainWater_42();
		
		int[] a1 = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println("Cai Test = " + obj.trap(a1));
	}
	
	// 最好的解法!!!
	// 1 ms, faster than 99.81%
	// Approach 3: Two pointers
	// TC: O(n) --- one pass
	// SC: O(1)
	public int trap(int[] height) {
		final int n = height.length;
		
		int ans = 0;
		int leftMax = 0; int rightMax = 0;
		// two pointers
		int left = 0; 
		int right = n - 1;
		while (left < right) {
			// calculate on the left side
			if (height[left] < height[right]) {
				if (height[left] >= leftMax) {
					leftMax = height[left];
				} else {
					ans += leftMax - height[left];
				}
				left++;
			} else {
				// calculate on the right side
				if (height[right] >= rightMax) {
					rightMax = height[right];
				} else {
					ans += rightMax - height[right];
				}
				right--;
			}
		}
		return ans;
	}

	// 1 ms, faster than 99.81%
	// Approach 2: Dynamic Programming --- Optimized approach 1 to avoid using embeded loop
	// TC: O(n)
	// SC: O(2 * n)
	public int trap2(int[] height) {
		final int n = height.length;
        int ans = 0;
        int[] leftMax = new int[n];
        for (int i = 0; i < n; i++) {
        	leftMax[i] = i > 0 ? Math.max(leftMax[i - 1], height[i]) : height[i];
        }
        //System.out.println("Cai Test left max array = " + Arrays.toString(leftMax));
        
        int[] rightMax = new int[n];
        for (int i = n - 1; i >= 0; i--) {
        	rightMax[i] = i < n - 1 ? Math.max(rightMax[i + 1], height[i]) : height[i];
        }
        //System.out.println("Cai Test right max array = " + Arrays.toString(rightMax));
        
        for (int i = 0; i < n; i++) {
        	ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
	}
	
	// 58 ms, faster than 8.49%
	// Approach 1: Brute Force
	// TC: O(n^2) --- For each element of array, we iterate the left and right parts
	// SC: O(1)
	public int trap3(int[] height) {
        final int n = height.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
        	// find leftMax 
        	int leftMax = 0;
        	for (int j = 0; j <= i; j++) {
        		leftMax = Math.max(leftMax, height[j]);
        	}
        	
        	int rightMax = 0;
        	for (int k = i; k < n; k++) {
        		rightMax = Math.max(rightMax, height[k]);
        	}
        	
        	ans += Math.min(leftMax, rightMax) - height[i];
        }
        return ans;
    }
}
