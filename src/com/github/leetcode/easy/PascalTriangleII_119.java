package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII_119 {

	public static void main(String[] args) {
		System.out.println("Cai Test generate = " + getRow(31));
	}
	
	// 1 ms, faster than 89.33% 
	// runtime is O(k^2) and the space complexity is O(k).
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();
		if (rowIndex < 0)
			return list;

		for (int i = 0; i < rowIndex + 1; i++) {
			list.add(0, 1);//!!!
			for (int j = 1; j < list.size() - 1; j++) {
				list.set(j, list.get(j) + list.get(j + 1));
			}
		}
		return list;
	}

	// Time Limit Exceeded
//	// time exceed for 31 ---- row is <= 33
//	public static List<Integer> getRow(int rowIndex) {
//		List<Integer> result = new ArrayList<>(rowIndex + 1);
//		for (int i = 0; i <= rowIndex; i ++) {
//			if (i == 0 || i == rowIndex) {
//				result.add(1);
//			} else {
//				// traverse back 
//				result.add(getValue(i, rowIndex));
//			}
//		}
//        return result;
//    }
//	
//	public static int getValue(int index, int rowIndex) {
//		// in the beginning of row
//		if (index == 0) {
//			return 1;
//		}
//		// in the end of row
//		if (index == rowIndex) {
//			return 1;
//		}
//		
//		return getValue(index - 1, rowIndex - 1) + getValue(index, rowIndex - 1);
//	}
}
