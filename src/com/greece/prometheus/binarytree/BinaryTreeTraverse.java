package com.greece.prometheus.binarytree;

import java.util.Stack;

public class BinaryTreeTraverse {
	
	public static class Node {
		public int data; // ������
		public Node left; // ��ָ����
		public Node right; // ��ָ����
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void printTreeNodeRecur(Node head) {
		if (head == null) {
			return;
		}
		// System.out.println(head.data);
		printTreeNodeRecur(head.left);
		// System.out.println(head.data);
		printTreeNodeRecur(head.right);
		System.out.println(head.data);
	}
	
	/**
	 * �ǵݹ�ǰ�����(ͷ������)
	 * 1���Ƚ�ͷ�ڵ�ѹջ
	 * 2����ջ�е���һ���ڵ�cur
	 * 3����ӡ(����)�ýڵ�
	 * 4�����ҡ�����(�����)
	 * 5���ظ�1-4
	 * @param head
	 */
	public static void preOrderUnRecur(Node head) {
		System.out.println("pre-order:");
		if (head != null) {
			Stack<Node> stack = new Stack<>();
			stack.add(head);
			while (!stack.isEmpty()) {
				head = stack.pop();
				System.out.println(head.data + " ");
				if (head.right != null) {
					stack.push(head.right);
				}
				if (head.left != null) {
					stack.push(head.left);
				}
			}
		}
		System.out.println();
	}
	
	
	/**
	 * �ǵݹ��������(��ͷ����)
	 * �Ƚ�һ��������߽���ջ��Ȼ���ٵ����������������������������
	 * @param head
	 */
	public static void inOrderUnRecur(Node head) {
		System.out.println("in-order:");
		if (head != null) {
			Stack<Node> stack = new Stack<>();
			while (!stack.isEmpty() || head != null) {
				if (head != null) {
					stack.push(head);
					head = head.left;
				} else {
					head = stack.pop();
					System.out.println(head.data + " ");
					head = head.right;
				}
			}
		}
	}
	
	public static void inOrderUnRecur1(Node head) {
		System.out.println("in-order:");
		if (head != null) {
			Stack<Node> stack = new Stack<>();
			while (!stack.isEmpty() || head != null) {
				if (head != null) {
					stack.push(head);
					head = head.left;
				} else {
					head = stack.pop();
					System.out.println(head.data + " ");
					head = head.right;
				}
			}
		}
	}
	
	/**
	 * �ǵݹ�������(���ҡ�ͷ)
	 * �ڷǵݹ�ǰ������У���ѹջ����������ѹջ���������õ���˳����ͷ���ҡ���
	 * �ٽ���ջ��תͷ���ҡ��� ---> ���ҡ�ͷ�����õ�����
	 * @param head
	 */
	public static void posOrderUnRecur(Node head) {
		System.out.println("pos-order:");
		if (head != null) {
			Stack<Node> s1 = new Stack<>();
			Stack<Node> s2 = new Stack<>();
			s1.add(head);
			while (!s1.isEmpty()) {
				head = s1.pop();
				s2.add(head);
				if (head.left != null) {
					s1.add(head.left);
				}
				if (head.right != null) {
					s1.add(head.right);
				}
			}
			while (!s2.isEmpty()) {
				System.out.println(s2.pop().data + " ");
			}
		}
	}
	
	public static Node createTreeNode(Integer[] array, int index) {
		if (index > array.length) {
			return null;
		}
		Integer value = array[index-1];
		if (value == null) {
			return null;
		}
		Node node = new Node(value);
		node.left = createTreeNode(array, 2*index);
		node.right = createTreeNode(array, 2*index + 1);
		return node;
	}
	
	/**
	 * �ж�һ��������ȫ������
	 * 1������һ�ڵ㣬��������false
	 * 2��������1������£����������һ�������Ӳ�ȫ��������Ľڵ�ȫ��Ҷ�ӽڵ�
	 * ʹ�ÿ�����ȱ���(����)
	 * @param args
	 */
	
	/**
	 * 1��һ�����Ƿ�������������
	 * 2��һ�����Ƿ�����ȫ������
	 * 3��һ�����Ƿ�����������
	 * 4��һ�����Ƿ���ƽ�������
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] array = {1, 2, 3, 4, 5, 6, 7};
		Node head = createTreeNode(array, 1);
		// printTreeNodeRecur(head);
		// preOrderUnRecur(head);
		// posOrderUnRecur(head);
		/***************************************/
		posOrderUnRecur(head);
	}

}
