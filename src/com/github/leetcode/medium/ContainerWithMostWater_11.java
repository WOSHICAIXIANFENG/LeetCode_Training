package com.github.leetcode.medium;

public class ContainerWithMostWater_11 {

	public static void main(String[] args) {
		ContainerWithMostWater_11 obj = new ContainerWithMostWater_11();
		
		int[] a1 = new int[]{1,8,6,2,5,4,8,3,7};
		System.out.println("Cai Test = " + obj.maxArea(a1));
	}
	
	// 2 ms, faster than 98.37% 
	// Approach 1: Two Pointers
	// TC: O(n) ---Single Pass
	// SC: O(1). 
	public int maxArea(int[] height) {
		if (height == null || height.length == 0) return 0;
		
		int p1 = 0;
		int p2 = height.length - 1;
		int maxArea = 0;
		while (p1 < p2) {
			maxArea = Math.max(maxArea, Math.min(height[p1], height[p2]) * (p2 - p1));
			if (height[p1] > height[p2]) {
				p2--;
			} else {
				p1++;
			}
		}
        return maxArea;
    }

}
