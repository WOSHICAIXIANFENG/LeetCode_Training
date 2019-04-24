package com.github.leetcode.hard;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBT_297 {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n1.left = n2;
		n1.right = n3;
		n3.left = n4; 
		n3.right = n5;
		
		Codec codec = new Codec();
		TreeNode ans = codec.deserialize(codec.serialize(n1));
		System.out.println("Cai Test = " + ans);
	}
}

class Codec {
	// 11 ms, faster than 72.59%
	
	// Approach 1: Pre Order --- to String --- use '#' represent null node
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringWriter sw = new StringWriter();
        preOrderStr(root, sw);
        String ans = sw.toString();
        if (ans.length() > 0) {
        	ans = ans.substring(0, ans.length() - 1);
        }
        return ans;
    }

    public void preOrderStr(TreeNode root, StringWriter sw) {
    	if (root == null) {
    		sw.write("#,");
    		return;
    	}
    	sw.write(root.val + ",");
    	preOrderStr(root.left, sw);
    	preOrderStr(root.right, sw);
    }

    // Do not use class member/global/static variables to store states. 
    // Your serialize and deserialize algorithms should be stateless.
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return buildBT(queue);
    }
    
    public TreeNode buildBT(Queue<String> queue) {
    	String val = queue.poll();
    	if ("#".equals(val)) {
    		return null;
    	}
    	
    	TreeNode node = new TreeNode(Integer.parseInt(val));
    	node.left = buildBT(queue);
    	node.right = buildBT(queue);
    	return node;
    }
}