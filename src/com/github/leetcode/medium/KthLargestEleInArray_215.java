package com.github.leetcode.medium;

import java.util.PriorityQueue;

/**
 * 
Find the kth largest element in an unsorted array. 
Note that it is the kth largest element in the sorted order, not the kth distinct element.
For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ? k ? array's length.

 * @author Samuel
 */
public class KthLargestEleInArray_215 {

	public static void main(String[] args) {
		int[] arry1 = {7, 10, 4, 3, 20, 15};
		int k = 4;
		System.out.println("Samuel Test findKthLargest = " + findKthLargest2(arry1, k));
	}
	
	// Java Priority Queue implementation provides O(log(n)) time for enqueing and dequeing method.
	// PriorityQueue is not thread safe, so java provides PriorityBlockingQueue for multithreading environment.
	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
		for (int i : nums) {
			pq.offer(i);// vs add(). if the queue's capacity is fixed. when you try to add another new item into this queue, 
			//it will throw uncheckedException if you use add(), if you use offer(), just return false.
			
			if (pq.size() > k) {
				pq.poll();// vs remove()
			}
		}
		
		return pq.peek();
    }
	
	
	public static int findKthLargest2(int[] nums, int k) {
		if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
	    return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
	}    

	public static int findKthLargest(int[] nums, int start, int end, int k) {// quick select: kth smallest
		if (start > end) return Integer.MAX_VALUE;
		
		int pivot = nums[end];// Take A[end] as the pivot, 
		int left = start;
		for (int i = start; i < end; i++) {
			if (nums[i] <= pivot) // Put numbers < pivot to pivot's left
				swap(nums, left++, i);			
		}
		swap(nums, left, end);// Finally, swap A[end] with A[left]
		
		if (left == k)// Found kth smallest number
			return nums[left];
		else if (left < k)// Check right part
			return findKthLargest(nums, left + 1, end, k);
		else // Check left part
			return findKthLargest(nums, start, left - 1, k);
	} 

	static void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;				
	}
}

