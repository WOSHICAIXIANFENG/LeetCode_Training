package com.github.leetcode.easy;

public class SqrtX_69 {

	public static void main(String[] args) {
		System.out.println("Cai Test max INT = " + Integer.MAX_VALUE);// 2^31-1
		System.out.println("Cai Test max INT = " + Double.MAX_VALUE);// 2^1024-1,  1.7976931348623157e+308
		
		System.out.println("Cai Test mySqrt = " + mySqrt(1));//1
		System.out.println("Cai Test mySqrt = " + mySqrt(2));//1.4
		System.out.println("Cai Test mySqrt = " + mySqrt(3));//1.7
		System.out.println("Cai Test mySqrt = " + mySqrt(4));//2
		System.out.println("Cai Test mySqrt = " + mySqrt(8));//2
		System.out.println("Cai Test mySqrt = " + mySqrt(10));//3
		System.out.println("Cai Test mySqrt = " + mySqrt(2147395600));
		System.out.println("Cai Test mySqrt = " + mySqrt(2147483647));// this is maximum integer
	}
	
	// Solve it by Newton Method: Xm = Xn - f(xn)/f'(xn) --- m = n +1
	// f(xn) = x^2 - num = 0
	public static int mySqrt(int x) {
		if (x <= 1) return x;
		
        double x1 = 0, x2 = 1;
        while (Math.abs(x1 - x2) > 0.000001) {
            x1 = x2;
            x2 = (x1 + x/x1) / 2;
        }
        return (int)x1;
	}
	
	// 14 ms, faster than 94.61%
	// Use binary search solution
	// Time Complexity: O(logN) --- O(lg(x)) = O(32)=O(1)
//	public static int mySqrt(int x) {
//		int left = 1; // start from 1
//		int right = x;
//		while (left <= right) {
//			int middle = left + (right - left) / 2;
//			if (middle == x / middle) {// use '/' to avoid * value is out of Int Range
//				return middle;
//			} else if (middle > x / middle) {
//				right = middle - 1;
//			} else {
//				left = middle + 1;
//			}
//		}
//        return left - 1;// Why -1 ? [8] --->low:1,1,3 high:8,3,2 --> 2
//    }
	
	// 138 ms, faster than 3.76% 
//	public static int mySqrt(int x) {
//		if (x == 1) return 1;
//		
//		int i = 1;
//		while (i <= x/2 + 1) {
//            if (Math.pow(i, 2) == x) {
//                break;
//            } else if (Math.pow(i, 2) > x) { // use i * i will has out of Integer range issue
//				i --;
//				break;
//			}
//			i ++;
//		}
//        return i;
//    }
	
//	public static int mySqrt(int x) {
//		if (x == 1) return 1;
//		
//		int i = 1;
//		while (i <= x/2 + 1) {
//            if (i * i == x) {
//                break;
//            } else if (i * i > x) { // if i * i was out of Integer range, this will not pass
//				i --;
//				break;
//			}
//			i ++;
//		}
//        return i;
//    }

}
