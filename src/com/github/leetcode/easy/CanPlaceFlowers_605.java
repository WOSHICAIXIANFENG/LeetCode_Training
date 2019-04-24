package com.github.leetcode.easy;

public class CanPlaceFlowers_605 {

	public static void main(String[] args) {
		int[] a1 = {1,0,0,0,1};
		System.out.println("Cai Test = " + canPlaceFlowers(a1, 1));// true
		System.out.println("Cai Test = " + canPlaceFlowers(a1, 2));// false
		
		int[] a2 = {0,1,0,0,0,1,0};
		System.out.println("Cai Test = " + canPlaceFlowers(a2, 2));// false
		int[] a3 = {1,0,0,1,0,0,1};
		System.out.println("Cai Test = " + canPlaceFlowers(a3, 1));// false
		
		// !!! special cases
		int[] a4 = {0,0,1,0,0,1,0,0};
		System.out.println("Cai Test = " + canPlaceFlowers(a4, 2));// true
		
		//
		int[] a5 = {1,0,0,0,0,0,1};
		System.out.println("Cai Test = " + canPlaceFlowers(a5, 2));// true
		
		int[] a6 = {0};
		System.out.println("Cai Test = " + canPlaceFlowers(a6, 1));// true
		
		int[] a7 = {0,0,0,0};
		System.out.println("Cai Test = " + canPlaceFlowers(a7, 3));// false
		
		int[] a8 = {1,0,0,0};
		System.out.println("Cai Test = " + canPlaceFlowers(a8, 1));// true
	}

	// Linear scan
	// 5 ms, faster than 97.64% 
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		int count = 0;
		for (int i = 0; i < flowerbed.length; i++) {
			// [0] --- [1]
			// [00] --- [10]
			// [100] --- [101]
			// [000] ---> [010] --- normal case
			if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
				flowerbed[i] = 1;
				count++;
			}
			
			// an optimization 
			if (count >= n) {
				return true;
			} 
		}
		return false;
    }
}
