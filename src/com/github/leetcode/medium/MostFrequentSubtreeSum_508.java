package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MostFrequentSubtreeSum_508 {

	public static void main(String[] args) {
		MostFrequentSubtreeSum_508 obj = new MostFrequentSubtreeSum_508();
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(-3);
		n1.left = n2;
		n1.right = n3;
		System.out.println("Cai Test = " + Arrays.toString(obj.findFrequentTreeSum(n1)));//[2, -3, 4]
	
		//[] -- should return []
		System.out.println("Cai Test = " + Arrays.toString(obj.findFrequentTreeSum(null)));//[]
	}
	
	// 40 ms, faster than 17.39%
	// Optimize to use one loop to solve this problem?
	// TC: O(N)
	// SC: O(H) + O(N) + O(ans.size)
	private Map<Integer, Integer> memory = new HashMap<>();
	private int maxFrequent = 0;
	public int[] findFrequentTreeSum(TreeNode root) {
		List<Integer> ans = new ArrayList<Integer>();
		getSum(root, ans);
		// 经过测试发现 stream api 的得分表现并不好
		//return ans.stream().mapToInt(Integer::intValue).toArray();
		// 使用普通的loop之后，4 ms, faster than 99.55%
		int size = ans.size();
		int[] results = new int[size];
        for (Integer i : ans) {
            results[--size] = i;
        }
        return results;
	}
	
	// TC: O(N)  SC: O(H)
	public int getSum(TreeNode root, List<Integer> ans) {
		if (root == null) return 0;
		
		int leftSum = getSum(root.left, ans);
		int rightSum = getSum(root.right, ans);
		
		int sum = root.val + leftSum + rightSum;
		memory.put(sum, memory.getOrDefault(sum, 0) + 1);
		
		if (memory.get(sum) > maxFrequent) {
			ans.clear();
			maxFrequent = memory.get(sum);
			ans.add(sum);
		} else if (memory.get(sum) == maxFrequent) {
			ans.add(sum);
		}
		
		return sum;
	}

	// 54 ms, faster than 5.65% 
	// Approach 1: Recursion with memory array
	// Sum -> Frequency
	// TC: 2* O(N)
	// SC: O(N) + O(ans.size)
//	private Map<Integer, Integer> memory = new HashMap<>();
//	public int[] findFrequentTreeSum(TreeNode root) {
//        // step1: dfs traverse to get all sum value
//		dfsHelper(root);
//		//System.out.println("Cai Test = " + memory);
//		
//		List<Integer> ans = new ArrayList<Integer>();
//		int maxFrequent = 0;
//		
//		//System.out.println("Cai Test = " + memory.entrySet().size());
//		for (Map.Entry<Integer, Integer> entry: memory.entrySet()) {
//			if (entry.getValue() > maxFrequent) {
//				ans.clear();
//				ans.add(entry.getKey());
//				maxFrequent = entry.getValue();
//			} else if (entry.getValue() == maxFrequent){
//				ans.add(entry.getKey());
//			}
//		}
//		return ans.stream().mapToInt(Integer::intValue).toArray();
//    }
//	
//	// TC: O(N)  SC: O(H)
//	public int dfsHelper(TreeNode root) {
//		if (root == null) return 0;
//		int sum = root.val + dfsHelper(root.left) + dfsHelper(root.right);
//		memory.put(sum, memory.getOrDefault(sum, 0) + 1);
//		return sum;
//	}
}
