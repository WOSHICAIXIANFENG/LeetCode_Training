package com.github.leetcode.easy;

public class ArrangingCoins_441 {

	public static void main(String[] args) {
		System.out.println("Cai Test = " + arrangeCoins(5));
		System.out.println("Cai Test = " + arrangeCoins(8));
		System.out.println("Cai Test = " + arrangeCoins(Integer.MAX_VALUE));
		
		System.out.println("Cai Test = " + arrangeCoins(1));
		System.out.println("Cai Test = " + arrangeCoins(10));
	}
	
	// Better ---- use math formula to solve this problem.
	// 17 ms, faster than 99.73%
	public static int arrangeCoins(int n) {
		// 1 + 2 + 3 + 4 + ...x = n, x possibly will be incomplete, x will be double value. we use (int) to get previous Integer
		// x(1 + x)/2 = n --- try to get x
		// x^2 + x = 2n
		// (x + 1/2)^2 = 2n + 1/4 
		// x + 1/2 = sqrt( (8n + 1) / 4)
		// x = (sqrt(8n + 1) / 2) - 1/2
		// x = (sqrt(8n + 1) - 1) / 2
		return (int) ((Math.sqrt(8 * (long) n + 1) - 1) / 2);
	}
	
	// 25 ms, faster than 61.89%
//	public static int arrangeCoins(int n) {
//		if (n <= 0) return 0;
//		
//		int sum = 0;
//		int start = 1;
//		while (sum < n) {
//			sum += start;
//			if (n - sum <= start) {
//				return start;
//			}
//			start++;
//		}
//		
//        return start;
//    }

}
