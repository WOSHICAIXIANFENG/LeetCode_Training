package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/the-skyline-problem/description/
 * 
 * @author Samuel
 *
 */
public class SkylineProblem_218 {

	public static void main(String[] args) {
		// normal case
		int[][] buildings = { {2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8} };
		
		// Test case1
		int[][] buildings2 = { {0,1,3} };
		
		// Test case2
		int[][] buildings3 = { {1,2,1},{1,2,2},{1,2,3} };
		
		// Test case3
		int[][] buildings4 = { {3,10,20},{3,9,19},{3,8,18},{3,7,17},{3,6,16},{3,5,15},{3,4,14} };
		
		// Test case4
		int[][] buildings5 = { {0,5,7},{5,10,7},{5,10,12},{10,15,7},{15,20,7},{15,20,12},{20,25,7} };
		
		List<int[]> results = getSkyline(buildings3);
		
		for (int[] lines : results) {
			System.out.println("Samuel Test results = " + Arrays.toString(lines));
		}
		//System.out.println("Samuel Test results = " + results);
	}

	public static List<int[]> getSkyline(int[][] buildings) {
		List<int[]> results = new ArrayList<>();
		int[] lastBuilding = null;
		
		for (int i = 0; i < buildings.length; i ++) {
			// Handle the first line
			if (i == 0) {
				// Test case2
				//results.add(new int[] {buildings[0][0], buildings[0][2]});
				
				// find next different left value building, get the hight height
				// {1,2,1},{1,2,2},{1,2,3}
				// {1,2,1},{1,4,2},{1,2,3}
				int firstLeft = buildings[0][0];
				int firstHeight = buildings[0][2];
				int j = 1;
				while (j < buildings.length && buildings[j][0] == firstLeft) {
					if (buildings[j][2] > firstHeight) {
						firstHeight = buildings[j][2];
					}
					
					j ++;
				}
				results.add(new int[] {firstLeft, firstHeight});
			} else {
				if (buildings[i][0] > lastBuilding[1]) {
					// add baseline point
					results.add(new int[] {lastBuilding[1], 0});
					
					// Test case2
					// add left point
					//results.add(new int[] {buildings[i][0], buildings[i][2]});
					int firstLeft = buildings[i][0];
					int firstHeight = buildings[i][2];
					int j = 1;
					while (j < buildings.length && buildings[j][0] == firstLeft) {
						if (buildings[j][2] > firstHeight) {
							firstHeight = buildings[j][2];
						}
						
						j ++;
					}
					results.add(new int[] {firstLeft, firstHeight});
				} else {
					// compare with the previous building
					if (buildings[i][2] > lastBuilding[2]) {
						if (buildings[i][0] != lastBuilding[0]) {
							results.add(new int[] {buildings[i][0], buildings[i][2]});
						} else {
							if (buildings[i][1] < lastBuilding[1]) {
								results.add(new int[] {buildings[i][1], lastBuilding[2]});
							} else if (buildings[i][1] >= lastBuilding[1]) {
								results.add(new int[] {buildings[i][0], buildings[i][2]});
							}
						}
			
					} else if (buildings[i][2] < lastBuilding[2]) {
						// compare the right coordinate
						if (buildings[i][1] > lastBuilding[1]) {
							results.add(new int[] {lastBuilding[1], buildings[i][2]});
						}
					}
				}
			}
			
			if (i == 0 || i < buildings.length - 1) {
				lastBuilding = buildings[i];
			}
			
			// Test case1
			// handle the last line
			if (i == buildings.length - 1) {
				if (buildings[i][1] >= lastBuilding[1]) {
					results.add(new int[] {buildings[i][1], 0});
				} else {
					// get the first different right pointer
					int rightValue = buildings[i][1];
					int j = i - 1;
					while (j >= 0 && buildings[j][1] > rightValue) {
						rightValue = buildings[j][1];
						j --;
					}
					
					results.add(new int[] {rightValue, 0});
				}
			}
		}
	
		return results;
    }
}
