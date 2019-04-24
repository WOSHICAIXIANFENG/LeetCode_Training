package com.github.leetcode.medium;

public class DistributeCoinsInBT_979 {

	public static void main(String[] args) {
		DistributeCoinsInBT_979 obj = new DistributeCoinsInBT_979();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(0);
		TreeNode n3 = new TreeNode(0);
		TreeNode n4 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;
		n2.right = n4;
		System.out.println("Cai Test = " + obj.distributeCoins(n1));
	}

	// in order or pre order doesn't work
	// in order --- 0,3,1,0 ----> 1,1,1,1 ---> 1 + 2
	// post order--- 3,0,0,1 ----> 1,1,1,1 ---> 1 + 2
	// pre order --- 1,0,3,0 ----> 2
	
	// pre order 0,3,0 ---> 2
	// post order 3,0,0 ---> 3
	// in order 3,0,0 ---> 3
	// Then  ---- confirmed:  DFS traverse array doesn't work
	
	// 0 ms, faster than 100.00%
	
	// !!! there are N nodes, total coins are N, so each node need 1 coins to keep balance
	
	// Approach 1: Depth First Search
	// TC: O(N), SC: O(H)
	// Answer = flow(left) + flow(right)
	// Balance(root) = root.val - 1 + balance(left) + balance(right)
	// flow(left) = abs(balance(left)), flow(right) = abs(balance(right))
	private int ans;
	public int distributeCoins(TreeNode root) {
        ans = 0;
        balance(root);
        return ans;
    }
	
	// calculate how many moves needed to achieve balance status
    public int balance(TreeNode root) {
        if (root == null) return 0;// no flow needed
        int left = balance(root.left);
        int right = balance(root.right);
        // 因为只有N个Node,只有N个coins. 所以最终每一个Node会有一个coin，最后的计算的root balance value必定等于0
        // 因为Balance状态是能够达到的!!!
        // accumulate movements
        ans = Math.abs(left) + Math.abs(right);
        // return how many moves needed for balance this tree
        return left + right + root.val - 1;
    }
}
