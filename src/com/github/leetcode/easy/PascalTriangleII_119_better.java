package com.github.leetcode.easy;

import java.util.Arrays;
import java.util.List;

public class PascalTriangleII_119_better {

	public static void main(String[] args) {
		System.out.println("Cai Test generate = " + getRow(31));
		System.out.println("Cai Test generate = " + getRow(4));
	}

	// 0 ms, faster than 100.00% 
	public static List<Integer> getRow(int rowIndex) {
		Integer[] row = new Integer[rowIndex + 1];
		Arrays.fill(row, 0);
		row[0] = 1;
		
		for (int i = 1; i <= rowIndex; i ++) {
			for (int j = i; j > 0; j --) {
				row[j] = row[j] + row[j - 1];
			}
		}
		
		return Arrays.asList(row);
	}
}
