package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/discuss/84566/Share-My-Solution-which-beat-96.42
public class FindKPairsWithSmallestSums_373 {

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
	
	// 3 ms, faster than 99.42%
	// Approach 1: Use MinHeap to solve it
	// Time Complexity: O((n+k)*logN) when k < m*n, otherwise O((n+m*n)*logn)
	public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> ans = new ArrayList<>();
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return ans;
		}
		PriorityQueue<Trible> minHeap = new PriorityQueue<>();
		for (int i = 0; i < nums2.length; i++) {
			minHeap.offer(new Trible(0, i, nums1[0] + nums2[i]));
		}
		
		// k could be > n*m
		for (int i = 0; i < Math.min(k, nums1.length * nums2.length); i++) {
			Trible ithSmall = minHeap.poll();
			ans.add(new int[]{nums1[ithSmall.x], nums2[ithSmall.y]});
			if (ithSmall.x == nums1.length - 1) {
				continue;
			}
			minHeap.offer(new Trible(ithSmall.x + 1, ithSmall.y, nums1[ithSmall.x + 1] + nums2[ithSmall.y]));
		}
		
        return ans;
    }
}

class Trible implements Comparable<Trible> {
	int x, y, val;
	public Trible(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}
	@Override
	public int compareTo(Trible that) {
		return this.val - that.val;
	}
	@Override
	public String toString() {
		return " val = " + val;
	}
}
