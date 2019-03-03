package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CovertSortedArrayToBinarySearchTree_108 {
	
	static ArrayList<ArrayList<Integer>> printTree(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
        if (pRoot==null) {
            return arrayLists;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                if (queue.peek().left!=null) {
                    queue.add(queue.peek().left);
                }
                if (queue.peek().right!=null) {
                    queue.add(queue.peek().right);
                }
                arrayList.add(queue.poll().val);
            }
            arrayLists.add(arrayList);
        }
        return arrayLists;
    }
	
	public static void main(String[] args) {
		// what is Binary Search Tree? insert/search/remove O(log(n))
		// what is Self-balancing binary search tree? 
		// !!! 
		/**
		 * Binary Search Tree
		 * 它或者是一棵空树，或者是具有下列性质的二叉树：若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
		 * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树。
		 * 
		 * Self-balancing binary search tree
		 * 我们知道，对于一般的二叉搜索树（Binary Search Tree），其期望高度（即为一棵平衡树时）为log2n，其各操作的时间复杂度（O(log2n)）同时也由此而决定。
		 * 但是，在某些极端的情况下（如在插入的序列是有序的时），二叉搜索树将退化成近似链或链，此时，其操作的时间复杂度将退化成线性的，即O(n)。'
		 * 我们可以通过随机化建立二叉搜索树来尽量的避免这种情况，但是在进行了多次的操作之后，由于在删除时，我们总是选择将待删除节点的后继代替它本身，这样就会造成总是右边的节点数目减少，以至于树向左偏沉。
		 * 这同时也会造成树的平衡性受到破坏，提高它的操作的时间复杂度。
         * 平衡二叉搜索树（Balanced Binary Tree）具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
         * 常用算法有红黑树、AVL、Treap、伸展树等。在平衡二叉搜索树中，我们可以看到，其高度一般都良好地维持在O（log（n）），大大降低了操作的时间复杂度。
		 */
		
		int[] a1= {-10,-3,0,5,9};
		System.out.println("Cai Test sortedArrayToBST = " + printTree(sortedArrayToBST(a1)));
	}

	// 1 ms, faster than 98.27% of
	public static TreeNode sortedArrayToBST(int[] nums) {
        return arrayToBST(nums, 0, nums.length - 1);
    }
	
	public static TreeNode arrayToBST(int[] nums, int start, int end) {
		TreeNode root = null;
		int middle = start + (end - start)/2;
		if (start <= end) {
			root = new TreeNode(nums[middle]); 
			root.left = arrayToBST(nums, start, middle - 1);
			root.right = arrayToBST(nums, middle + 1, end);
		}
        return root;
    }
}
