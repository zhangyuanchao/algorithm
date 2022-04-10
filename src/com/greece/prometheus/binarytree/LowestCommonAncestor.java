package com.greece.prometheus.binarytree;

/**
 * @author zhangyuanchao
 *
 */
public class LowestCommonAncestor {
	
	public static class Node {
		public int value; // ������
		public Node left; // ��ָ����
		public Node right; // ��ָ����
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	/**
	 * ��������ڵ����͹�������
	 * o1��o2����headΪͷ����
	 * 1��o1��o2��LCA����o2��o1��LCA
	 * 2��o1��o2����ΪLCA
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
		// �����������������з���ֵ
		return left != null ? left : right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
