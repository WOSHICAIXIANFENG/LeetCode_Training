package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountSmallerNumbersAfterSelf_315_best {

	public static void main(String[] args) {
		CountSmallerNumbersAfterSelf_315_best obj = new CountSmallerNumbersAfterSelf_315_best();
		int[] a1 = {5, 2, 6, 1};
		System.out.println("Cai Test = " + obj.countSmaller(a1));
		
		// special case
		int[] a2 = {};
		System.out.println("Cai Test = " + obj.countSmaller(a2));
	}
	
	// 16 ms, faster than 46.76%
	// 最简单但并不高效的实现，介绍: https://blog.csdn.net/qq_35923749/article/details/85218769
	// Approach 4: Binary Search 
	// TC: O(nlgN*N)
	// SC: O(n)
//	public List<Integer> countSmaller(int[] nums) {
//		Integer[] result = new Integer[nums.length];
//        
//        List<Integer> sorted = new ArrayList<Integer>(nums.length);
//        int left,right;
//        int mid;
//        for(int i = nums.length - 1; i >= 0; i--){
//            left = 0;
//            right = sorted.size();
//            //二分法查到当前数值的排序位置，即当前数值的右边有几个比它小的个数
//            while (left < right){
//                mid = left + (right - left)/2;
//                if (sorted.get(mid) >= nums[i]) {
//                    right = mid;
//                } else {
//                    left = mid + 1;
//                }
//            }
//            result[i] = left;
//            sorted.add(left, nums[i]);//!!! 这里存在Shifts， 所以可能会有O(n) TC
//        }
//        return Arrays.asList(result);
//	}

	// 5 ms, faster than 93.12%
	// 4 ms, faster than 98.30%
	
	//Approach 3: BST --- track the number of elements smaller than the current node
	// count the total number of elements smaller than val during inserting val into the tree
	// TC: O(nlogN) --- O(n^2)
	// SC: O(k) --- k is the # unique elements
	
	// TC: O(nlgN) is the average time. However, if the nums is sorted in ascending or descending order.
	// the run time will degenerates into O(n^2). we can fix this by using a self-balancing BST (AVL tree or a red-black tree) and retaining the same logic
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> ans = new ArrayList<>();
		if (nums == null || nums.length == 0) return ans; //!!!
		
		int len = nums.length;
		Node root = new Node(nums[len - 1]);
		ans.add(0);
		for (int i = len - 2; i >= 0; --i) {
			ans.add(insert(root, nums[i]));
		}
		Collections.reverse(ans);
		return ans;
	}
	
	private int insert(Node root, int val) {
		if (root.val == val) {
			++root.count;
			return root.left_count;
		} else if (val < root.val) {
			++root.left_count;
			if (root.left == null) {
				root.left = new Node(val);
				return 0;
			}
			return insert(root.left, val);
		} else {
			if (root.right == null) {
				root.right = new Node(val);
				return root.less_or_equal();
			} else {
				return root.less_or_equal() + insert(root.right, val);
			}
		}
	}
	
	class Node {
		int val;
		int count;
		int left_count;
		Node left;
		Node right;
		public Node(int val) {
			this.val = val;
			this.count = 1;
			this.left_count = 0;
		}
		public int less_or_equal() {
			return count + left_count;
		}
	}
}
