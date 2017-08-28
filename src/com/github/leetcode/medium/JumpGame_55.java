package com.github.leetcode.medium;

public class JumpGame_55 {

	public static void main(String[] args) {
		int[] a1 = {2,3,1,1,4};
		int[] a2 = {3,2,1,0,4};
		
		System.out.println("Cai Test a1 = " + canJump(a1));
		System.out.println("Cai Test a2 = " + canJump(a2));
	}
	
	public static boolean canJump(int[] A) {
		boolean[] can = new boolean[A.length];
		can[0] = true;
		
		for (int i = 1; i < A.length; i ++) {
			for (int j = 0; j < i; j ++) {
				if (can[j] && j + A[j] >= i) {
					can[i] = true;
					break;
				}
			}
		}
		return can[A.length - 1];
	}

}
