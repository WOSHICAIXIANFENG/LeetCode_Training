package com.github.leetcode.medium;

import java.util.Arrays;

public class SerializeDeserializeBST_449 {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;
		
		Codec codec = new Codec();
		TreeNode ans = codec.deserialize(codec.serialize(n1));
		System.out.println("Cai Test ans = " + codec.serialize(n1));
		System.out.println("Cai Test ans = " + codec.deserialize("1,2,3"));
		
		// special case !!!
		System.out.println("Cai Test ans = " + codec.deserialize(codec.serialize(null)));
	
		// special case !!!
		TreeNode b1 = new TreeNode(2);
		TreeNode b2 = new TreeNode(1);
		b1.left = b2;
		// [2,1] ---> if becomes [1, null, 2], that's wrong!!!!
		System.out.println("Cai Test ans = " + codec.serialize(b1));
		
		// 如何解决上面的case2呢???
	}
}

// !!!
// 中序是无法解决的这个问题，所没有必要去使用中序遍历 


// !!!!
// 这是我们自己的解决方法，但是并不能通过上面 special case 2: [2,1] ---> it becomes [1, null, 2]
class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        
        String ans = sb.toString();
        if (ans.length() > 0) {
        	ans = ans.substring(0, sb.length() - 1);//Don't forget!!!
        }
        return ans;
    }
    
    private void inOrder(TreeNode root, StringBuilder sb) {
    	if (root == null) return;
    	inOrder(root.left, sb);
    	sb.append(root.val).append(",");
    	inOrder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if (data == null || data.length() == 0) return null; //Don't forget!!!
        String[] numbers = data.split(",");
        //System.out.println("Cai Test array.length = " + "".split(",").length);//!!! return 1
        return buildBST(numbers, 0, numbers.length - 1);
    }
    
    private TreeNode buildBST(String[] values, int start, int end) {
    	if (end < start) return null;//!!!
    	
    	int mid = start + (end - start) / 2;
    	//System.out.println("Cai Test = " + values[mid] + " ,mid = " + mid + " ,start = " + start);
    	TreeNode root = new TreeNode(Integer.parseInt(values[mid]));
    	root.left = buildBST(values, start, mid - 1);
    	root.right = buildBST(values, mid + 1, end);
    	return root;
    }
}
