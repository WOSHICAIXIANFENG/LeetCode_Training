package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/discuss/84551/simple-Java-O(KlogK)-solution-with-explanation
public class FindKPairsWithSmallestSums_373_Lite {

	public static void main(String[] args) {
		int[] a1 = {1,7,11};
		int[] a2 = {2,4,6};
		System.out.println("Cai Test = " + print(kSmallestPairs(a1, a2, 3)));
		
		int[] b1 = {1,1,2};
		int[] b2 = {1,2,3};
		System.out.println("Cai Test = " + print(kSmallestPairs(b1, b2, 2)));
		
		int[] c1 = {1,2};
		int[] c2 = {3};
		System.out.println("Cai Test = " + print(kSmallestPairs(c1, c2, 3)));
	}
	
	public static String print(List<int[]> array) {
		String result = "{ ";
		for (int[] a : array) {
			result += Arrays.toString(a);
		}
		return result + " }";
	}
	
	// !!! Lite version without inner class Tuple 
	// 3 ms, faster than 99.42%
	// Approach 1: Use MinHeap to solve it ---- 
	// Time Complexity: 
	// O(k*LogK) since que.size <= k and we do at most k loop
	public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
		List<int[]> res = new ArrayList<>();
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return res;
		}
		
		// put first column into minHeap
		for (int i = 0; i < nums1.length && i < k; i++) {
			minHeap.offer(new int[]{nums1[i], nums2[0], 0}); // '0' means column index
		}
		while (k-- > 0 && !minHeap.isEmpty()) {
			int[] cur = minHeap.poll();
			res.add(new int[]{cur[0], cur[1]});
			// the last column
			if (cur[2] == nums2.length - 1) {
				continue;
			}
			minHeap.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1}); // !!! nums2[columnIndex + 1]
		}
		return res;
    }
}
