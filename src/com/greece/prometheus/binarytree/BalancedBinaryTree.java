package com.greece.prometheus.binarytree;

/**
 * ƽ�������
 * ����һ���ڵ�x
 * 1����������ƽ�������
 * 2����������ƽ�������
 * 3�����������������ĸ߶Ȳ����1
 * @author zhangyuanchao
 *
 */
public class BalancedBinaryTree {
	
	public static class Node {
		public int data; // ������
		public Node left; // ��ָ����
		public Node right; // ��ָ����
		
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
