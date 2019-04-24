package com.github.leetcode.medium;

import java.util.PriorityQueue;

// 学习MinHeap的各种操作： 下面写得非常好！
// https://www.cnblogs.com/Elliott-Su-Faith-change-our-life/p/7472265.html
public class KthSmallestEleInASortedMatrix_378_heap {

	public static void main(String[] args) {
		int[][] m1 = {{1,  5,  9},{10, 11, 13},{12, 13, 15}};
		System.out.println("Cai Test = " + kthSmallest(m1, 8));
	}
	
// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code
	
	// PriorityQueue的peek()和element操作是常数时间，add(), offer(), 无参数的remove()以及poll()方法的时间复杂度都是log(N)。
	// 看不懂的话：给上面的blog，画图帮助理解
	// Approach 2: Try to use min heap to solve kth kind of questions
	// Time Complexity: O(K*2LogN)
	// Space Complexity: O(N) ---- N is the length of matrix N*N
	// 16 ms, faster than 56.76%
	public static int kthSmallest(int[][] matrix, int k) {
		// Since it is a N*N square
		int length = matrix.length;
		PriorityQueue<Triple> minHeap = new PriorityQueue<>();
		
		// put first row elements into minHeap
		for (int i = 0; i < matrix[0].length; i++) {
			minHeap.offer(new Triple(0, i, matrix[0][i]));
		}
		
		// 每次poll都能取出最小的那个元素，即ith Smallest ele ---- !!!因为每个元素的下面的，或右面的元素都比它大。
		// 所以minHeap 里面永远可以poll出最小的元素。因为matrix是从左到右，从上到下 升序的!!!
		for (int i = 0; i < k - 1; i++) {
			Triple currEle = minHeap.poll();
			if (currEle.row == length - 1) continue;
			minHeap.offer(new Triple(currEle.row + 1, currEle.col, matrix[currEle.row + 1][currEle.col]));
		}
		System.out.println("Cai Test heap size = " + minHeap.size());
		System.out.println("Cai Test heap size = " + minHeap.peek());
		return minHeap.poll().val;
	}
}

class Triple implements Comparable<Triple> {
	int row, col, val;
	
    public Triple (int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
    
    @Override
    public int compareTo (Triple that) {
        return this.val - that.val;
    }

	@Override
	public String toString() {
		return "Triple [row=" + row + ", col=" + col + ", val=" + val + "]";
	}
}