package com.github.leetcode.hard;

public class BTCameras_968 {

	public static void main(String[] args) {
		BTCameras_968 obj = new BTCameras_968();
		TreeNode n1 = new TreeNode(0);
		TreeNode n2 = new TreeNode(0);
		TreeNode n3 = new TreeNode(0);
		TreeNode n4 = new TreeNode(0);
		TreeNode n5 = new TreeNode(0);
		n1.left = n2;
		n2.left = n3;
		n3.left = n4;
		n4.right = n5;
		System.out.println("Cai test = " + obj.minCameraCover(n1));
	}
	
	// 1 ms, faster than 91.75% 
	// Approach 1: DFS --- State 
	// TC: O(N). SC: O(H)

	// 定义Node的状态，要么是Camera,要么是None, 要么是Covered. 最终态是所有Node都变成 Camera or Covered
	enum State {NONE, COVERED, CAMERA}
	private int ans;
	public int minCameraCover(TreeNode root) {
		ans = 0;
        if (dfs(root) == State.NONE) ++ans;
        return ans;
    }
	
	public State dfs(TreeNode root) {
		if (root == null) return State.COVERED;
		
		State left = dfs(root.left);
		State right = dfs(root.right);
		if (left == State.NONE || right == State.NONE) {
			++ans;
			return State.CAMERA;
		}
		if (left == State.CAMERA || right == State.CAMERA) {
			return State.COVERED;
		}
		// here: left & right is Covered, so the root state will be none, the previous recursion fun will put Camera to make root be covered
		return State.NONE;
	}
}
