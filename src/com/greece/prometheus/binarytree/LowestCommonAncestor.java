package com.greece.prometheus.binarytree;

/**
 * @author zhangyuanchao
 *
 */
public class LowestCommonAncestor {
	
	public static class Node {
		public int value; // 数据域
		public Node left; // 左指针域
		public Node right; // 右指针域
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	/**
	 * 求解两个节点的最低公共祖先
	 * o1、o2属于head为头的树
	 * 1、o1是o2的LCA或者o2是o1的LCA
	 * 2、o1、o2不互为LCA
	 * @param head
	 * @param o1
	 * @param o2
	 * @return
	 */
	public static Node lowestCommonAncestor(Node head, Node o1, Node o2) {
		if (head == null || head == o1 || head == o2) {
			return head;
		}
		Node left = lowestCommonAncestor(head.left, o1, o2);
		Node right = lowestCommonAncestor(head.right, o1, o2);
		if (left != null && right != null) {
			return head;
		}
		// 左右两棵树，不都有返回值
		return left != null ? left : right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
