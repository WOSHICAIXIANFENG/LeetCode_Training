package com.github.leetcode.medium;

public class KokoEatingBananas_875 {

	public static void main(String[] args) {
		int[] p1 = {3,6,7,11};
		System.out.println("Cai Test = " + minEatingSpeed(p1, 8));//4
		int[] p2 = {30,11,23,4,20};
		System.out.println("Cai Test = " + minEatingSpeed(p2, 5));//30
		int[] p3 = {30,11,23,4,20};
		System.out.println("Cai Test = " + minEatingSpeed(p3, 6));//23
	}
	
	// 10 ms, faster than 97.35%
	// Time Complexity: O(NlogW), where N is the number of piles. W is the maximum size of a pile
	// Space Complexity: O(1)
	public static int minEatingSpeed(int[] piles, int H) {
		int low = 1;
		int high = 1_000_000_000;// maximum size of bananas pile
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (possible(piles, H, mid)) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
        return low;
    }
	
	// Can Koko eat all bananas in H hours with eating speed K?
    public static boolean possible(int[] piles, int h, int k) {
    	int time = 0;
    	for (int pile : piles) {
    		time += (pile - 1) / k + 1;
    	}
    	return time <= h;
    }
}
