package com.github.leetcode.medium;

import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBST_449_done {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;
		
		Codec2 codec = new Codec2();
		TreeNode ans = codec.deserialize(codec.serialize(n1));
		//System.out.println("Cai Test ans = " + codec.serialize(n1));
		//System.out.println("Cai Test ans = " + codec.deserialize("2,1,#,#,3,#,#"));
		System.out.println("Cai Test ans = " + ans);
		System.out.println("Cai Test ans = " + ans.left);
		System.out.println("Cai Test ans = " + ans.right);
		
		// special case !!! --- 
		System.out.println("Cai Test ans = " + codec.deserialize(codec.serialize(null)));
	
		// special case !!!
		TreeNode b1 = new TreeNode(2);
		TreeNode b2 = new TreeNode(1);
		b1.left = b2;
		System.out.println("Cai Test ans = " + codec.serialize(b1));//2,1,#,#
	}
}

class Codec2 {
	// 7 ms, faster than 73.33%
	// Approach 1: PreOrder output String, use # to as Null Node
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        String ans = sb.toString();
        if (ans.length() > 1) {
            ans = ans.substring(0, ans.length() - 1);
        }
        return ans;
    }
    
    public void preOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(",");
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	Queue<String> queue = new LinkedList<>();
    	queue.addAll(Arrays.asList(data.split(",")));
        return buildBST(queue);
    }
    
    // todo: 改成 Java InputStream/OutputStream来写。
    // todo: 改成 Java 8 stream来写 
    // todo: 改成字节流来写 
    
    // Do not use class member/global/static variables to store states.
    // 所以传 index就解决不了了，只能用流 stream的思想，那到底用哪个流呢？用Java 8 new tream API 吗？
    // 另一种思路: because we want to get the value from the start of the string one by one, 
    // which is like a queue. So we put the string into queue, then poll the value out as the node of the string.
    public TreeNode buildBST(Queue<String> queue) {
       String val = queue.poll();
       if (val.equals("#")) return null;
       
       TreeNode root = new TreeNode(Integer.valueOf(val));
       root.left = buildBST(queue);
       root.right = buildBST(queue);
       return root;
    }
}
