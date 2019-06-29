package com.github.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class VideoStitching_1024 {

	public static void main(String[] args) {
		VideoStitching_1024 obj = new VideoStitching_1024();
		int[][] c1 = {
				{0, 2},
				{4, 6},
				{8, 10},
				{1, 9},
				{1, 5},
				{5, 9}
		};
		System.out.println("Cai Test = " + obj.videoStitching(c1, 10));// 3
		int[][] c2 = {
				{0, 1},
				{1, 2}
		};
		System.out.println("Cai Test = " + obj.videoStitching(c2, 5)); // -1
	}

	/**
	 * 1 <= clips.length <= 100
     * 0 <= clips[i][0], clips[i][1] <= 100
	 * ----->  DP --- N^3 or N^2 solution 
	 */
	
	// 1 ms, faster than 90.31%
	// sorting by first element, for the clip with same first element, save only the largest end one. 
	// then use the greedy logic to get the result.
	// Approach 1: Greedy
	// TC: O(n)
	// SC: O(1)
	public int videoStitching(int[][] clips, int T) {
		final int n = clips.length;
//		Arrays.sort(clips, new Comparator<int[]>() {
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				return o1[0] - o2[0];
//			}
//		});
		
		Arrays.sort(clips, (a, b) -> a[0] - b[0]);
		
		
		int count = 0;
		int curEnd = 0;
		for (int i = 0; i < n;) {
			if (clips[i][0] > curEnd) {
				return -1;// there is a gap can't be filled
			}
			
			int maxEnd = curEnd;
			while (i < n && clips[i][0] <= curEnd) {
				maxEnd = Math.max(maxEnd, clips[i][1]);
				i++;
			}
			// took the longest one with the same start time
			count++;
			curEnd = maxEnd;
			if (curEnd >= T) {
				return count;
			}
		}
		return -1;
    }
}
