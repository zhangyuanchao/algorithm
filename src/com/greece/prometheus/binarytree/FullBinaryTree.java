package com.greece.prometheus.binarytree;

public class FullBinaryTree {
	
	public static class Node {
		public int value; // 数据域
		public Node left; // 左指针域
		public Node right; // 右指针域
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static class Result {
		public int height;
		public int nodes;
		public Result(int height, int nodes) {
			this.height = height;
		}
		
	}
	
	public static boolean checkFBT(Node head) {
		if (head == null) {
			return true;
		}
		Result result = process(head);
		return result.nodes == (1 << result.height) -1;
	}
	
	public static Result process(Node head) {
		if (head == null) {
			return new Result(0, 0);
		}
		Result ls = process(head.left);
		Result rs = process(head.right);
		int height = Math.max(ls.height, rs.height) + 1;
		int nodes = ls.nodes + rs.nodes + 1;
		return new Result(height, nodes);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
