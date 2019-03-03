package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle_118 {

	public static void main(String[] args) {
		System.out.println("Cai Test generate = " + generate(5));

	}

	// 0 ms, faster than 100.00% 
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 1; i <= numRows; i ++) {
			result.add(generateRow(result, i));
		}
        return result;
    }
	
	public static List<Integer> generateRow(List<List<Integer>> result, int row) {
		if (row == 1) {
			List<Integer> rowArray = new ArrayList<>();
			rowArray.add(1);
			return rowArray;
		} else {
			List<Integer> previousArray = result.get(result.size() - 1);
			List<Integer> rowArray = new ArrayList<>(row);
			for (int i = 0; i < row; i ++) {
				if (i == 0 || i == row -1) {
					rowArray.add(1);
				} else {
					rowArray.add(previousArray.get(i - 1) + previousArray.get(i));
				}
			}
			return rowArray;
		}
	}
	
//	public static List<Integer> generateRow(List<List<Integer>> result, int row) {
//		if (row == 1) {
//			List<Integer> rowArray = new ArrayList<>();
//			rowArray.add(1);
//			return rowArray;
//		} else {
//			List<Integer> previousArray = result.get(result.size() - 1);
//			List<Integer> rowArray = new ArrayList<>(row);
//			for (int i = 0; i < row; i ++) {
//				if (i == 0 || i == row -1) {
//					rowArray.add(1);
//				} else {
//					rowArray.add(previousArray.get(i - 1) + previousArray.get(i));
//				}
//			}
//			return rowArray;
//		}
//	}
}
