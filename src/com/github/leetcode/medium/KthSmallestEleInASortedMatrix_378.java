package com.github.leetcode.medium;

/**
 * A Good Explanation: 
 *  https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code
 * @author Samuel
 *
 */
public class KthSmallestEleInASortedMatrix_378 {

	public static void main(String[] args) {
		int[][] m1 = {{1,  5,  9},{10, 11, 13},{12, 13, 15}};
		System.out.println("Cai Test = " + kthSmallest(m1, 8));
	}

	// 0 ms, faster than 100.00%
	// Approach 1: Binary Search
	// Time Complexity: The worst case: the kth is the N^2 th ----- ??? Confirm with 
	// log(N^2)*log(N*M) : 
	// LogN^2 ---- N*N elements, we use binary search! --- each binary search round, we need to go through each element: log(N*N)
	public static int kthSmallest(int[][] matrix, int k) {
		int low = matrix[0][0];
		int high = matrix[matrix.length - 1][matrix[0].length - 1]; //[low, high]
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int count = 0;
			// calculate how many elements <= mid
			int j = matrix[0].length - 1;
			// *****x  ---> j = 4
			// ***xxx ---> j = 2
			// **x ---> j = 1
			// *x ---> j = 0
			for (int i = 0; i < matrix.length; i++) {
				while (j >= 0 && matrix[i][j] > mid) j--;
				count += (j + 1);// since j start from 0, so, we need + 1
			}
			
			if (count < k) {//!!! 这里不能是 count <= k，因为 count=k，我们想从左顶点，即low处向右下收缩。 
				// 当 count == k，我们找到，但是kth smallest value无法给出。这时我们不应该加大mid的值，而是应该神缩小mid的值
				low = mid + 1;
			} else {
				high = mid - 1;//!!! when count == k, 我们从另一侧进行收缩，最终两值相等，再做一次就跳出
			}
		}
		// 两根斜线两个方法夹近，最终得到 kth smallest element
        return low;// why low is the kth smallest element?
    }
}
