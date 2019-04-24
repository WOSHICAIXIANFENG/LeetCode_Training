package com.github.leetcode.hard;

import java.util.PriorityQueue;

public class KthSmallestNumInMultiplicationTable_668 {

	public static void main(String[] args) {
		System.out.println("Cai Test = " + findKthNumber(3, 3, 5));//3
		System.out.println("Cai Test = " + findKthNumber(2, 3, 6));//6
		
		// extrime case --- MiniHeap Solution can't solve this case
		System.out.println("Cai Test = " + findKthNumber(9895, 28405, 100787757));
	}

	// Time Limit Exceeded
	// Approach 2: Use MinHeap to solve kth Small questions
	// Time Complexity: O(nlogN + k*2logN) ---- for the worst case, k = m*n
	// ---> O(m*nLogn)
	// Space Complexity: O(N)
//	public static int findKthNumber(int m, int n, int k) {
//		PriorityQueue<Tuple> minHeap = new PriorityQueue<>();
//		// put first row into minHeap
//		for (int i = 1; i <= n; i++) {
//			minHeap.offer(new Tuple(i, 1));
//		}
//		for (int i = 1; i <= k - 1; i++) {
//			// pop up the ith Smallest element
//			Tuple ithSmall = minHeap.poll();
//			if (ithSmall.rowIndex == m) {
//				continue;
//			}
//			minHeap.offer(new Tuple(ithSmall.val/ithSmall.rowIndex * (ithSmall.rowIndex + 1) , ithSmall.rowIndex + 1));
//		}
//		return minHeap.poll().val;
//	}
	
	// 9 ms, faster than 97.73% 
	// Approach 1: Binary Search. 
	// Time Complexity: O(m*log(m*n)). Our binary search divides the interval [lo, hi] into half at each step.
	// for each step, we calculate how many numbers <= mid, which require O(m)
	public static int findKthNumber(int m, int n, int k) {
		int low = 1;
		int high = m * n;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			// calculate how many numbers <= mid;
			int count = 0;
			int j = n;// from right to left
			// 12345
			// 2468*
			// 48***
			// 8****
			for (int i = 1; i <= m; i++) {
				// 这里可以简化成 count += Math.min(x / i, n); 不用内部while和J来计算, 但是这会使速度变慢!!! from 9ms become 14ms, > 97.73 to > 68.8
				while (j >= 1 && i * j > mid) {
					j--;
				}
				count += j;
			}
			
			if (count < k) {
				low = mid + 1;
			} else {
				// case count > k, we need a smaller mid
				// case count == k, we need a smaller mid value to figure out the kth Smallest value
				high = mid - 1;
			}
		}
        return low;
    }
}

class Tuple implements Comparable<Tuple> {
	int val, rowIndex;
	public Tuple(int val, int rowIndex) {
		this.val = val;
		this.rowIndex = rowIndex;
	}
	
	@Override
	public int compareTo(Tuple that) {
		return this.val - that.val;
	}
}
