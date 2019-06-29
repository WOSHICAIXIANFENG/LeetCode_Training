package com.github.leetcode.medium;

public class RangeSumQueryMutable_307 {

	public static void main(String[] args) {
//		int[] nums = {1, 3, 5};
//		NumArray obj = new NumArray(nums);
//		System.out.println("Cai Test = " + obj.sumRange(0, 2));
//		obj.update(1, 2);
//		System.out.println("Cai Test = " + obj.sumRange(0, 2));
		
		int[] nums = {7, 2, 7, 2, 0};
		NumArray obj = new NumArray(nums);
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

// http://zxi.mytechroad.com/blog/sp/fenwick-tree-binary-indexed-tree-sp3/

/**
 * Fenwick tree is mainly designed for solving the single point update range sum problems. 
 * e.g. what's the sum between i-th and j-th element while the values of the elements are mutable.
 * 
 */
// 58 ms, faster than 74.76%
// Approach 1: Fenwick Tree/ Binary Index Tree
// TC: O(ilgN) -- Init the tree.  Update the value of ele take O(logN). Query the range sum takes O(logN)
// SC: O(n) --- Fenwick tree use an array to simulate the tree
class NumArray {
    private FenwickTree fenwick;
    
    private int[] nums;// original nums array
    
    public NumArray(int[] nums) {
    	this.nums = nums;
    	// init the Fenwick tree
        this.fenwick = new FenwickTree(nums.length);
        for (int i = 0; i < nums.length; i++) {
        	fenwick.update(i + 1, nums[i]);
        }
    }
    
    // i starts from 0, fenwick starts from 1
    public void update(int i, int val) {
        fenwick.update(i + 1, val - nums[i]);
        nums[i] = val;
    }
    
    public int sumRange(int i, int j) {
        return fenwick.query(j + 1) - fenwick.query(i);
    }
}

// 为什么 FenwickTree (binary Index Tree) 的下标需要从1 开始？
// 因为它的 tree构建过程是 依赖index的 low bit1的。所以起始点必需要有 1存在，所以 index has to start from 1

// the index of FenwickTree is start from 1.  每个结点其实存的是一个partial sum
class FenwickTree {
	int[] sum;
	
	// index start from 1, that's why we need n + 1
	public FenwickTree(int n) {
		sum = new int[n + 1];
	}
	
	// update的过程是从 i到它最后的root结点，每个结点其实存的是一个partial sum
	// i 最终会变成 the last element index
	public void update(int i, int delta) {
		while (i < sum.length) {
			sum[i] += delta;
			i += (i & -i); // += lowbit 
		}
	}
	
	//每个结点其实存的是一个partial sum --- Query的过程是一个 i 逆向归0的过程。
	// get pre sum of index i
	public int query(int i) {
		int preSum = 0;
		while (i > 0) {
			preSum += sum[i];
			i -= (i & -i);// -= lowbit;
		}
		return preSum;
	}
	
	// get last 1 bit
	private int lowbit(int x) {
		return x & -x;
	}
}
