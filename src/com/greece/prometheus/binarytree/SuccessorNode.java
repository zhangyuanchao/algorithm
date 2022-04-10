package com.greece.prometheus.binarytree;

/**
 * ��̽ڵ�
 * ��������У�һ���ڵ�ĺ�һ���ڵ�
 * 			A
 * 		  /   \
 * 		 B	   C
 * 	    / \   / \
 * 	   D   E F   G
 * �������: D->B->E->A->F->C-G
 * D�ĺ�̽ڵ���B
 * B�ĺ�̽ڵ���E
 * ...
 * @author zhangyuanchao
 *
 */
public class SuccessorNode {
	
	public static class Node {
		public int value; // ������
		public Node left; // ��ָ����
		public Node right; // ��ָ����
		public Node parent; // ���ڵ�
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	/**
	 * ���ڽڵ�x��x�ĺ�̽ڵ�?
	 * 1��x������������x�ĺ�̽ڵ���������������ڵ�
	 * 2��xû��������
	 * @param node
	 * @return
	 */
	/**
	 * 	�ýṹ����ͨ����������һ��ָ�򸸽ڵ��ָ��parent�����۾���:
		1������ýڵ�������������ýڵ�ĺ�̽ڵ�Ϊ�ýڵ���������ϵ�����ڵ㡣
		2�����ýڵ�û�����������������Ҹ��ڵ㣬�ж����ýڵ�Ϊ���ڵ������������ø��ڵ���Ǻ�̽ڵ㣬
		���ýڵ�Ϊ���ڵ���Һ��ӣ���������ϱ�����ֱ��ĳ���ڵ�Ϊ�丸�ڵ�����ӣ�����Ϊ�ø��ڵ㣬
		��δ�ҵ���˵���ýڵ㲻���ڸ��ڵ㡣
	 */
	public static Node getSuccessorNode1(Node node) {
		if (node == null) {
			return node;
		}
		if (node.right != null) {
			// ������������̽ڵ����������������ڵ�
			return getLeftMost(node.right);
		} else {
			// ��������
			Node parent = node.parent;
			while (parent != null && parent.left != node) { // ��ǰ�ڵ����丸�ڵ���Һ���
				node = parent;
				parent = node.parent;
			}
			return parent;
		}
	}
	
	/**
	 * ����һ���ڵ�x
	 * ���x����������x�ĺ�̽ڵ���������������ڵ�
	 * ���xû��������:
	 * ���x���丸�ڵ����������x�ĺ�̽ڵ����丸�ڵ�
	 * @param node
	 * @return
	 */
	public static Node getSuccessorNode(Node node) {
		if (node == null) {
			return node;
		}
		if (node.right != null) {
			// ���������������̽ڵ����������������ڵ�
			return getLeftMost(node.right);
		} else {
			// û�������������ϲ��Ҹ��ڵ㣬
			// ���ýڵ��Ǹ��ڵ�����������򸸽ڵ��Ǻ�̽ڵ�
			// ���ýڵ��Ǹ��ڵ������������������ϲ��ң�ֱ��ĳ���ڵ����丸�ڵ�������������ڵ�Ϊ��̽ڵ�
			// ��δ�ҵ�����˵���ýڵ㲻���ڸ��ڵ�
			Node parent = node.parent;
			while (parent != null && parent.left != node) { 
				// ��ǰ�ڵ��Ǹ��ڵ���Һ��ӣ����ϲ���
				node = parent;
				parent = node.parent;
			}
			return parent;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static Node getLeftMost(Node node) {
		if (node == null) {
			return node;
		}
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
