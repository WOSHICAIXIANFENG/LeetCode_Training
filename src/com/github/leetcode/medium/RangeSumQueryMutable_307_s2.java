package com.github.leetcode.medium;

public class RangeSumQueryMutable_307_s2 {

	public static void main(String[] args) {
//		int[] nums = {1, 3, 5};
//		NumArray obj = new NumArray(nums);
//		System.out.println("Cai Test = " + obj.sumRange(0, 2));
//		obj.update(1, 2);
//		System.out.println("Cai Test = " + obj.sumRange(0, 2));
		
		int[] nums = {7, 2, 7, 2, 0};
		NumArray2 obj = new NumArray2(nums);
		obj.update(4, 6);
		obj.update(0, 2);
		obj.update(0, 9);
		System.out.println("Cai Test = " + obj.sumRange(4, 4));//6
		// 9,2,7,2,6
		
		obj.update(3, 8);
		// 9,2,7,8,6
		System.out.println("Cai Test = " + obj.sumRange(0, 4));//32
		obj.update(4, 1);
		System.out.println("Cai Test = " + obj.sumRange(0, 3));//26
	}

}

// https://www.youtube.com/watch?v=rYBtViWXYeI

/**
 * Discrete version of a Segment Tree: A balanced binary tree. O(lgN) height given n elements.
 * Each leaf node (segment) represents an element in the array. 
 * Each non leaf node covers the union of its children's range
 * Operations:
 * 	build(start, end, vals) ---> O(n)
 *  update(index, value) ---> O(lgN)
 *  rangeQuery(start, end) ---> O(lgN + k) ---- K is # of reported segments.
 */

// 55 ms, faster than 93.08% 

// Approach 2: Segment Tree ---- Discrete Version
// TC: BuildTree O(n), update O(lgN), sumRange O(lgN)
// SC: O(n) tree
class NumArray2 {
    private int[] nums;// original nums array
    private SegmentTree tree;
    
    public NumArray2(int[] nums) {
    	this.nums = nums;
    	// init the Segment Tree
    	this.tree = new SegmentTree(nums);
    }
    
    // i starts from 0, fenwick starts from 1
    public void update(int i, int val) {
        tree.updateTree(tree.root, i, val);
    }
    
    public int sumRange(int i, int j) {
        return tree.sumRange(tree.root, i, j);
    }
}

//  https://www.youtube.com/watch?v=rYBtViWXYeI
//  
class SegmentTree {
	private int[] nums;// original nums array
	SegmentTreeNode root;
	
	public SegmentTree(int[] nums) {
		this.nums = nums;
		this.root = this.buildTree(0, nums.length - 1);
	}
	
	// TC: O(n) ---- 
	private SegmentTreeNode buildTree(int start, int end) {
		// corner case: [] 
		if (start > end) return null;
		
		if (start == end) {
			// Each leaf node (segment) represents an element in the array. 
			return new SegmentTreeNode(start, end, nums[start]);
		}
		int mid = start + (end - start) / 2;
		SegmentTreeNode left = buildTree(start, mid);
		SegmentTreeNode right = buildTree(mid + 1, end);
		// Each non leaf node covers the union of its children's range
		return new SegmentTreeNode(start, end, left.sum + right.sum, left, right);
	}
	
	// TC: O(lgN)
	public void updateTree(SegmentTreeNode root, int i, int val) {
		if (root == null) return;
		
		if (root.start == i && root.end == i) {
			root.sum = val;
			return;
		}
		int mid = root.start + (root.end - root.start) / 2;
		if (i <= mid) {
			updateTree(root.left, i, val);
		} else {
			updateTree(root.right, i, val);
		}
		root.sum = root.left.sum + root.right.sum;//!!!
	}
	
	// TC: O(lgN + k) ---- K is # of reported segments.
	public int sumRange(SegmentTreeNode root, int i, int j) {
		if (root == null) return 0;
		
		if (root.start == i && root.end == j) {
			return root.sum;
		}
		int mid = root.start + (root.end - root.start) / 2;
		if (j <= mid) {
			return sumRange(root.left, i, j);
		} else if (i > mid) {
			return sumRange(root.right, i, j);
		} else {
			return sumRange(root.left, i, mid) + sumRange(root.right, mid + 1, j);
		}
	}
}

class SegmentTreeNode {
	int start;
	int end;
	int sum;
	SegmentTreeNode left;
	SegmentTreeNode right;
	
	public SegmentTreeNode(int start, int end, int sum) {
		this(start, end, sum, null, null);
	}
	
	public SegmentTreeNode(int start, int end, int sum, SegmentTreeNode left, SegmentTreeNode right) {
		this.start = start;
		this.end = end;
		this.sum = sum;
		this.left = left;
		this.right = right;
	}
}
