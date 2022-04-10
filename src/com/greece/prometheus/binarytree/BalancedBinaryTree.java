package com.greece.prometheus.binarytree;

/**
 * 平衡二叉树
 * 对于一个节点x
 * 1、左子树是平衡二叉树
 * 2、右子树是平衡二叉树
 * 3、左子树和右子树的高度差不超过1
 * @author zhangyuanchao
 *
 */
public class BalancedBinaryTree {
	
	public static class Node {
		public int data; // 数据域
		public Node left; // 左指针域
		public Node right; // 右指针域
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static class ResultType{
		public boolean isBalanced;
		public int height;
		public ResultType(boolean isBalanced, int height) {
			this.isBalanced = isBalanced;
			this.height = height;
		}
	}
	
	public static boolean isBalanced(Node head) {
		return process(head).isBalanced;
	}
	
	public static ResultType process(Node x) {
		if (x == null) {
			return new ResultType(true, 0);
		}
		ResultType lt = process(x.left);
		ResultType rt = process(x.right);
		int height = Math.max(lt.height, rt.height) + 1;
		boolean isBalanced = lt.isBalanced && rt.isBalanced 
				&& Math.abs(lt.height - rt.height) < 2;
		return new ResultType(isBalanced, height);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
