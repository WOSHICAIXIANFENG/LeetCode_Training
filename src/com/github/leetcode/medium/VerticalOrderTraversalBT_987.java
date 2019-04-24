package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class VerticalOrderTraversalBT_987 {

	public static void main(String[] args) {
		VerticalOrderTraversalBT_987 obj = new VerticalOrderTraversalBT_987();
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(9);
		TreeNode n3 = new TreeNode(20);
		TreeNode n4 = new TreeNode(15);
		TreeNode n5 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n5;
		System.out.println("Cai Test = " + obj.verticalTraversal(n1));
	}

	// 我自己的解法 ！！！ ---- It's wrong. values with the same x should sorted by y
	// 解决法错误 ！！！ --- 我尝试用 x --> val --- TreeMap + TreeSet
	// special case [0,5,1,9,null,2,null,null,null,null,3,4,8,6,null,null,null,7]
	// Expect: [[9,7],[5,6],[0,2,4],[1,3],[8]]
	// My output: [[7,9],[5,6],[0,2,4],[1,3],[8]]
//	public List<List<Integer>> verticalTraversal(TreeNode root) {
//        Map<Integer, Set<Integer>> map = new TreeMap<>();
//        // step1: collect data
//        traverse(root, 0, map);
//        List<List<Integer>> ans = new ArrayList<>();
//        // step2: construct the result
//        for(Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
//        	Integer[] array = new Integer[entry.getValue().size()];
//        	entry.getValue().toArray(array);
//        	ans.add(Arrays.asList(array));
//        }
//        return ans;
//    }
//	
//	public void traverse(TreeNode root, int x, Map<Integer, Set<Integer>> map) {
//		if (root == null) return;
//		
//		Set<Integer> values = map.getOrDefault(x, new TreeSet<>());
//		values.add(root.val);
//		map.put(x, values);
//		
//		traverse(root.left, x - 1, map);
//		traverse(root.right, x + 1, map);
//	}
	
	// 45 ms, faster than 14.52%
	// !!! values with the same x should sorted by y
	// Approach 1: 
	// TreeMap + TreeSet
	// step1 : Collect Data. {x} --> {y, val} with sort by y
	// step2: Construct the report
	// TreeMap --- put() or getOrDefault()  --- O(log n)
	// TreeSet --- add() ---- O(log n)
	// TC: O(n*2*logN) --- each node will be put in treeMap and treeSet
	// SC: O(N)
	public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Set<Pair<Integer, Integer>>> map = new TreeMap<>();
        // step1: collect data
        traverse(root, 0, 0, map);
        //System.out.println("Cai test map = " + map);
        List<List<Integer>> ans = new ArrayList<>();
        // step2: construct the result
        for(Map.Entry<Integer, Set<Pair<Integer, Integer>>> entry : map.entrySet()) {
//        	List<Integer> values = entry.getValue().stream().map(pair -> pair.val).collect(Collectors.toList());
//        	ans.add(values);
        	
        	// 为了提高运行效率，不用stream API.
        	// 37 ms, faster than 20.87%
//        	List<Integer> values = new ArrayList<>();
//        	entry.getValue().forEach(pair -> values.add(pair.val));
//        	ans.add(values);
        	
        	// 4 ms, faster than 88.59% 
        	List<Integer> values = new ArrayList<>();
        	Iterator<Pair<Integer, Integer>> interator = entry.getValue().iterator();
        	while (interator.hasNext()) {
        		values.add(interator.next().val);
        	}
        	ans.add(values);
        }
        return ans;
    }
	
	public void traverse(TreeNode root, int x, int y, Map<Integer, Set<Pair<Integer, Integer>>> map
			) {
		if (root == null) return;
		
		Set<Pair<Integer, Integer>> values = map.getOrDefault(x, new TreeSet<>());
		values.add(new Pair<>(y, root.val));
		map.put(x, values);
		
		traverse(root.left, x - 1, y + 1, map);
		traverse(root.right, x + 1, y + 1, map);
	}
}

// make sure the nodes with same y can be put in
// {y, value} ---> sorted by y
class Pair<T1 extends Comparable<T1>, T2 extends Comparable<T2>> implements Comparable<Pair<T1, T2>>{
	T1 y;
	T2 val;
	public Pair(T1 t1, T2 t2) {
		this.y = t1;
		this.val = t2;
	}
	
	//!!! compare y value first, then val value, make sure the nodes with same y can be put in
	@Override
	public int compareTo(Pair<T1, T2> o) {
		int result = y.compareTo(o.y);
		if (result == 0) {
			return val.compareTo(o.val);
		}
		return result;
	}
}



//// {y, x} --> sorted by y 
//class Pair<T1 extends Comparable<T1>, T2 extends Comparable<T2>> implements Comparable<Pair<T1, T2>>{
//	T1 t1;
//	T2 t2;
//	
//	public Pair(T1 t1, T2 t2) {
//		this.t1 = t1;
//		this.t2 = t2;
//	}
//
//	@Override
//	public int compareTo(Pair<T1, T2> o) {
//		return t1.compareTo(o.t1);
//	}
//}